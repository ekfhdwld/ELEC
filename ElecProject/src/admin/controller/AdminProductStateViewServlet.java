package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productState.model.service.ProductStateService;
import productState.model.vo.ProductRankState;
import productState.model.vo.ProductState;

/**
 * Servlet implementation class productStateViewServlet
 */
@WebServlet("/admin/stateView")
public class AdminProductStateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductStateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.사용자 입력값처리
		
		//2.업무로직: productStatus 모든 행 조회
		List<ProductState> list = new ProductStateService().selectAll();
//		System.out.println("list@servlet = " + list);
		
		List<ProductRankState> rankList =  new ProductStateService().selectRankListAll();
		System.out.println("rankList@servlet = " + rankList);
		
		//3.view단 처리 : /WEB-INF/views/admin/productStateView.jsp
		request.setAttribute("list", list);
		request.setAttribute("rankList", rankList);
		request.getRequestDispatcher("/WEB-INF/views/admin/productStateView.jsp")
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
