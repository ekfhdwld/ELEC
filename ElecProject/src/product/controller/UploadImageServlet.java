package product.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class uploadImageServlet
 */
@WebServlet("/product/uploadImage")
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String saveDirectory = readTempFolder();
		int maxPostSize = 10 * 1024 * 1024;
		String encoding = "utf-8";
		MultipartRequest mr = new MultipartRequest(request, saveDirectory, 
				maxPostSize, encoding);
		String brand = (String)mr.getParameter("brand");
		
		//업로드된 파일명 변경
		if(reNameTo(saveDirectory, mr)) {
			request.setAttribute("msg", "이미지 등록 완료!");
		}
		else {
			request.setAttribute("msg", "이미지 등록 완료! 리네임은 실패!;");
		}
		request.setAttribute("msg", "상품 등록 완료!");
		request.getRequestDispatcher("/seller/list?memberId="+brand+"&cPage=1")
		.forward(request, response);
		
	}

	private boolean reNameTo(String saveDirectory, MultipartRequest mr) {
		//오리지널네임 추출
		String originalThumName = mr.getOriginalFileName("thum");
		String originalAdImg1 = mr.getOriginalFileName("adImg1");
		String originalAdImg2 = mr.getOriginalFileName("adImg2");
		//이미지파일객체
		File thum = new File(saveDirectory+"/"+originalThumName);
		File adImg1 = new File(saveDirectory+"/"+originalAdImg1);
		File adImg2 = new File(saveDirectory+"/"+originalAdImg2);
		//리네임 실행
		boolean bool1 = thum.renameTo(new File(saveDirectory+"/thum.png"));
		boolean bool2 = adImg1.renameTo(new File(saveDirectory+"/adImg1.png"));
		boolean bool3 = adImg2.renameTo(new File(saveDirectory+"/adImg2.png"));
		
		if(bool1&&bool2&&bool3) return true;
		else return false;
	}

	private String readTempFolder() {
		
		String result = "";
		try {
			FileReader fr = new FileReader("C:/Temp/temp.txt");
			int nextC= 0;
			while((nextC=fr.read())!=-1) {
				
				result += (char)nextC;
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("잘 읽어왓는감~? "+result);
		
		return result;
	}
	
	
	

}
