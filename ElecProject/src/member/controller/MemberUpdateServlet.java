package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String memberId = request.getParameter("userId");
		String memberName = request.getParameter("userName");
		String memberRole = request.getParameter("memberRole");
		String memberPhone = request. getParameter("userPhone");
		String postAddress = request.getParameter("roadFullAddr");

		Member member = new Member(memberId,memberName,null,memberRole
				,memberPhone,postAddress,null,null);
		
		int result = new MemberService().updateMember(member);
			
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = request.getContextPath() + "/member/view?memberId="+memberId;

		if(result>0){
			msg = "성공적으로 회원정보를 수정했습니다.";
			HttpSession session = request.getSession();
			Member updateMember = new MemberService().selectOne(memberId);
			Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");

			if(memberId.equals(memberLoggedIn.getMemberId()))
				session.setAttribute("memberLoggedIn", updateMember);
		}
		else { 
			msg = "회원정보수정에 실패했습니다.";	
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
