<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String prodCode = (String)request.getAttribute("prodCode");
	String inch = (String)request.getAttribute("inch");
	
	System.out.println("prodCode@msg = " + prodCode);
	System.out.println("inch@msg = " + inch);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		alert("<%= request.getAttribute("msg")%>");
		<%-- 패스워드 변경후 팝업창을 닫기 위한 스크립트 코드 --%>
		<%= request.getAttribute("script") != null ? request.getAttribute("script") : ""%>
		
		location.href = "<%= request.getAttribute("loc")%>?productCode=<%= prodCode%>&inch=<%=inch%>";
	</script>
</body>
</html>