package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import member.model.vo.Member;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
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
		request.setCharacterEncoding("utf-8");      
		
		Member memberLoggedIn = (Member)request.getSession().getAttribute("memberLoggedIn");
		String memberId = memberLoggedIn.getMemberId();
		String boardContent = request.getParameter("inputReview"); // 리뷰내용 받아오기
		String prodCode = request.getParameter("prodCode"); // 제품코드 가져오기
		String grade = request.getParameter("reivewGrade");
		
		String inch = request.getParameter("prodInch");
		int boardGrade = Integer.parseInt(grade);
		
		BoardService boardService = new BoardService();
		
		int result = boardService.insertBoard(memberId, boardContent, boardGrade, prodCode);
		
		String view = "/WEB-INF/views/common/reviewMsg.jsp";
		String msg = "";
		String loc = request.getContextPath() + "/product/productview";
		
		if(result > 0)  msg = "리뷰등록이 성공되었습니다";
		else  msg = "리뷰등록에 실패하였습니다.";
		
		
		request.setAttribute("loc", loc);
		request.setAttribute("msg", msg);
		request.setAttribute("prodCode", prodCode);
		request.setAttribute("inch", inch);
		request.getRequestDispatcher(view)
			   .forward(request, response);
		
		
		
	}

}
