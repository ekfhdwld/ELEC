<%@page import="java.util.List"%>
<%@page import="productCategory.model.vo.ProductCategory"%>
<%@page import="member.model.service.MemberService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member" %>


<%
	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");

	//쿠키확인 : 요청과 함께 전송된 쿠키확인
	boolean saveId = false;
	String memberId = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie c : cookies){
			String key = c.getName();
			String value = c.getValue();
			System.out.println(key + " = " + value);
	
		}
	}
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ELECSEMIPROJECT</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
  <link rel="stylesheet" href=" https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
   	<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
  
  
 <script type="text/javascript">
 $(function(){
		
		$("#loginL").submit(function(){
			var $memberId = $("#memberId");
			var $password = $("#password");
			
			if(/^.{4,}$/.test($memberId.val()) == false){
				alert("유효한 아이디를 입력하세요.");
				return false;
			}
			if(/^.{4,}$/.test($password.val()) == false){
				alert("유효한 패스워드를 입력하세요.");			
				return false;
			}
			
			return true;
		});
	});	 

    //login
     $(document).ready(function(){
       $("#login").click(function(){
         $(".login-form").toggleClass('active')

       })
     })


    $(document).ready(function(){
      $("#search").click(function(){
        $(".menuA").toggleClass('hide-item')
        $('.search-form').toggleClass('active')
      })
    });
    </script>
  </head>
  
  <body>
 
  <!--header 시작-->
  <div id="container">
  
  <div id="won">
    <header id="header">           
      
    
      <!-- nav :  메뉴, 네비게이션등을 제공하는 태그. header, aside, footer등 자유롭게 사용가능 -->
      <nav class="w_na" style="margin-top: 10px;">
        <ul class="w_u">
          <li class="w_l"><a href="<%= request.getContextPath() %>" ><class class="fa fa-bolt fa-2x" aria-hidden="true"></class></i></a></li>
          <li class="w_l"><a href="<%= request.getContextPath() %>/product/list?category=N" class="menuA">Product</a>        
            <ul class="w_u">
               <li class="w_l"><a href="<%= request.getContextPath() %>/product/list?category=N"class="menuA" ><i class="fa fa-laptop" aria-hidden="true"></i>Laptop</a></li>
              <li class="w_l"><a href="<%= request.getContextPath() %>/product/list?category=P" class="menuA"><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>Phone</a></li>
            </ul>
         
          </li>
          <li class="w_l"><a href="<%= request.getContextPath() %>/product/cList?brand=APPLE" class="menuA">Brand</a>           
              <ul class="w_u">
	           	   <li class="w_l"><a href="<%= request.getContextPath() %>/product/cList?brand=APPLE" class="menuA"><i class="fa fa-apple" aria-hidden="true"></i>Apple </a></li> 
	               <li class="w_l"><a href="<%= request.getContextPath() %>/product/cList?brand=SAMSUNG" class="menuA"><i class="fa fa-scribd" aria-hidden="true"></i>Samsung </a></li> 
	               <li class="w_l"><a href="<%= request.getContextPath() %>/product/cList?brand=LG"class="menuA"><i class="fa fa-gg" aria-hidden="true"></i>LG </a></li>
              </ul>       
          
          </li>  
          	<% if(memberLoggedIn != null 
					   && MemberService.SELLER_MEMBER_ROLE.equals(memberLoggedIn.getMemberRole())){ %>
					<li class="w_l" ><a href="<%= request.getContextPath() %>/seller/list?memberId=<%=memberLoggedIn.getMemberName() %>" class="menuA">SellerList</a></li>
			<% } else { %>					
          		<li class="w_l"><a href="<%= request.getContextPath() %>/cart/view"class="menuA">Cart</a></li>
            <% }  %>
          
          	<% if(memberLoggedIn != null 
					   && MemberService.ADMIN_MEMBER_ROLE.equals(memberLoggedIn.getMemberRole())){ %>
					<li class="w_l"><a href="<%= request.getContextPath() %>/admin/memberList" class="menuA">AdminPage</a>
					 <ul class="w_u">
              			 <li class="w_l"><a href="<%= request.getContextPath() %>/admin/memberList" class="menuA">MemberList </a></li> 
              				 <li class="w_l"><a href="<%= request.getContextPath() %>/admin/stateView" class="menuA">StateView </a></li> 
					</ul>
					</li>
					
					<% } else { %>
					
          <li class="w_l"><a href="<%= request.getContextPath() %>" class="menuA">MyPage</a>
         <ul class="w_u">
            <%if(memberLoggedIn != null) {%>
            	<li class="w_l"><a href="<%= request.getContextPath() %>/orderList" class="menuA"><i class="fa fa-list-ul" aria-hidden="true"></i>List </a></li>
            <%}else{ %>
            	<li class="w_l"><a href="<%= request.getContextPath() %>" class="menuA" onclick="alert('로그인 후에 이용하실 수 있습니다!');"><i class="fa fa-list-ul" aria-hidden="true"></i>List </a></li>
            <%} %> 
            <% if(memberLoggedIn == null){ %>	
            	<li class="w_l"><a href="<%= request.getContextPath() %>/member/view?memberId=" class="menuA"><i class="fa fa-info" aria-hidden="true"></i> Info </a></li>  
           <% } else { %>
            	<li class="w_l"><a href="<%= request.getContextPath() %>/member/view?memberId=<%= memberLoggedIn.getMemberId() %>" class="menuA"><i class="fa fa-info" aria-hidden="true"></i> Info </a></li>  
          <% } %>	
           </ul>    
          </li> 
          <% }  %>
          <!-- <li class="w_l"><a href="#" id="search">Search</a></li> -->
          
          	<% if(memberLoggedIn != null) { %> 
					<span style ="color : white;"><%= memberLoggedIn.getMemberId() %> 님 
						<input type="button" value="로그아웃" id ="log-out"onclick="location.href = '<%= request.getContextPath() %>/member/logout';"/>
					</span>
				
	 		<%} else{%>
         		 <li class="w_l"><a href="#" id="login">Login</a></li>
          
                    
            <%} %>              
                   	
		      
        </ul>   
  

          <div id="search-product" class="search-form">
          <form action="<%= request.getContextPath() %>/productFinder" >
           <input type="text" placeholder="Search" name="searchKeyword">
             
                  <button id="w_sfB"><i class="fa fa-search" aria-hidden="true"  onclick="<%= request.getContextPath() %>/ProductCategory"></i></button>
			</form> 
          </div>
          

        <div class="login-form">
<% if(memberLoggedIn == null){ %>
          <form id="loginL" 
          action="<%= request.getContextPath() %>/member/login" 
          method="POST"	
          class="input-group">
            <br>
            <input type="text" name="memberId" class="input-field" placeholder="User ID" required >
           
            <input type="password" name="password" class="input-field" placeholder="Enter Password" required>
            <!-- <input type="checkbox" class="check-box"><span> Remember Password </span> -->
            <br>
            <br>
          
            <button type="submit" class="submit-btn">LogIn</button>
              
        </form>          
	      <button type="submit" class="submit-btn" onclick="location.href='<%= request.getContextPath() %>/member/enroll';">Register</button>
             
        </div>
      </nav>
      <% } %>	


     

      
    </header>
    
    <div style="height:70px; background-color:#000000d9; width: 1280px; "></div>
  </div>
  <section id="content_WH" >
  
