<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/enrollForm.css" />


<!-- 회원가입 페이지 -->

<section class="switch-btn">
<!-- 중복아이디 확인 폼 -->
<!-- 판매자 -->
<form name="checkIdDuplicateFrm1">
	<input type="hidden" name="memberId" />
</form>


	<div class="form-boxS">
		<!-- 판매자&관리자선택 버튼 시작 -->
		<!-- 판매자&관리자선택 버튼  끝-->

			<div class="button-boxS">
				<input type="button" id="btnS" value="" />
				<button type="button" id="toggle-btnS" onclick="location='sellerEnroll'">Seller</button>
				<button type="button" id="toggle-btnS" onclick="location='enroll'">Member</button>
			</div>
		<div class="enroll-formS">
			<!--판매자 폼 시작-->
			<form id="sellerEnrollFrm" class="input-groupS"
				name="sellerEnrollFrm"
				action="<%=request.getContextPath()%>/member/sellerEnroll" method="post">

				<label class="label">아이디<span>*</span></label> 
						<input type="text" class="member" name="memberId" id="memberId_" placeholder="4글자이상 " required>
				&nbsp; <input type="button" class="check_btn" value="중복" onclick="checkIdDuplicate_S();" />
						<!-- 아이디 중복검사 여부 : 0=미확인, 1=확인 -->
						<input type="hidden" id="idValid" value="0" />
				
				<label class="label">비밀번호<span>*</span></label> 
				<input type="password" class="member" name="memberPwd" id="memberPwd" placeholder="4자이상" required> <input type="password"
							placeholder="비밀번호 확인" class="member" name="memberPwdCheck" id="userPwdCheck" required>
				<hr>
				<label class="label">이름<span>*</span></label> 
					<input type="text" class="member" name="memberName" id="memberName_" placeholder="2자이상" required style="width: 205px; height: 35px;"> 
				<label class="label" style="clear: both;">연락처<span>*</span></label> 
					<input type="text" class="member" name="memberPhone" id="memberPhone_" placeholder="'-'를 제외하고 적으시오" required> 
				<label class="label">주소<span>*</span> 
					<input type="button" class="serach_address_btn" value="search" onclick="goPopup2();" />
				</label> 
					<input type="text" class="member" name="roadFullAddr" id="roadFullAddr" placeholder="주소를 검색하시오" readonly> 
				<br />
				<input class="reg-btn" type="submit" id="Reg_submit" value="가입하기">
				<input class="reg-btn" type="reset" value="취소">
			</form>
			<!-- 판매자 폼 끝 -->

			
		</div>

		<script>
					var x = document.getElementById("sellerEnrollFrm");
                    var y = document.getElementById("memberEnrollFrm");
                    var z = document.getElementById("btnS");

                    function memberEnrollBtn(){
                    x.style.left ="-500px";
                    y.style.left="50px";
                    z.style.left="130px";
                    }
                    function sellerEnrollBtn(){
                        x.style.left ="50px";
                        y.style.left="450px";
                        z.style.left="0";
                    }
                  
                    /**
                    * 팝업창 중복검사 기능
    				* 아이디 중복검사 함수
    				* 팝업창 checkIdDuplcateFrm 제출
    				/* 
    				판매자 폼기능
    				*/
    				function checkIdDuplicate_S(){
    					//아이디 중복검사	
    					var $memberId = $("#memberId_");
    					
    					
    					if(/^\w{4,}$/.test($memberId.val()) == false){
    						alert("4글자이상의 유효한 아이디를 입력해주세요.");
    						
    						return;
    					}
    					//1.팝업관련
    					var url = "";//checkIdDuplicateFrm의 action값이 사용되므로, 비워둠.
    					var title = "checkIdDuplicatePopup1";
    					var spec = "left=500px, top=300px, width=500px, height=200px";
    					open(url, title, spec);
    					
    					//2.폼관련
    					var $frm = $("[name=checkIdDuplicateFrm1]");
    					$frm.attr("action", 
    							  "<%=request.getContextPath()%>/member/checkIdDuplicate");
    					$frm.attr("method", "POST");
    					$frm.attr("target", title);//폼과 팝업창 연결
    					$frm.find("[name=memberId]").val($memberId.val());
    					$frm.submit();
    				}
    				/**
    				 * 중복검사 미실시, 폼제출불가
    				 * change이벤트는 blur시 변경사항이 있다면 발생.
    				*/
    				$("#memberId_").change(function(){
    					console.log("#memberId_ changed!!!");
    					
    					//0 미확인 상태 -> 최종 유효성검사에서 중복검사하지 않은 상태로 제출불가
    					$("#idValid").val(0);	
    				});
    				
    				$("[name=sellerEnrollFrm]").submit(function(){
    				
    					//.중복검사 여부
    					var $idValid = $("#idValid");
    					if($idValid.val() == 0){
    						alert("아이디 중복 검사해주세요.");
    						return false;
    					}
    					return true;
    				});
    				//-------------중복검사팝업창 끝! 
    				//유효성검사
    				//판매자이름
                    $("#memberName_").blur(function(){
    				var $memberName_ = $("#memberName_");
    				
    					if(/^[A-Z]{2,}$/.test($memberName_.val()) == false){
    						$('#memberName_').val('');
    						alert("판매자 이름은 영어 대문자로, 두글자이상 입력해주세요.");
    						return false;
    					}		
    					return true;
    				})
                    //판매자아이디
                    $("#memberId_").blur(function(){
    					var $memberId = $("#memberId_");
    					if(/^[\w]{4,}$/.test($memberId.val()) == false){
    						alert("4글자이상 유효한 아이디를 입력하세요.");
    						return false;
    					}
    					return ture;
    				})
    				//판매자 비밀번호
    				$("#memberPwd").blur(function(){
    					var $memberPwd = $("#memberPwd");
    					if(/^[\w]{4,}$/.test($memberPwd.val()) == false){
    						alert("4글자이상 비밀번호를 입력하세요.");
    						return false;}	
    					return true;
    				})
    				$("#memberPwdCheck").blur(function(){
    					var $memberPwd = $("#memberPwd");
    					var $memberPwdCheck = $("#memberPwdCheck");
    					if($memberPwd.val() != $memberPwdCheck.val()){
    						alert("비밀번호가 일치하지 않습니다.");
    						return false;}	
    					return true;
    				})
					//판매자 핸드폰번호
     				$("#memberPhone_").blur(function(){
    					var $memberPhone_ = $("#memberPhone_");	
    					if(/^[0-9]{11}$/.test($memberPhone_.val())==false){
    						return false;
    						alert("연락처는 숫자로만, 11글자 입력해주세요");
    					}
    					return true;
    				})
    		

    	
			//공통주소검색 api
			function goPopup2() {
				var pop = window.open("/elec/popup/jusoPopup2.jsp", "pop",
						"width=570,height=420, scrollbars=yes, resizable=yes");
			}
			function jusoCallBack2(roadFullAddr, roadAddrPart1, addrDetail,
					roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn,
					bdMgtSn, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm,
					liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm,
					lnbrSlno, emdNo) {
					document.sellerEnrollFrm.roadFullAddr.value = roadFullAddr;
			}
		</script>
	</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</section>


