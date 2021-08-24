<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
.MngEmp {
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
table select {
	margin-left: 20px;
	width: 150px;
	height: 40px;
	border: none;
}
</style>
</head>
<body>
<c:forEach var="empM" items="${empMng }">
<h1 style="text-align: center">${empM.emp_name }</h1>
	<div class="MngEmp">
		
		<table border="1">
		<tr><td rowspan="3" style="background-color:#E0E3DA; color: #000; text-align: center; width: 65px">변경 전</td><td style="background-color:#E0E3DA; color: #000; text-align: center; width: 75px">부서</td><td style="padding-left: 20px">${empM.dept }</td></tr>
		<tr><td style="background-color:#E0E3DA; color: #000; text-align: center; width: 75px">팀</td><td style="padding-left: 20px">${empM.team }</td></tr>
		<tr><td style="background-color:#E0E3DA; color: #000; text-align: center; width: 75px">직급</td><td style="padding-left: 20px">${empM.rank }</td></tr>
		</table>
		</c:forEach>
		<form action="mngEmp" method="post">
		<input type="hidden" name="empno" value="${empno }">
		<table border="1">
		<tr><td rowspan="3" style="background-color:#E0E3DA; color: #000; text-align: center; width: 65px">변경 후</td><td style="background-color:#E0E3DA; color: #000; text-align: center; width: 75px">부서</td><td><select id="dep_num" name="dep_num" onchange="getTeam();getRnk();">
	              										<option selected='selected' disabled='disabled'></option>             
											         <c:forEach var="deptList" items="${deptList }" >                                 
											              <option value="${deptList.dcode }">${deptList.dept }</option>
											         </c:forEach>
											         </select></td></tr>
		<tr><td style="background-color:#E0E3DA; color: #000; text-align: center; width: 75px">팀</td><td><select id="team_num" name="team_num">
					 			<option selected='selected' disabled='disabled'></option>              
							</select></td></tr>
		<tr><td style="background-color:#E0E3DA; color: #000; text-align: center; width: 75px">직급</td><td><select id="rnk_num" name="rnk_num">
					              <option selected='selected' disabled='disabled'></option>             
					         </select></td></tr>
		</table>
		 
		<div style=" margin-top: 10px;" align="center">
			<input type="submit" value="변경" class="btn2">  <button type="button" onclick="deleteEmp()" class="btn2">삭제</button>
		</div> 
		</form>
		
	</div>
            
    
    

<c:if test="${result == 1 }">
	<script type="text/javascript">
	window.onload = function() {
		alert("인사정보가 변경되었습니다.");
		opener.document.location.reload();
		self.close();
	}
	</script>
</c:if>	
<c:if test="${result == 0 }">
	<script type="text/javascript">
	window.onload = function() {
		alert("변경에 실패하였습니다.");
		self.close();
	}
	</script>
</c:if>		
<c:if test="${result2 == 1 }">
	<script type="text/javascript">
	window.onload = function() {
		alert("사원이 삭제되었습니다.");
		opener.document.location.reload();
		self.close();
	}
	</script>
</c:if>	
<c:if test="${result2 == 0 }">
	<script type="text/javascript">
	window.onload = function() {
		alert("삭제에 실패하였습니다.");
		self.close();
	}
	</script>
</c:if>	


<script type="text/javascript">
function getTeam() {
	console.log("team 시작")
    var dcode = document.getElementById('dep_num').value;
	console.log(dcode);
	var url = '../selectTeam?dcode='+dcode;
	var str = "";
	var str2 = "";
	$.ajax({
        url: url,
        dataType: 'json',
        success: function (data) {
        	$('#team_num *').remove();
        	$('#team_num').append('<option value="100">-</option>');
        	$(data).each(
        			function(){
        				str2 = "<option value='" +this.tcode + "'>" + this.team + "</option>";
        				str += str2;
        			}
        		);
			
			$('#team_num').append(str);
        }
    });
}
function getRnk() {
	console.log("Rnk 시작")
    var dcode = document.getElementById('dep_num').value;
	console.log(dcode);
	var url = '../selectRnk?dcode='+dcode;
	var str = "";
	var str2 = "";
	$.ajax({
        url: url,
        dataType: 'json',
        success: function (data) {
        	$('#rnk_num *').remove();
        	$('#rnk_num').append('<option value="100">-</option>');
        	$(data).each(
        			function(){
        				str2 = "<option value='" +this.rcode + "'>" + this.rank + "</option>";
        				str += str2;
        			}
        		);
			
			$('#rnk_num').append(str);
        }
    });
}
function deleteEmp() {
	var empno = document.getElementById('empno').value;
	window.location.href="deleteEmp?empno="+empno;
}
</script>
</body>
</html>