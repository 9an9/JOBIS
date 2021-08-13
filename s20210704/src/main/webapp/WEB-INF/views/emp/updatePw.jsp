<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/SpringMain.css">
<style type="text/css">
.PwD {
	width: 90%;
	position: absolute;
  	left: 50%;
 	transform: translateX(-50%);
}
table {
	width: 100%;
	margin: 0 auto;	
    margin-top: 15px;
	border: 1px solid #E0E3DA ;
    align-self: center;
}
td {
	height: 50px;
}
.btn2{
   color: #fff;
   background-color: #3C3530;
   border-color: #AAABD3;
   border-radius: 6px;
 }
input {
	border: none;
	margin-left: 20px;
}
input:focus {outline:1px solid #d50000;}
</style>
</head>
<body>
<h1 align="center">비밀번호 변경</h1>
	<div class="PwD">
		<table border="1">
			<tr><td style="background-color:#E0E3DA; color: #000; text-align: center; width: 140px;">현재비밀번호</td><td><form action="chkPw" style="vertical-align: middle;margin: 0px;"><input type="password" name="pw" id="pw"  value="${pw1 }" required="required" style="width:150px;height: 30px; ">  <input type="submit" value="확인" required="required" onchange="chkerrmsg()" class="btn2"></form></td></tr>
			<tr><td style="background-color:#E0E3DA; color: #000; text-align: center; width: 140px;">변경 후 비밀번호</td><td><input type="password" name="newPw" id="newPw" required="required" style="width:150px;height: 30px; "></td></tr>
			<tr><td style="background-color:#E0E3DA; color: #000; text-align: center; width: 140px;">비밀번호 확인</td><td><input type="password" name="newPw1" id="newPw1" required="required" onchange="comparePw()" style="width:150px;height: 30px; "><br>
																					<span class="error_next_box"></span></td></tr>
		</table>
		<div style=" margin-top: 10px;" align="center">
			<input type="button" value="변경" onclick="changePw()" class="btn2">
		</div>

	</div>

	
<c:if test="${result == 1 }">
	<script type="text/javascript">
	window.onload = function() {
		alert("비밀번호가 변경되었습니다.");
		opener.document.location.reload();
		self.close();
	}
	</script>
</c:if>	
<c:if test="${result == 0 }">
	<script type="text/javascript">
	window.onload = function() {
		alert("비밀번호 변경에 실패하였습니다.");
		self.close();
	}
	</script>
</c:if>	
<script type="text/javascript">
function changePw() {
		location.href='changePw?newPw=' + document.getElementById('newPw').value;

}
var error = document.getElementsByClassName('error_next_box');

function comparePw() {
	var pw0 = document.getElementById('pw').value;
	var pw1 = document.getElementById('newPw').value;
	var pw2 = document.getElementById('newPw1').value;

    if(pw2 == pw1) {
    	error[0].innerHTML = "비밀번호가 일치합니다.";
    	error[0].style.color = "#08A600";
    	error[0].style.display = "block";
    } else if(pw2 != pw1) {
    	error[0].innerHTML = "비밀번호가 일치하지 않습니다.";
    	error[0].style.display = "block";
    	error[0].style.color = "red";
    	document.getElementById("newPw1").value="";
    	
    } 
}
</script>
</body>
</html>