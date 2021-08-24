package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.SwMsg_rcv;
import com.oracle.s20210704.model.SwMsg;
import com.oracle.s20210704.model.YjEmp;


@Repository
public class SwMsgDaoImpl implements SwMsgDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<SwMsg> msgList(SwMsg swmsg) {
		List<SwMsg> msgList = null;
		System.out.println("SwEmpDaoImpl msgList Start ..." );
		try {
			// Naming Rule 
			msgList = session.selectList("msgList", swmsg);
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl msgList Exception->"+e.getMessage());
		}
	return msgList;
	}
	
	@Override
	public List<SwMsg_rcv> msg_rcvList(SwMsg_rcv swmsg_rcv) {
		List<SwMsg_rcv> msg_rcvList = null;
		System.out.println("SwMsgDaoImpl msg_rcvlist Start ..." );
		try {
			msg_rcvList = session.selectList("msg_rcvList", swmsg_rcv);
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl msg_rcvlist Exception->"+e.getMessage());
		}
		return msg_rcvList;
	}
	

	@Override
	public List<SwMsg> rcvDetailMsg(int note_sq) {
		List<SwMsg> rcvDetailMsg = null;
		System.out.println("SwMsgDaoImpl rcvDetailMsg Start ..." );
		try {
			rcvDetailMsg = session.selectList("rcvDetailMsg", note_sq);
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl rcvDetailMsg() Exception->"+e.getMessage());
		}
	return rcvDetailMsg;
	}
	
	@Override
	public List<YjEmp> listEmp() {
		List<YjEmp> empList = null;
		System.out.println("SwMsgDaoImpl listEmp Start ..." );
		try {
			// Naming Rule 
			empList = session.selectList("listEmp");
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl listEmp Exception->"+e.getMessage());
		}
	return empList;
	}
	
	@Override
	public int insertMsg_rcv(SwMsg_rcv swmsg_rcv) {
		int result2 = 0;
		System.out.println("SwMsgDaoImpl insertMsg_rcv Start ..." );
		try {
			result2 = session.insert("insertMsg_rcv", swmsg_rcv);
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl insertMsg_rcv Exception->"+e.getMessage());
		}
	return result2;
	}
	
	@Override
	public int insertMsg(SwMsg swmsg) {
		int result1 = 0;
		System.out.println("SwMsgDaoImpl insertMsg Start ..." );
		try {
			result1 = session.insert("insertMsg", swmsg);
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl insertMsg Exception->"+e.getMessage());
		}
	return result1;
	}

	@Override
	public int delete(String checks) {
		System.out.println("SwMsgDaoImpl delete Start...");
		int result = 0;
		try {
			result  = session.delete("delete", checks);
			System.out.println("SwMsgDaoImpl delete result->" + result);
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl delete Exception->"+e.getMessage());
		}
	return result;
	}
	
	@Override
	public List<SwMsg_rcv> sentDetailMsg(int note_sq) {
		List<SwMsg_rcv> sentDetailMsg = null;
		System.out.println("SwMsgDaoImpl sentDetailMsg Start ..." );
		try {
			// Naming Rule 
			sentDetailMsg = session.selectList("sentDetailMsg", note_sq);
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl sentDetailMsg Exception->"+e.getMessage());
		}
	return sentDetailMsg;
	}
	
	@Override
	public int update(int note_sq) {
		System.out.println("SwMsgDaoImpl update start..");
		int result = 0;
		try {
			result  = session.update("update", note_sq);
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl update Exception->"+e.getMessage());
		}
	return result;
	}

	@Override
	public int total(int emp_num) {
		int tot = 0;
		System.out.println("SwMsgDaoImpl total Start ..." );
		try {
			  // session -> Mapper ID total 호출 
			 tot = session.selectOne("total", emp_num);
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl total Exception->"+e.getMessage());
		}	
	return tot;
	}

	@Override
	public int total2(int emp_num) {
		int tot = 0;
		System.out.println("SwMsgDaoImpl total2 Start ..." );
		try {
			  // session -> Mapper ID total 호출 
			 tot = session.selectOne("total2", emp_num);
		} catch (Exception e) {
			System.out.println("SwMsgDaoImpl total2 Exception->"+e.getMessage());
		}		
	return tot;
	}
	
	@Override
	public int unreadMsg(int emp_num) {
		int unreadMsg = session.selectOne("total2", emp_num);
		return unreadMsg;
	}
}