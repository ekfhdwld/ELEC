<%@page import="product.model.vo.ProductL"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 원혁쓰헤더 -->
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<ProductL> plList = (List<ProductL>)request.getAttribute("list");
    String msg = (String)request.getAttribute("msg");
    int cPage = (int)request.getAttribute("cPage");
%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/seller.css" />
<script>
$(document).ready(function(){
	<%if(msg!=null){%>
		alert("<%=msg%>");
	<%}%>
});

$(document).ready(function(){
	$(".buttonB").click(function(){
		
		var code = $(this).next().val();
		var amount = $(this).prev().val();
		
		if(amount>0)
			location.replace("<%=request.getContextPath()%>/seller/update?code="+code+"&amount="+amount+"&id=<%=memberLoggedIn.getMemberName()%>&cPage=<%=(int)request.getAttribute("cPage")%>");
		else
			alert("수량을 입력해주세요");
	});
});

$(document).ready(function(){
	$("#deleteB").click(function(){

		var checks = $(".chB:checked");
				console.log(checks);
		
		if(checks.length==0){
			alert("삭제할 상품을 선택해주세요.");
			return;
		}
		
		if(confirm("정말 삭제하시겠습니까?")){
		
		
			var list="";
			for(var i = 0 ; i<checks.length ; i++){
				list += checks[i].value;
				if(i != checks.length-1){
					list += ",";			
				}
			}
		
		location.href = "<%=request.getContextPath()%>/seller/delete?list="+list+"&id=<%=memberLoggedIn.getMemberName()%>&cPage=<%=cPage%>";		
	}
		
	});
});
	
</script>

<div class="containerB">

    <h1 style="text-align:center; margin-bottom: 20px; font-family: 'Noto Sans KR', sans-serif;">상품 목록</h1>
    <ul class="naviB">
        <li><a href="#"> 상품등록 ▽</a>
            <ul>
                <li><a href="<%= request.getContextPath() %>/product/formP">핸드폰</a></li>
                <li><a href="<%= request.getContextPath() %>/product/formN?inch=13">노트북-13인치</a></li>
                <li><a href="<%= request.getContextPath() %>/product/formN?inch=15">노트북-15인치</a></li>
                <li><a href="<%= request.getContextPath() %>/product/formN?inch=17">노트북-17인치</a></li>
            </ul>
        </li>
    </ul>

     <table class="tableB">
        <tr class="tabletrB">
            <th>체크</th>
            <th>분류</th>
            <th>썸네일</th>
            <th>제품명</th>
            <th>재고</th>
        </tr>
        <%if(plList==null || plList.isEmpty()){ %>
        <tr>
        	<th colspan="5">
        	조회된 상품이 없습니다.
        	</th>
        </tr>
        
        <%
        } else{
        for(ProductL pl : plList){
        
        %>
        <tr class="tabletrB">
            <td><input type="checkbox" name="check" class="chB" value="<%=pl.getProdSerialCode()%>"></td>
            <td><%=pl.getProdSerialCode().substring(0, 1) %></td>
            <td><img src="<%=request.getContextPath() %>/<%=pl.getProductImg()%>/thum.png" style="width:100px;"></td>
            
            <td><a class="a_B" href="<%=request.getContextPath()%>/product/productview?productCode=<%=pl.getProdSerialCode().split("C")[0]%>&inch=<%=pl.getInch()%>">
            
            <%=pl.getProductName()%>
            <%if(!pl.getInch().equals("0")){%> 
            	<%="-"+pl.getInch()%>인치
            <%}%>
            <%="-"+pl.getColorName()+"-"+pl.getCapacity()%></a></td>
            <td>
	            	재고수량 : <%=pl.getAmount() %> <br />
	            <input type="number" name="stock" id="stock" min="0" placeholder="수량입력" style="width:70px;" />
           		<button type="button" class="buttonB" style="display:inline-block;">입고</button>
           		<input type="hidden" class="serial" name="prodSerialCode" value="<%=pl.getProdSerialCode() %>" />
            </td>
        </tr>
        
<%}

        } %>

    </table>

    
    <button type="button" id="deleteB">상품삭제</button>
    <br />	
    <div class="pagingB"><%=request.getAttribute("pageBar") %></div>
    <br />
    <br />
    <br />
    
    
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>
