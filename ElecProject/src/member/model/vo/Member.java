package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {


	private static final long serialVersionUID = 1L;
	private String memberId;
	private String memberName;
	private String memberPwd;
	private String memberRole;
	private String memberPhone;
	private String memberAddress;
	private Date memberEnrollDate;
	private String memberSecession;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memberId, String memberName, String memberPwd, String memberRole, String memberPhone,
			String memberAddress, Date memberEnrollDate, String memberSecession) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPwd = memberPwd;
		this.memberRole = memberRole;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
		this.memberEnrollDate = memberEnrollDate;
		this.memberSecession = memberSecession;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Date getMemberEnrollDate() {
		return memberEnrollDate;
	}

	public void setMemberEnrollDate(Date memberEnrollDate) {
		this.memberEnrollDate = memberEnrollDate;
	}

	public String getMemberSecession() {
		return memberSecession;
	}

	public void setMemberSecession(String memberSecession) {
		this.memberSecession = memberSecession;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberPwd=" + memberPwd
				+ ", memberRole=" + memberRole + ", memberPhone=" + memberPhone + ", memberAddress=" + memberAddress
				+ ", memberEnrollDate=" + memberEnrollDate + ", memberSecession=" + memberSecession + "]";
	}
	
	
	

}
