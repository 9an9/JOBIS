package com.oracle.s20210704.handler;


import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketHandler extends TextWebSocketHandler {
	// 웹소켓 세션을 담아둘 맵
	HashMap<String, WebSocketSession> sessionMap = new HashMap<>();
	// 웹소켓 세션 ID과 Member을 담아둘 맵
	HashMap<String, String> sessionUserMap = new HashMap<>();
	// 웹소켓 세션 ID과 Member을 담아둘 JSONObject
	JSONObject jsonUser = null;
	HashMap<String, String> sessionUserDept = new HashMap<>();
	JSONObject jsonDept = null;
	HashMap<String, String> sessionUserTeam = new HashMap<>();
	JSONObject jsonTeam = null;

	// 메소드는 메시지를 수신하면 실행
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		// 메시지 발송
		String msg = message.getPayload();
		System.out.println("SocketHandler handleTextMessage msg->" + msg);
		JSONObject jsonObj = jsonToObjectParser(msg);
		// type을 Get하여 분기
		String msgType = (String) jsonObj.get("type");
		System.out.println("SocketHandler handleTextMessage  msgType->" + msgType);
		switch (msgType) {
		// 전체 Message
		case "message":
			jsonUser = new JSONObject(sessionUserMap);
			System.out.printf("JSONUser: %s", jsonUser);

			// 전송대상을 기준으로 분기
			String yourName = (String) jsonObj.get("yourName");
			System.out.println("SocketHandler handleTextMessage  yourName->" + yourName);
			// 전체
			if (yourName.equals("전체")) {
				System.out.println("SocketHandler msgType:message yourName-->" + yourName);
				for (String key : sessionMap.keySet()) {
					System.out.println("SocketHandler sessionMap key-->" + key);
					WebSocketSession wss = sessionMap.get(key);
					try {
						wss.sendMessage(new TextMessage(jsonObj.toJSONString()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			// 부서별
			} else if (yourName.equals("부서")){   //"3"+ "")) {
				System.out.println("부서 전송");
				String yourDept = (String) jsonObj.get("userDept");
				String sessionUserDepStr = "";
				for (String key : sessionUserDept.keySet()) {
					// sessionUserDep의 부서명을 받아옴 
					sessionUserDepStr = sessionUserDept.get(key);
//					System.out.println("sessionUserDept -> " + sessionUserDept);
//					System.out.println("jsonObj.get(userDept) -> " + jsonObj.get("userDept"));
//					System.out.println("yourDept -> " + yourDept);
					if (yourDept.equals(sessionUserDepStr)) {
						WebSocketSession wss2 = sessionMap.get(key);
						try {
							wss2.sendMessage(new TextMessage(jsonObj.toJSONString()));
						} catch (Exception e) {
							e.printStackTrace();
						}
					
					}
				}  // for 
			//팀별
			} else if(yourName.equals("팀")) {
				System.out.println("팀 전송");
				String yourTeam = (String) jsonObj.get("userTeam");
				String sessionUserTeamStr = "";
				for (String key : sessionUserTeam.keySet()) {
					// sessionUserDep의 부서명을 받아옴 
					sessionUserTeamStr = sessionUserTeam.get(key);
//					System.out.println("sessionUserTeam -> " + sessionUserTeam);
//					System.out.println("jsonObj.get(userTeam) -> " + jsonObj.get("userTeam"));
//					System.out.println("yourDept -> " + yourTeam);
					if (yourTeam.equals(sessionUserTeamStr)) {
						WebSocketSession wss3 = sessionMap.get(key);
						try {
							wss3.sendMessage(new TextMessage(jsonObj.toJSONString()));
						} catch (Exception e) {
							e.printStackTrace();
						}
					} 
				} 
			}else { // 개인 전송 대상자(yourName은 개인 sessionID)
				// 상대방
				System.out.println("개인 전송 대상자 상대방-->" + yourName);
				WebSocketSession wss3 = sessionMap.get(yourName);
				try {
					wss3.sendMessage(new TextMessage(jsonObj.toJSONString()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 나에게도 보내줘
				String meName = (String) jsonObj.get("sessionId");
				WebSocketSession wss5 = sessionMap.get(meName);
				System.out.println("개인 전송 대상자 나-->" + meName);
				try {
					wss5.sendMessage(new TextMessage(jsonObj.toJSONString()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			break;

		// sessionUserMap에 User등록
		case "userSave":
			// sessionUserMap에 sessionId와 userName 등록
			String sessionId = (String) jsonObj.get("sessionId");
			String userName = (String) jsonObj.get("userName");
			String userDept = (String) jsonObj.get("userDept");
			String userTeam = (String) jsonObj.get("userTeam");
			System.out.println("== sessionUserMap에 User등록시 userDept  ==>"+userDept);
		    sessionUserMap.put(sessionId, userName);
			sessionUserDept.put(sessionId, userDept);
			sessionUserTeam.put(sessionId, userTeam);
			System.out.println("==================================================");
			System.out.println("== sessionUserMap 저장내용 조회하여 arrayJsonUser에   ==");
			System.out.println("==  각각의 JSONObject jsonUser로  변환                           ==");
			System.out.println("== 1. type : userSave                          ==");
			System.out.println("== 2. sessionId : sessionUserMap.sessionId     ==");
			System.out.println("== 3. userName  : sessionUserMap.userName      ==");
			System.out.println("=================================================");
			JSONArray arrayJsonUser = new JSONArray();
//			JSONArray arrayJsonDept = new JSONArray();
//			JSONArray arrayJsonTeam = new JSONArray();
			System.out.println("== 1. type : userSave                         ==");
			Iterator<String> userIter = sessionUserMap.keySet().iterator();
			System.out.println("== 2. sessionId : sessionUserMap.sessionId    ==");
			System.out.println("== 3. userName  : sessionUserMap.userName     ==");
			System.out.println("== 4. userDep   : sessionUserMap.userDep Map만 저장  ==");

			while (userIter.hasNext()) {
				String key = userIter.next();
				String value = sessionUserMap.get(key);
				System.out.println("Key : Value -->" + key + " : " + value);
				jsonUser = new JSONObject();
				jsonUser.put("type", "userSave");
				jsonUser.put("sessionId", key);
				jsonUser.put("userName", value);
				arrayJsonUser.add(jsonUser);
								
			}
		 
			
			System.out.println("====== session을 Get하여 User 내용 전송 ========");
			System.out.printf("arrayJsonUser: %s", arrayJsonUser);

			// 전체에 User등록을 하게 함
			for (String key : sessionMap.keySet()) {
				WebSocketSession wss = sessionMap.get(key);
				try {
					wss.sendMessage(new TextMessage(arrayJsonUser.toJSONString()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// 전체에 부서등록을 하게 함
//			for (String point : sessionMap.keySet()) {
//				WebSocketSession wss2 = sessionMap.get(userDep);
//				try {
//					wss2.sendMessage(new TextMessage(arrayJsonUser.toJSONString()));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//	            // 
//	     	    WebSocketSession wss = sessionMap.get(sessionId);
//				try {
//					wss.sendMessage(new TextMessage(arrayJsonUser.toJSONString()));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

			break;
		case "userDelete":
				// 웹소켓 종료
	     		sessionMap.remove(session.getId());
	     		// sessionUserMap 종료
	     		sessionUserMap.remove(session.getId());
			break;
		}
	}

//  @SuppressWarning
//  이건 컴파일러가 일반적으로 경고하는 내용 중	"이건 하지마"하고 제외시킬 때 쓰임
//	따라서 어떤 경고를 제외시킬지 옵션
//	1. all : 모든 경고를 억제
//	2. cast : 캐스트 연산자 관련 경고 억제
//	3. dep-ann : 사용하지 말아야 할 주석 관련 경고 억제
//	4. deprecation : 사용하지 말아야 할 메소드 관련 경고 억제
//	5. fallthrough : switch문에서의 break 누락 관련 경고 억제
//	6. finally : 반환하지 않는 finally 블럭 관련 경고 억제
//	7. null : null 분석 관련 경고 억제
//	8. rawtypes : 제네릭을 사용하는 클래스 매개 변수가 불특정일 때의 경고 억제
//	9. unchecked : 검증되지 않은 연산자 관련 경고 억제
//	10. unused : 사용하지 않는 코드 관련 경고 억제

	// 웹소켓 연결이 되면 동작
	@SuppressWarnings("unchecked")
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("SocketHandler afterConnectionEstablished start...");
		// 웹소켓 연결이 되면 동작
		super.afterConnectionEstablished(session);
		sessionMap.put(session.getId(), session);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("type", "getId");
		jsonObj.put("sessionId", session.getId());
		session.sendMessage(new TextMessage(jsonObj.toJSONString()));
	}

	// 웹소켓이 종료되면 동작
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("SocketHandler afterConnectionEstablished start...");
		// 웹소켓 종료
		sessionMap.remove(session.getId());
		// sessionUserMap 종료
		sessionUserMap.remove(session.getId());
		super.afterConnectionClosed(session, status);
	}

	// handleTextMessage 메소드 에 JSON파일이 들어오면 파싱해주는 함수를 추가
	private static JSONObject jsonToObjectParser(String jsonStr) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;
		try {
			jsonObj = (JSONObject) parser.parse(jsonStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
}