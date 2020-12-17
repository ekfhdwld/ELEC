<%@page import="product.model.vo.ProductL"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
    <%
    List<ProductL> PList = (List<ProductL>)request.getAttribute("PList");
    String brand = (String)request.getAttribute("brand");
    %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/PList.css" />
	
	
	<div class="conB">
	
		<%for(int i = 0 ; i<PList.size();i++){ %>
		
			<%if(i%2 == 0){%>

				<div class="prodB">
				<div class="proddB BL">
				<%if(!PList.get(i).getInch().equals("0")){ %>
				<h3 class="h3B"><%=PList.get(i).getInch() %>인치
					</h3>
				<%} %>
					<br>
					<h1 class="prodH1B"><%=PList.get(i).getProductName() %></h1>
					<br>
					<button class="butB"
						onclick="location.href=
	               '<%=request.getContextPath()%>/product/productview?productCode=<%=PList.get(i).getProdSerialCode()%>&inch=<%=PList.get(i).getInch()%>'">
						Buy</button>
				</div>
				<img class="prodImgB"
					src="<%=request.getContextPath()%><%=PList.get(i).getProductImg()%>/thum.png">
				</div>
				<hr class="hrB">
				
			<%}else{ %>
		
			
				<div class="prodB">
					<img class="prodImgB leftB"
						src="<%=request.getContextPath()%><%=PList.get(i).getProductImg()%>/thum.png">
						</h3>
						<div class="proddB BR">
				<%if(!PList.get(i).getInch().equals("0")){ %>
					<h3 class="h3B"><%=PList.get(i).getInch() %>인치
					</h3>
				<%} %>
						<br>
						<h1 class="prodH1B"><%=PList.get(i).getProductName() %></h1>
						<br>
					<button class="butB"
						onclick="location.href=
	               '<%=request.getContextPath()%>/product/productview?productCode=<%=PList.get(i).getProdSerialCode()%>&inch=<%=PList.get(i).getInch()%>'">
						Buy</button>
					</div>
					</div>
			<hr class="hrB">
			
			<%} %>
			
		<%} %>
	</div>
	
<%@ include file="/WEB-INF/views/common/footer.jsp" %>