<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<title>JOBIS</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/SpringMain.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.w3-col.m7{width:73.33333%}
.btn2{
   color: #fff;
   background-color: #3C3530;
   
   border-color: #3C3530;
   border-radius: 6px;
 }
 .cmtTB{
	text-align: center;
	width: 80%;
	margin: 0 auto;
	
    margin-top: 5px;
    border: 1px solid #7d97a5;
    border-collapse: collapse;
    border-spacing: 0;
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
      <a href="../apv/apvWrite" class="w3-bar-item w3-button">결재 서류 작성</a>
      <a href="../apv/apvSnd" class="w3-bar-item w3-button">받은 결재</a>
      <a href="../apv/apvRcv" class="w3-bar-item w3-button">보낸 결재</a>
    </div>
  </div>
  <a href="../calendar/calendar" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Account Settings"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>일정</a>
  <a href="rr" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Messages"><i class="fa fa-list-alt fa-fw w3-margin-right"></i>자료실</a>
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
  
  <a href="../" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">
    <i class="fa fa-sign-out w3-margin-right"></i>Logout
  </a>
 </div>
</div> 

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="#" class="w3-bar-item w3-button w3-padding-large">안보임</a> <!-- 이 줄은 안보이는 줄입니다 -->
  <button onclick="myFunction1('Demo1')" class="w3-bar-item w3-button w3-padding-large">전자결재</button>
  	<div id="Demo1" class="w3-hide w3-bar-block">
    	<a href="../apv/apvWrite" class="w3-button w3-block w3-theme-l5 w3-left-align">결재 서류 작성</a>
        <a href="../apv/apvSnd" class="w3-button w3-block w3-theme-l5 w3-left-align">받은 결재</a>
        <a href="../apv/apvRcv" class="w3-button w3-block w3-theme-l5 w3-left-align">보낸결재</a>
    </div>
  <a href="../calendar/calendar" class="w3-bar-item w3-button w3-padding-large">일정</a>
  <a href="rr" class="w3-bar-item w3-button w3-padding-large">자료실</a>
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
			<a href="../message/sendMsg" class="w3-button w3-block w3-theme-l5 w3-left-align">메시지 보내기</a>
			<a href="../message/sentMsg" class="w3-button w3-block w3-theme-l5 w3-left-align">보낸 메시지</a>
			<a href="../message/rcvMsg" class="w3-button w3-block w3-theme-l5 w3-left-align"><span class="w3-badge w3-right w3-small w3-green">1</span>받은 메시지</a>
         </div>
          <a href="../apv/apvSnd" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-file-text fa-fw w3-margin-right"></i><c:if test="${unreadTotal > 0 }"><span class="w3-badge w3-right w3-small w3-green">${unreadTotal }</span></c:if><c:if test="${apvNoTotal > 0 }"><span class="w3-badge w3-right w3-small w3-red">${apvNoTotal }</span></c:if>
결재</a>
          <a href="../board/surveyList" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-check-square-o fa-fw w3-margin-right"></i><span class="w3-badge w3-right w3-small w3-green">2</span> 설문</a>
          <button onclick="nwindow()" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fas fa-comment-dots fa-fw w3-margin-right"></i><span class="w3-badge w3-right w3-small w3-green"></span>채팅</button>
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
              <h1><i class="fa fa-clock-o fa-fw w3-margin-right" style="font-size: 42px"></i><b>자료실 상세보기</b></h1><hr>
	            <table border="1" class="cmtTB" style="align-content: center; border: none;">
						<tr>
							<td style="background-color:#E0E3DA;">사원번호</td>
							<td>${jhRr.emp_num }</td>			
						</tr>
						<tr>
							<td style="background-color:#E0E3DA;">자료종류</td>
							<td>
								<c:if test="${jhRr.rr_type == 0 }">문서양식</c:if>
								<c:if test="${jhRr.rr_type == 1 }">기타양식</c:if>
								<c:if test="${jhRr.rr_type == 2 }">동호회</c:if>
								<c:if test="${jhRr.rr_type == 3 }">공지사항</c:if>
							</td>			
						</tr>
						<tr>
							<td style="background-color:#E0E3DA;">제목</td>
							<td>${jhRr.rr_subject }</td>			
						</tr>
						<tr>
							<td style="background-color:#E0E3DA;">내용</td>
							<td>${jhRr.rr_content }</td>			
						</tr>
<!-- 						<tr> -->
<!-- 							<td>조회수</td> -->
<%-- 							<td>${jhRr.rr_hits }</td>			 --%>
<!-- 						</tr> -->
						<tr>
							<c:if test="${jhRr.rr_filename ne equal}">
								<td style="background-color:#E0E3DA;">파일</td>
								<c:set var="a" value="${jhRr.rr_filename }"/>
								<td><a href="../hhh?fileName=${jhRr.rr_filename }">${fn:substring(a,37,100)}</a></td>			
							</c:if>
						</tr>
						<tr>
							<td style="background-color:#E0E3DA;">작성일</td>
							<td>${jhRr.rr_date }</td>			
						</tr>
					<tr>
				</table>
						<div style="text-align: center; margin-top: 10px">
							<input class="btn2" type="button" value="목록" onclick="location.href='rr'">
							<c:if test="${detail_num == emp_num }">
								<input class="btn2" type="button" value="수정" onclick="location.href='rrupdateForm?rr_num=${jhRr.rr_num }&detail_num=${jhRr.emp_num}'">				
								<input class="btn2" type="button" value="삭제" onclick="location.href='rrdelete?rr_num=${jhRr.rr_num }&detail_num=${jhRr.emp_num}'">
							</c:if>
						</div>
				<!-- 삭제가능(댓글 목록보기) -->
				<hr>
				<div id="reply">
					<form action="replyDelete" style="text-align: center;">
					<ol class="replyList">
						<c:forEach items="${replyList }" var="replyList">
							<div>
								<div style="margin: 5px 0 0 11px">작성자 : ${replyList.emp_name } / 작성날짜 : ${replyList.rrc_date }</div>
								<div>작성내용 : ${replyList.rrc_content }</div>
								</p>
								<c:if test="${replyList.emp_num == emp_num }">
									<input class="btn2" type="button" value="삭제" onclick="location.href='replyDelete?rrc_num=${replyList.rrc_num}&rr_num=${jhRr.rr_num }'">
								</c:if>
								<hr>
							</div>
						</c:forEach>
					</ol>
					</form>
				</div>
				<!-- 삭제가능(댓글 목록보기) -->
				<div>
					<form action="replyWrite" method="post" style="text-align: center;">
						<input type="hidden" id="rr_num" name="rr_num" value="${jhRr.rr_num }">
						<input type="hidden" name="emp_num" value="${emp_num }">
<%-- 						<input type="hidden" name="emp_name" value="${svo.emp_name }"> --%>
						<input type="hidden" name="emp_name" value="${svo.emp_name }">
						<textarea rows="" cols="" name="rrc_content"></textarea><br/>
						<input class="btn2" type="submit" value="댓글달기">
					</form>
				</div>
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
function nwindow(){
    var url="../chat/chat";
    window.open(url,"","width=600,height=805,location=no");
}
</script>

</body>
</html> 

