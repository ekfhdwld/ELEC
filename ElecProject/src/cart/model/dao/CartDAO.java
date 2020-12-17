package cart.model.dao;

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

import cart.model.vo.Cart;
import cart.model.vo.CartInfo;
import product.model.vo.Product;
import productCategory.model.vo.ProductCategory;


public class CartDAO {

	private Properties prop = new Properties();
	
	public CartDAO() {
		try {
			//클래스객체 위치찾기 : 절대경로를 반환한다. 
			String fileName = CartDAO.class.getResource("/sql/cart/cart-query.properties").getPath();
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


//	public List<Cart> getCartList(Connection conn, String memberId) {
//		
//		List<Cart> list = new ArrayList<>();
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String query = prop.getProperty("getCartList");
//		
//		try {
//			
//			pstmt = conn.prepareStatement(query);
//			
//			pstmt.setString(1, memberId);
//			
//			rset = pstmt.executeQuery();
//			
//			while(rset.next()) {
//				Cart c = new Cart();
//				
//				c.setCartNo(rset.getInt("cart_no"));
//				c.setMemberId(rset.getString("member_id"));
//				c.setProdSerialCode(rset.getString("prod_serial_code"));
//				c.setAmount(rset.getInt("amount"));
//				
//				list.add(c);
//			}
//			
//		}catch(SQLException e){
//			e.printStackTrace();
//		}finally{
//			close(rset);
//			close(pstmt);
//		}
//		
//		return list;
//	}

	public List<CartInfo> getCartInfoList(Connection conn, String memberId) {
		List<CartInfo> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("getCartInfoList");

		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				CartInfo ci = new CartInfo();
				
				ci.setProdSerialCode(rset.getString(1));
				ci.setAmount(rset.getInt(2));
				ci.setProductName(rset.getString(3));
				ci.setInch(rset.getString(4));
				ci.setColorName(rset.getString(5));
				ci.setDiscountRate(rset.getInt(6));
				ci.setPrice(rset.getInt(7));
				ci.setProductImg(rset.getString(8));
				ci.setCapacity(rset.getString(9));
				
			
				
				list.add(ci);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		
		System.out.println("list@dao = " + list );
		return list;
	}


	public int deleteFromCart(Connection conn, String prodSerialCode, String memberId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteFromCart");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prodSerialCode);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		System.out.println("result@dao = " + result);
		
		return result;
	}


	public int insertCartProduct(Connection conn, String serialCode, String memberId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertCartProduct");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, serialCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		System.out.println("result@dao = " + result);
		
		return result;
	}


	public int getCountProduct(Connection conn, String serialCode, String memberId) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("getCountProduct");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, serialCode);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			count = rset.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
	
		System.out.println("count@dao = " + count);
		
		return count;
	}


	public int updateCartProduct(Connection conn, String serialCode, String memberId, int amount) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateCartProduct");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, amount);
			pstmt.setString(2, memberId);
			pstmt.setString(3, serialCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		System.out.println("result@dao = " + result);
		
		return result;
	}
	
}
