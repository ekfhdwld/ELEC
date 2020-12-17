<%@page import="order.model.vo.OrderListSeller"%>
<%@page import="order.model.vo.OrderBrand"%>
<%@page import="javax.sound.midi.MidiDevice.Info"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="order.model.vo.OrderListInfo"%>
<%@page import="order.model.vo.OrderList"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<OrderList, Object> orderMap = (Map<OrderList, Object>)request.getAttribute("orderMap");
	
	Map<OrderBrand, Object> orderMapSeller = (Map<OrderBrand, Object>)request.getAttribute("orderMapSeller");
	System.out.println("Map@jsp = " + orderMap);
	
	int totalPrice = 0;
	

%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/orderlist.css" />
<div id="phrasesH"><p id="p1H" class="korFontH">주문내역</p></div>

   <%if(memberLoggedIn != null && MemberService.USER_MEMBER_ROLE.equals(memberLoggedIn.getMemberRole())){ %>
		<div>
	      	<ul class="ulH"> 
	        <%for(Entry<OrderList, Object> entry : orderMap.entrySet()){ %>
		        <li> 
			          <div class="dateH"><%= entry.getKey().getOrderDate() %></div>
			          <div class="hrH"></div>
			          <ul class="ulH">
				            <%List<OrderListInfo> orderListInfo = (List<OrderListInfo>)entry.getValue(); %>
				            <%for(OrderListInfo info : orderListInfo){%>
					            <li>
						              <div class="listH">
							              <img src="<%=request.getContextPath() %><%=info.getProductImg() %>/thum.png" alt="">
							              <div class="prodInfoH">
							              	<%String inch = info.getInch().equals("0") ? "" : info.getInch()+"inch"; %>
							              	<% String productName = info.getProductName() + " " + inch + " " + info.getCapacity()+ " " +info.getColorName();%>
						                    <div class="info1H"><p class="engFontH" ><%= productName %></p></div>
						                    <div class="info2H"><p class="korFontH">수량  : <%= info.getAmount() %></p></div>
						                     <% int price = info.getPrice() * (100 - info.getDiscountRate()) / 100; %> 
						                     <% totalPrice += price * info.getAmount(); %>
						                    <div class="info3H"><p class="engFontH">₩ <%= price %></p></div>
						                    <div class="lineH"></div>
						                    <input type="hidden" name="hiddenCode" value="<%= info.getProductCode()%>"/>
						                    <input type="hidden" name="hiddenInch" value="<%= info.getInch()%>"/>
						                    <button class="btnReiviewH" value="<%%>" onclick="review(this);">리뷰쓰기</button>
							              </div>
						            </div>
					            </li>
					           <div class="hrH"></div>
				            <%} %>
			          </ul>
			          <div class="totalPriceH" ><p class="totalPH">Total = ₩ <%= totalPrice %></p></div>
			         <div class="hrH"></div>
	        	</li>
	        <%} %>
	      </ul>
	    </div>
    
   
	<%}else if(memberLoggedIn != null && MemberService.SELLER_MEMBER_ROLE.equals(memberLoggedIn.getMemberRole()) ){ %>
	
	<div>
	      	<ul class="ulH"> 
	        	<%int i=1; %>
	        <%for(Entry<OrderBrand, Object> entry : orderMapSeller.entrySet()){ %>
		        <li> 
			          <div class="dateH">No.<%= i++ %> <%= entry.getKey().getOrderDate() %></div>
			          <div class="hrH"></div>
			          <ul class="ulH">
				            <%List<OrderListInfo> orderListInfo = (List<OrderListInfo>)entry.getValue(); %>
				            <%for(OrderListInfo info : orderListInfo){%>
					            <li>
						              <div class="listH">
							              <img src="<%=request.getContextPath() %><%=info.getProductImg() %>/thum.png" alt="">
							              <div class="prodInfoH">
							              	<%String inch = info.getInch().equals("0") ? "" : info.getInch()+"inch"; %>
							              	<% String productName = info.getProductName() + " " + inch + " " + info.getCapacity()+ " " +info.getColorName();%>
						                    <div class="info1H"><p class="engFontH" ><%= productName %></p></div>
						                    <div class="info2H"><p class="korFontH">수량  : <%= info.getAmount() %></p></div>
						                    <div class="lineH"></div>
							              </div>
						            </div>
					            </li>
					           <div class="hrH"></div>
				            <%} %>
			          </ul>
			         <div class="hrH"></div>
			         <div id="orderInfoH">
			          <p id="orderPH">주문자 : <%= entry.getKey().getMemberId() %></p>
			          <span ="orderSpanH">수령자 : <%= entry.getKey().getRecipient()%></span>
			          <span class="orderSpanH">핸드폰 번호 : <%=entry.getKey().getRecipientPhone() %></span>
			          <span class="orderSpanH" >주소 : <%= entry.getKey().getAddress() %></span>
			          </div>
	        	</li>
	        <%} %>
	      </ul>
	    </div>
	
	
	
	
	
	<%} %>
<script>	

$(".btnReiviewH").click(function(){
	var code = $(this).parent().children('input[name=hiddenCode]').attr('value');
	console.log(code);
	
	var inch = $(this).parent().children('input[name=hiddenInch]').attr('value');
	console.log(inch);
	
	var rvo = "on";
	location.href = "<%= request.getContextPath()%>/product/productview?productCode=" + code + "&inch=" + inch + 
			"&rvo=" + rvo; 
});
</script>  
    
<%@ include file="/WEB-INF/views/common/footer.jsp" %>