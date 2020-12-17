package product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.ProductService;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/seller/update")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		int amount = Integer.parseInt(request.getParameter("amount"));
		int cPage = Integer.parseInt(request.getParameter("cPage"));
		String memberId = request.getParameter("id");
		
		int result = new ProductService().updateAmount(code, amount);
		
		if(result>0)
			System.out.println("업데이트성공~");
		else
			System.out.println("업데이트실패~");
		
		response.sendRedirect(request.getContextPath()+"/seller/list?memberId="+memberId+"&cPage="+cPage);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
