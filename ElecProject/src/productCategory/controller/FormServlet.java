package productCategory.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.ProductService;
import product.model.vo.Product;
import productCategory.model.service.ProductCategoryService;
import productCategory.model.vo.ProductCategory;

/**
 * Servlet implementation class formH
 */
@WebServlet("/seller/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String category= request.getParameter("category");
		String productCode = makeCode(category);
		String brand = request.getParameter("brand");
		String productName = request.getParameter("productName");
		String inch = request.getParameter("inch");
		String[] descArr = request.getParameterValues("option");
		String productDesc = "";

		for (int i = 0; i < descArr.length; i++) {
			productDesc += descArr[i];
			if (i != descArr.length - 1)
				productDesc += ",";
		}

		String productImg = "/upload/" + brand + "/" +category+ "/"+productCode;
		String saveDirectory = saveDirectory(productImg); // 이미지폴더 생성

		ProductCategory pc = new ProductCategory(productCode, brand, 
				productName, productDesc, productImg);

		int result1 = new ProductCategoryService().insertProductCategory(pc);
		
		if (result1 > 0) makeTempFolder(saveDirectory); //temp파일 입력
		else 	System.out.println("카테고리 실패");

		List<Product> list = makeSerialCode(productCode, request, inch);
		//제품 등록
		int result2 = new ProductService().insertProduct(list);
		
		if(result2>0) System.out.println("제품 성공");
		else System.out.println("제품 실패");
		
		request.setAttribute("msg", "등록 성공 ! 이미지 업로드로 넘어갑니다.");
		request.setAttribute("brand", brand);
		request.setAttribute("productCode", productCode);
		request.setAttribute("category", category);
		request.getRequestDispatcher("/WEB-INF/views/product/uploadImage.jsp")
				.forward(request, response);
		
	}

	private void makeTempFolder( String saveDirectory) {
		try {
			
			File newFolder = new File("C:/Temp");

			if (!newFolder.exists()) {
				newFolder.mkdirs();
				System.out.println("temp 디렉토리 생성");
			}
			
			File temp = new File("C:/Temp/temp.txt");
			FileWriter fw = new FileWriter(temp, false);
			
			fw.write(saveDirectory);
			
			fw.flush();
			fw.close();
			System.out.println("파일쓰기 완료, 내용="+saveDirectory);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}


	private String makeCode(String category) {
		
		String productCode = new ProductCategoryService().findCodeCount(category);
		
		return productCode;
	}

	public String saveDirectory(String productImg) {

		System.out.println("getServletContext = " + getServletContext());
		System.out.println("getServletContext.getRealPath = " + getServletContext().getRealPath(productImg));
		
		String saveDirectory = getServletContext().getRealPath(productImg);
		File newFile = new File(saveDirectory);

		// 이미지업로드폴더 생성
		if (!newFile.exists()) {
			newFile.mkdirs();
			System.out.println("디렉토리 생성 굿");
		}
		return saveDirectory;
	}

	public List<Product> makeSerialCode(String productCode, HttpServletRequest rq, String inch) {

		List<Product> list = new ArrayList<>();

		String[] color = rq.getParameterValues("color");
		String[] prices = rq.getParameterValues("price");
		String[] capacity = rq.getParameterValues("capacity");
		
		if(inch==null) {
			inch = "0";
		}
		
		//일련코드 만들기
		for (int i = 0; i < color.length; i++) {
			for (int j = 0; j < capacity.length; j++) {
				Product product = new Product();
				// 고정요소 세팅
				product.setProdCode(productCode);
				product.setCategory(rq.getParameter("category"));
				product.setInch(inch);
				product.setStock(50);
				product.setPrice(Integer.parseInt(prices[j]));
				product.setDiscountRate(Integer.parseInt(rq.getParameter("discountRate")));
				product.setProdDelete("N");
				
				String color_ = color[i];
				String before = capacity[j];
				String after = before.substring(0, before.length()-2);
				String serialCode = productCode + color_.toUpperCase() + "I"+inch + "M" + after;

				product.setProdSerialCode(serialCode);
				product.setColor(color_.toLowerCase());
				product.setCapacity(before);
				System.out.println(color_);
				list.add(product);
			}
		}

		return list;

	}
}
