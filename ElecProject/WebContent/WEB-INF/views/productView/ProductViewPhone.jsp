<%@page import="java.util.Map.Entry"%>
<%@page import="board.model.vo.Board"%>
<%@page import="java.util.Map"%>
<%@page import="product.model.vo.ProductInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Map<String, String> colorMap = (Map<String, String>)request.getAttribute("colorMap");
	List<String> capaList = (List<String>)request.getAttribute("capaList");
	ProductInfo productInfo = (ProductInfo)request.getAttribute("productInfo");
	List<Board> reviewList = (List<Board>)request.getAttribute("reviewList");
	List<ProductInfo> otherProducts = (List<ProductInfo>)request.getAttribute("otherProducts");
	String rvo = (String)request.getAttribute("rvo");
	
%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/productView.css" />
            <div id="first-boxJ">
                <div id="left-lineJ">
                    <div id="imgSectionJ">
                        <img src="<%= request.getContextPath() %><%= productInfo.getProductImg() %>/thum.png" alt="" id="detailJ">
                       <h2 id="productNameJ"><%= productInfo.getProductName() %></h2>
                        <h1 id="productGradeJ">★ <%= productInfo.getProductGrade() %></h1>
                        <p id="productDescJ">
                           <% String[] desc = productInfo.getProductDesc().split(",");%>
                          <% for(int d=0; d<desc.length; d++){ %>
                        		<%= desc[d]%> <br>
                           <% } %>
                        </p>
                    </div>
                </div>
                <div id="right-lineJ">
                   <div id="colorOptionJ">
                        <p class="optionTitleJ" >Choose Your Color</p>
                        <div id="colorOptionBoxJ"  >
                           <% for (Entry<String, String> entry : colorMap.entrySet()) { %> 
                            <div class="color-nameJ" >
                                <div class="circleJ" style="background-color : <%= entry.getValue() %>"></div> 
                                <p class="colorPJ"><%= entry.getKey() %></p>
                            </div>
                            <%} %>
                        </div>
                    </div>
                    <div id="hrJ"></div>
                    <div id="capacityOptionJ">
                        <p class="optionTitleJ" >Choose Your Capacity</p>
                        <div id="capaOptionBoxJ" >
                        	<% for(String capa : capaList) {%>
                            <div class="capa-nameJ" >
                               <span><%= capa %></span>
                            </div>
                            <% } %>
                        </div>
                    </div>
                    <div id="hrJ"></div>
                      <div id="totalRowJ">
                     	<% int price = productInfo.getPrice() * (100 - productInfo.getDiscountRate()) / 100; %>
                        <p id="totalPriceJ" class="korBoldJ" value="<%= price %>">Price : ₩ <%= price %></p>
                    </div>
                    <div id="button-rowJ">
                        <button id="btnCartJ" onclick="addToCart(<%= productInfo.getInch()%>);">Cart</button>
                        <input type="hidden" id="inputProdCodeJ" value="<%= productInfo.getProductCode() %>" name="prodCode" />
                        <button id="btnBuyJ" onclick="buyProduct(<%= productInfo.getInch()%>);">Buy Now</button>
                    </div>
                </div>

            </div>
               <div id="second-boxJ">
                <div class="slideJ">
			        <img id="backJ" src="<%= request.getContextPath() %>/images/JH/back.png" alt="" width="50">
			       	<ul>
			            <li><img class="adImgJ" src="<%= request.getContextPath() %><%= productInfo.getProductImg() %>/adImg1.png" alt="" width="1280" height="300"></li>
			            <li><img class="adImgJ" src="<%= request.getContextPath() %><%= productInfo.getProductImg() %>/adImg2.png" alt="" width="1280" height="300"></li>
			        </ul>
			        <img id="nextJ" src="<%= request.getContextPath() %>/images/JH/next.png" alt="" width="50">
			    </div>
            </div>

            <div id="third-boxJ">
                <div class="hrJ"></div>
                <div id="review-rowJ" class="menuJ">
                   <p class="slideTitleJ">Review</p>
                   <div class="rotateJ" id="review-rotateJ">+</div>
                </div>
                <div id="reviewJ" class="slide-contentJ"> 
                 <% if(rvo.equals("on")){%>
                    <div id="inputReviewJ">
                       <form action="<%= request.getContextPath() %>/board/insert" method="post" id="formReviewJ">
                       <div id="box1J"><span class="korBoldJ">리뷰작성하기</span></div>
                       <div id="box2J"><input type="text" value="" id="textReviewJ" class="korJ" name="inputReview"></div>
                       <div class="box3J">
                            <p class="star_ratingJ">
                                <a href="" class="onJ">★</a>
                                <a href="" class="onJ">★</a>
                                <a href="" class="onJ">★</a>
                                <a href="">★</a>
                                <a href="">★</a>
                            </p>
                            <input type="hidden" name="reivewGrade" id="reivewGradeJ" value=""/>
                            <input type="hidden" name="prodCode" value="<%= productInfo.getProductCode()%>"/>
                            <input type="hidden" name="prodInch" value="<%= productInfo.getInch()%>"/>
                        </div>
                       <div id="box4J"><button id="btnReviewJ" type="submit">OK</button></div>
                        </form>
                    </div>
                 <% } %>
                    <table id="review-tableJ">
                        <tr>
                            <th class="korBoldJ">아이디</th>
                            <th class="korBoldJ">한줄평</th>
                            <th class="korBoldJ">평점</th>
                            <th class="korBoldJ">날짜</th>
                        </tr>
                       <%if(reviewList == null || reviewList.isEmpty()){ %>
	                       <tr>
								<th colspan="4">작성된 리뷰가 없습니다.</th>
						   </tr>
                       <%}else { 
                       	  for(Board b : reviewList){%>
	                       	<tr>
	                            <th><%= b.getBoardWriter() %></th>
	                            <th class="korJ"><%= b.getBoardContent() %></th>
	                            <th><%= b.getBoardGrade() %></th>
	                            <th><%= b.getBoardDate() %></th>
	                        </tr>
	                      <% }
                        } %>
                    </table>
                </div>
                <div class="hrJ"></div>
                <div id="product-rowJ" class="menuJ">
                    <p class="slideTitleJ">Other Product</p>
                    <div class="rotateJ" id="product-rotateJ">+</div>
                </div>
                <div id="productJ" class="slide-contentJ">
                    <p id="compStmJ">Compare with other items</p>
                     <% for(int i=0; i<otherProducts.size(); i++){%>
        			<% ProductInfo pi = otherProducts.get(i); %>
                    <div  class="prodBoxJ">
                        <img src="<%= request.getContextPath()%><%= pi.getProductImg() %>/thum.png" alt="" class="prodBoxImgJ">
                        <h2 class="prodBoxNameJ"><%= pi.getProductName() %></h2>
                        <p class="prodBoxDescJ" >
                        	<% String[] temp = pi.getProductDesc().split(","); %>
                        	<% for(int t=0; t<temp.length; t++){ %>
                        		<%= temp[t]%> <br>
                            <% } %>
                        </p>
                        <button class="prodBoxBtnJ" onclick="moveToProduct();">Buy</button>
                    </div>
                 <% } %>
                  </div>
                <div class="hrJ"></div>
                <br><br>
                
            </div>
    
<script type="text/javascript">
    var deg = -45;
    var totalDeg = 0;
    $("div.menuJ").click(function(){
        $(this).next().slideToggle("easeOut")
                      .siblings("p").slideUp("easeOut");

        deg *= -1;
        totalDeg += deg; 
        $(this).children("div").css('transform','rotate(' + totalDeg + 'deg)');
    });

    $( ".star_ratingJ a" ).click(function() {
        $(this).parent().children("a").removeClass("onJ");
        $(this).addClass("onJ").prevAll("a").addClass("onJ");
        return false;
    });
    
    $("div.color-nameJ").click(function(){
        var products = document.querySelectorAll(".color-nameJ");
        console.log(products);
        for(var i=0; i<products.length; i++){
            products[i].style.border = "2px solid darkgray"; 
            products[i].setAttribute("value","off");
        }
        $(this).css({"border-color": "#0070c9", 
                    "border-width":"2px", 
                    "border-style":"solid"})
               .attr('value','on');
       
       
    });
    
    $("div.capa-nameJ").click(function(){
        var products = document.querySelectorAll(".capa-nameJ");
        console.log(products);
        for(var i=0; i<products.length; i++){
            products[i].style.border = "2px solid darkgray"; 
            products[i].setAttribute("value","off");
        }
        $(this).css({"border-color": "#0070c9", 
                    "border-width":"2px", 
                    "border-style":"solid"})
               .attr('value','on');
       

    });
    
    
    function buyProduct(inch){
    	
    	 if(examineSelectOption() < 2){
    		alert("옵션을 선택해주세요!");
    	}else{
    		var confirmBuy = confirm("상품을 구매하시겠습니까?"); 
        	if(confirmBuy == true){
        		var orderSerialcode = findSerialCode(inch);
        		var orderQuantityList = 1;
        		var totalPrice = $("#totalPriceJ").attr('value');
        		
        		location.href="<%=request.getContextPath()%>/order/orderpage?orderSerialcode="+orderSerialcode+"&orderQuantityList="+orderQuantityList+"&totalPrice="+totalPrice;
        	}
    	}
    	var orderSerialcode = findSerialCode(inch);
		var orderQuantityList = 1;
		var totalPrice = $("#totalPriceJ").attr('value');
    }
    
    
	function addToCart(inch){
    	
		if(examineSelectOption() < 2){
    		alert("옵션을 선택해주세요!");
    	}else{
    		var addCart = confirm("장바구니에 상품을 담으시겠습니까?"); 
        	if(addCart == true){
        		
        		var serialCode = findSerialCode(inch);
        		location.href="<%=request.getContextPath()%>/cart/insert?serialCode="+serialCode;	
        	}
    	}		
    }
	
	$("#formReviewJ").submit(function(){
		
		var stars = document.getElementsByClassName("onJ");
		var grade = stars.length;
		console.log(grade);
		
		var stars = document.getElementsByClassName("onJ");
		var grade = stars.length;
		console.log(grade);
		
		$("#reivewGradeJ").val(grade);
		
	});
	
	
	function findSerialCode(inch){
		var prodCode = $("#button-rowJ input[type='hidden']").val();
      	var colorOption = document.querySelectorAll("div.color-nameJ");
    	var capaOption = document.querySelectorAll("div.capa-nameJ");
    	var color;
    	var capa;
  
    	for(var i=0; i<colorOption.length; i++){
    		if(colorOption[i].getAttribute("value") == 'on'){
    			color = findColorCode(colorOption[i].innerText);
    		}
        } 
    	
    	for(var j=0; j<capaOption.length; j++){
    		if(capaOption[j].getAttribute("value") == 'on'){
    			capa = findCapaCode(capaOption[j].innerText);
    		}
    	}
    	 
    	var serialCode = prodCode + color + "I" + inch + capa;
    	return serialCode;
	}
	
	
	function findCapaCode(capacity){
		var capaCode;
		switch(capacity){
		case "32GB" : 
			capaCode = "M32";
			break;
		case "64GB" : 
			capaCode = "M64";
			break;
		case "256GB" : 
			capaCode = "M256";
			break;
		case "512GB" : 
			capaCode = "M512";
			break;
		}
		return capaCode;
	}
	
	
	function findColorCode(colorName){
		var colorCode;
		switch(colorName){
		case "Black" : 
			colorCode = "C1";
			break;
		case "Red" : 
			colorCode = "C2";
			break;
		case "Blue" : 
			colorCode = "C3";
			break;
		case "Green" : 
			colorCode = "C5";
			break;
		case "Gray" : 
			colorCode = "C6";
			break;
		case "White" : 
			colorCode = "C7";
			break;
		case "Purple" : 
			colorCode = "C9";
			break;
		case "Silver" : 
			colorCode = "C10";
			break;
		case "Gold" : 
			colorCode = "C11";
			break;
		}
		
		return colorCode;
	}
	
	function examineSelectOption(){
		
		var colorOption = document.querySelectorAll("div.color-nameJ");
    	var capaOption = document.querySelectorAll("div.capa-nameJ");
    	
    	var count = 0;
    	for(var i=0; i<colorOption.length; i++){
    		if(colorOption[i].getAttribute("value") == 'on'){
    			count += 1;
    			
    		}
        } 
    	
    	for(var j=0; j<capaOption.length; j++){
    		if(capaOption[j].getAttribute("value") == 'on'){
    			count += 1;
    		}
    	}
		
    	return count;
	}
	
	
	 $(document).ready(function(){
	      var imgs;
	      var img_count;
	      var img_position = 1;

	      imgs = $(".slideJ ul");
	      img_count = imgs.children().length;

	      //버튼을 클릭했을 때 함수 실행
	      $('#backJ').click(function () {
	        back();
	      });
	      $('#nextJ').click(function () {
	        next();
	      });

	      function back() {
	        if(1 < img_position){
	          imgs.animate({
	            left:'+=1280px'
	          });
	          img_position--;
	        }
	      }
	      function next() {
	        if(img_count>img_position){
	          imgs.animate({
	            left:'-=1280px'
	          });
	          img_position++;
	        }
	      }

	    });
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
    