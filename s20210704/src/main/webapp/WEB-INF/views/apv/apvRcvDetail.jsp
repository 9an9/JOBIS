<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<title>JOBIS</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/SpringMain.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.w3-col.m7{width:73.33333%}
.btn1{
   color: #fff;
   background-color: #607084;
   
   border-color: #607084;
   border-radius: 6px;
 }
.btn2{
  color: #fff;
  background-color: #d20404;
  
  border-color: #d20404;
  border-radius: 6px;
}
td{
	width: 12.5%;
}
th{
	width: 12.5%;
	background-color:#E0E3DA; 
}
select {
  text-align-last: center;
  text-align: center;
  -ms-text-align-last: center;
  -moz-text-align-last: center;
}
</style>




<body class="w3-theme-l5">

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
    <a href="../main" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>Home</a>
  <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large" title="Notifications"><i class="fa fa-file-text fa-fw w3-margin-right"></i>전자결재</button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">
      <a href="apvWrite" class="w3-bar-item w3-button">결재 서류 작성</a>
      <a href="apvSnd" class="w3-bar-item w3-button">받은 결재</a>
      <a href="apvRcv" class="w3-bar-item w3-button">보낸 결재</a>
    </div>
  </div>
  <a href="../calendar/calendar" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Account Settings"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>일정</a>
  <a href="../rr/rr" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Messages"><i class="fa fa-list-alt fa-fw w3-margin-right"></i>자료실</a>
  <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large" title="Notifications"><i class="fa fa-commenting-o fa-fw w3-margin-right fa-flip-horizontal"></i>게시판</button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">
      <a href="../board/noticeList" class="w3-bar-item w3-button">공지사항</a>
      <a href="../board/surveyList" class="w3-bar-item w3-button">설문</a>
      <a href="../board/clubList" class="w3-bar-item w3-button">동호회</a>
    </div>
  </div>
  <c:if test="${svo.dcontent == '인사부' || svo.dcontent == '임원'  }">
	   <div class="w3-dropdown-hover w3-hide-small">
	    <button class="w3-button w3-padding-large" title="Notifications"><i class="fa fa-cog fa-fw w3-margin-right" aria-hidden="true"></i>관리</button>      
	    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">
	      <a href="../emp/empList" class="w3-bar-item w3-button">사원 정보 관리</a>
	      <a href="../cmt/cmt" class="w3-bar-item w3-button">사원 근태 관리</a>
	    </div>
	  </div>
  </c:if>
  
  <a href="../logout" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">
    <i class="fa fa-sign-out w3-margin-right"></i>Logout
  </a>
 </div>
</div> 

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="#" class="w3-bar-item w3-button w3-padding-large">안보임</a> <!-- 이 줄은 안보이는 줄입니다 -->
  <button onclick="myFunction1('Demo1')" class="w3-bar-item w3-button w3-padding-large">전자결재</button>
  	<div id="Demo1" class="w3-hide w3-bar-block">
    	<a href="apvWrite" class="w3-button w3-block w3-theme-l5 w3-left-align">결재 서류 작성</a>
        <a href="apvSnd" class="w3-button w3-block w3-theme-l5 w3-left-align">받은 결재</a>
        <a href="apvRcv" class="w3-button w3-block w3-theme-l5 w3-left-align">보낸결재</a>
    </div>
  <a href="../calendar/calendar" class="w3-bar-item w3-button w3-padding-large">일정</a>
  <a href="../rr/rr" class="w3-bar-item w3-button w3-padding-large">자료실</a>
  <button onclick="myFunction1('Demo2')" class="w3-bar-item w3-button w3-padding-large">게시판</button>
  	<div id="Demo2" class="w3-hide w3-bar-block">
    	<a href="../board/noticeList" class="w3-button w3-block w3-theme-l5 w3-left-align">공지사항</a>
        <a href="../board/surveyList" class="w3-button w3-block w3-theme-l5 w3-left-align">설문조사</a>
        <a href="../board/clubList" class="w3-button w3-block w3-theme-l5 w3-left-align">동호회</a>
    </div>
    <c:if test="${svo.dcontent == '인사부' || svo.dcontent == '임원'  }">
	   <button onclick="myFunction1('Demo4')" class="w3-bar-item w3-button w3-padding-large">관리</button>
	  	<div id="Demo4" class="w3-hide w3-bar-block">
	    	<a href="../emp/empList" class="w3-button w3-block w3-theme-l5 w3-left-align">사원 정보 관리</a>
	        <a href="../cmt/cmt" class="w3-button w3-block w3-theme-l5 w3-left-align">사원 근태 관리</a>
	    </div>
    </c:if>
</div>

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile -->
      <div class="w3-card w3-round w3-white">
        <div class="w3-container">
         <h4 class="w3-center">My Profile</h4>
         <p class="w3-center"><img src="../images/LUCY.jpg" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
         <hr>
         <p><i class="fa fa-id-badge fa-fw w3-margin-right w3-text-theme"></i> ${svo.emp_name }</p>
         <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${svo.dcontent } / ${svo.rcontent }</p>
         <a href="../cmt/mycmt" style="display: block; text-decoration: none;"><i class="fa fa-clock-o fa-fw w3-margin-right w3-text-theme"></i> 나의 근태정보</a><p>
         <a href="../emp/myInfoUpdate" style="display: block; text-decoration: none;"><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> 개인정보수정</a>
        </div>
      </div>
      <br>
      
      <!-- Accordion -->
      <div class="w3-card w3-round">
        <div class="w3-white">
          <button onclick="myFunction('Demo3')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-envelope fa-fw w3-margin-right" ></i><span class="w3-badge w3-right w3-small w3-green">1</span> 쪽지</button>
          <div id="Demo3" class="w3-hide w3-bar-block">
          	<a href="../note/sendNote" class="w3-button w3-block w3-theme-l5 w3-left-align">쪽지 보내기</a>
            <a href="../note/sentNote" class="w3-button w3-block w3-theme-l5 w3-left-align">보낸 쪽지함</a>
            <a href="../note/receiveNote" class="w3-button w3-block w3-theme-l5 w3-left-align"><span class="w3-badge w3-right w3-small w3-green">1</span>받은 쪽지함</a>
          </div>
          <a href="apvSnd" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-file-text fa-fw w3-margin-right"></i><c:if test="${unreadTotal > 0 }"><span class="w3-badge w3-right w3-small w3-green">${unreadTotal }</span></c:if><c:if test="${apvNoTotal > 0 }"><span class="w3-badge w3-right w3-small w3-red">${apvNoTotal }</span></c:if> 결재</a>
          <a href="../board/surveyList" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-check-square-o fa-fw w3-margin-right"></i><span class="w3-badge w3-right w3-small w3-green">2</span> 설문</a>
        </div>      
      </div>
      <br>
      
      <!-- Interests --> 
      <div class="w3-card w3-round w3-white w3-hide-small">
        <div class="w3-container">
          <p>채팅</p>
          <hr>
		  <p>인사부<p>
          <p>관리부<p>
          <p>개발부<p>
        </div>
      </div>
      <br>

    
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
   <div class="w3-col m7" >
    
      <div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card w3-round w3-white">
            <div class="w3-container w3-padding">          
              <h1><i class="fa fa-file-text fa-fw w3-margin-right"></i><b>받은 결재</b></h1><hr>
              
          	  	 <form action="apvok" method="post" style="margin-top: 30px;" name="frm" target="_self" onsubmit="return chk()">
        	  	 	<c:set var="okChk" value="0"/>
        	  	 	<input type="hidden" name="apv_ok" id="apv_ok">
        	  	 	<input type="hidden" name="apv_sq" value="${rcvDetail.apv_sq }">
        	  	 	<input type="hidden" name="apv_mid_emp" value="${emp_num }">
        	  	 	<table style="width: 100%; text-align: center; border: none;" border="1">
	        	  	 	<tr><th>사원번호</th><td>${rcvDetail.apv_snd }</td><th>부서</th><td>${rcvDetail.srt_dep }</td><th>직급</th><td>${rcvDetail.srt_rnk }</td><th>이름</th><td>${rcvDetail.srt_name }</td></tr>
	        	  	 	<tr>
	        	  	 		<th>결재분류</th><td>${rcvDetail.apv_type }</td><td colspan="4"></td>
	       	  	 			<c:if test="${not empty rcvDetail.apv_fnl }">
	        	  	 			<c:if test="${rcvDetail.apv_fnl == emp_num }">
	        	  	 				<th>최종 결재자</th><td>${rcvDetail.rcv_name }</td>
	        	  	 			</c:if>
	        	  	 		</c:if>
	        	  	 		<c:if test="${not empty rcvDetail.apv_fnl }">
		       	  	 			<c:if test="${rcvDetail.apv_fnl != emp_num }">
		        	  	 			<th id="nxt"></th>
		        	  	 			<td id="Rcv_List"></td>
		        	  	 		</c:if>
	        	  	 		</c:if>
	        	  	 	</tr>
	        	  	 	<tr><th>제목</th><td colspan="7" style="text-align: initial;">${rcvDetail.apv_title }</td></tr>
	        	  	 	<tr>
	        	  	 		<th>첨부파일  </th> 
	        	  	 		<td class="fileBox" colspan="7" style="text-align: initial;">
		        	  	 		<c:if test="${empty rcvDetail.apv_pl_nm }">없음</c:if>
		        	  	 		<c:if test="${not empty rcvDetail.apv_pl_nm }">
			        	  	 		<a href="ysdownload?fileName=${rcvDetail.apv_pl_nm }" style="text-decoration: none; color: black;">📁${fn:substringAfter(rcvDetail.apv_pl_nm, '_') }</a>
		        	  	 		</c:if>
	        	  	 		</td>
	        	  	 	</tr>
	        	  	 	
						<tr>
							<th>진행과정  </th>
							<td colspan="7" style="text-align: initial;">
								<c:set value="0" var="i"/>
								<c:set value="0" var="ing_no"/>
								<c:forEach var="apv_ing" items="${apv_ing }">
									<c:if test="${apv_ing.apv_ok == 4}"><c:set value="${ing_no + 1 }" var="ing_no"/></c:if>
									<c:if test="${i == 0 }">
										<span>${apv_ing.rcv_name }</span>						
									</c:if>
									<c:if test="${i > 0 }">
										<c:choose>
											<c:when test="${(apv_ing.apv_ok == 0 || apv_ing.apv_ok == 4) && ing_no > 0}">
												<span> &nbsp; ->  &nbsp; ${apv_ing.rcv_name } (반려)</span>						
											</c:when>
											<c:when test="${apv_ing.apv_ok == 1 || apv_ing.apv_ok == 3 }">
												<span> &nbsp; ->  &nbsp; ${apv_ing.rcv_name } (승인)</span>						
											</c:when>
											<c:otherwise>
												<span> &nbsp; ->  &nbsp; ${apv_ing.rcv_name } (진행중)</span>
											</c:otherwise>
										</c:choose>
									</c:if>
									<c:set value="${i + 1 }" var="i"/>	
								</c:forEach>
							</td>
						</tr>
						
						<tr><td id="pdf" colspan="8" style="text-align: center;"></td></tr>
						
						<tr><th>내용</th><td colspan="7" style="height: 150px;">${rcvDetail.apv_content }</td></tr>
						
						<tr style="border-bottom: 1px solid #c1c0c0;">
							<c:if test="${rcvDetail.apv_ok == 4 }">
								<th>반려사유 </th><td colspan="7">${rcvDetail.apv_no }</td>
							</c:if>
					
							
		       	  	 		<c:if test="${not empty rcvDetail.apv_mid_ok }">
		        	  	 		<c:if test="${rcvDetail.apv_mid_ok == 0 && rcvDetail.apv_ok < 3}">
		        	  	 			<c:set var="okChk" value="${okChk + 1 }"/>
		        	  	 			<th>반려사유</th><td colspan="7"><input type="text" name="apv_no" placeholder="반려를 하신다면 사유를 작성해주세요"  style="width: 100%; border: none;"></td>
		        	  	 		</c:if>
		       	  	 		</c:if>
	       	  	 		</tr>
       	  	 		</table>
       	  	 		<c:if test="${not empty rcvDetail.apv_mid_ok }">
        	  	 		<c:if test="${rcvDetail.apv_mid_ok == 0 && rcvDetail.apv_ok < 3}">
        	  	 			<div style="margin-top: 3px; margin-bottom: 45px;">
        	  	 				<button type="button" class="btn2" style="float: right; margin-left: 3px;" onclick="apvno()">반려</button>
        	  	 				<input type="submit" value="승인" class="btn1" style="float: right;">
        	  	 			</div>
        	  	 		</c:if>
       	  	 		</c:if>
          	  	 </form>
          	  
           

            </div>
          </div>
        </div>
      </div>
      

      
    <!-- End Middle Column -->
    </div>
    
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>
<br>


<!-- Footer -->
<footer class="w3-container w3-theme-d5">
  <p>&copy copyright is reserved by JOBIS/<a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>
 
<script>
// Accordion
function myFunction(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-theme-l1";
  } else { 
    x.className = x.className.replace("w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-theme-l1", "");
  }
}
function myFunction1(id) {
	  var x = document.getElementById(id);
	  if (x.className.indexOf("w3-show") == -1) {
	    x.className += " w3-show";
	    x.previousElementSibling.className += " w3-theme-d2";
	  } else { 
	    x.className = x.className.replace("w3-show", "");
	    x.previousElementSibling.className = 
	    x.previousElementSibling.className.replace(" w3-theme-d2", "");
	  }
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}



///////////



function getRcvList(){
	var tdName = '다음 결재자';
	$('#nxt').empty();
	$('#nxt').append(tdName);
	var apv_ok   = document.getElementById('apv_ok');
	var emp_rnk  = '${svo.rcontent }';
	var emp_num  = '${emp_num }';
	var apv_type = '${rcvDetail.apv_type }';
	var url = "";
	if(apv_type == '일일보고'){
		if(emp_rnk == '대리'){ url = "../rcvList2?emp_num="+emp_num; apv_ok.value = 2;}
		else if(emp_rnk == '팀장'){ apv_ok.value = 3; }
	}else if(apv_type == '주간보고'){
		if(emp_rnk == '부장'){ url = "../rcvList4"; apv_ok.value = 2; }
		else if(emp_rnk == '전무'){ apv_ok.value = 3; }
		else if(emp_rnk == '상무'){ apv_ok.value = 3; }
	}else if(apv_type == '근태보고'){
		if(emp_rnk == '대리'){ url = "../rcvList2?emp_num="+emp_num; apv_ok.value = 2; }
		else if(emp_rnk == '팀장'){ apv_ok.value = 3; }
	}else if(apv_type == '비용신청'){
		if(emp_rnk == '사원'){ url = "../rcvList6"; apv_ok.value = 1; }
		else if(emp_rnk == '대리'){ url = "../rcvList7"; apv_ok.value = 2; }
		else if(emp_rnk == '팀장'){ apv_ok.value = 3;}
	}else if(apv_type == '사업보고'){
		if(emp_rnk == '팀장'){ url = "../rcvList3?emp_num="+emp_num; apv_ok.value = 1; }
		else if(emp_rnk == '부장'){ url = "../rcvList4"; apv_ok.value = 2; }
		else if(emp_rnk == '전무'){ apv_ok.value = 3; }
		else if(emp_rnk == '상무'){ apv_ok.value = 3; }
	}else if(apv_type == '인사보고'){
		if(emp_rnk == '대리'){ url = "../rcvList2?emp_num="+emp_num; apv_ok.value = 1; }
		else if(emp_rnk == '팀장'){ url = "../rcvList3?emp_num="+emp_num; apv_ok.value = 2; }
		else if(emp_rnk == '부장'){ apv_ok.value = 3; }
	}else if(apv_type == '행사보고'){
		if(emp_rnk == '대리'){ url = "../rcvList7"; apv_ok.value = 1; }
		else if(emp_rnk == '팀장'){ url = "../rcvList8";apv_ok.value = 2; }
		else if(emp_rnk == '부장'){ apv_ok.value = 3; }
	}else if(apv_type == '월간보고'){
		apv_ok.value = 3;
	}else if(apv_type == '최종보고'){
		apv_ok.value = 3;
	}
	
	var str  = "";
	var str2 = "";
	$.ajax({
		url:url,
		dataType:'json',
		success:function(data){
			$('#Rcv_List *').remove();
			str += "<select name = 'apv_fnl' required='required' id='slt' onchange='sltrm()' style='width: 100%;'><option value='-결재자-' selected='selected'>-결재자-</option>";
			$(data).each(
					function(){
						str2 = "<option value = '"+this.emp_num + "'>"+this.emp_name + "</option>";
						str += str2;
					}		
				);
				str += "</select>";
				$('#Rcv_List').append(str);
		}
	});
}

var okChk = '${okChk}';
if(okChk > 0){ getRcvList(); }

function chk(){
	if(frm.apv_fnl.value == '-결재자-'){
		alert("다음 결재자를 선택해주세요");
		return false;
	}
	return true;
}



function sltrm(){
	$("#slt option[value='-결재자-']").remove();
}


function apvno(){
	var nono= frm.apv_no.value;
	if(!frm.apv_no.value){
		alert("반려사유를 작성해주세요");
		return;
	}else{
		location.href='apvno?sq=${rcvDetail.apv_sq }&nono='+nono;
	}
}
var pdfName = '${rcvDetail.apv_pl_nm}';
if(pdfName){
	var pdfPath = '<iframe width="80%" height="550" src="../upload/${rcvDetail.apv_pl_nm}" style="margin-top: 10px;" />';
	$('#pdf').append(pdfPath);	
}

</script>

</body>
</html> 

