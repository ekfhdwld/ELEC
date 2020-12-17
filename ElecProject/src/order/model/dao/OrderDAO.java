package order.model.dao;

import java.io.FileReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cart.model.vo.Cart;

import static common.JDBCTemplate.*;

import member.model.dao.MemberDAO;


public class OrderDAO {
	
	private static Properties prop = new Properties();
	
	public OrderDAO(){

		String fileName = "/sql/order/order-query.properties";
				fileName =  MemberDAO.class.getResource(fileName)
										   .getPath();

				try {
					prop.load(new FileReader(fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
	

	public static int InsertOrder(Connection conn, String userName, String userphone, String useradd) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("paylistInsert"); 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,useradd);
			pstmt.setString(2,userName);
			pstmt.setString(3,userphone);
			
			result = pstmt.executeUpdate();
			System.out.println("resultDAO" + result);
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally{
			close(pstmt);
		}	
		return result;
	}


	public static Cart selectOne(Connection conn, String cartNo) {
		Cart cart = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			if(rset.next()) {
				cart = new Cart();
				
				
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return cart;
	}


//	public static List<Cart> cartListNo(Connection conn, Cart cartlist) {
//		List<Cart> list = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String query = prop.getProperty("cartListNo");
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, cart[i]);
//			rset = pstmt.executeQuery();
//			list = new ArrayList<Cart>();
//			while(rset.next()) {
//				Cart cart = new Cart();
//				cart.setCartNo(rset.getInt("CartNo"));
//				cart.setMemberId(rset.getString("membmerId"));
//				cart.setProdSerialCode(rset.getString("ProdSerialcode"));
//				cart.setAmount(rset.getInt("Amount"));
//				
//				System.out.println(cart);
//				list.add(cart);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//
//	
//		return list;
//	}

}
