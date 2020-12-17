
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
<%
	List<ProductCategory> pList = (List<ProductCategory>)request.getAttribute("pList");
	String searchKeyword = request.getParameter("searchKeyword");
%>	
		<table id="tbl-PC">
		<tr id="tr_W">
			<th id="th_W">상품코드</th>
			<th id="th_W">브랜드</th>
			<th id="th_W">상품명</th>
			<th id="th_W">상품설명</th>
			<th id="th_W">상품이미지</th>
			
		</tr>				

		
<% 	if(pList == null || pList.isEmpty()){ %>
		<%-- 조회된 회원이 없는 경우 --%>		
		
		<tr>
			<th colspan="10">관심 있는 상품명을 입력하세요</th>
		</tr>		
<% 	
	} else {
		
		for(ProductCategory pC : pList){	
%>		
		<%-- 조회된 회원이 있는 경우 --%>
	
		<tr id="tr_W">
			<td id="td_W">
				<a href="<%= request.getContextPath() %>/product/view?productCode=<%= pC.getProductCode() %>">
					<%= pC.getProductCode() %>
				</a>
				
			
			<td id="td_W"><%= pC.getBrand() %></td>		
			<td id="td_W"><%= pC.getProductName() %></td>		
			<td id="td_W"><%= pC.getProductDesc() %></td>		
			<td id="td_W"> <img src="<%=request.getContextPath() %><%= pC.getProductImg() %>/thum.png" alt="" /> </td>		
		</tr>
	
	
<%  
		}
	} 
%>	
	
	</table>
	

		
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
