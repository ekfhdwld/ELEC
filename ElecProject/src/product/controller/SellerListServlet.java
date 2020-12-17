package product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Utils;

import product.model.service.ProductService;
import product.model.vo.ProductL;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/seller/list")
public class SellerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerListServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		
		int numPerPage = 10;//한페이지당 수
		int cPage = 1;//요청페이지
		try{
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e){
			e.printStackTrace();
		}
		System.out.println("cPage="+cPage); 
		
		List<ProductL> list = new ProductService().selectProductList(memberId, cPage, numPerPage);
		System.out.println("list="+list);
		
		int totalContents = new ProductService().selectProductCount(memberId);
		
		String url = request.getRequestURI();//  /mvc/board/list
		String pageBar = Utils.getPageBarHtml(memberId, cPage, numPerPage, totalContents, url);

		request.setAttribute("list",list);
		request.setAttribute("pageBar",pageBar);	
		request.setAttribute("cPage", cPage);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/product/sellerList.jsp")
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
