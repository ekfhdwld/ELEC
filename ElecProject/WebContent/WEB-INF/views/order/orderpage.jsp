<%@page import="cart.model.vo.Cart"%>
<%@page import="java.util.List"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/order.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
<%	
	
	String totalPrice = (String)request.getAttribute("totalPrice");
	String orderSerialcode = (String)request.getAttribute("orderSerialcode");
	String orderQuantityList = (String)request.getAttribute("orderQuantityList");
 
%> 
<script>
function kakao(){

	var url = "<%= request.getContextPath() %>/pay/kakao";
	var title = "kakaoPay";
	var spec = "left=400px, top=60px, width=400px, height=520px";
	
	open(url, title, spec);

	}
function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/elec/popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
 //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadFullAddr){
		
	var tfAddress = document.querySelector("#paddress");
	tfAddress.value = roadFullAddr;

}



$(document).ready(function(){
	 $("#selfadd").click(function () {
		 if($("input[name=selfadd]:checked") ){
			 document.getElementById("userName").value = "<%=memberLoggedIn.getMemberName()%>"
			 document.getElementById("userPhone").value = "<%=memberLoggedIn.getMemberPhone()%>"
			 document.getElementById("paddress").value = "<%=memberLoggedIn.getMemberAddress()%>"	
		 }
	});
});

</script>
</head>
<body>
<form action="<%= request.getContextPath() %>/pay/kakao" name="orderpage" method="post">
    <div class="Payment_formH">
    <div class="paywonH">
    <strong id="payH">결제:</strong><strong id="wonH">₩ <%= totalPrice%></strong>
    <br> <hr>

<br>
<h1 id="text1H">주문하신 제품(들)이 어디로 배송되길 원하십니까?</h1> 

<div class="Input_formH">
<!-- <span id="text2">이름및 주소입력</span> &nbsp; -->
<input type="radio" name="selfadd" id="selfadd"  value="selfadd">기본배송지 <br><br>
<input type="text" name="userName" class="userH" id="userName" value="<%-- <%=memberLoggedIn.getMemberName()%> --%>" placeholder="이름">
<input type="text" name="userPhone" class="userH" id="userPhone" value="<%-- <%=memberLoggedIn.getMemberPhone()%> --%>"  placeholder="연락처">
<input type="text" class="user1H" name="paddress" id="paddress"  value="<%-- <%=memberLoggedIn.getMemberAddress()%> --%>" placeholder="상세주소">
<input type="button" id="add_btn" onclick="goPopup();" value="주소찾기">
<input type="text" name="request" class="userH" id="request" placeholder="배송요청사항(선택사항)">
<h2 class="paymentH">결제수단</h2>
<hr>
<select name="" class="userH"style="width: 520px;">
    <option value="" class="userH" style="font-family: 'Quicksand', sans-serif;">카카오페이결제</option>
</select> <br>
<input type="submit" id="paybtn" value="결제 페이지로 이동()"><br><br><br><br><br><br>

</div>
<input type="hidden" id="memberId" name="memberId" value="<%=memberId %>" />
<input type="hidden" id="orderSerialcode" name="orderSerialcode" value="<%=orderSerialcode %>" />
<input type="hidden" id="totalPrice" name="totalPrice" value="<%=totalPrice %>" />
<input type="hidden" id="orderQuantityList" name="orderQuantityList" value="<%=orderQuantityList %>" />

</div>
</div>


</form>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>