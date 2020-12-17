<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        	$("[name=color]").on("click", function(){
                var cnt = $("[name=color]:checked").length;
                if(cnt>4){
                    console.log(this);
                    $(this).prop("checked", false);
                    alert("색상은 4개까지 선택할 수 있습니다.");
                }
        	});
        	
        });
    
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
        name="registB"
        style="height:880px;">
           <div class="navvB">
            <br>
            <label for="productName" class="labelB">상품명 : </label>
            <input type="text" name="productName" placeholder="핸드폰 상품명">
            
	         <input type="hidden" name="category" value="P"/>
	     	<input type="hidden" name="brand" value="<%=memberLoggedIn.getMemberName()%>"/>

            <br>
            <br>
           
            <label for="color" class="labelB">색상 : </label>
            <input type="checkbox" name="color" id="c1" value="c1">
            <label for="c1">블랙</label>
            <input type="checkbox" name="color" id="c2" value="c2" style="margin-left:22px;">
            <label for="c2">레드</label>
            <input type="checkbox" name="color" id="c5" value="c5" style="margin-left:22px;">
            <label for="c5">그린</label>
            <br>
            <input type="checkbox" name="color" id="c6" value="c6"  style="margin-left: 145px;">
            <label for="c6">그레이</label>
            <input type="checkbox" name="color" id="c7" value="c7">
            <label for="c7">화이트</label>
            <input type="checkbox" name="color" id="c9" value="c9">
            <label for="c9">퍼플</label>
            <br>
            <input type="checkbox" name="color" id="c11" value="c11" style="margin-left: 145px;">
            <label for="c11">골드</label>
            

 			 <br>
 			 <br>
            <label for="capacity" class="labelB">저장용량 : </label>
            <input type="checkbox" name="capacity" value="32GB">
            <label for="32">32GB</label>
            <input type="number" name="price" placeholder="가격입력" style="display: none; width: 100px; margin-left:22px;">
            <br />
            <input type="checkbox" name="capacity" value="64GB" style="margin-left: 192px;" >
            <label for="64">64GB</label>
            <input type="number" name="price" placeholder="가격입력" style="display: none; width: 100px; margin-left:22px;">
            <br />
            <input type="checkbox" name="capacity" value="256GB" style="margin-left: 192px;">
            <label for="256">256GB</label>
            <input type="number" name="price" placeholder="가격입력" style="display: none; width: 100px;">
            <br>
            <input type="checkbox" name="capacity"  value="512GB" style="margin-left: 192px;">
            <label for="512">512GB</label>
            <input type="number" name="price" placeholder="가격입력" style="display: none; width: 100px;">
            <br>
            <br>
            <label for="discountRate" class="labelB">할인율</label>
            <input type="range" min="1" max="5" step="1" name="discountRate" id="discountRate" value="0" onchange="view(this);" required>
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
<%@ include file="/WEB-INF/views/common/footer.jsp" %>