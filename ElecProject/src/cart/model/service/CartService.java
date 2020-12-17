package cart.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import cart.model.dao.CartDAO;
import cart.model.vo.CartInfo;

public class CartService {
	private CartDAO cartDAO = new CartDAO();


	public List<CartInfo> getCartInfoList(String memberId) {
		Connection conn = getConnection();
		List<CartInfo> list = cartDAO.getCartInfoList(conn, memberId);
		System.out.println("list@service = " + list);
		close(conn);
		return list;
	}

	public int deleteFromCart(String prodSerialCode, String memberId) {
		Connection conn = getConnection();
		int result = cartDAO.deleteFromCart(conn, prodSerialCode, memberId);
		System.out.println("result@service = " + result);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	public int insertCartProduct(String serialCode, String memberId) {
		Connection conn = getConnection();
		int count = cartDAO.getCountProduct(conn, serialCode, memberId);
		int result = 0;
		if(count == 0 ) {
			result = cartDAO.insertCartProduct(conn, serialCode, memberId);
		}else {
			result = cartDAO.updateCartProduct(conn, serialCode, memberId, count+1);
		}
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}
}
