<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
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
	display:inline-block;
	border:2px solid #66677f;
	border-top-width: 0px;
	border-left-width: 0px;
	width:100px;
	height:30px;
	line-height:30px;
	text-align:center;
	vertical-align:middle;
	background-color: #3C3530;
	color:white;
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
   color: #fff;
   background-color: #3C3530;
   
   border-color: #3C3530;
   border-radius: 6px;
 }
 .btn3{
   display:inline-block;
	border:2px solid #66677f;
	border-top-width: 0px;
	border-left-width: 0px;
	width:50px;
	height:30px;
	line-height:30px;
	text-align:center;
	vertical-align:middle;
	background-color: #3C3530;
	color:white;
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
iframe{
	margin-top: 10px;
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
         <p class="w3-center"><c:if test="${svo.ph_path eq null }"><img src="../images/LUCY.jpg" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></c:if>
                        <c:if test="${svo.ph_path ne null }"><img src="../upload/${svo.ph_path }" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></c:if></p>
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
<a href="../message/sendMsg" class="w3-button w3-block w3-theme-l5 w3-left-align">메시지 보내기</a>
<a href="../message/sentMsg" class="w3-button w3-block w3-theme-l5 w3-left-align">보낸 메시지</a>
<a href="../message/rcvMsg" class="w3-button w3-block w3-theme-l5 w3-left-align"><c:if test="${unreadMsg > 0 }"><span class="w3-badge w3-right w3-small w3-green">${unreadMsg }</span></c:if>받은 메시지</a></div>
          <a href="apvSnd" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-file-text fa-fw w3-margin-right"></i><c:if test="${unreadTotal > 0 }"><span class="w3-badge w3-right w3-small w3-green">${unreadTotal }</span></c:if><c:if test="${apvNoTotal > 0 }"><span class="w3-badge w3-right w3-small w3-red">${apvNoTotal }</span></c:if> 결재</a>
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
              <h1><i class="fa fa-file-text fa-fw w3-margin-right"></i><b>결재 작성</b></h1><hr>  
          	  	 <form action="apvReWrite" method="post" enctype="multipart/form-data" style="margin-top: 30px;" name="frm" >
        	  	 	<input type="hidden" name="apv_snd" value="${emp_num }">
        	  	 	<input type="hidden" name="fnlChk" id="fnlChk" value="0">
        	  	 	<input type="hidden" name="apv_sq" value="${sndDetail.apv_sq }">
        	  	 	<input type="hidden" name="apv_pl_nm" id="apv_pl_nm" value="${sndDetail.apv_pl_nm }">
        	  	 	<table style="width: 100%; text-align: center; border: none;" border="1">
        	  	 	<tr><th>사원번호</th><td>${emp_num }</td><th>부서</th><td>${svo.dcontent }</td><th>직급</th><td>${svo.rcontent }</td><th>이름</th><td>${svo.emp_name }</td></tr>
        	  	 	<tr>
       	  	 			<th>결재분류  </th>
       	  	 			<td>
	       	  	 			<select name="apv_type" id="apv_type" onchange="getRcvList()" required="required" style="width: 100%;">
	       	  	 				<option value="${sndDetail.apv_type }" selected="selected">${sndDetail.apv_type }</option>
	       	  	 				<c:if test="${svo.dcontent == '임원'}"><option value="최종보고">최종보고</option></c:if>
	       	  	 				<c:if test="${svo.dcontent != '임원'}">
	       	  	 					<c:if test="${svo.rcontent == '사원'}">
	       	  	 						<option value="일일보고">일일보고</option>
	       	  	 						<option value="근태보고">근태보고</option>
	       	  	 						<c:if test="${svo.dcontent == '인사부'}"><option value="인사보고">인사보고</option></c:if>
	       	  	 					</c:if>
	       	  	 					<c:if test="${svo.rcontent == '대리'}">
	       	  	 						<option value="일일보고">일일보고</option>
	       	  	 						<option value="근태보고">근태보고</option>
	       	  	 						<option value="사업보고">사업보고</option>
	       	  	 						<c:if test="${svo.dcontent == '인사부'}"><option value="인사보고">인사보고</option></c:if>
	       	  	 					</c:if>
	       	  	 					<c:if test="${svo.rcontent == '팀장'}">
	       	  	 						<option value="주간보고">주간보고</option>
	       	  	 						<option value="사업보고">사업보고</option>
	       	  	 						<c:if test="${svo.dcontent == '인사부'}"><option value="인사보고">인사보고</option></c:if>
	       	  	 					</c:if>
	       	  	 					<c:if test="${svo.rcontent == '부장'}">
	       	  	 						<option value="주간보고">주간보고</option>
	       	  	 						<option value="비용신청">비용신청</option>
	       	  	 						<option value="사업보고">사업보고</option>
	       	  	 						<option value="행사보고">행사보고</option>
	       	  	 						<option value="월간보고">월간보고</option>
	       	  	 					</c:if>
	       	  	 				</c:if>
	       	  	 			</select>
       	  	 			</td>
       	  	 			<td colspan="4"></td>
       	  	 			<c:if test="${svo.dcontent == '임원'}">
       	  	 				<script type="text/javascript">
       	  	 					var fnlChk   = document.getElementById('fnlChk');
       	  	 					fnlChk.value = 1;
       	  	 				</script>
       	  	 				<th>결재자 </th><td>서팔광</td>
       	  	 				<input type="hidden" name="apv_fnl" value="1701001">
       	  	 			</c:if>
       	  	 				<c:if test="${svo.dcontent != '임원'}">
        	  	 			<th id="nxt"></th>
        	  	 			<td id="Rcv_List"></td>
        	  	 		</c:if>
        	  	 	</tr>
        	  	 	<tr><th>제목</th><td colspan="7"><input type="text" name="apv_title" placeholder="결재 제목을 작성해주세요" required="required" style="width: 100%; border: none;" value="${sndDetail.apv_title }"></td></tr>
        	  	 	<tr>
        	  	 		<th>첨부파일</th> 
        	  	 		<td class="fileBox" colspan="7" style="text-align: initial;">
							<input type="text" class="fileName" readonly="readonly" value="${fn:substringAfter(sndDetail.apv_pl_nm, '_') }">
							<label for="uploadBtn" class="btn_file">업로드 수정</label>
							<input type="file" id="uploadBtn" class="uploadBtn" name="file1" accept=".pdf" onchange="setThumbnail(event);">
							<label class="btn3" onclick="fdel()">제거</label>
						</td>
        	  	 	</tr>
        	  	 	<tr><td id="pdf" colspan="8" style="text-align: center;"></td></tr>
        	  	 	<tr style="border-bottom: 1px solid #c1c0c0;">
        	  	 		<th>내용</th> 
        	  	 		<td colspan="7"><pre><textarea name="apv_content" maxlength="4000"  style="height:150px; width: 100%; resize: none; border: none;" required="required">${sndDetail.apv_content }</textarea></pre></td>
        	  	 	</tr>
        	  	 	</table>
        	  	 	<div style="margin-top: 3px; margin-bottom: 45px;"><input type="submit" value="재결재신청" class="btn2" style="float: right;"></div>
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




/////////////////////////////////////////////////////////


function getRcvList(){
	var tdName = '결재자';
	$('#nxt').empty();
	$('#nxt').append(tdName);
	var emp_rnk  = '${svo.rcontent }';
	var emp_num  = '${emp_num }';
	var apv_type = document.getElementById('apv_type').value;
	var fnlChk   = document.getElementById('fnlChk');
	var url = "";
	var fnlChk2 = 0;
	if(apv_type == '일일보고'){
		if(emp_rnk == '사원'){ url = "../rcvList1?emp_num="+emp_num; }
		else if(emp_rnk == '대리'){ url = "../rcvList2?emp_num="+emp_num; fnlChk2 = 1; fnlChk.value = 1; }
	}else if(apv_type == '주간보고'){
		if(emp_rnk == '팀장'){ url = "../rcvList3?emp_num="+emp_num; }
		else if(emp_rnk == '부장'){ url = "../rcvList4"; fnlChk2 = 1; fnlChk.value = 1; }
	}else if(apv_type == '근태보고'){
		if(emp_rnk == '사원'){ url = "../rcvList1?emp_num="+emp_num; }
		else if(emp_rnk == '대리'){ url = "../rcvList2?emp_num="+emp_num; fnlChk2 = 1; fnlChk.value = 1; }
	}else if(apv_type == '비용신청'){
		if(emp_rnk == '부장'){ url = "../rcvList5"; }
	}else if(apv_type == '사업보고'){
		if(emp_rnk == '대리'){ url = "../rcvList2?emp_num="+emp_num; }
		else if(emp_rnk == '팀장'){ url = "../rcvList3?emp_num="+emp_num; }
		else if(emp_rnk == '부장'){ url = "../rcvList4"; fnlChk2 = 1; fnlChk.value = 1; }
	}else if(apv_type == '인사보고'){
		if(emp_rnk == '사원'){ url = "../rcvList1?emp_num="+emp_num; }
		else if(emp_rnk == '대리'){ url = "../rcvList2?emp_num="+emp_num; }
		else if(emp_rnk == '팀장'){ url = "../rcvList3?emp_num="+emp_num; fnlChk2 = 1; fnlChk.value = 1; }
	}else if(apv_type == '행사보고'){
		if(emp_rnk == '부장'){ url = "../rcvList6"; }
	}else if(apv_type == '월간보고'){
		if(emp_rnk == '부장'){ url = "../rcvList4"; fnlChk2 = 1; fnlChk.value = 1; }
	}else if(apv_type == '최종보고'){
		fnlChk.value = 1;
	}
	
	var str  = "";
	var str2 = "";
	var nextNum = '${nextEmp.rcv_num}';
	$.ajax({
		url:url,
		dataType:'json',
		success:function(data){
			$('#Rcv_List *').remove();
			if(fnlChk2 == 1){
				str += "<select name = 'apv_fnl' required='required' id='slt2' style='width: 100%;'><option value='${nextEmp.rcv_num}' selected='selected'>${nextEmp.rcv_name}</option>";
			}else{			
				str += "<select name = 'apv_mid_emp' required='required' id='slt' style='width: 100%;'><option value='${nextEmp.rcv_num}' selected='selected'>${nextEmp.rcv_name}</option>";
			}
			$(data).each(
					function(){
						if(this.emp_num != nextNum){							
							str2 = "<option value = '"+this.emp_num + "'>"+this.emp_name + "</option>";
							str += str2;
						}
					}		
				);
				str += "</select>";
				$('#Rcv_List').append(str);
		}
	});
}

getRcvList();



var obj = {};
$("select").children("option").each(function(){
 let val = $(this).attr("value");
 if(obj[val]){
   if($(this).is(":selected")){
    obj[val].remove();
    obj[val] = $(this);
   }else if(obj[val].is(":selected")){
    $(this).remove()
   }else{
    $(this).remove();
   }
 }
 obj[val] = $(this);
});

var uploadFile = $('.fileBox .uploadBtn');
uploadFile.on('change', function(){
	if(window.FileReader){
		var filename = $(this)[0].files[0].name;
	} else {
		var filename = $(this).val().split('/').pop().split('\\').pop();
	}
	$(this).siblings('.fileName').val(filename);
	$('#apv_pl_nm').val('change');
	$.get('fileDelete?fileName=${sndDetail.apv_pl_nm }');
});

function fdel(){
	$('#pdf *').remove();
    $('.fileName').val('');
	$('#apv_pl_nm').val('');
	$.get('fileDelete?fileName=${sndDetail.apv_pl_nm }');
	/* location.href='fileDelete?fileName=${sndDetail.apv_pl_nm }'; */
}

var pdfName = '${sndDetail.apv_pl_nm}';
if(pdfName){
	var pdfPath = '<iframe width="80%" height="550" src="../upload/${sndDetail.apv_pl_nm}" />';
	$('#pdf').append(pdfPath);	
}

function setThumbnail(event) { 
	$('#pdf *').remove();
	var agent = navigator.userAgent.toLowerCase();
    // 파일 업로드 확장자 체크
    if( $("#uploadBtn").val() != "" ){
      	var ext = $('#uploadBtn').val().split('.').pop().toLowerCase();
 	    if($.inArray(ext, ['pdf']) == -1) {
 	     	alert('pdf파일만 업로드 해주세요.');
 			//파일초기화
 			$('#apv_pl_nm').val('');
 			$('.fileName').val('');
 			$.get('fileDelete?fileName=${sndDetail.apv_pl_nm }');
 			if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
 				$("#uploadBtn").replaceWith($("#uploadBtn").clone(true));
 			}else{
 		    	$("#uploadBtn").val("");
 			}
 	     	return;
	  	}
     }
	
	var reader = new FileReader(); 
	reader.onload = function(event) { 
		var iframe = document.createElement("iframe");
		iframe.setAttribute("width", "80%");
		iframe.setAttribute("height", "550");
		iframe.setAttribute("src", event.target.result); 
		document.querySelector('#pdf').appendChild(iframe); 
	}; 
	reader.readAsDataURL(event.target.files[0]); 
}

</script>

</body>
</html> 

