package product.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import board.model.vo.Board;
import cart.model.dao.CartDAO;
import product.model.vo.Product;
import product.model.vo.ProductInfo;
import product.model.vo.ProductL;

public class ProductDAO {

	private Properties prop = new Properties();
	
	public ProductDAO() {
		try {
			//클래스객체 위치찾기 : 절대경로를 반환한다. 
			String fileName = CartDAO.class.getResource("/sql/product/product-query.properties").getPath();
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public List<String> selectCapaOption(Connection conn, String prodCode, String inch) {
		List<String> list = new ArrayList<String>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectCapaOption");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prodCode);
			pstmt.setString(2, inch);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				
				list.add(rset.getString("capacity"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		System.out.println("list@dao = " + list);
		
		return list;
	}

	public ProductInfo getProductInfo(Connection conn, String prodCode, String inch) {
	
		ProductInfo productInfo = new ProductInfo();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("getProductInfo");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prodCode);
			pstmt.setString(2, inch);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				productInfo.setProductCode(rset.getString(1));
				productInfo.setProductName(rset.getString(2));
				productInfo.setInch(rset.getString(3));
				productInfo.setProductDesc(rset.getString(4));
				productInfo.setProductImg(rset.getString(5));
				productInfo.setPrice(rset.getInt(6));
				productInfo.setDiscountRate(rset.getInt(7));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return productInfo;
	}

	public List<ProductInfo> getOtherProducts(Connection conn, String prodCode, String inch) {
		List<ProductInfo> list = new ArrayList<ProductInfo>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("getOtherProducts");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prodCode);
			pstmt.setString(2, inch);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				ProductInfo pi = new ProductInfo();
				
				pi.setProductCode(rset.getString(1));
				pi.setProductName(rset.getString(2));
				pi.setInch(rset.getString(3));
				pi.setProductDesc(rset.getString(4));
				pi.setProductImg(rset.getString(5));
				
				list.add(pi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		System.out.println("list@dao = " + list);
		
		return list;
	}
	
	public double getProductGrade (Connection conn, String prodCode) {
		double grade = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("getProductGrade");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prodCode);
			rset = pstmt.executeQuery();
			
			rset.next();
				
			grade = rset.getDouble(1);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("grade@dao = " + grade);
		return grade;
	}

	public Map<String, String> selectColorOption(Connection conn, String prodCode, String inch) {
		Map<String, String> map = new HashMap<String, String>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectColorOption");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prodCode);
			pstmt.setString(2, inch);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				map.put(rset.getString(1), rset.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("map@dao = " + map);
		return map;
	}

	public List<Board> getReviewBoard(Connection conn, String prodCode) {
		List<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("getReviewBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prodCode);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Board b = new Board();
				
				b.setBoardNo(rset.getInt(1));
				b.setBoardWriter(rset.getString(2));
				b.setBoardContent(rset.getString(3));
				b.setBoardDate(rset.getDate(4));
				b.setBoardGrade(rset.getInt(5));
				b.setProdSerialCode(rset.getString(6));
				
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		System.out.println("list@dao = " + list);
		
		return list;
	}
	
	
	public int insertProduct(Connection conn, List<Product> list) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(Product p : list) {
				
				pstmt.setString(1, p.getProdSerialCode());
				pstmt.setString(2, p.getProdCode());
				pstmt.setString(3, p.getCategory());
				pstmt.setString(4, p.getColor());
				pstmt.setString(5, p.getInch());
				pstmt.setString(6, p.getCapacity());
				pstmt.setInt(7, p.getPrice());
				pstmt.setInt(8, p.getDiscountRate());

				result = pstmt.executeUpdate();
				
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		System.out.println("result@productDAO="+result);
		
		return result;
	}

	public List<Product> selectProduct(Connection conn, String memberId) {
		List<Product> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product();
				p.setProdSerialCode(rset.getString("prod_serial_code"));
				p.setProdCode(rset.getString("prod_code"));
				p.setCategory(rset.getString("category"));
				p.setColor(rset.getString("color"));
				p.setInch(rset.getString("inch"));
				p.setCapacity(rset.getString("capacity"));
				p.setStock(rset.getInt("stock"));
				p.setPrice(rset.getInt("price"));
				p.setDiscountRate(rset.getInt("discount_rate"));
				p.setProdDelete(rset.getString("prod_delete"));
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public List<ProductL> selectProductL(Connection conn, String memberId) {
		
		List<ProductL> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProductL");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ProductL pl = new ProductL();
				
				pl.setProdSerialCode(rset.getString("prod_serial_code"));
				pl.setAmount(rset.getInt("stock"));
				pl.setProductName(rset.getString("product_name"));
				pl.setInch(rset.getString("inch"));
				pl.setColorName(rset.getString("color_name"));
				pl.setDiscountRate(rset.getInt("discount_rate"));
				pl.setPrice(rset.getInt("price"));
				pl.setProductImg(rset.getString("product_img"));
				pl.setCapacity(rset.getString("capacity"));
				
				list.add(pl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int updateAmount(Connection conn, String code, int amount) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAmount");
		int result = 0;
		
		System.out.println(code+amount);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.setInt(2, amount);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		System.out.println("result@dao="+result);
		
		return result;
	}

	public int searchCodeCount(Connection conn, String serial) {

		int cnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchCodeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serial);
			pstmt.setString(2, serial);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				cnt = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("search@dap ="+cnt);
		
		return cnt;
	}

	public int deleteProductCategory(Connection conn, String serial) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteProductCategory");
		int result = 0;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serial);
			pstmt.setString(2, serial);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		System.out.println("resultC@dao="+result);
		
		return result;
		
	}

	public int deleteProduct(Connection conn, String serial) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteProduct");
		int result = 0;
		System.out.println("serial@dao="+serial);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serial);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectProductCount(Connection conn, String memberId) {
		int cnt = 0;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String sql = prop.getProperty("productCount");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				cnt = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		System.out.println("count@dao="+cnt);
		
		return cnt;
	}

	public List<ProductL> selectProductList(Connection conn, String brand, int cPage, int numPerPage) {
		
		List<ProductL> list = new ArrayList<>();
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProductList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brand);
			pstmt.setInt(2, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(3, cPage * numPerPage);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ProductL pl = new ProductL();
				pl.setProdSerialCode(rset.getString("prod_serial_code"));
				pl.setAmount(rset.getInt("stock"));
				pl.setProductName(rset.getString("product_name"));
				pl.setInch(rset.getString("inch"));
				pl.setColorName(rset.getString("color_name"));
				pl.setDiscountRate(rset.getInt("discount_rate"));
				pl.setPrice(rset.getInt("price"));
				pl.setProductImg(rset.getString("product_img"));
				pl.setCapacity(rset.getString("capacity"));
				
				list.add(pl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("list@dao="+list);
		
		
		return list;
	}

	public List<ProductL> selectAllProduct(Connection conn, String category) {

		List<ProductL> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ProductL pl = new ProductL();
				
				pl.setProdSerialCode(rset.getString("product_code"));
				pl.setAmount(0);
				pl.setProductName(rset.getString("product_name"));
				pl.setInch(rset.getString("inch"));
				pl.setColorName(null);
				pl.setDiscountRate(0);
				pl.setPrice(0);
				pl.setProductImg(rset.getString("product_img"));
				pl.setCapacity(null);
				
				list.add(pl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<ProductL> selectCategory(Connection conn, String brand) {

		List<ProductL> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brand);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ProductL pl = new ProductL();
				
				pl.setProdSerialCode(rset.getString("product_code"));
				pl.setAmount(0);
				pl.setProductName(rset.getString("product_name"));
				pl.setInch(rset.getString("inch"));
				pl.setColorName(null);
				pl.setDiscountRate(0);
				pl.setPrice(0);
				pl.setProductImg(rset.getString("product_img"));
				pl.setCapacity(null);
				
				list.add(pl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	
}
