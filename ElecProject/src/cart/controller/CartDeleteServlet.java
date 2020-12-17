package cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.model.service.CartService;
import member.model.vo.Member;

/**
 * Servlet implementation class CartDeleteServlet
 */
@WebServlet("/cart/delete")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodSerialCode = request.getParameter("prodSerialCode");
		Member memberLoggedIn = (Member)request.getSession().getAttribute("memberLoggedIn");
		
		String memberId = memberLoggedIn.getMemberId();
		
		
		CartService cartService = new CartService(); 
		
		
		int result = cartService.deleteFromCart(prodSerialCode, memberId);
		System.out.println("result@servlet = " + result);
		
		String msg = "";
		String loc = request.getContextPath() + "/cart/view";
		String view = "/WEB-INF/views/common/msg.jsp";
		if(result > 0) {
			msg = "상품삭제 성공!";
		}else {
			msg = "상품삭제 실패!";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
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
