package payInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.model.vo.Cart;
import member.model.service.MemberService;
import member.model.vo.Member;
import order.model.service.OrderService;

/**
 * Servlet implementation class kakaopayServlet
 */
@WebServlet("/pay/kakao")
public class kakaopayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kakaopayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
//		  HttpSession session = request.getSession(true); Member
//		  memberLoggedIn=(Member)session.getAttribute("memberLoggedIn");
		 	String memberId = (String)request.getParameter("memberId");
			String userName = (String) request.getParameter("userName");
			String userphone = (String)request.getParameter("userPhone");
			String paddress = (String)request.getParameter("paddress");
			String orderQuantityList = (String)request.getParameter("orderQuantityList");
			String totalPrice = (String)request.getParameter("totalPrice");
			String orderSerialcode = (String)request.getParameter("orderSerialcode");
			
			
			
			request.setAttribute("memberId", memberId);
			request.setAttribute("orderSerialcode",orderSerialcode);
			request.setAttribute("totalPrice",totalPrice);
			request.setAttribute("orderQuantityList",orderQuantityList);
			request.setAttribute("userName", userName);		
			request.setAttribute("userPhone",userphone);
			request.setAttribute("paddress", paddress);
		 
		
		  System.out.println(memberId);
		  System.out.println("카orderSerialcode="+orderSerialcode);
		  System.out.println("카totalPrice="+totalPrice);
		  System.out.println("카orderQuantityList="+orderQuantityList);
		  System.out.println("카userName="+userName);
		  System.out.println("카userPhone="+userphone);
		  System.out.println("카paddress="+paddress);
		 
		  
		  request.getRequestDispatcher("/WEB-INF/views/payInfo/kakaopay.jsp").forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
