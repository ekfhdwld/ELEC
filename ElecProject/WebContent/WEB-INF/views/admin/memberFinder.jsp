<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Member> list = (List<Member>)request.getAttribute("list");

	String searchType = request.getParameter("searchType");
	String searchKeyword = request.getParameter("searchKeyword");
%>			
 <link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css" /> 

<style>
div#name-containerS { width: 1280px; margin: 0 0 10px 0; height:60px; line-Height:60px; background-color: #929ca9; color: #fff}
#search-container {width: 100%; margin:0 0 10px 0; padding:3px; background-color: #fff;}
div#search-memberId {display: <%= "memberId".equals(searchType) ? "inline-block" : "none" %>;}
div#search-memberRole{display:<%= "memberRole".equals(searchType) ? "inline-block" : "none" %>;}
div#search-container #search-btn { width: 80px; height: 30px; background-color: gray; color: white; text-align: center; line-height: 20px; font-size: 15px; display: inline-block; margin-left: 4px; cursor: pointer; font-family: 'Quicksand', sans-serif; font-weight : bold; }
</style>

<script>
<%-- 회원관리내 검색 기능 --%>
$(function(){
	$("#searchType").change(function(){
		console.log($(this).val());
		var type = $(this).val();
		$(".search-type").hide()
						 .filter("#search-" + type)
						 .css("display", "inline-block"); //버튼 클릭할때 css속성 설정
	});
});
</script>
<section id="memberList-container">
	<div id="name-containerS">
		<h2>회원관리</h2>	
	</div>
	
	<table id="tbl-member">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>회원권한</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>가입날짜</th>
			<th>탈퇴여부</th>
		</tr>
<% 	if(list == null || list.isEmpty()){ %>
		<%-- 조회된 회원이 없는 경우 --%>		
		<tr>
			<th colspan="7">조회된 회원이 없습니다.</th>
		</tr>		
<% 	
	} else {
		
		for(Member m : list){	
%>		
		<%-- 조회된 회원이 있는 경우 --%>
		<tr>
			<td>
				<%-- 회원의 상세정보보기로 이동가능한 a태그 --%>
				<a href="<%= request.getContextPath() %>/member/view?memberId=<%= m.getMemberId() %>">
					<%= m.getMemberId() %>
				</a>
			</td>
			<td><%= m.getMemberName() %></td>
			<td><%= m.getMemberRole() %></td>
			
			<td><%= m.getMemberPhone() %></td>
			<td><%= m.getMemberAddress() %></td>
			<td><%= m.getMemberEnrollDate() %></td>
			<td><%= m.getMemberSecession() %></td>
		</tr>
<%  
		}
	} 
%>	

	</table>
	
	<div id="search-container"> 
        <select id="searchType">
            <option value="memberId">아이디</option>		
            <option value="memberRole">회원권한</option>
        </select>
        <div id="search-memberId" class="search-type">
            <form action="<%=request.getContextPath()%>/admin/memberFinder">
                <input type="hidden" name="searchType" value="memberId"/>
                <input type="text" name="searchKeyword"  size="25" placeholder="검색할 아이디를 입력하세요."
                value="<%= "memberId".equals(searchType) ? searchKeyword : ""%>"/>
                <button type="submit" id="search-btn" >Search</button>			
            </form>	
        </div>
        <div id="search-memberRole" class="search-type">
            <form action="<%=request.getContextPath()%>/admin/memberFinder?searchType=memberRole">
                <input type="hidden" name="searchType" value="memberRole"/>
                <input type="radio" name="searchKeyword" value="S" <%= "memberRole".equals(searchType) && "S".equals(searchKeyword) ? "checked" : ""  %>> 판매자
                <input type="radio" name="searchKeyword" value="A" <%= "memberRole".equals(searchType) && "A".equals(searchKeyword) ? "checked" : ""  %> > 관리자
                <input type="radio" name="searchKeyword" value="B" <%= "memberRole".equals(searchType) && "B".equals(searchKeyword) ? "checked" : ""  %> > 구매자
                <button type="submit" id="search-btn">Search</button>
            </form>
        </div>
    </div>
    
	
	<div id="pageBar">
		<%= request.getAttribute("pageBar") %>
	</div>

</section>	
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
