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
</head>
<body>
<h1>부서 관리</h1><p>
	<form action="addDept" method="post"><input type="text" id="dept" name="dept"><input type="submit" value="추가"></form>
	    <table>
		<tr><th>부서</th><th>팀</th></tr>
		<c:forEach var="dtList" items="${dtList }">
		<tr><td class="tdDept"><a href="javascript:addTeam('${dtList.dept }')" style="text-decoration: none;"><i class="fa fa-plus-square-o"></i></a>${dtList.dept }</td>
			<td><a href="javascript:deleteTeam('${dtList.team }')" style="text-decoration: none;"><i class="fa fa-minus-square-o"></i></a>${dtList.team }</td></tr> 
		</c:forEach>
	</table>

         
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