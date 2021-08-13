<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.deptD {
	width: 80%;
	position: absolute;
  	left: 50%;
 	transform: translateX(-50%);
}
table {
	width: 100%;
	text-align: center;
	margin: 0 auto;	
    margin-top: 15px;
    border: 1px solid #7d97a5;
    border-collapse: collapse;
    border-spacing: 0;
    align-self: center;
   	border: 1px solid #384f76 ;
}
td {
	padding: 10px;
}
tr {
	padding: 10px;
}
.btn2{
   color: #fff;
   background-color: #384f76;
   
   border-color: #AAABD3;
   border-radius: 6px;
}
i {
	color: #384f76;
}
form {
	align-self: center;
}
</style>
</head>
<body>
<h1 align="center">부서 관리</h1><p>
	<div class="deptD">
	<form action="addDept" method="post"><input type="text" id="dept" name="dept" style="width: 180px;height: 30px;">  <input type="submit" value="추가" class="btn2"></form>
	    <table border="1">
		<tr style="background-color:#384f76; color: white; "><th>부서</th><th>팀</th></tr>
		<c:forEach var="dtList" items="${dtList }">
		<tr><td class="tdDept"><a href="javascript:addTeam('${dtList.dept }')" style="text-decoration: none;"><i class="fa fa-plus-square-o"></i></a>  ${dtList.dept }</td>
			<td><a href="javascript:deleteTeam('${dtList.team }')" style="text-decoration: none;"><i class="fa fa-minus-square-o"></i></a>  ${dtList.team }</td></tr> 
		</c:forEach>
	</table>
	</div>

         
<script type="text/javascript">
$(document).ready(function(e){
    genRowspan("tdDept");
});
 
function genRowspan(className){
    $("." + className).each(function() {
        var rows = $("." + className + ":contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length);
            rows.not(":eq(0)").remove();
        }
    });
}
function addTeam(dept) {
	console.log(" addTeam 실행"+ dept);
	window.location.href="addTeam?dept="+dept;
}
function deleteTeam(team) {
	console.log(" deleteTeam 실행"+ team);
	window.location.href="deleteTeam?team="+team;
}
</script>   
    
</body>
</html>