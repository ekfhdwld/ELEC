<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberId = (String)request.getParameter("memberId");
	String orderSerialcode = (String)request.getParameter("orderSerialcode");
	String totalPrice =(String)request.getParameter("totalPrice");
	String orderQuantityList =(String)request.getParameter("orderQuantityList");
	String userName = (String)request.getParameter("userName");		
	String userphone = (String)request.getParameter("userPhone");
	String paddress = (String)request.getParameter("paddress");
	/* System.out.println("카카오페이jsp"+orderSerialcode); */

%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>

    <script>

    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp96969083'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '(주)Elec',
            amount : <%=totalPrice%>,          
        }, function(rsp) {
            if ( rsp.success ) {   
            
   
		    	$("#orderList").submit();


            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>";
                alert(msg);
            }
        });
        
    });
    
    
    </script>
    	<form action="<%=request.getContextPath()%>/payOrder/orderList" id="orderList"  method="POST">
              
                <input type="hidden" name="memberId" id="memberId" value="<%=memberId %>"/>
                <input type="hidden" name="orderSerialcode" id="orderSerialcode" value="<%=orderSerialcode %>"/>
                <input type="hidden" name="totalPrice" id="totalPrice" value="<%=totalPrice %>"/>
                <input type="hidden" name="orderQuantityList" id="orderQuantityList" value="<%=orderQuantityList %>"/>
                <input type="hidden" name="userName" id="userName" value="<%=userName %>"/>
                <input type="hidden" name="userPhone" id="userPhone" value="<%=userphone %>"/>
                <input type="hidden" name="paddress" id="paddress" value="<%=paddress %>"/>
             <%--    <input type="hidden" name="memberId" id="memberId" value="<%=member.getMemberId() %>"/> --%>

                </form>		
   
 
</body>
</html>