package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Utils;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		password = Utils.getEncryptedPassword(password); //비밀번호 암호화
		
		String saveId = request.getParameter("saveId");
		System.out.println("saveId@servlet = " + saveId);
		
		Member member = new MemberService().selectOne(memberId);
		
		String view = "";
		//로그인 성공
		if(member != null && password.equals(member.getMemberPwd())) {
			HttpSession session = request.getSession(true);
			session.setAttribute("memberLoggedIn", member);
	
			Cookie cookie = new Cookie("saveId", memberId);
			cookie.setPath(request.getContextPath());// /mvc이하 디렉토리에서 사용
			
			if(saveId != null)
				cookie.setMaxAge(7*24*60*60); //7일간 브라우져에서 보관
			else
				cookie.setMaxAge(0);//즉시삭제. 브라우져에 이미 존재하는 쿠키를 삭제.
			
			response.addCookie(cookie);
			
			String referer = request.getHeader("referer");
			response.sendRedirect(referer);
			
		}else {
			view = "/WEB-INF/views/common/msg.jsp";
			request.setAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
			request.setAttribute("loc", request.getContextPath());
			request.getRequestDispatcher(view)
				   .forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
