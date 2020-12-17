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
 * Servlet implementation class CartInsertServlet
 */
@WebServlet("/cart/insert")
public class CartInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		Member memberLoggedIn = (Member) request.getSession().getAttribute("memberLoggedIn");
		String memberId = memberLoggedIn.getMemberId();
		String serialCode = request.getParameter("serialCode");
		System.out.println("serialCode = " + serialCode);
		
		CartService cartService = new CartService(); 
		int result = cartService.insertCartProduct(serialCode, memberId);
		
		String msg = "";
		String view = "/WEB-INF/views/common/msg.jsp";
		String loc = request.getContextPath() + "/cart/view";
		if(result > 0) {
			msg = "장바구니 상품 담기 성공!";
		}else {
			msg = "장바구니 상품 담기 실패!";
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
