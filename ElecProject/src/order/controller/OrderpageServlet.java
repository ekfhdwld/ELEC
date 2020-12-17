package order.controller;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;




/**
 * Servlet implementation class orderpage
 */
@WebServlet("/order/orderpage")
public class OrderpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderpageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true); 
		Member memberLoggedIn =(Member)session.getAttribute("memberLoggedIn");
		 
		String orderQuantityList = request.getParameter("orderQuantityList");
		String totalPrice = request.getParameter("totalPrice");
		String orderSerialcode = request.getParameter("orderSerialcode");

		request.setAttribute("memberId", memberLoggedIn);
		request.setAttribute("orderSerialcode",orderSerialcode);
		request.setAttribute("totalPrice",totalPrice);
		request.setAttribute("orderQuantityList",orderQuantityList);

		request.getRequestDispatcher("/WEB-INF/views/order/orderpage.jsp")
			   .forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
