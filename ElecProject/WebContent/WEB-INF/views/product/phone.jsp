<%@page import="product.model.vo.ProductL"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 	List<ProductL> PList = (List<ProductL>)request.getAttribute("PList");
 	%>
 	<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500&display=swap" rel="stylesheet">
<link rel="stylesheet"
	href="<%= request.getContextPath() %>/css/PList.css" />

	<script>
	
    $(document).ready(function () {
        $(".conB").first().nextAll(".conB").css("display", "none");
    });

    $(document).ready(function () {

        var $div = $(".conB");
        for(var i = 0; i<$div.length ; i++){
            $div[i].id = "con"+i;
            console.log($div[i].id);
        }

        var num = 1;
        console.log("#"+$div[num].id);
        
        $(".spB").click(function () {
            $(".moreB").attr("href", "#"+$div[num].id);
			
            $div[num].style.display="block";
            num++;

            if(num==$div.length){
                $(".spB").css("display", "none");
            }

        });

    });
	</script>




	<!-- <div class="conB"> -->
		<%for(int i = 0 ; i<PList.size();i++){ %>
			<%if(i==0 || i%4==0) {%>
			<div class="conB">
			<%} %>
			<%if(i%2 == 0){%>

				<div class="prodB">
				<div class="proddB BL">
					<br>
					<h1 class="prodH1B"><%=PList.get(i).getProductName() %></h1>
					<br>
					<button class="butB"
						onclick="location.href=
	               '<%=request.getContextPath()%>/product/productview?productCode=<%=PList.get(i).getProdSerialCode()%>&inch=<%=PList.get(i).getInch()%>'">
						Buy</button>
				</div>
				<img class="prodImgB"
					src="<%=request.getContextPath()%><%=PList.get(i).getProductImg()%>/thum.png" style="margin-left:0px;">
				</div>
				<hr class="hrB">
				
			<%}else{ %>
		
			
				<div class="prodB">
					<img class="prodImgB leftB"
						src="<%=request.getContextPath()%><%=PList.get(i).getProductImg()%>/thum.png"  >
						</h3>
						<div class="proddB BR" style="margin-left:0px;">
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
			
			<%if(i==3 || i==7 || i==11|| i==15||i==PList.size()-1) {%>
			</div>
			<%} %>
			
		<%} %>
s
	<button class="spB"><a class="moreB">더보기</a></button>



<%@ include file="/WEB-INF/views/common/footer.jsp" %>