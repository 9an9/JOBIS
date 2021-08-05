package com.oracle.s20210704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210704.model.Emp;
import com.oracle.s20210704.model.SwNote_tb;
import com.oracle.s20210704.model.SwNote_rcv_tb;
import com.oracle.s20210704.dao.SwNoteDao;

@Service
public class SwNoteServiceImpl implements SwNoteService {
	
	@Autowired
	private SwNoteDao snd;
	
	@Override
	public List<Emp> listEmp() {
		List<Emp> empLists = null;
		System.out.println("SwNoteServiceImpl listEmp Start..." );
		empLists = snd.listEmp();
		System.out.println("SwNoteServiceImpl listEmp empList.size()->" +empLists.size());
	return empLists;
	}

	@Override
	public int insertNote_tb(SwNote_tb swnote_tb) {
		System.out.println("SwNoteServiceImpl insertNote_tb Start..." );
		int result1 = snd.insertNote_tb(swnote_tb);
	return result1;
	}

	@Override
	public int insertNote_rcv_tb(SwNote_rcv_tb swnote_rcv_tb) {
		System.out.println("SwNoteServiceImpl insertNote_rcv_tb Start..." );
		int result2 = snd.insertNote_rcv_tb(swnote_rcv_tb);
	return result2;
	}

	@Override
	public List<SwNote_rcv_tb> listSwNote_rcv_tb(SwNote_rcv_tb swnote_rcv_tb) {
		List<SwNote_rcv_tb> listSwNote_rcv_tb = null;
		System.out.println("SwNoteServiceImpl listEmp Start..." );
		listSwNote_rcv_tb = snd.listSwNote_rcv_tb(swnote_rcv_tb);
		System.out.println("SwNoteServiceImpl listSwNote_rcv_tb listSwNote_rcv_tb.size()->" + listSwNote_rcv_tb.size());
	return listSwNote_rcv_tb;
	}

	@Override
	public List<SwNote_tb> listSwNote_tb(SwNote_tb swnote_tb) {
		List<SwNote_tb> listSwNote_tb = null;
		System.out.println("SwNoteServiceImpl listSwNote_tb Start..." );
		listSwNote_tb = snd.listSwNote_tb(swnote_tb);
		System.out.println("SwNoteServiceImpl listEmp empList.size()->" + listSwNote_tb.size());
	return listSwNote_tb;
	}
	
	@Override
	public int delete1(String checks) {
		int result1 = 0;
		System.out.println("SwNoteServiceImpl delete2 Start..." );
		result1 = snd.delete1(checks);
	return result1;
	}
	
	@Override
	public int delete2(String checks) {
		int result2 = 0;
		System.out.println("SwNoteServiceImpl delete Start..." );
		result2 = snd.delete2(checks);
	return result2;
	}

	@Override
	public List<SwNote_tb> receiveDetailNote(int note_sq) {
		List<SwNote_tb> receiveDetailNote = null;
		System.out.println("SwNoteServiceImpl receiveDetailNote Start..." );
		receiveDetailNote = snd.receiveDetailNote(note_sq);
	return receiveDetailNote;
	}

	@Override
	public List<SwNote_rcv_tb> sentDetailNote(int note_sq) {
		List<SwNote_rcv_tb> sentDetailNote = null;
		System.out.println("SwNoteServiceImpl sentDetailNote Start..." );
		sentDetailNote = snd.sentDetailNote(note_sq);
		System.out.println("SwNoteServiceImpl sentDetailNote sentDetailNote.size()->" + sentDetailNote.size());
	return sentDetailNote;
	}

	@Override
	public int total() {
		System.out.println("SwNoteServiceImpl total Start..." );
		int totCnt = snd.total();
		System.out.println("SwNoteServiceImpl total totCnt->"+ totCnt );
	return totCnt;
	}

	@Override
	public int update(int note_sq) {
		System.out.println("SwNoteServiceImpl update ...");
		int result = 0;
		result = snd.update(note_sq);
	return result;
	}

	@Override
	public int total2(int emp_num) {
		System.out.println("SwNoteServiceImpl total2 Start..." );
		int totCnt = snd.total2(emp_num);
		System.out.println("SwNoteServiceImpl total2 totCnt->"+ totCnt );
	return totCnt;
	}
	
	@Override
	public int total3(int emp_num) {
		System.out.println("SwNoteServiceImpl total3 Start..." );
		int totCnt = snd.total3(emp_num);
		System.out.println("SwNoteServiceImpl total3 totCnt->"+ totCnt );
	return totCnt;
	}
}