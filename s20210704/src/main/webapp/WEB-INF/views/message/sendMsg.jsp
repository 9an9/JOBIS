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
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.w3-col.m7{width:73.33333%}
.fileBox .fileName {
	display:inline-block;
	width:170px;
	height:30px;
	padding-left:10px;
	margin-right:5px;
	line-height:30px;
	border:1px solid #aaa;
	background-color:#fff;
	vertical-align:middle;
	border-radius: 10px;
	}
.fileBox .btn_file {
	color: #FFFFFF;
	background-color: #3C3530;
	display:inline-block;
	border:2px solid #66677f;
	border-top-width: 0px;
	border-left-width: 0px;
	width:100px;
	height:30px;
	line-height:30px;
	text-align:center;
	vertical-align:middle;
	border-radius: 6px;
	}
.fileBox input[type="file"] {
	position:absolute;
	width:1px;
	height:1px;
	padding:0;
	margin:-1px;
	overflow:hidden;
	clip:rect(0,0,0,0);
	border:0
	}
	
.btn2{
	color: #FFFFFF;
	background-color: #3C3530;
	border-radius: 6px;
	width: 50px;
    height: 30px;
	}
   
.btn3{
	display:inline-block;
	border:2px solid #66677f;
	border-top-width: 0px;
	border-left-width: 0px;
	border-radius: 6px;
	width:50px;
	height:30px;
	line-height:30px;
	text-align:center;
	vertical-align:middle;
	color: #FFFFFF;
    background-color: #3C3530;
	}
 
th{
 	background-color:#E0E3DA; 
	}

iframe {
	width: 0px;
	height: 0px;
	border: 0px
	}

.TB{
	width: 100%;
	margin: 0 auto;
    margin-top: 5px;
	border: none;
    border-collapse: collapse;
    border-spacing: 0;
	}
	
textarea{
	width: 100%;
	height: 400px;
	resize: none;
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
          <button onclick="myFunction('Demo3')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-envelope fa-fw w3-margin-right" ></i><c:if test="${unreadMsg > 0 }"><span class="w3-badge w3-right w3-small w3-green">${unreadMsg }</span></c:if> 메시지</button>
          <div id="Demo3" class="w3-hide w3-bar-block">
          	<a href="sendMsg" class="w3-button w3-block w3-theme-l5 w3-left-align">메시지 보내기</a>
            <a href="sentMsg" class="w3-button w3-block w3-theme-l5 w3-left-align">보낸 메시지</a>
            <a href="rcvMsg" class="w3-button w3-block w3-theme-l5 w3-left-align"><c:if test="${unreadMsg > 0 }"><span class="w3-badge w3-right w3-small w3-green">${unreadMsg }</span></c:if>받은 메시지</a>
          </div>
          
           <a href="../apv/apvSnd" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-file-text fa-fw w3-margin-right"></i><span class="w3-badge w3-right w3-small w3-green">3</span> 결재</a>
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
<h1><i class="fa fa-envelope fa-fw w3-margin-right"></i><b>메시지 보내기</b></h1><hr>

		     <c:if test="${result1!=null}">
			     <c:if test="${result1 + result2 == 2}">
				     <script type="text/javascript">
				     	alert("메시지가 성공적으로 발송되었습니다.");
				     </script>
			     </c:if>
		     </c:if>
		     
		     <c:if test="${result1!=null}">
			     <c:if test="${result1 + result2 == 0}">
				     <script type="text/javascript">
				     	alert("메시지가 발송되지 않았습니다.");
				     </script>
			     </c:if>
		     </c:if>
		    
			 <form action="writeMsg" method="post" enctype="multipart/form-data" >
				 <table border="1" class="TB">
					 <input type="hidden" name="emp_num" required="required" value="${emp_num}">
					<tr><th>받는사람</th>
						<td><select name="emp_num2">
							<c:forEach var="emp" items="${listEmp}">
								<option value="${emp.emp_num}">${emp.emp_name}</option>
							</c:forEach>
							</select>
						</td></tr>
							
					<tr><th style="width:10%;" >제목</th>
						<td><input type="text" name="msg_title" required="required" style="width:100%; border:0;" maxlength="100"></td></tr>
					<tr><th>내용</th>
						<td><textarea name="msg_content" required="required" maxlength="4000" style="border:0;"></textarea></td></tr>
					</table>
					
						<span class="fileBox">
							<input type="text" class="fileName" readonly="readonly">
							<label for="uploadBtn" class="btn_file">파일 업로드</label>
							<input type="file" id="uploadBtn" class="uploadBtn" name="file1" onchange="setThumbnail(event);">
							<label class="btn3" onclick="fdel()" style="margin: 5px 0px;">제거</label>
						</span>
					    <input type="hidden" name="msg_fl_path" value="${pageContext.request.contextPath}/resources/image/">
						<input type="button" value="취소" onclick="history.back(-1)" class="btn2" style="float: right; margin: 5px 0px;">
						<input type="submit" value="전송" style="float: right; margin: 5px 2px;" class="btn2">
					
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
function nwindow(){
    var url="../chat/chat";
    window.open(url,"","width=600,height=805,location=no");
}

var uploadFile = $('.fileBox .uploadBtn');
uploadFile.on('change', function(){
	if(window.FileReader){
		var filename = $(this)[0].files[0].name;
	} else {
		var filename = $(this).val().split('/').pop().split('\\').pop();
	}
	$(this).siblings('.fileName').val(filename);
});

function fdel(){
	
    $('.fileName').val('');
    $('#pdf *').remove();
	var agent = navigator.userAgent.toLowerCase();
	//파일초기화
	if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
		$("#uploadBtn").replaceWith($("#uploadBtn").clone(true));
	}else{
	    $("#uploadBtn").val("");
	}	
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
</script>

</body>
</html> 

