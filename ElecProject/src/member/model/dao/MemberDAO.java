package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDAO {
	private Properties prop = new Properties();

	public MemberDAO() {
		
		String fileName = "/sql/member/member-query.properties";
		fileName =  MemberDAO.class.getResource(fileName)
								   .getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member selectOne(Connection conn, String memberId) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();

			
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberPwd(rset.getString("member_pwd"));
				member.setMemberRole(rset.getString("member_role"));
				member.setMemberPhone(rset.getString("member_phone"));
				member.setMemberAddress(rset.getString("member_address"));
				member.setMemberEnrollDate(rset.getDate("member_enroll_date"));
				member.setMemberSecession(rset.getString("member_secession"));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		
		System.out.println("@memberDAO");
				
				
		return member;
		
	}

	
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMember"); 
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getMemberPwd());
			pstmt.setString(4, member.getMemberRole());
			pstmt.setString(5, member.getMemberPhone());
			pstmt.setString(6, member.getMemberAddress());
		
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

	public List<Member> selectAll(Connection conn, int cPage, int numPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> list = null;
		String sql = prop.getProperty("selectAllPaging");
		
		try {
			//1.PreparedStatement 객체 생성 / 미완성 쿼리 전달 / 값대입
			pstmt = conn.prepareStatement(sql);
			//(공식1) cPage, numPerPage => startRnum, endRnum
			//cPage=1 : 1~10
			//cPage=2 : 11~20
			//cPage=3 : 21~30
			int startRnum = (cPage-1) * numPerPage + 1;
			int endRnum = cPage * numPerPage;
			//sql내의 ?를 채우는 숫자1&2
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			
			//2. 실행
			rset = pstmt.executeQuery();
			
			//3. ResultSet => List<Member>
			list = new ArrayList<>();
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberPwd(rset.getString("member_pwd"));
				member.setMemberRole(rset.getString("member_role"));
				member.setMemberPhone(rset.getString("member_phone"));
				member.setMemberAddress(rset.getString("member_address"));
				member.setMemberEnrollDate(rset.getDate("member_enroll_date"));
				member.setMemberSecession(rset.getString("member_secession"));	
				
				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//4. 자원반납
			close(rset);
			close(pstmt);
		}
		
		System.out.println("list@dao = " + list);
		
		return list;
	}

	public List<Member> searchMember(Connection conn, Map<String, Object> param) {
		List<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//memberId : select * from member where member_id like '%a%'
		//memberRole : select * from member where gender = 'S'
		//memberRole : select * from member where gender like '%U %'
		//select * from member where ● like ?
		String sql = prop.getProperty("searchMemberPaging");
		String col = "";
		switch(String.valueOf(param.get("searchType"))) {
		case "memberId" : col = "member_id"; break;
		case "memberRole" : col = "member_role"; break;
		}
		sql = sql.replace("●", col);
		System.out.println("sql@dao = " + sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + param.get("searchKeyword") + "%");
			
			int cPage = (int)param.get("cPage");
			int numPerPage = (int)param.get("numPerPage");			
			pstmt.setInt(2, (cPage-1) * numPerPage + 1);
			pstmt.setInt(3, cPage * numPerPage);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberPwd(rset.getString("member_pwd"));
				member.setMemberRole(rset.getString("member_role"));
				member.setMemberPhone(rset.getString("member_phone"));
				member.setMemberAddress(rset.getString("member_address"));
				member.setMemberEnrollDate(rset.getDate("member_enroll_date"));
				member.setMemberSecession(rset.getString("member_secession"));	
				
				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("list@dao = " + list);
		return list;
	}
	
	public int getTotalContents(Connection conn, Map<String, Object> param) {
		int totalContents = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getSearchTotalContents");
		System.out.println("sql@dao_gettotalcontents= "+sql);
		String col = "";
		switch(String.valueOf(param.get("searchType"))) {
		case "memberId" : col = "member_id"; break;
		case "memberRole" : col = "member_name"; break;
		}
		sql = sql.replace("●", col);
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + param.get("searchKeyword") + "%");
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalContents = rset.getInt("total_contents");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalContents;
	}

	public int getTotalContents(Connection conn) {
		int totalContents = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getTotalContents");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalContents = rset.getInt("total_contents"); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return totalContents;
		
	}

	
	public int updatePassword(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updatePassword"); 
		System.out.println("memberDAO");

		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberId());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			System.out.println("result="+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberPhone());
			pstmt.setString(3, member.getMemberAddress());
			pstmt.setString(4, member.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		 return result;
	}

	public int deleteMember(Connection conn, String memberId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,memberId);
			result = pstmt.executeUpdate();
			System.out.println("result결과="+result);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
