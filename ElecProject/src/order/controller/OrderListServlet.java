package order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import order.model.service.OrderListService;
import order.model.vo.OrderBrand;
import order.model.vo.OrderList;
import order.model.vo.OrderListInfo;
import order.model.vo.OrderListSeller;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Member memberLoggedIn = (Member)request.getSession().getAttribute("memberLoggedIn");
		String memberId = memberLoggedIn.getMemberId();
		String memberRole = memberLoggedIn.getMemberRole();
		
		OrderListService orderListService = new OrderListService();
		
		if(memberRole.equals("S")){ //판매자
			List<OrderBrand> orderNoList = orderListService.selectOrderNoList(memberId); 
			List<OrderListInfo> orderListSeller = null;
			Map<OrderBrand, Object> orderMapSeller = new HashMap<OrderBrand, Object>();
			for(OrderBrand ob : orderNoList) {
				orderListSeller = orderListService.selectOrderListSeller(ob.getOrderNo(), memberId);
				orderMapSeller.put(ob, orderListSeller);
			}
			request.setAttribute("orderMapSeller", orderMapSeller);
		}
		
		if(memberRole.equals("B")) { //구매자
			List<OrderList> orderList = orderListService.selectOrderList(memberId);
			List<OrderListInfo> orderListInfo = null;
			Map<OrderList, Object> orderMap = new HashMap<OrderList, Object>();
			for(OrderList ol : orderList) {
				orderListInfo = orderListService.selectOrderDetailList(ol.getOrderNo());
				orderMap.put(ol, orderListInfo);
			}
			request.setAttribute("orderMap", orderMap);
		}
		
		String view = "/WEB-INF/views/order/OrderListPage.jsp";
		request.getRequestDispatcher(view)
			   .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
