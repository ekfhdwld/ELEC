package order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import order.model.service.OrderListService;

@WebServlet("/payOrder/orderList")
public class PayOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userName = (String) request.getParameter("userName");
		String userphone = (String)request.getParameter("userPhone");
		String paddress = (String)request.getParameter("paddress");
		
		String orderQuantityList = (String)request.getParameter("orderQuantityList");
		int ordertotal = Integer.parseInt(request.getParameter("totalPrice"));
		String orderSerialcode = (String)request.getParameter("orderSerialcode");
		
		Member memberLoggedIn = (Member)request.getSession().getAttribute("memberLoggedIn");
		String memberId = memberLoggedIn.getMemberId();
		
		String[] orderQuantity = orderQuantityList.split(",");
		int [] orderQuantityInt = new int[orderQuantity.length];
		for(int i=0; i<orderQuantity.length; i++) 
			orderQuantityInt[i] = Integer.parseInt(orderQuantity[i]);

		String[] orderSerial = orderSerialcode.split(",");
		
		OrderListService orderService = new OrderListService();
		
		int resultOfOrderList = orderService.insertOrder(ordertotal, memberId, paddress, userName, userphone);
		int resultOfDetail = 0;
		int orderNo;
		if(resultOfOrderList == 0) {
			System.out.println("주문내역 추가 실패!");
		}else {
			orderNo = orderService.selectOrderNum(memberId); 
			resultOfDetail = orderService.insertOrderDetail(orderSerial, orderQuantityInt, orderNo); 
		}
		
		String loc = "";
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		if(resultOfDetail == orderSerial.length) {
			msg = "주문내역 추가 성공";
			loc = request.getContextPath() + "/orderList"; 
		}else {
			msg = "주문내역 추가 실패";
			loc = request.getContextPath();
		}
		
		request.setAttribute("loc", loc);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(view)
				.forward(request, response);
	}

}


