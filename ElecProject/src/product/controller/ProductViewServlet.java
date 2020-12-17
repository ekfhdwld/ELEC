package product.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.vo.Board;
import product.model.service.ProductService;
import product.model.vo.ProductInfo;

/**
 * Servlet implementation class ProductViewServlet
 */
@WebServlet("/product/productview")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductViewServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodCode = request.getParameter("productCode");
		String inch = request.getParameter("inch");
	
		String rvo = request.getParameter("rvo") == null ? 
				"off" : request.getParameter("rvo");
	
		ProductService productService = new ProductService();
		
		Map<String, String> colorMap = productService.selectColorOption(prodCode, inch); 
		List<String> capaList = productService.selectCapaOption(prodCode, inch); 
		ProductInfo productInfo = productService.getProductInfo(prodCode, inch); 
		
		List<ProductInfo> otherProducts = productService.getOtherProducts(prodCode, inch); 
		List<Board> reviewList = productService.getReviewBoard(prodCode);
		
		String view = "";
		if(inch.equals("0")) 
			view = "/WEB-INF/views/productView/ProductViewPhone.jsp"; //핸드폰
		else 
			view = "/WEB-INF/views/productView/ProductViewNotebook.jsp"; //노트북
		
		
		request.setAttribute("colorMap", colorMap);
		request.setAttribute("capaList", capaList);
		request.setAttribute("productInfo", productInfo);
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("otherProducts", otherProducts);
		request.setAttribute("rvo", rvo);
		request.getRequestDispatcher(view)
		   .forward(request, response);
	}

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}
	
}
