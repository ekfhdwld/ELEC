package order.model.service;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import cart.model.vo.Cart;
import order.model.dao.OrderDAO;


public class OrderService {
		
	public int InsertUser(String userName, String userphone, String useradd) {
		Connection conn = getConnection();
		
		int result = OrderDAO.InsertOrder(conn,userName,userphone,useradd);
		System.out.println("result service=" + result);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}


	public Cart selectOne(String cartNo) {
		Connection conn = getConnection();
		Cart cart = OrderDAO.selectOne(conn, cartNo);
		close(conn);
		return cart;
	}

//	public List<Cart> cartListNo(Cart cartlist) {
//		Connection conn = getConnection();
//		List<Cart> list = OrderDAO.cartListNo(conn,cartlist);
//		close(conn);
//		return list;
//	}

}
