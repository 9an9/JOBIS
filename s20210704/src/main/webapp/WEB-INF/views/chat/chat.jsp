<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
	<title>Chating</title>
	<style>
		*{
			background: #FFFFF;
			margin:0;
			padding:0;
			border-left:0;
			border-right: 0;
		}
		.container{
			width: 500px;
			margin: 0 auto;
			padding: 25px;
		}
		.container h1{
			text-align: left;
			padding: 5px 5px 5px 15px;
			color: #222222;
			margin-bottom: 20px;
		}
		.chating{
			background-color: #FFFFFF;
			width: 500px;
			height: 500px;
			overflow: auto;
		}
		.chat {
			font-size: 20px;
			color:black;
			margin: 5px;
			min-height: 20px;
			padding: 5px;
			min-width: 50px;
			text-align: left;
	        height:auto;
	        word-break : break-all;
	        background: #F0F0F0;
			color: #9A9A9A;
	        width:auto;
	        display:inline-block;
	        border-radius: 10px 10px 10px 10px;
		}
		.my-chat{
			text-align: right;
			background: #E5EAE4;
			color: #919390;
			border-radius: 10px 10px 10px 10px;
		}
		.chat-info{
			color:#556677;
			font-size: 10px;
			text-align: right;
			padding: 5px;
			padding-top: 0px;
		}
		.chat-box{
			text-align: left;
			margin-top: 5px;
		}
		.my-chat-box{
			text-align: right;
		}
		.senduser {
			text-align: left;
			color: #8C8C8C;
		}

		input{
			margin: 0px;
			width: 330px;
			height: 25px;
		}
		#yourMsg{
			display: none;
		}
		#userName{
			display : none;
		}
		#delBtn{
			display : none;
			background: #8C8C8C;
			color: #FFFFFF;
			float: right;
			border: none;
		    padding: .8em .5em;
			text-align: center;
			text-decoration: none;
			font-family: inherit;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;
			border-radius: 5px;
		}
		#startBtn{
			border-radius: 5px;
			background: #8C8C8C;
			color: #FFFFFF;
		    border: 1px #8C8C8C;
		    padding: 25px;;
		    width: 500px;
		    text-align: center;
		    text-decoration: none;
		    font-size: 15px;
		    cursor: pointer;
		}
		#meName {
			background: #F9EBDE;
			color: #222222;
			font-weight: bolder;
			size: 12px;
			border-radius: 3px;
		}

		select {
			width: 200px;
			padding: .8em .5em;
			border: 1px solid #999;
			font-family: inherit;
			background: url('../images/arrow.jpg') no-repeat 95% 50%;
			border-radius: 0px;
			-webkit-arrearance: none;
			-moz-apperance: none;
			appearance: none;
		}
		select::-ms-expand {
			display: none;
		}
		#message_box {
			padding: .8em .5em;
			border: 1px solid #999;
			font-family: inherit;
			border-radius: 0px;
			-webkit-arrearance: none;
			-moz-apperance: none;
			appearance: none;
			width: 434.69px;
			height: 50px;
		}
		#sendBtn {
			background-color: #8C8C8C; 
			border: none;
			color: #FFFFFF;
			padding: .8em .5em;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-family: inherit;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;
			height: 73.31px;
			border-radius: 5px;
		}
	</style>
</head>

<script type="text/javascript">
	var ws;
/* 	var vsg = new Vue({
		el: '#vue_root',
		data: { ,/
			datas:
				{g_title: '이름',}
		}
	}) */

	function wsOpen(){
		console.log("wsOpen  location.host: " + location.host);
        var wsUri  = "ws://" + location.host + "/chating";
        // WebSocket 프로토콜을 사용하여 통신하기 위해서는 WebSocket객체를 생성. 
        // 객체는 자동으로 서버로의 연결
 		ws = new WebSocket(wsUri);
		wsEvt();
	}
		
	function wsEvt() {
		console.log("wsEvt  start... ");
		
		//소켓이 열리면 동작
		ws.onopen = function(data){
			console.log("wsEvt  소켓이 열리면 초기화 세팅하기..");
			}
		//메시지를 받으면 동작
		ws.onmessage = function(data) {
			
			var msg = data.data;
			var memberSave = false;
			//alert("ws.onmessage->"+msg)
			if(msg != null && msg.trim() != ''){
				memberSave = false;
				// JSON 오브젝트를 자바스크립트 오브젝트로 변환
			    var jsonMsg = JSON.parse(msg);
				// msg가 배열이고, 2개이상의 Count이면 , member 등록 대상 
                if (Array.isArray(jsonMsg)) {
                	if (Object.keys(jsonMsg).length > 1) {
                    	memberSave = true;
                       	//alert("JSONArray jsonMsg Count->"+ Object.keys(jsonMsg).length);
                	}
                }
				// 파싱한 객체의 type값을 확인하여 getId값이면 초기 설정된 값이므로 채팅창에 값을 입력하는게 아니라
				// 추가한 태그 sessionId에 값을 세팅
				if(jsonMsg.type == "getId"){
					var sid = jsonMsg.sessionId != null ? jsonMsg.sessionId : "";
					if(sid != ''){
						$("#sessionId").val(sid); 
						// session User 등록 수행
						sendUser();
					}
				}else if(jsonMsg.type == "message"){
					var date = new Date();
					var dateInfo = date.getHours() + "시 " + date.getMinutes() + "분에 전송";
					// type이 message인 경우엔 채팅이 발생한 경우.
	                // 상대방과 자신을 구분하기 위해 여기서 sessionId값을 사용
	                // 최초 이름을 입력하고 연결되었을때, 발급받은 sessionId값을 비교하여 같다면 자기 자신이 발신한
	                // 메시지이므로 오른쪽으로 정렬하는 클래스를 처리하고 메시지를 출력.     
	                // 비교하여 같지 않다면 타인이 발신한 메시지이므로 왼쪽으로 정렬하는 클래스를 처리하고 메시지를 출력
					if(jsonMsg.sessionId == $("#sessionId").val()){
						$("#chating").append("<div class='my-chat-box'><p class=userme>" + "<div class='chat my-chat'>" + jsonMsg.msg + "</div><div class='chat-info'>" + dateInfo + "(" + $("#member_sub option:selected").text() + " 에게)" + "</div></div>");
						
						
					}else if(jsonMsg.sessionId != $("#sessionId").val() && jsonMsg.yourName == "전체"){
						var $chat = $("<div class='chat-box'><p class='senduser'>" + jsonMsg.userName + " :" + "</p><div class='chat'>" + jsonMsg.msg + "</div><div class='chat-info chat-box'>" + dateInfo + "(전체에게)" + "</div></div>");
						$("#chating").append($chat);
					}else if(jsonMsg.sessionId != $("#sessionId").val() && jsonMsg.yourName == "부서"){
						var $chat = $("<div class='chat-box'><p class='senduser'>" + jsonMsg.userName + " :" + "</p><div class='chat'>" + jsonMsg.msg + "</div><div class='chat-info chat-box'>" + dateInfo + "(부서에게)" + "</div></div>");
						$("#chating").append($chat);
					}else if(jsonMsg.sessionId != $("#sessionId").val() && jsonMsg.yourName == "팀"){
						//$("#chating").append("<p class='pothers'><span class='others'>" + jsonMsg.userName + "(" + "팀에게)" + " :" + jsonMsg.msg + "</span></p>");
						var $chat = $("<div class='chat-box'><p class='senduser'>" + jsonMsg.userName + " :" + "</p><div class='chat'>" + jsonMsg.msg + "</div><div class='chat-info chat-box'>" + dateInfo + "(팀에게)" + "</div></div>");
						$("#chating").append($chat);
					}else{
						//$("#chating").append("<p class='pothers'><span class='others'>" + jsonMsg.userName + " :" + jsonMsg.msg + "</span></p>");
						var $chat = $("<div class='chat-box'><p class='senduser'>" + jsonMsg.userName + " :" + "</p><div class='chat'>" + jsonMsg.msg + "</div><div class='chat-info chat-box'>" + dateInfo + "(당신 에게)" + "</div></div>");
						$("#chating").append($chat);
					}
					$("#chating").scrollTop($("#chating")[0].scrollHeight);
				
				}else if(memberSave = true){
					//alert("userSave");
					$('#member_sub').remove();
					//  memberSave = true 면  -->	User 등록일경우
					// div로 감싸주면 재정의시 삭제(Refresh)후 다시 생성 
					//var str = " <div id='member_sub' class='member_sub'> ";
					var str = " ";
					str  += " <div >";
					str  += " <select name='member' id='member_sub' class='member_sub'> ";
					str  += " <optgroup label='그룹채팅'>";
					str  += " <option value='전체'>전체 </option> "; 
					str  += " <option value='부서'>부서</option> ";
					str  += " <option value='팀'>팀</option>";
					str  += " <optgroup label='개인채팅'>";
					
					$(jsonMsg).each(
						function(){
							var str2 = "";
				            // User를 선택하여 message전송 가능토록 member에 등록 
							if(jsonMsg.sessionId == $("#sessionId").val()){
								//alert("내꺼임"+ $("#sessionId").val())
							
							} else {  // 타인 session일 경우 추가 등록 
								
								str2 += " <option value='"+this.sessionId + "'> "+this.userName  + "</option> "; 
								str  += str2 ;
							}
						}
					);
					str += " </optgroup>"
					str += " </select>"
					str += " </div><p>"
					$('#member').append(str);	
					memberSave = false;
					
				}else{
						console.warn("unknown type!");
				}
			}
		}
		

		document.addEventListener("keypress", function(e){
			if(e.keyCode == 13){ //enter press
				send();
			}
		});
	}

	function chatName(){
		var userName = $("#userName").val();
		var userDept = $("#userDept").val();
		var userTeam = $("#userTeam").val();
		var userRank = $("#userRank").val();
		console.log("chatName  userName: " + userName);
		//if(userName == null || userName.trim() == ""){
		//	alert("사용자 이름을 입력해주세요.");
		//	$("#userName").focus();
		//}else{
		wsOpen();
		$("#meName").append(userDept+" "+userTeam+" "+userName+userRank); 
		//$("#meName").append("나의이름:"+userName);
		$("#yourName").hide();
		$("#yourMsg").show();
		$("#delBtn").show();
		//}
	}

	// User 등록  Message 전송 
	function sendUser() {
		var userOption ={
			type: "userSave",
			sessionId : $("#sessionId").val(),
			userName : $("#userName").val(),
			userDept : $("#userDept").val(),
			userTeam : $("#userTeam").val(),
		}
		// 자바스크립트의 값을 JSON 문자열로 변환
		ws.send(JSON.stringify(userOption));
		// $('#message_box').val("");
	}
	// 삭제시 처리 
	function chatNameDelete() {
		var userName = $("#userName").val();
		var sessionId = $("#sessionId").val();
		console.log("chatNameDelete userName : " + userName);
		console.log("chatNameDelete sessionId : " + sessionId);
		wsDeleteUser(sessionId);
		window.close();
	}
	
	// User Delete  Message 전송 
	function wsDeleteUser(sessionId) {
		var option ={
			type: "userDelete",
			sessionId : sessionId
		}
		// 자바스크립트의 값을 JSON 문자열로 변환
		ws.send(JSON.stringify(option));
	}
	
	// User의 부서등록 Message 전송
	function sendDept() {
		var deptOption ={
			type: "deptSave",
			sessionId : $("#sessionId").val(),
			userDept : $("#userDept").val(),			
		}
		ws.send(JSON.stringify(deptOption));
	}
	
	// 전체 Message 전송 
	function send() {
		var option ={
			type: "message",
			sessionId : $("#sessionId").val(),
			userName : $("#userName").val(),
			userDept : $("#userDept").val(),
			userTeam : $("#userTeam").val(),
			yourName : $("#member_sub").val(),
			msg : $("#message_box").val()
		}
		//alert('function send yourName->'+$("#member_sub").val())
		// 자바스크립트의 값을 JSON 문자열로 변환
		ws.send(JSON.stringify(option));
		$('#message_box').val("");
	}
</script>
<body>

	<div id="container" class="container">
		<h1>채팅</h1>
		<input type="hidden" id="sessionId" value="">
		<table id="nameArea">
			<tr><td id="meName"></td>		
		</table>
		<div id="nameAreaBtn" align="right"><button onclick="chatNameDelete()" id="delBtn">접속종료</button></div>
		
		<div id="chating" class="chating">
			<div id="chat-container">
			</div>
		</div>
		<div id="member" class="member">
		</div>
		
		<div id="yourName">
			<table class="inputTable">
				<tr>
					<th><input type="hidden" name="userName" id="userName" value="${svo.emp_name }"></th>
					<th><input type="hidden" name="userDept" id="userDept" value="${svo.dcontent }"></th>
					<th><button onclick="chatName()" id="startBtn">채팅 시작하기</button></th>
					<th><input type="hidden" name="userTeam" id="userTeam" value="${svo.tcontent }"></th>
					<th><input type="hidden" name="userRank" id="userRank" value="${svo.rcontent }"></th> 
					
				</tr>
			</table>
		</div>
		
		<div id="yourMsg">
			<table class="inputTable">
				<tr>
					<th><textarea id="message_box" placeholder="보내실 메시지를 입력하세요."></textarea></th>
					<th><button onclick="send()" id="sendBtn">전송</button></th>
				</tr>
			</table>
		</div>
		
	</div>
</body>
</html>