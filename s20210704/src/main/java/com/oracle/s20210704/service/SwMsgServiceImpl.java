package com.oracle.s20210704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210704.model.YjEmp;
import com.oracle.s20210704.model.SwMsg;
import com.oracle.s20210704.model.SwMsg_rcv;
import com.oracle.s20210704.dao.SwMsgDao;

@Service
public class SwMsgServiceImpl implements SwMsgService {
	
	@Autowired
	private SwMsgDao smd;
	
	@Override
	public List<SwMsg_rcv> msg_rcvList(SwMsg_rcv swmsg_rcv) {
		List<SwMsg_rcv> msg_rcvList = null;
		System.out.println("SwMsgServiceImpl msg_rcvList Start..." );
		msg_rcvList = smd.msg_rcvList(swmsg_rcv);
		System.out.println("SwNoteServiceImpl msg_rcvList.size()->" + msg_rcvList.size());
	return msg_rcvList;
	}

	@Override
	public List<SwMsg> msgList(SwMsg swmsg) {
		List<SwMsg> msgList = null;
		System.out.println("SwNoteServiceImpl msgList Start..." );
		msgList = smd.msgList(swmsg);
		System.out.println("SwNoteServiceImpl msgList.size()->" + msgList.size());
	return msgList;
	}
		
	@Override
	public List<YjEmp> listEmp() {
		List<YjEmp> empLists = null;
		System.out.println("SwNoteServiceImpl listEmp Start..." );
		empLists = smd.listEmp();
		System.out.println("SwNoteServiceImpl listEmp empList.size()->" +empLists.size());
	return empLists;
	}

	@Override
	public int insertMsg(SwMsg swmsg) {
		System.out.println("SwNoteServiceImpl insertMsg Start..." );
		int result1 = smd.insertMsg(swmsg);
	return result1;
	}

	@Override
	public int insertMsg_rcv(SwMsg_rcv swmsg_rcv) {
		System.out.println("SwNoteServiceImpl insertMsg_rcv Start..." );
		int result2 = smd.insertMsg_rcv(swmsg_rcv);
	return result2;
	}

	@Override
	public int delete(String checks) {
		int result = 0;
		System.out.println("SwNoteServiceImpl delete Start..." );
		result = smd.delete(checks);
	return result;
	}

	@Override
	public List<SwMsg> rcvDetailMsg(int note_sq) {
		List<SwMsg> rcvDetailMsg = null;
		System.out.println("SwNoteServiceImpl rcvDetailMsg Start..." );
		rcvDetailMsg = smd.rcvDetailMsg(note_sq);
	return rcvDetailMsg;
	}

	@Override
	public List<SwMsg_rcv> sentDetailMsg(int note_sq) {
		List<SwMsg_rcv> sentDetailMsg = null;
		System.out.println("SwNoteServiceImpl sentDetailMsg Start..." );
		sentDetailMsg = smd.sentDetailMsg(note_sq);
		System.out.println("SwNoteServiceImpl sentDetailMsg.size()->" + sentDetailMsg.size());
	return sentDetailMsg;
	}

	@Override
	public int update(int note_sq) {
		System.out.println("SwNoteServiceImpl update Start...");
		int result = 0;
		result = smd.update(note_sq);
	return result;
	}

	@Override
	public int total(int emp_num) {
		System.out.println("SwNoteServiceImpl total Start..." );
		int totCnt = smd.total(emp_num);
		System.out.println("SwNoteServiceImpl total totCnt->"+ totCnt );
	return totCnt;
	}
	
	@Override
	public int total2(int emp_num) {
		System.out.println("SwNoteServiceImpl total2 Start..." );
		int totCnt = smd.total2(emp_num);
		System.out.println("SwNoteServiceImpl total2 totCnt->"+ totCnt );
	return totCnt;
	}
}