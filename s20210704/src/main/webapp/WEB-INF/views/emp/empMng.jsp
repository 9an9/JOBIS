<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<c:forEach var="empM" items="${empMng }">
<h1>${empM.emp_name }</h1>
	기존<p>
	부서 : ${empM.dept } <br>
         팀  : ${empM.team } <br>
         직급 : ${empM.rank } <p>
</c:forEach>         
         변경 후<p>
    <form action="mngEmp" method="post"> 
    <input type="hidden" id="empno" name="empno" value="${empno }">    
         부서 : <select id="dep_num" name="dep_num" onchange="getTeam()">
              <option selected='selected' disabled='disabled'></option>             
         <c:forEach var="deptList" items="${deptList }" >                                 
              <option value="${deptList.dcode }">${deptList.dept }</option>
         </c:forEach>
         </select><br> 
         팀 : <select id="team_num" name="team_num">
 			<option selected='selected' disabled='disabled'></option>              
		</select><br>            
         직급 : <select name="rnk_num">
              <option selected='selected' disabled='disabled'></option>             
         <c:forEach var="rankList" items="${rankList }">                                 
         	   <option value="${rankList.rcode }">${rankList.rank }</option>
         </c:forEach>
         </select><br>  
    <input type="submit" value="변경하기">  <button type="button" onclick="deleteEmp()">삭제하기</button>
    </form>         
    
         
    
    

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
function deleteEmp() {
	var empno = document.getElementById('empno').value;
	window.location.href="deleteEmp?empno="+empno;
}
</script>
</body>
</html>