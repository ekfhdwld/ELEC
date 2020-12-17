package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Utils;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberListServlet
 */
@WebServlet("/admin/memberList")
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * 페이징처리
	 * 
	 * 공식3 + 필요변수
	 * a. 시작rnum, 끝rnum
	 * b. totalPage 
	 * c. pageStart
	 * 
	 * 1. contents영역
	 * 		cPage 현재페이지
	 * 		numPerPage 한페이지당 게시물수
	 * 		
	 * 2. pageBar영역
	 * 		totalContents 전체게시물수
	 * 		totalPage 전체페이지
	 * 		pageBarSize 페이지바에 표시될 페이지수
	 * 		pageStart | pageEnd 페이지바의 시작/끝 페이지넘버
	 * 		pageNo 증감변수
	 * 		
	 * 	
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.사용자입력값처리
		//최초페이지 입력시, 값업음
		int numPerPage = 10;
		int cPage = 1;
		try {
			//사용자 입력값받아서 cpage에 담는다.
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			//여기 코드 안써도 cpage안에는 1이 담겨잇어서 문제없음
		}
		//2.업무로직 : member테이블의 모든 행 조회
		List<Member> list = new MemberService().selectAll(cPage, numPerPage);
		System.out.println("list@servlet = "+ list);
		int totalContents = new MemberService().getTotalContents();
		System.out.println("totalContents@servlet = " + totalContents);
		
		//페이지바 문자열을 리턴할 static메소드 호출
		String url = request.getRequestURI();// /elec/admin/memberList
		String pageBar = Utils.getPageBarHtml(cPage, numPerPage, totalContents, url);
		
		//3. VIEW단 처리 : /WEB-INF/views/admin/memberList.jsp
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp")
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
