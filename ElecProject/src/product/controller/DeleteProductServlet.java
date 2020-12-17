package product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.ProductService;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/seller/delete")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] serialArr = request.getParameter("list").split(",");
		String memberId = request.getParameter("id");
		int cPage = Integer.parseInt(request.getParameter("cPage"));
		
	
		int result = new ProductService().deleteProduct(serialArr);
		
		if(result>0) {
			System.out.println("삭제성공~");
		}
		else {
			System.out.println("삭제실패~");
		}
		
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
