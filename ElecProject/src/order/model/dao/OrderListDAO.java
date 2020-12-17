package order.model.dao;

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

import order.model.vo.Order;
import order.model.vo.OrderBrand;
import order.model.vo.OrderList;
import order.model.vo.OrderListInfo;
import order.model.vo.OrderListSeller;


public class OrderListDAO {
	private static Properties prop = new Properties();

	public OrderListDAO() {
		String fileName = "/sql/order/order-query.properties";
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public int insertOrder(Connection conn, int ordertotal,String memberId, String paddress, String userName, String userphone) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql ="insert into order_list values(seq_order_no.nextval,?,?,default,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ordertotal);
			pstmt.setString(2, memberId);
			pstmt.setString(3, paddress);
			pstmt.setString(4, userName);
			pstmt.setString(5, userphone);
					
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("orderList=" + result);
		return result;
	}

	



	public int insertOrderDetail(Connection conn, String orderSerial, int orderQuantity, int orderNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql ="insert into order_detail values(seq_o_no.nextval, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, orderNo);
			pstmt.setString(2, orderSerial);
			pstmt.setInt(3, orderQuantity);
				
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("orderList=" + result);
		return result;
	}



	

	public int selectOrderNum(Connection conn, String memberId) {
		int orderNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from( select order_no from order_list  where member_id = ? order by order_no DESC) where ROWNUM = 1";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {				
				orderNo = rset.getInt("order_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return orderNo;
	}



	public List<OrderList> selectOrderList(Connection conn, String memberId) {

		List<OrderList> list = new ArrayList<OrderList>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String query = "select * from order_list where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				OrderList ol = new OrderList();
				
				ol.setOrderNo(rset.getInt(1));
				ol.setOrderTotal(rset.getInt(2));
				ol.setMemberId(rset.getString(3));
				ol.setOrderDate(rset.getDate(4));
				ol.setAddress(rset.getString(5));
				ol.setRecipient(rset.getString(6));
				ol.setRecipientPhone(rset.getString(7));
				
				list.add(ol);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("list@dao = "+ list);
		
		return list;
	}



	public List<OrderListInfo> selectOrderDetailList(Connection conn, int orderNo) {
		List<OrderListInfo> list = new ArrayList<OrderListInfo>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String query = "select od.order_no, pc.product_code, pc.product_name,  p.inch, color.color_eng_name, p.capacity, p.price, p.discount_rate, od.amount, pc.product_img from order_detail od left join product p on od.prod_serial_code = p.prod_serial_code left join product_category pc on pc.product_code = p.prod_code left join product_color color on color.color_code = p.color where od.order_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				OrderListInfo oli = new OrderListInfo();
				
				oli.setOrderNo(rset.getInt(1));
				oli.setProductCode(rset.getString(2));
				oli.setProductName(rset.getString(3));
				oli.setInch(rset.getString(4));
				oli.setColorName(rset.getString(5));
				oli.setCapacity(rset.getString(6));
				oli.setPrice(rset.getInt(7));
				oli.setDiscountRate(rset.getInt(8));
				oli.setAmount(rset.getInt(9));
				oli.setProductImg(rset.getString(10));
				
				list.add(oli);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("list@dao = "+ list);
		
		return list;
	}



	public List<OrderBrand> selectOrderNoList(Connection conn, String memberId) {
		List<OrderBrand> list = new ArrayList<OrderBrand>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String query = "select distinct ol.order_no, ol.order_date , ol.member_id, ol.recipient, ol.recipient_phone, ol.address "  
				+ "from order_detail od left join order_list ol on od.order_no = ol.order_no left join product p on p.prod_serial_code = od.prod_serial_code left join product_category pc on pc.product_code = p.prod_code " 
				+ "where pc.brand = ? order by order_no";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				OrderBrand ob = new OrderBrand();
				
				ob.setOrderNo(rset.getInt(1));
				ob.setOrderDate(rset.getDate(2));
				ob.setMemberId(rset.getString(3));
				ob.setRecipient(rset.getString(4));
				ob.setRecipientPhone(rset.getString(5));
				ob.setAddress(rset.getString(6));
				
				list.add(ob);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		System.out.println("list@dao = " + list);
		return list;
	}



	public List<OrderListInfo> selectOrderListSeller(Connection conn, int orderNo, String memberId) {
		
		List<OrderListInfo> list = new ArrayList<OrderListInfo>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String query = "select  pc.product_name, p.inch, p.capacity, color.color_eng_name, pc.product_img, od.amount " + 
				"from order_detail od left join order_list ol on od.order_no = ol.order_no left join product p on p.prod_serial_code = od.prod_serial_code left join product_category pc on pc.product_code = p.prod_code left join product_color color on color.color_code = p.color " + 
				"where pc.brand = ? and ol.order_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, orderNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				OrderListInfo oli = new OrderListInfo();
				
				oli.setProductName(rset.getString(1));
				oli.setInch(rset.getString(2));
				oli.setCapacity(rset.getString(3));
				oli.setColorName(rset.getString(4));
				oli.setProductImg(rset.getString(5));
				oli.setAmount(rset.getInt(6));
				
				list.add(oli);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("list@dao = " + list);
		
		return list;
		
	}


}
	
	
	



