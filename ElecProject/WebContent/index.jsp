<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
      <div id="img">       
    </div>
    <section class="zoom" id="section1"> 
      <img src="images/WH/samzoom3.jpg" alt="">
    </section>
    <section id="moveLg">
    </section>
    <div>
      <section class="sec1"></section>
      <section class="sec3"></section>
    </div>
    <div id="iphone">
      <section class="hero iphon">
        <div class="cta">
          <p></p>
          <br><br><br><br>
        </div>
      </section>
    </div>
    <div>
      <img src="images/WH/bannersamsung.jpg" alt="" id="homeImg" >
      <img src="images/WH/bannerLg.jpg" alt="" id="imgHome">
    </div>
		<script type="text/javascript">
		//samsungfold
		 $(window).scroll(function(){
		   var scroll = $(window).scrollTop();
		   $(".zoom img").css({
		     width:(100 +scroll/10) +"%"
		   })
		 });

		 //lg

		 $(window).scroll(function(){
		   var scrollPosition = $(window).scrollTop()/14;
		   $("#moveLg").css({
		     "background-position-x" : - scrollPosition +"px"
		   })
		 });
		 
		</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
