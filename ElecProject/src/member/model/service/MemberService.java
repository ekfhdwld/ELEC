package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	
	public static final String USER_MEMBER_ROLE = "B";
	public static final String ADMIN_MEMBER_ROLE = "A";
	public static final String SELLER_MEMBER_ROLE = "S";
	
	private MemberDAO memberDAO = new MemberDAO();

	public Member selectOne(String memberId) {
		Connection conn = getConnection();
		Member member = memberDAO.selectOne(conn,memberId);
		System.out.println("@memberService");
		close(conn);
		
		return member;
	}
	
	//회원가입 메소드
	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertMember(conn, member);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}


	public List<Member> selectAll(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Member> list = memberDAO.selectAll(conn, cPage, numPerPage);
		close(conn);
		return list;
	}


	public List<Member> searchMember(Map<String, Object> param) {
		Connection conn = getConnection();
		List<Member> list = memberDAO.searchMember(conn, param); 
		close(conn);
		return list;
	}


	public int getTotalContents() {
		Connection conn = getConnection();
		int totalContents = memberDAO.getTotalContents(conn);
		close(conn);
		return totalContents;
	}

	public int getTotalContents(Map<String, Object> param) {
		Connection conn = getConnection();
		int totalContents = memberDAO.getTotalContents(conn, param);
		close(conn);
		return totalContents;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updateMember(conn,member);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		int result = new MemberDAO().deleteMember(conn, memberId);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	

	public int updatePassword(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updatePassword(conn,member);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
}
