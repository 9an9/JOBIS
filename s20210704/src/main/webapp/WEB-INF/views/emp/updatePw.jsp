<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>비밀번호 변경</h1>
	<table>
		<form action="chkPw"><tr><td>현재비밀번호</td><td><input type="password" name="pw" id="pw"  value="${pw1 }" required="required"><input type="submit" value="확인" required="required" onchange="chkerrmsg()"></td></tr></form>
		<tr><td>변경 후 비밀번호</td><td><input type="password" name="newPw" id="newPw" required="required"></td></tr>
		<tr><td>비밀번호 확인</td><td><input type="password" name="newPw1" id="newPw1" required="required" onchange="comparePw()"></td></tr>
		<tr><td></td><td><span class="error_next_box"></span></td>
	</table>
	<input type="button" value="확인" onclick="changePw()">
	
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