<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html>
<html>
<title>JOBIS</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/SpringMain.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.w3-col.m7{width:73.33333%}
.cmtTB{
	text-align: center;
	width: 80%;
	margin: 0 auto;
	
    margin-top: 5px;
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
.w3-green, .w3-hover-green:hover {
    color: #F8FAFF!important;
    background-color: #566270!important;
}
select {
   text-align-last: center;
   text-align: center;
   -ms-text-align-last: center;
   -moz-text-align-last: center;
}
.btn3{
   color: #fff;
   background-color: #384f76;
   border-color: #384f76;
   border-radius: 6px;
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
      <a href="../board/clubList" class="w3-bar-item w3-button">동호회</a>
    </div>
  </div>
  <c:if test="${svo.dcontent == '인사부' || svo.dcontent == '임원'  }">
	   <div class="w3-dropdown-hover w3-hide-small">
	  <button class="w3-button w3-padding-large" title="Notifications"><i class="fa fa-cog fa-fw w3-margin-right" aria-hidden="true"></i>관리</button>      
	    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">
	      <a href="../emp/empList" class="w3-bar-item w3-button">사원 정보 관리</a>
	      <a href="cmt" class="w3-bar-item w3-button">사원 근태 관리</a>
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
        <a href="../board/clubList" class="w3-button w3-block w3-theme-l5 w3-left-align">동호회</a>
    </div>
    <c:if test="${svo.dcontent == '인사부' || svo.dcontent == '임원'  }">
	   <button onclick="myFunction1('Demo4')" class="w3-bar-item w3-button w3-padding-large">관리</button>
	  	<div id="Demo4" class="w3-hide w3-bar-block">
	    	<a href="../emp/empList" class="w3-button w3-block w3-theme-l5 w3-left-align">사원 정보 관리</a>
	        <a href="cmt" class="w3-button w3-block w3-theme-l5 w3-left-align">사원 근태 관리</a>
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
         <p class="w3-center"><c:if test="${svo.ph_path eq null }"><img src="../images/LUCY.jpg" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></c:if>
                        <c:if test="${svo.ph_path ne null }"><img src="../upload/${svo.ph_path }" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></c:if></p>
         <hr>
         <p><i class="fa fa-id-badge fa-fw w3-margin-right w3-text-theme"></i> ${svo.emp_name }</p>
         <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${svo.dcontent } / ${svo.rcontent }</p>
         <a href="mycmt" style="display: block; text-decoration: none;"><i class="fa fa-clock-o fa-fw w3-margin-right w3-text-theme"></i> 나의 근태정보</a><p>
         <a href="../emp/myInfoUpdate" style="display: block; text-decoration: none;"><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> 개인정보수정</a>
        </div>
      </div>
      <br>
      
      <!-- Accordion -->
      <div class="w3-card w3-round">
        <div class="w3-white">
         <button onclick="myFunction('Demo3')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-envelope fa-fw w3-margin-right" ></i><c:if test="${unreadMsg > 0 }"><span class="w3-badge w3-right w3-small w3-green">${unreadMsg }</span></c:if> 메시지</button>
<div id="Demo3" class="w3-hide w3-bar-block">
<a href="../message/sendMsg" class="w3-button w3-block w3-theme-l5 w3-left-align">메시지 보내기</a>
<a href="../message/sentMsg" class="w3-button w3-block w3-theme-l5 w3-left-align">보낸 메시지</a>
<a href="../message/rcvMsg" class="w3-button w3-block w3-theme-l5 w3-left-align"><c:if test="${unreadMsg > 0 }"><span class="w3-badge w3-right w3-small w3-green">${unreadMsg }</span></c:if>받은 메시지</a></div>
          <a href="../apv/apvSnd" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-file-text fa-fw w3-margin-right"></i><c:if test="${unreadTotal > 0 }"><span class="w3-badge w3-right w3-small w3-green">${unreadTotal }</span></c:if><c:if test="${apvNoTotal > 0 }"><span class="w3-badge w3-right w3-small w3-red">${apvNoTotal }</span></c:if> 결재</a>
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
              <h1><i class="fa fa-clock-o fa-fw w3-margin-right" style="font-size: 42px"></i><b>사원 근태 관리</b></h1><hr>
	          <c:if test="${not empty ysEmpCmt.searchStart}">
		          <h3 style="margin-bottom: -25px;text-align: center;color: #7d97a5;">
		          	${ysEmpCmt.searchStart } ~ ${ysEmpCmt.searchEnd } 
		          	<c:if test="${not empty ysEmpCmt.searchDept }">${ysEmpCmt.searchDept }</c:if>
		          	<c:if test="${not empty ysEmpCmt.searchName }">${ysEmpCmt.searchName }</c:if>
		          	검색결과
		          </h3>
	          </c:if>
	          <div style="width: 80%; height: 40px;margin-top: 60px;margin-left: 12%;">
	          	<form action="cmtSearch" method="post" name="frm" onsubmit="return chk()">
	          		 조회하기 <input type="date" style="width: 15%; font-size: 11px;" name="searchStart" id="searchStart" onchange="selectStr()"> ~ <input type="date" style="width: 15% ;font-size: 11px;margin-right: 2%;" name="searchEnd" id="searchEnd" onchange="selectEnd()">
				          부서 <input type="text" style="width: 17%; font-size: 12px;margin-right: 1%;" name="searchDept" id="searchDept" placeholder="부서를 입력해주세요">
				          사원 <input type="text" style="width: 17%; font-size: 12px;margin-right: 1%;" name="searchName" id="searchName" placeholder="사원을 입력해주세요">
			    	<button class="btn2" type="submit">검색</button>
	          	</form>
	          </div>
	          
	          <table class="cmtTB">
					<tr style="background-color:#384f76; color: white; "><th>사원번호</th><th>이름</th><th>부서</th><th>소속</th><th>직급</th><th>출근시간</th><th>퇴근시간</th><th>날짜</th><th>상태</th><th>수정일</th></tr>
						<c:forEach var="cmtList" items="${cmtList}">
							<tr>
								<td>${cmtList.emp_num }</td>
								<td>${cmtList.emp_name}</td> 
								<td>${cmtList.dcontent}</td>
								<td>${cmtList.tcontent}</td>
								<td>${cmtList.rcontent}</td>
								<td>${cmtList.srttime}</td>
								<td>${cmtList.endtime}</td>
								<td>${cmtList.cmt_date}</td>
								
								<c:set var="shh" value="${fn:substring(cmtList.srttime,0,1)}"/>
								<c:set var="sh" value="${fn:substring(cmtList.srttime,1,2)}"/>
								<c:set var="smm" value="${fn:substring(cmtList.srttime,3,4)}"/>
								<c:set var="sm" value="${fn:substring(cmtList.srttime,4,5)}"/>
								
								<c:set var="ehh" value="${fn:substring(cmtList.endtime,0,1)}"/>
								<c:set var="eh" value="${fn:substring(cmtList.endtime,1,2)}"/>

								<td>
									<c:if test="${svo.dcontent == '임원' || (svo.dcontent == '인사부' && svo.rcontent == '사원')  }">
										<c:choose>
											<c:when test="${((sh >= 9 && (smm > 0 || sm > 0))||shh>0)&&((ehh == 1 && eh == 9) || ehh == 2)}"><span style="margin: 0;color: red;">지각</span>,<span style="margin: 0;color: rgb(225, 1, 255);">연장</span></c:when>
											<c:when test="${((sh >= 9 && (smm > 0 || sm > 0))||shh>0)&&(ehh < 2 && eh < 7)}"><span style="margin: 0;color: red;">지각</span>,<span style="margin: 0; color: #0072ff;">조퇴</span></c:when>
	
											<c:when test="${(sh >= 9 && (smm > 0 || sm > 0))||shh>0}"><p style="margin: 0; color: red;">지각</p></c:when>										
											<c:when test="${(ehh == 1 && eh == 9) || ehh == 2}"><p style="margin: 0; color: rgb(225, 1, 255);">연장</p></c:when>
											<c:when test="${ehh < 2 && eh < 7}"><p style="margin: 0; color: #0072ff;">조퇴</p></c:when>
											
											<c:otherwise><p style="margin: 0;">정상</p></c:otherwise>
										</c:choose>
									</c:if>
								
								
								
									<c:if test="${svo.dcontent == '인사부' && svo.rcontent != '사원'  }">										
										<form action="cmtMD" name="cmtMdFrm" id="cmtMdFrm${cmtList.cmt_num}" method="post">
										<input type="hidden" name="dt" value="${cmtList.cmt_date}">
										<input type="hidden" name="cmt_num" value="${cmtList.cmt_num}">
										<input type="hidden" name="currentPage" value="${yp.currentPage}">
										<c:choose>
											<c:when test="${((sh >= 9 && (smm > 0 || sm > 0))||shh>0)&&((ehh == 1 && eh == 9) || ehh == 2)}">
												<select name="state" style="color: rgb(225, 1, 255); border: none;" onchange="cmtMD(${cmtList.cmt_num})">
													<option selected="selected" style="color: rgb(225, 1, 255);" value="1">지각,연장</option>
													<option style="color: #0072ff;"value="2">지각,조퇴</option>
													<option style="color: red;"value="3">지각</option>
													<option style="color: rgb(225, 1, 255);"value="4">연장</option>
													<option style="color: #0072ff;"value="5">조퇴</option>
													<option value="6">정상</option>	
												</select>
											</c:when>
											<c:when test="${((sh >= 9 && (smm > 0 || sm > 0))||shh>0)&&(ehh < 2 && eh < 7)}">
												<select name="state" style="color: #0072ff; border: none;" onchange="cmtMD(${cmtList.cmt_num})">
													<option style="color: rgb(225, 1, 255);" value="1">지각,연장</option>
													<option selected="selected" style="color: #0072ff;"value="2">지각,조퇴</option>
													<option style="color: red;"value="3">지각</option>
													<option style="color: rgb(225, 1, 255);"value="4">연장</option>
													<option style="color: #0072ff;"value="5">조퇴</option>
													<option value="6">정상</option>	
												</select>
											</c:when>
	
											<c:when test="${(sh >= 9 && (smm > 0 || sm > 0))||shh>0}">
												<select name="state" style="color: red; border: none;" onchange="cmtMD(${cmtList.cmt_num})">
													<option style="color: rgb(225, 1, 255);" value="1">지각,연장</option>
													<option style="color: #0072ff;"value="2">지각,조퇴</option>
													<option selected="selected" style="color: red;"value="3">지각</option>
													<option style="color: rgb(225, 1, 255);"value="4">연장</option>
													<option style="color: #0072ff;"value="5">조퇴</option>
													<option value="6">정상</option>	
												</select>
											</c:when>										
											<c:when test="${(ehh == 1 && eh == 9) || ehh == 2}">
												<select name="state" style="color: rgb(225, 1, 255); border: none;" onchange="cmtMD(${cmtList.cmt_num})">
													<option style="color: rgb(225, 1, 255);" value="1">지각,연장</option>
													<option style="color: #0072ff;"value="2">지각,조퇴</option>
													<option style="color: red;"value="3">지각</option>
													<option selected="selected" style="color: rgb(225, 1, 255);"value="4">연장</option>
													<option style="color: #0072ff;"value="5">조퇴</option>
													<option value="6">정상</option>	
												</select>
											</c:when>
											<c:when test="${ehh < 2 && eh < 7}">
												<select name="state" style="color: #0072ff; border: none;" onchange="cmtMD(${cmtList.cmt_num})">
													<option style="color: rgb(225, 1, 255);"value="1">지각,연장</option>
													<option style="color: #0072ff;"value="2">지각,조퇴</option>
													<option style="color: red;"value="3">지각</option>
													<option style="color: rgb(225, 1, 255);"value="4">연장</option>
													<option selected="selected" style="color: #0072ff;"value="5">조퇴</option>
													<option value="6">정상</option>	
												</select>		
											</c:when>
											
											<c:otherwise>
												<select name="state" style="border: none;" onchange="cmtMD(${cmtList.cmt_num})">
													<option style="color: rgb(225, 1, 255);"value="1">지각,연장</option>
													<option style="color: #0072ff;"value="2">지각,조퇴</option>
													<option style="color: red;"value="3">지각</option>
													<option style="color: rgb(225, 1, 255);"value="4">연장</option>
													<option style="color: #0072ff;"value="5">조퇴</option>
													<option selected="selected"value="6">정상</option>	
												</select>
											</c:otherwise>
										</c:choose>
										</form>
									</c:if>
								</td>
								
								<td>
									<c:if test="${empty cmtList.cmt_md}">-</c:if>
									<c:if test="${not empty cmtList.cmt_md}"><p style="color: red; margin: 0px;">${cmtList.cmt_md }</p></c:if>
								</td>
								
							</tr> 
						</c:forEach>	
				</table>
				
				<div>
		          	<a href="excelDown" style="text-decoration: none; color: black; float: left; margin-left: 10%;"><button type="button" class="btn3">Excel출력</button></a>
		          	<form action="absent" method="post" style="margin-top: 5px; margin-left: 65%">
		          		<input type="date" style="width: 38%; font-size: 13px;" name="absent" id="absent" required="required">
				    	<button class="btn2" type="submit">결근사원조회</button>
		          	</form>
	            </div>
	            
				<c:if test="${empty ysEmpCmt.searchStart}">
					<div class="w3-center">
						<div class="w3-bar w3-border" style=" margin: 10px 0px;border: 1px solid #7d97a5;">
							<c:if test="${yp.startPage > yp.pageBlock }">
								<a href="cmt?currentPage=${yp.startPage-yp.pageBlock}" class="w3-bar-item w3-button">&laquo;</a>
							</c:if>
							<c:forEach var="i" begin="${yp.startPage }" end="${yp.endPage }">
								<c:if test="${yp.currentPage == i }">
									<a href="cmt?currentPage=${i}" class="w3-bar-item w3-button" style="background-color: #384f76; color: white;">${i}</a>
								</c:if>
								<c:if test="${yp.currentPage != i }">
									<a href="cmt?currentPage=${i}" class="w3-bar-item w3-button">${i}</a>
								</c:if>
							</c:forEach>
							<c:if test="${yp.endPage < yp.totalPage }">
								<a href="cmt?currentPage=${yp.startPage+yp.pageBlock}" class="w3-bar-item w3-button">&raquo;</a>
							</c:if>
						</div>
					</div>
				</c:if>
			    <c:if test="${not empty ysEmpCmt.searchStart}">
					<form action="cmtSearch" method="post" name="searchFrm">
						<input type="hidden" name="searchStart" value="${ysEmpCmt.searchStart }">
						<input type="hidden" name="searchEnd" value="${ysEmpCmt.searchEnd }">
						<input type="hidden" name="searchDept" value="${ysEmpCmt.searchDept }">
						<input type="hidden" name="searchName" value="${ysEmpCmt.searchName }">
						<input type="hidden" name="currentPage" id="currentPage">
						<div class="w3-center">
							<div class="w3-bar w3-border" style=" margin: 10px 0px;border: 1px solid #7d97a5;">
								<c:if test="${yp.startPage > yp.pageBlock }">
									<button onclick="searchPaging(-1)"  class="w3-bar-item w3-button">&laquo;</button> 
								</c:if>
								<c:forEach var="i" begin="${yp.startPage }" end="${yp.endPage }">
									<c:if test="${yp.currentPage == i }">
										<button onclick="searchPaging(${i})" style="background-color: #384f76; color: white;"  class="w3-bar-item w3-button">${i}</button>
									</c:if>
									<c:if test="${yp.currentPage != i }">
										<button onclick="searchPaging(${i})"   class="w3-bar-item w3-button">${i}</button>
									</c:if>
								</c:forEach>
								<c:if test="${yp.endPage < yp.totalPage }">
									<button onclick="searchPaging(-2)"   class="w3-bar-item w3-button">&raquo;</button>
								</c:if>
							</div>
						</div>
					</form> 
				</c:if> 
				
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
function nwindow(){
    var url="../chat/chat";
    window.open(url,"","width=600,height=805,location=no");
}
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
/////////////////////////////////////////////////

var searchStart = document.getElementById('searchStart');
var searchEnd = document.getElementById('searchEnd');
var absent = document.getElementById('absent');

searchStart.max = new Date().toISOString().split("T")[0];
searchEnd.max = new Date().toISOString().split("T")[0]; 
absent.max = new Date().toISOString().split("T")[0];

function selectStr(){
	searchEnd.min = searchStart.value;
}

function selectEnd(){
	searchStart.max = searchEnd.value;
}




function chk() {
	if(!frm.searchStart.value || !frm.searchEnd.value){
		alert("조회하기위한 날짜를 모두 입력해주세요.\n하루를 선택하시려면 조회 시작날짜와 종료날짜를 똑같이 해주세요");
		return false;
	}
	return true;
}

function searchPaging(i){
	var a = i
	var currentPage = document.getElementById('currentPage');
	var searchFrm  = document.getElementById('searchFrm');
	if(a == -1){
		currentPage.value = '${yp.startPage-yp.pageBlock}';
	}else if (a == -2){
		currentPage.value = '${yp.startPage+yp.pageBlock}';
	} else{
		currentPage.value = a;
	}
	searchFrm.submit();
	
} 

function cmtMD(num){
	var cmtMdFrm  = document.getElementById('cmtMdFrm'+num);
	const md =  confirm("해당 사원의 상태를 변경하시겠습니까?");
	if (md){		
		cmtMdFrm.submit();
	}
}
</script>

</body>
</html> 

