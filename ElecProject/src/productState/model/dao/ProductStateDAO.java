package productState.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.vo.Member;
import productState.model.vo.ProductRankState;
import productState.model.vo.ProductState;

public class ProductStateDAO {
	
//	private static Properties prop = new Properties();
	
//	public ProductStatusDAO(){
//		String fileName = "/sql/productStatus/productStatus-query.properties";
//		fileName = ProductStatusDAO.class.getResource(fileName)
//							   			 .getPath();
//		
//		System.out.println("fileName@dao = "+ fileName);
//		
//		try {
//			prop.load(new FileReader(fileName));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static List<ProductState> selectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ProductState> list = null;
		String sql = "with v as ( select pc.brand, prod_serial_code, amount from product p left outer join  product_category pc on(p.prod_code=pc.product_code) left outer join product_io pi using (prod_serial_code) where status = 'O' ) select a.*, floor(count/(select sum(amount)  from v)*100) percent  from ( select nvl(brand, 'total') brand, sum(amount) count from v group by brand ) a";
		
		
		try {
		//1. Pstmt객체생성 / 미완성쿼리전달 /값대입
		pstmt = conn.prepareStatement(sql);
		
		//2. 실행
		rset = pstmt.executeQuery();
		//3. rset -> List<ProductStatus>
		list =  new ArrayList<>();
		
			//2-1. sql값을 가져옴
		while(rset.next()) {
			ProductState ps = new ProductState();
			ps.setBrand(rset.getString("brand"));
			ps.setCount(rset.getInt("count"));
			ps.setPercent(rset.getInt("percent"));
	
			list.add(ps);
		}
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//4. 자원반납
			close(rset);
			close(pstmt);
		}
//		System.out.println("list@dao = " + list);
		
		return list;
	}

	public static List<ProductRankState> selectRankListAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ProductRankState> rankList = null;
		String sql = "with v as ( select pc.product_name, prod_serial_code, amount from product p left outer join  product_category pc on(p.prod_code=pc.product_code) left outer join product_io pi using (prod_serial_code) where status = 'O' ) select a.* from ( select product_name, sum(amount) count, rank() over (order by sum(amount) desc) rank from v group by product_name ) a";
		
		try {
		//1. Pstmt객체생성 / 미완성쿼리전달 /값대입
		pstmt = conn.prepareStatement(sql);
		
		//2. 실행
		rset = pstmt.executeQuery();
		//3. rset -> List<ProductStatus>
		rankList =  new ArrayList<>();
		
			//2-1. sql값을 가져옴
		while(rset.next()) {
			ProductRankState ps = new ProductRankState();
			ps.setProductName(rset.getString("product_name"));
			ps.setCount(rset.getInt("count"));
			ps.setRank(rset.getInt("rank"));
	
			rankList.add(ps);
		}
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//4. 자원반납
			close(rset);
			close(pstmt);
		}
		System.out.println("list@dao = " + rankList);
		
		
		return rankList;
	}

}
