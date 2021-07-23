<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>

<body>
	<form  method="post" action="login"> 
			<div>
				<label for="emp_Num"></label>
				<input type="text" id="emp_num" name="emp_num">
			</div>
			<div>
				<label for="empPass"></label>
				<input type="password" id="emp_pw" name="emp_pw">
			</div>
			<div>
				<button type="submit">로그인</button>
			</div>

		<c:if test="${msg ==  1}">
			<p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
		</c:if>
	</form>
</body>
</html>
 

 

 