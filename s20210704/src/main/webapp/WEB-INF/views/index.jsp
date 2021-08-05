<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/Login.css">
<body>
<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>JOB<span>IS</span></div>
		</div>
		<br>
		<div class="login">
	<form  method="post" action="login"> 
				<label for="emp_Num"></label>
				<input type="text" id="emp_num" name="emp_num">
			    <label for="empPass"></label>
				<input type="password" id="emp_pw" name="emp_pw">
			<br>
					<button type="submit" id="login-button">Login</button>
	
		</form>
	</div>
	
	
	
</body>
</html>
 

 

 