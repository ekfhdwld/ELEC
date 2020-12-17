<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String inch = (String)request.getAttribute("inch");
    %>
    <!-- 원혁쓰헤더 -->
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/form.css" />

<script>
$(document).ready(function(){

    var i = 1;
    $("#addB").click(function(){
        var add = document.getElementById("waitingB");
        var html = '<input type="text" name="option" id="op'+i+'">';
        
        if(i !=6){
            add.innerHTML += html + "<br/>";
            i++;
         }

    });

    $("[name=registB]").submit(function(){
    	
        if(confirm("제품을 등록하시겠습니까?")){
            return true;
        }
        else{
            return false;
        }
    });

});
    
    function view(e) {
        $("#discountView").html(e.value + "%");
    }
    $(document).ready(function(){
        $("[name=capacity]").change(function(){
            console.log($(this));
            $(this).next().next().css("display", "inline-block");

            $("[name=capacity]").not(":checked").next().next().css("display", "none");
        });
    });


</script>

    <div class="contentB">
            <img src="<%=request.getContextPath() %>/images/DJ/st1.jpg" class="imBB">

            <form action="<%= request.getContextPath() %>/seller/form" 
       		 method="POST" 
                name="registB">
                <div class="navvB">

                    
                    <br>
                    <label for="productName"class="labelB">상품명 : </label>
                    <input type="text" name="productName" placeholder="노트북 상품명" required>
                    <input type="hidden" name="inch" value="<%=inch%>" />
                    <input type="hidden" name="category" value="N" />
                    <input type="hidden" name="brand" value="<%=memberLoggedIn.getMemberName() %>" />
                    
                    <br>
                    <br>
                    
                    <label for="color" class="labelB">색상 : </label>
                    <input type="checkbox" name="color" id="c3" value="c3" required>
                    <label for="c3">블루</label>
                    <input type="checkbox" name="color" id="c6" value="c6">
                    <label for="c6">그레이</label>
                    <input type="checkbox" name="color" id="c7" value="c7">
                    <label for="c7">화이트</label>
                    <br />
                    <input type="checkbox" name="color" id="c10" value="c10" style="margin-left: 145px;">
                    <label for="c10">실버</label>
                    
                    <br>
                    <br>
                    <label for="capacity" class="labelB">저장용량 : </label>
                    <input type="checkbox" name="capacity" id="500GB" value="500GB" required>
                    <label for="500GB">500GB</label>
                    <input type="number" name="price" placeholder="가격입력" style="display:none; width: 100px;" />
                    <br />
                    <input type="checkbox" name="capacity" id="1TB" value="1TB" style="margin-left: 192px;">
                    <label for="1TB">1TB</label>
                    <input type="number" name="price" placeholder="가격입력" style="display:none; width: 100px; margin-left: 40px;" />
                    
                    <br>
                    <br> 
                    <label for="discountRate" class="labelB">할인율</label>
                    <input type="range" min="1" max="5" step="1" name="discountRate" id="discountRate" value="0" onchange="view(this);" style="width: 200px;" required>
                    <div id="discountView" style="display: inline;">1%</div>
                    <br>
                    <br>
                    
                    <label for="description" class="labelB">옵션 : </label>
                    <input type="text" name="option" id="op0" required> <input type="button" value="추가" id="addB">
                    <div id="waitingB"></div>
                    
                    <button type="submit" class="subB">등록</button>
                    
                    
                </div>
                    
                </form>
                
                
            </div>


<%--    <div class="contenB">
        <div class="contB connntB"><span></span>제품 등록</div>   
        <div class="contB conntB">이미지 등록</div>   

    </div>
    
    <div class="contentB">

            <form action="<%= request.getContextPath() %>/seller/form" 
       		 method="POST" 
      		  name="registB">
            
            <br>
            <label for="productName"class="labelB">상품명 : </label>
            <input type="text" name="productName" required>
            <input type="hidden" name="inch" value="<%=inch%>" />
            <input type="hidden" name="category" value="N" />
            <input type="hidden" name="brand" value="<%=memberLoggedIn.getMemberName() %>" />

            <br>
            <br>

             <label for="color" class="labelB">색상 : </label>
            <input type="checkbox" name="color" id="c3" value="c3" required>
            <label for="c3">블루</label>
            <input type="checkbox" name="color" id="c6" value="c6">
            <label for="c6">그레이</label>
            <input type="checkbox" name="color" id="c7" value="c7">
            <label for="c7">화이트</label>
            <br />
            <input type="checkbox" name="color" id="c10" value="c10" style="margin-left: 155px;">
            <label for="c10">실버</label>

       		<br>
       		<br>
            <label for="capacity" class="labelB">저장용량 : </label>
            <input type="checkbox" name="capacity" id="500GB" value="500GB" required>
            <label for="500GB">500GB</label>
            <input type="number" name="price" placeholder="가격입력" style="display:none; width: 100px;" />
            <br />
            <input type="checkbox" name="capacity" id="1TB" value="1TB" style="margin-left: 205px;">
            <label for="1TB">1TB</label>
            <input type="number" name="price" placeholder="가격입력" style="display:none; width: 100px;" />

            <br>
            <br>
            <label for="discountRate" class="labelB">할인율</label>
            <input type="range" min="0" max="5" step="1" name="discountRate" id="discountRate" value="0" onchange="view(this);"  required>
            <div id="discountView" style="display: inline;">0%</div>
            <br>
            <br>

            <label for="description" class="labelB">기타 옵션 : </label>
            <input type="text" name="option" id="op0" required> <input type="button" value="추가" id="add">
            <div id="waitingB"></div>

            <button type="submit" class="subB">등록</button>



        </form>


    </div> --%>
    
<%@ include file="/WEB-INF/views/common/footer.jsp" %>