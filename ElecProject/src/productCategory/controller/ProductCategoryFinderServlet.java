package productCategory.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Utils;

import productCategory.model.service.ProductCategoryService;
import productCategory.model.vo.ProductCategory;



/**
 * Servlet implementation class ProductCategoryFinderServlet
 */
@WebServlet("/productFinder")
public class ProductCategoryFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCategoryFinderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. parameter handling
		
		String searchKeyword = request.getParameter("searchKeyword");
		
		Map<String, Object> param = new HashMap<>();
	
		param.put("searchKeyword", searchKeyword);
		System.out.println("param = " + param);
		
		//2. business logic
		List<ProductCategory> pList = new ProductCategoryService().searchProduct(param);
		System.out.println("list@servlet = " + pList);
		
		//페이지바 문자열을 리턴할 static메소드 호출
		//String url = request.getRequestURI() + "&searchKeyword=" + searchKeyword;
		
		String view = "/WEB-INF/views/productCategory/ProductCategory.jsp";
		//3. view handling
		
		
		request.setAttribute("pList", pList);
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
