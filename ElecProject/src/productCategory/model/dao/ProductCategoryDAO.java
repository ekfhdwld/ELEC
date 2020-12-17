package productCategory.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import static common.JDBCTemplate.*;
import productCategory.model.vo.ProductCategory;

public class ProductCategoryDAO {
	
	private Properties prop = new Properties();
	
	public ProductCategoryDAO() {
		String fileName = "/sql/productCategory/productCategory-query.properties";
		fileName = ProductCategoryDAO.class.getResource(fileName)
								   .getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}	


	public int getTotalContents(Connection conn, Map<String, Object> param) {
		int totalContents = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getSearchTotalContents");
		
		System.out.println(sql);
		
		String tsr = (String)param.get("searchKeyword");
				
				
		System.out.println("'%" + tsr + "%'");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "'%" + tsr + "%'");
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalContents = rset.getInt("total_contents");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("toalContentsDAO@"+totalContents);
		return totalContents;
	}


	public List<ProductCategory> searchProduct(Connection conn, Map<String, Object> param) {
		List<ProductCategory> list = null;
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql  = "select * from product_category where brand like ?";
		System.out.println(sql);
		
		String tsr = (String)param.get("searchKeyword");
		
		
		System.out.println("'%" + tsr + "%'");

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%" + tsr.toUpperCase() + "%");

			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
			
				ProductCategory category = new ProductCategory();

				category.setProductCode(rset.getString("product_code"));
				category.setBrand(rset.getString("brand"));
				category.setProductName(rset.getString("product_name"));
				category.setProductDesc(rset.getString("product_desc"));
				category.setProductImg(rset.getString("product_img"));
				list.add(category);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("listDAO@"+list);
		return list;
	}

	
	
	public int insertProductCategory(Connection conn, ProductCategory pc) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProductCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pc.getProductCode());
			pstmt.setString(2, pc.getBrand());
			pstmt.setString(3, pc.getProductName());
			pstmt.setString(4, pc.getProductDesc());
			pstmt.setString(5, pc.getProductImg());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public String findCodeCount(Connection conn, String category) {
		String productCode = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findCodeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category+"%");
			rset = pstmt.executeQuery();
			int cnt = 0;
			if(rset.next()) {
				cnt = rset.getInt(1);
				System.out.println(cnt);
			}
			productCode = category+(cnt+1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("productCode@dao="+productCode);
		
		return productCode;
	}

	public List<ProductCategory> selectProductCategory(Connection conn, String memberId) {
		List<ProductCategory> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProductCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ProductCategory pc = new ProductCategory();
				pc.setProductCode(rset.getString("product_code"));
				pc.setBrand(rset.getString("brand"));
				pc.setProductName(rset.getString("product_name"));
				pc.setProductDesc(rset.getString("product_desc"));
				pc.setProductImg(rset.getString("product_img"));
				
				list.add(pc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	

}
