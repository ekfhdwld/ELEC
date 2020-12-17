<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Member member = (Member)request.getAttribute("member");

%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script language="javascript">

function updateMember(){
	var frm = $("#memberFrm");
	var url = "<%=request.getContextPath() %>/member/update";
	frm.attr('action',url);
	//console.log($("#memberFrm").attr('action'));
	frm.submit();
	
}

function updatePassword(){
	var url = "<%= request.getContextPath()%>/member/updatePassword?memberId=<%= member.getMemberId() %>";
	var title = "updatePassword"
	var status = "left=600px, top=200px, width=600px, height=300px";
	
	open(url,title,status);
}

function deleteMember(){
	var bool = confirm("정말로 탈퇴하시겠습니까?");
	if(bool){
		var frm = $("[name=memberDeleteFrm]");
		frm.submit();
	}
		
}
function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/elec/popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
 //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadFullAddr){
		
	var tfAddress = document.querySelector("#roadFullAddr");
	tfAddress.value = roadFullAddr;
}
</script>


<section id=enroll-containerH>
	<form id="memberFrm"  method="post" >               	
   		<div class="login-formH">
			<h2>회원 정보 수정</h2>
			<br><br><hr>
            <div class="member">
             <label class="labelH">아이디<span>*</span></label>
             <input type="text" class="userH" name="userId" id="userId_" placeholder="아이디 4글자이상" value="<%= member.getMemberId() %>" required>
            	
         
             <label class="labelH">이름<span>*</span></label>
             <input type="text" class="userH" name="userName" placeholder="이름을 입력해주세요" value="<%= member.getMemberName() %>" required ">
         
             <label class="labelH" style="clear: both;">연락처<span>*</span></label>
             <input type="text" class="userH" name="userPhone" placeholder="'-'를 제외하고적으세요" value="<%= member.getMemberPhone() %>" required>
      
             <label class="labelH" >주소<span>*</span></label>      
             <input type="text" class="userH" name="roadFullAddr" id="roadFullAddr" value="<%=member.getMemberAddress() %>" placeholder="상세주소">
             <input type="button" id="add_btnH" onclick="goPopup();" value="주소찾기">

             <input type="button" id="update_btnH" onclick="updateMember();" value="정보수정"/>&nbsp;
             <input type="button" id="delete_btnH" onclick="deleteMember();" value="탈퇴"/>&nbsp;
             <input type="button" id="uppw_btnH" onclick="updatePassword();" value="비밀번호변경"/>
             </div>
         </div>
        </form>
       	<form action="<%= request.getContextPath() %>/member/delete" 
		  method="POST" 
		  name="memberDeleteFrm">
		<input type="hidden" name="memberId" value="<%= member.getMemberId() %>"/>
	</form>
             </section>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>