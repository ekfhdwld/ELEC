<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String msg = (String)request.getAttribute("msg"); 
	String brand = (String)request.getAttribute("brand");
	String productCode = (String)request.getAttribute("productCode");
	String category = (String)request.getAttribute("category");
	%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/form.css" />

<body>
	
<%-- <%@ include file="/WEB-INF/views/common/header.jsp" %> --%>
<script>

$(document).ready(function() {
   <%if(msg!=null){%>
   	alert('<%=msg%>');
   <%}%>
}); 


$(document).ready(function() {
        $("input[type=file]").on("change", handleImgFileSelect);
    }); 
    
    
    function handleImgFileSelect(e) {

        var $img;
        var $span;
        if(e.target == thum){
            $img = $("#img_thum");
            $span = $("#span_thum");
        }else if(e.target == adImg1){
            $img = $("#img_adImg1");
            $span = $("#span_adImg1");
        }else{
            $img = $("#img_adImg2");
            $span = $("#span_adImg2");
        }

        var files = e.target.files;
        var filesArr = Array.prototype.slice.call(files);

        filesArr.forEach(function(f) {

            if(!f.type.match("image.*")) {
                alert("이미지만 올릴 수 있습니다."+f.name);
                $span.css("opacity", "1");
                return;
            }
            $span.css("opacity", "0");

            sel_file = f;

            var reader = new FileReader();
            reader.onload = function(e) {
                $img.attr("src", e.target.result);
            }
            reader.readAsDataURL(f);
        });

    }
    $(document).ready(function(){
    	$("[name=imageUpload]").submit(function(){
    		if(confirm("이미지를 등록하시겠습니까?"))
    			return true;
    		else
    			return false;
    		
    	});
    });


</script>


<div class="contentB">
	<img src="<%=request.getContextPath() %>/images/DJ/st1.jpg"
		class="imBB">
		
	<form action="<%=request.getContextPath() %>/product/uploadImage" method="POST" name="imageUpload"
		enctype="multipart/form-data">
			<input type="hidden" name="brand" value="<%=brand%>" />
		<div class="inaveB">
			<h2 class="SumB">썸네일 등록</h2>
			<input type="file" accept="image/*" class="img-btnB" name="thum"
				id="thum"> <span id="span_thum"></span>
			<div class="thum_wrap">
				<img id="img_thum">
			</div>
			<h2 class="SumB">광고이미지 등록</h2>
			<input type="file" accept="image/*" class="img-btnB" name="adImg1"
				id="adImg1"><span id="span_adImg1"></span>
			<div class="adImg1_wrap">
				<img id="img_adImg1">
			</div>
			<h2 class="SumB">광고이미지 등록</h2>
			<input type="file" accept="image/*" class="img-btnB" name="adImg2"
				id="adImg2"><span id="span_adImg2"></span>
			<div class="adImg2_wrap">
				<img id="img_adImg2">
			</div>

			<button type="submit" id="submitB">이미지 등록</button>
		
		</div>
	</form>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>