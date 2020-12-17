<%@page import="cart.model.vo.CartInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CartInfo> cartInfoList = (List<CartInfo>)request.getAttribute("cartInfoList");
	int totalPrice = 0;
%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/cart.css" />
    <div id="phrasesJ">
<% if(cartInfoList == null || cartInfoList.size() == 0){ %>        
        <p id="pEmptyJ">현재 장바구니가 비어있습니다.</p>
<% } else {%>
        <p id="p1J">장바구니에 들어있는 제품입니다</p>
<% } %>
        <p id="p2J">모든 제품은 무료배송 서비스가 적용됩니다.</p>
    </div>
<% if(cartInfoList == null || cartInfoList.size() == 0){ %>
    <div id="isEmptyCartJ">
        <button id="btnMainJ" class="engFontJ" onclick="location.href='<%=request.getContextPath() %>'">Go to Main</button>
        <div id="goToShoppingJ">
           <div id="goToNotebookJ" style=" background-image: url('<%= request.getContextPath()%>/images/JH/cartNotebook.png');">
            <p class="engFontJ">
                Explore <br> Our NoteBook</p>
            <button id="btnNotebookJ" class="engFontJ" onclick="location.href='<%=request.getContextPath() %>'">shop</button>
        </div>
        <div id="goToPhoneJ" style=" background-image: url('<%= request.getContextPath() %>/images/JH/cartPhone.png');">
            <p class="engFontJ">
                Explore <br> Our Phone</p>
            <button id="btnPhoneJ" class="engFontJ" onclick="location.href='<%=request.getContextPath() %>'">shop</button>
           </div>
        </div>
    </div>

<%}else{ %>
    <div id="cartListJ">
        <div class="hrJ"></div>
        <ul id="ulJ">
        	<% for(int i=0; i<cartInfoList.size(); i++){%>
        	<% CartInfo ci = cartInfoList.get(i); %>
            <li>
                <div class="listJ">
                    <img src="<%= request.getContextPath()%><%= ci.getProductImg() %>/thum.png" alt="">
                    <div class="prodInfoJ">
                    	<% String inch = ci.getInch().equals("0") ? "" : ci.getInch()+"inch"; %>
                    	<% String productName = ci.getProductName() + " " + inch + " " + ci.getCapacity() + " " + ci.getColorName(); %>
                        <div class="info1J"><p class="engFontJ"><%= productName %></p></div>
                        <div class="info2J"><p class="korFontJ" value="<%= ci.getAmount()%>">수량  : <%= ci.getAmount() %></p></div>
                        <% int price = ci.getPrice() * (100 - ci.getDiscountRate()) / 100; 
                        	totalPrice += price;%>
                        <div class="info3J"><p class="engFontJ">₩ <%= price %></p></div>
                        <div class="lineJ"></div>
                        <button class="btnDeleteJ" value="<%= ci.getProdSerialCode() %>" >삭제</button>
                    </div>
                </div>
                <% if(i != cartInfoList.size() - 1){ %>
                	<hr id="cartHrJ" style="margin: 0px auto;">
               	<% } %>
            </li>
           <% } %>
        </ul>
        <div id="lastRowJ">
            <div class="hrJ"></div> <!-- 마지막 li인 경우 이걸 ul밖에 작성하도록 하기-->
            <div id="divRightJ">
                <div id="totalRowJ">
                    <p class="engFontJ" id="totalJ">₩ <%= totalPrice %></p>
                    <p class="engFontJ">Total : </p>
                </div>
                <div id="payRowJ">
                    <button id="btnPayJ" class="korFontJ" value="<%= totalPrice %>">결제하기</button>
                </div>
            </div>
       </div>
    </div>
<% } %>
<script>
$(".btnDeleteJ").click(function(){

    var resultConfirm = confirm("상품을 장바구니에서 삭제하시겠습니까?");
    if(resultConfirm == true){
   	 	var prodSerialCode = $(this).val();
   	   
   	 	location.href="<%=request.getContextPath()%>/cart/delete?prodSerialCode="+prodSerialCode;	
   } 
   
});


$("#btnPayJ").click(function(){
	if(confirm("상품을 구매하시겠습니까?") == true){
    	var orderSerialcode = "";
    	var orderQuantityList = "";
        var totalPrice = $(this).val();
    	
        var length = $('.prodInfoJ').length;
        var serialCode = document.querySelectorAll(".btnDeleteJ");
		 var quantityList = document.querySelectorAll(".info2J p");
       
        
        for(var i=0; i<length; i++){
            if(i == length - 1){
            	orderSerialcode += serialCode[i].getAttribute('value');
            	orderQuantityList += quantityList[i].getAttribute('value');
            }
            else{
            	orderSerialcode += serialCode[i].getAttribute('value') + ",";
            	orderQuantityList += quantityList[i].getAttribute('value') + ",";
        	}
        }
        
        console.log(orderSerialcode);
        console.log(orderQuantityList);
        console.log(totalPrice);
        
        location.href="<%=request.getContextPath()%>/order/orderpage?orderSerialcode="+orderSerialcode+"&orderQuantityList="+orderQuantityList+"&totalPrice="+totalPrice;
        
    }
    
});


</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>