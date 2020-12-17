package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Utils;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdatePasswordServlet
 */
@WebServlet("/member/updatePassword")
public class MemberUpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/member/updatePassword.jsp");
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId= request.getParameter("memberId");
		String password = Utils.getEncryptedPassword(request.getParameter("password"));
		String password_new = Utils.getEncryptedPassword(request.getParameter("password_new"));
		
		Member member = new MemberService().selectOne(memberId);
		
		String msg="";
		String loc = "";
		String view ="/WEB-INF/views/common/msg.jsp";
		
		if (member != null&& password.equals(member.getMemberPwd())){
			System.out.println("넘어와라!");
			System.out.println("password_new누구냔"+password_new);
			//현재 member객체에 갱신할 비밀번호를 업데이트
			member.setMemberPwd(password_new);
			int result = new MemberService().updatePassword(member);
			if(result>0){
				msg = "패스워드 변경 성공";
				request.setAttribute("script", "self.close();");
			}
				
		}
		else {
			msg = "패스워드를 잘못 입력하셨습니다.";
			loc = request.getContextPath() + "/member/updatePassword?memberId="+memberId;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);

	}

}