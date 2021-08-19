<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<title>JOBIS</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/SpringMain.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/jquery/jquery.table2excel.js" type="text/javascript"></script>

<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.w3-col.m7{width:73.33333%}
.empTB{
	text-align: center;
	width: 100%;
	margin: 0 auto;	
    margin-top: 15px;
    border: 1px solid #7d97a5;
    border-collapse: collapse;
    border-spacing: 0;
}
.btn2{
   color: #fff;
   background-color: #AAABD3;
   
   border-color: #AAABD3;
   border-radius: 6px;
 }
.btn3{
   color: #fff;
   background-color: #384f76;
   
   border-color: #AAABD3;
   border-radius: 6px;
}
.empTB select {
	border : none;
   text-align-last: center;
   text-align: center;
   -ms-text-align-last: center;
   -moz-text-align-last: center;
}
.searchSelect {
	height: 28.4px;
}
.searchList {
	width: 350px;
	display: inline-block;
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
	      <a href="empList" class="w3-bar-item w3-button">사원 정보 관리</a>
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
    	<a href="../apv/apvWrite" class="w3-button w3-block w3-theme-l5 w3-left-align">결재 서류 작성</a>
        <a href="../apv/apvSnd" class="w3-button w3-block w3-theme-l5 w3-left-align">받은 결재</a>
        <a href="../apv/apvRcv" class="w3-button w3-block w3-theme-l5 w3-left-align">보낸결재</a>
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
	    	<a href="empList" class="w3-button w3-block w3-theme-l5 w3-left-align">사원 정보 관리</a>
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
         <a href="myInfoUpdate" style="display: block; text-decoration: none;"><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> 개인정보수정</a>
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
          <a href="../apv/apvSnd" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-file-text fa-fw w3-margin-right"></i><c:if test="${unreadTotal > 0 }"><span class="w3-badge w3-right w3-small w3-green">${unreadTotal }</span></c:if><c:if test="${apvNoTotal > 0 }"><span class="w3-badge w3-right w3-small w3-red">${apvNoTotal }</span></c:if> 결재</a>
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
              <h1><i class="fa fa-id-card-o fa-fw w3-margin-right"></i><b>사원 관리</b></h1><hr>
              <div style="margin-top: 40px;">
              <form action="searchList" method="post" class="searchList">
              	<select name="search" class="searchSelect">
              		<option value="0">사원명</option>
              		<option value="1">부서명</option>
              	</select>
               <input type="text" id="keyword" name="keyword">  <input type="submit" value="검색" class="btn2"></form>
               <span style="float: right; display: inline-block; margin-left: 10px; "><c:if test="${dept ne '110' }"><input type="button" value="사원등록" onclick="location.href='empWrite'" class="btn2"></c:if></span>&nbsp;&nbsp;
               <span style="float: right; display: inline-block;"><c:if test="${dept eq '120' && rank eq '240' }"><input type="button" value="부서관리" onclick="javascript:openDept()" class="btn2"></c:if></span></div>
              <c:set var="num" value="${(pg.currentPage*pg.rowPage)-pg.rowPage+1}"></c:set>
              <table class="empTB" id="empTB">
			  	<tr style="background-color:#384f76; color: white; "><th>No.</th><th>사원번호</th><th>사원명</th><th>부서명</th><th>소속</th><th>직책</th><th>이메일</th><th>전화번호</th><th>주소</th><th>입사일</th><th>비고</th></tr>
				<c:forEach var="empList" items="${empList}">
					<tr><td>${num }</td>
						<td><a href="javascript:openEmpMng(${empList.emp_num })">${empList.emp_num }</a></td>
				    	<td>${empList.emp_name }</td>
						<td>${empList.dept }</td>
						<td>${empList.team }</td>
						<td>${empList.rank }</td>
						<td>${empList.emp_email }</td>
						<td>${empList.emp_phnum }</td>
						<td>${empList.address }</td>
						<td>${empList.emp_hiredate }</td>
						<c:choose>
							<c:when test="${dept eq '110' }">
								<td><c:choose>
										<c:when test="${empList.ref==0 }">-</c:when>
										<c:otherwise>부재중</c:otherwise>
									</c:choose></td>
							</c:when>
							<c:otherwise>							
								<td>											
								<form action="updateRef" method="post" id="frm${empList.emp_num}">
								<input type="hidden" name="empno" value=${empList.emp_num }>								
								<select name="ref" onchange="chg(${empList.emp_num})">
								<c:if test="${empList.ref==0 }">
									<option value="0" selected="selected"></option>
									<option value="1" >부재중</option>
								</c:if>
								<c:if test="${empList.ref!=0 }">
									<option value="0" ></option>
									<option value="1" selected="selected">부재중</option>
								</c:if>
								</select>
								</form>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<c:set var="num" value="${num + 1 }"></c:set>
				</c:forEach>
			  </table>
			<div style=" margin-top: 10px; float: left; margin-bottom: 20px">
				<input type="button" value="Excel출력" class="w3-center btn3" id="excel" onclick="location.href='excelDownload'">
			</div>			  
			  
			  <div class="w3-center">
			  	<div class="w3-bar w3-border" style=" margin: 10px 0px;border: 1px solid #7d97a5;">
			  
					  <c:if test="${pg.startPage > pg.pageBlock }">
					  	<a href="empList?currentPage=${pg.startPage-pg.pageBlock}" class="w3-bar-item w3-button">&laquo;</a>
					  </c:if>
					  <c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
					  	<c:if test="${pg.currentPage == i }">
							<a href="empList?currentPage=${i}" class="w3-bar-item w3-button" style="background-color: #384f76; color: white;">${i}</a>
						</c:if>
					  	<c:if test="${pg.currentPage != i }">
							<a href="empList?currentPage=${i}" class="w3-bar-item w3-button">${i}</a>
						</c:if>
				  	  </c:forEach>
					  <c:if test="${pg.endPage < pg.totalPage }">
			  		  	<a href="empList?currentPage=${pg.startPage+pg.pageBlock}" class="w3-bar-item w3-button">&raquo;</a>
					  </c:if>
			   	</div>
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
 
<c:if test="${result == 1 }">
	<script type="text/javascript">
		alert("수정되었습니다");
	</script>
</c:if>

<script>
function nwindow(){
    var url="../chat/chat";
    window.open(url,"","width=600,height=805,location=no");
}
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
function chg(num){
	console.log("체인지 넘어옴");
	var frm = document.getElementById('frm'+num);
	frm.submit();
}
function openEmpMng(empno) {	
	var w = (window.screen.width/2) - 200;
	var h = (window.screen.height/2) - 200;
	var url = "empMng?empno="+empno;
	window.open(url,"","width=450,height=480,left="+w+",top="+h);
}
function openDept() {	
	var w = (window.screen.width/2) - 200;
	var h = (window.screen.height/2) - 200;
	var url = "deptUpdate";
	window.open(url,"","width=440,height=530,left="+w+",top="+h);
}
//엑셀 버튼 클릭 
$("#excel").click(function () {
        $("#empTB").table2excel({
            name: "사원 목록",
            filename: "사원목록",
            fileext: ".xls"
        });
    });
</script>

</body>
</html> 

