package order.model.service;
import static common.JDBCTemplate.close;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import member.model.vo.Member;
import order.model.dao.OrderListDAO;
import order.model.vo.Order;
import order.model.vo.OrderBrand;
import order.model.vo.OrderList;
import order.model.vo.OrderListInfo;
import order.model.vo.OrderListSeller;


public class OrderListService {
	
	private OrderListDAO OrderListDAO = new OrderListDAO();


	public int insertOrder( int ordertotal, String memberId,
			String paddress, String userName, String userphone) {
		Connection conn = getConnection();	
		int result = OrderListDAO.insertOrder(conn,ordertotal,memberId,paddress,userName,userphone);	
		if(result >0)
			commit(conn);
		else
			rollback(conn);
		return result;
	}


	public int insertOrderDetail(String[] orderSerial, int[] orderQuantityInt, int orderNo) {
		Connection conn = getConnection();	
		int result = 0;
		for(int i=0; i<orderSerial.length; i++) {
			result += OrderListDAO.insertOrderDetail(conn, orderSerial[i], orderQuantityInt[i], orderNo);
		}

		if(result == orderSerial.length)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}


	

	public int selectOrderNum(String memberId) {
		Connection conn = getConnection();
		int orderNo = OrderListDAO.selectOrderNum(conn,memberId);
		close(conn);
		return orderNo;
	}


	public List<OrderList> selectOrderList(String memberId) {
		Connection conn = getConnection();
		List<OrderList> list = OrderListDAO.selectOrderList(conn, memberId);
		close(conn);
		System.out.println("list@service = " + list);
		return list;
	}


	public List<OrderListInfo> selectOrderDetailList(int orderNo) {
		Connection conn = getConnection();
		List<OrderListInfo> list = OrderListDAO.selectOrderDetailList(conn, orderNo);
		close(conn);
		System.out.println("list@service = " + list);
		return list;
	}


	public List<OrderBrand> selectOrderNoList(String memberId) {
		
		Connection conn = getConnection();
		List<OrderBrand> list = OrderListDAO.selectOrderNoList(conn, memberId);
		close(conn);
		System.out.println("list@service = " + list);
		return list;
		
	}


	public List<OrderListInfo> selectOrderListSeller(int orderNo, String memberId) {
		Connection conn = getConnection();
		List<OrderListInfo> list = OrderListDAO.selectOrderListSeller(conn, orderNo, memberId);
		close(conn);
		System.out.println("list@service = " + list);
		return list;
	}


	

}
