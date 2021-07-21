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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.w3-col.m7{width:73.33333%}
.cmtTB{
	text-align: center;
	width: 80%;
	margin: 0 auto;
}
</style>

<body class="w3-theme-l5">

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
    <a href="/" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>Home</a>
  <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large" title="Notifications"><i class="fa fa-file-text fa-fw w3-margin-right"></i>전자결재</button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">
      <a href="#" class="w3-bar-item w3-button">결재 서류 작성</a>
      <a href="#" class="w3-bar-item w3-button">받은 결재</a>
      <a href="#" class="w3-bar-item w3-button">보낸 결재</a>
    </div>
  </div>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Account Settings"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>일정</a>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Messages"><i class="fa fa-list-alt fa-fw w3-margin-right"></i>자료실</a>
  <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large" title="Notifications"><i class="fa fa-commenting-o fa-fw w3-margin-right fa-flip-horizontal"></i>게시판</button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">
      <a href="#" class="w3-bar-item w3-button">공지사항</a>
      <a href="#" class="w3-bar-item w3-button">설문조사</a>
      <a href="#" class="w3-bar-item w3-button">동호회</a>
    </div>
  </div>
  
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">
    <i class="fa fa-sign-out w3-margin-right"></i>Logout
  </a>
 </div>
</div> 

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="#" class="w3-bar-item w3-button w3-padding-large">안보임</a> <!-- 이 줄은 안보이는 줄입니다 -->
  <button onclick="myFunction1('Demo1')" class="w3-bar-item w3-button w3-padding-large">전자결재</button>
  	<div id="Demo1" class="w3-hide w3-bar-block">
    	<a href="#" class="w3-button w3-block w3-theme-l5 w3-left-align">결재 서류 작성</a>
        <a href="#" class="w3-button w3-block w3-theme-l5 w3-left-align">받은 결재</a>
        <a href="#" class="w3-button w3-block w3-theme-l5 w3-left-align">보낸결재</a>
    </div>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">일정</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">자료실</a>
  <button onclick="myFunction1('Demo2')" class="w3-bar-item w3-button w3-padding-large">게시판</button>
  	<div id="Demo2" class="w3-hide w3-bar-block">
    	<a href="#" class="w3-button w3-block w3-theme-l5 w3-left-align">공지사항</a>
        <a href="#" class="w3-button w3-block w3-theme-l5 w3-left-align">설문조사</a>
        <a href="#" class="w3-button w3-block w3-theme-l5 w3-left-align">동호회</a>
    </div>
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
         <p><i class="fa fa-id-badge fa-fw w3-margin-right w3-text-theme"></i> 이름</p>
         <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;직위/부서</p>
         <a href="#" style="display: block; text-decoration: none;"><i class="fa fa-clock-o fa-fw w3-margin-right w3-text-theme"></i> 나의 근태정보</a><p>
         <a href="#" style="display: block; text-decoration: none;"><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> 개인정보수정</a>
        </div>
      </div>
      <br>
      
      <!-- Accordion -->
      <div class="w3-card w3-round">
        <div class="w3-white">
          <button onclick="myFunction('Demo1')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-envelope fa-fw w3-margin-right" ></i><span class="w3-badge w3-right w3-small w3-green">1</span> 쪽지</button>
          <div id="Demo1" class="w3-hide w3-bar-block">
          	<a href="#" class="w3-button w3-block w3-theme-l5 w3-left-align">쪽지 보내기</a>
            <a href="#" class="w3-button w3-block w3-theme-l5 w3-left-align">보낸 쪽지함</a>
            <a href="#" class="w3-button w3-block w3-theme-l5 w3-left-align"><span class="w3-badge w3-right w3-small w3-green">1</span>받은 쪽지함</a>
          </div>
          <a href="#" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-file-text fa-fw w3-margin-right"></i><span class="w3-badge w3-right w3-small w3-green">3</span> 결재</a>
          <a href="#" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-check-square-o fa-fw w3-margin-right"></i><span class="w3-badge w3-right w3-small w3-green">2</span> 설문</a>
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
              <h1><i class="fa fa-clock-o fa-fw w3-margin-right" style="font-size: 42px"></i><b>사원 근태 관리</b></h1><hr>
	          <c:if test="${not empty ysEmpCmt.searchStart}">
		          <h3 style="margin-bottom: 30px;">
		          	${ysEmpCmt.searchStart } ~ ${ysEmpCmt.searchEnd } 
		          	<c:if test="${not empty ysEmpCmt.searchDept }">${ysEmpCmt.searchDept }</c:if>
		          	<c:if test="${not empty ysEmpCmt.searchName }">${ysEmpCmt.searchName }</c:if>
		          	검색결과
		          </h3>
	          </c:if>
	          <div>
	          	<form action="cmtSearch" method="post" name="frm" onsubmit="return chk()">
	          		 조회하기 <input type="date" style="width: 15%; font-size: 13px;" name="searchStart" id="searchStart" onchange="selectStr()"> ~ <input type="date" style="width: 15% ;font-size: 13px;margin-right: 2%;" name="searchEnd" id="searchEnd" onchange="selectEnd()">
				          부서 <input type="text" style="width: 17%; font-size: 13px;margin-right: 1%;" name="searchDept" id="searchDept" placeholder="부서를 입력해주세요">
				          사원 <input type="text" style="width: 17%; font-size: 13px;margin-right: 1%;" name="searchName" id="searchName" placeholder="사원을 입력해주세요">
			    	<button class="btn2" type="submit">검색</button>
	          	</form>
	          </div>
	          <table border="1" class="cmtTB">
					<tr><th>사원번호</th><th>이름</th><th>입사일</th><th>부서</th><th>소속</th><th>직급</th><th>출근시간</th><th>퇴근시간</th><th>날짜</th></tr>
						<c:forEach var="cmtList" items="${cmtList}">
							<tr>
								<td>${cmtList.emp_num }</td>
								<td><a href="#">${cmtList.emp_name}</a></td> 
								<td>${cmtList.emp_hiredate}</td> 
								<td>${cmtList.dcontent}</td>
								<td>${cmtList.tcontent}</td>
								<td>${cmtList.rcontent}</td>
								<td>${cmtList.srttime}</td>
								<td>${cmtList.endtime}</td>
								<td>${cmtList.cmt_date}</td>
							</tr> 
						</c:forEach>	
				</table>
				<c:if test="${empty ysEmpCmt.searchStart}">
					<div style="text-align: center;">
						<c:if test="${yp.startPage > yp.pageBlock }">
							<a href="cmt?currentPage=${yp.startPage-yp.pageBlock}">[이전]</a>
						</c:if>
						<c:forEach var="i" begin="${yp.startPage }" end="${yp.endPage }">
							<a href="cmt?currentPage=${i}">[${i}]</a>
						</c:forEach>
						<c:if test="${yp.endPage < yp.totalPage }">
							<a href="cmt?currentPage=${yp.startPage+yp.pageBlock}">[다음]</a>
						</c:if>
					</div>
				</c:if>
			    <c:if test="${not empty ysEmpCmt.searchStart}">
					<form action="cmtSearch" method="post" name="searchFrm">
						<input type="hidden" name="searchStart" value="${ysEmpCmt.searchStart }">
						<input type="hidden" name="searchEnd" value="${ysEmpCmt.searchEnd }">
						<input type="hidden" name="searchDept" value="${ysEmpCmt.searchDept }">
						<input type="hidden" name="searchName" value="${ysEmpCmt.searchName }">
						<input type="hidden" name="currentPage" id="currentPage">
						<div style="text-align: center;">
							<c:if test="${yp.startPage > yp.pageBlock }">
								<button onclick="searchPaging(-1)" style="padding: 0;border: 0;background-color: white;">[이전]</button> 
							</c:if>
							<c:forEach var="i" begin="${yp.startPage }" end="${yp.endPage }">
								<button onclick="searchPaging(${i})" style="padding: 0;border: 0;background-color: white;">[${i}]</button>
							</c:forEach>
							<c:if test="${yp.endPage < yp.totalPage }">
								<button onclick="searchPaging(-2)" style="padding: 0;border: 0;background-color: white;">[다음]</button>
							</c:if>
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
	
	searchStart.max = new Date().toISOString().split("T")[0];
	searchEnd.max = new Date().toISOString().split("T")[0]; 
	
	function selectStr(){
		searchEnd.min = searchStart.value;
	}
	
	function selectEnd(){
		searchStart.max = searchEnd.value;
	}

	

	
	function chk() {
		if(!frm.searchStart.value || !frm.searchEnd.value){
			alert("조회하기위한 날짜를 모두 입력해주세요.\n하루를 선택하시려면 조회 시작날짜와 종료날짜를 똑같이 해주세요")
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
</script>

</body>
</html> 
