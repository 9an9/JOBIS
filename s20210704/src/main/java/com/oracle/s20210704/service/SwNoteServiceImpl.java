package com.oracle.s20210704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SwNoteServiceImpl implements SwNoteService {
	
	@Autowired
	private com.oracle.s20210704.dao.SwNoteDao snd;
	
	@Override
	public List<com.oracle.s20210704.model.Emp> listEmp() {
		List<com.oracle.s20210704.model.Emp> empLists = null;
		System.out.println("SwNoteServiceImpl listEmp Start..." );
		empLists = snd.listEmp();
		System.out.println("SwNoteServiceImpl listEmp empList.size()->" +empLists.size());
		return empLists;
	}

	@Override
	public int insertNote_tb(com.oracle.s20210704.model.SwNote_tb swnote_tb) {
		System.out.println("SwNoteServiceImpl insertNote_tb Start..." );
		int result = snd.insertNote_tb(swnote_tb);
		return result;
	}

	@Override
	public int insertNote_rcv_tb(com.oracle.s20210704.model.SwNote_rcv_tb swnote_rcv_tb) {
		System.out.println("SwNoteServiceImpl insertNote_rcv_tb Start..." );
		int result2 = snd.insertNote_rcv_tb(swnote_rcv_tb);
		return result2;
	}

	@Override
	public List<com.oracle.s20210704.model.SwNote_rcv_tb> listSwNote_rcv_tb(int emp_num) {
		List<com.oracle.s20210704.model.SwNote_rcv_tb> listSwNote_rcv_tb = null;
		System.out.println("SwNoteServiceImpl listEmp Start..." );
		listSwNote_rcv_tb = snd.listSwNote_rcv_tb(emp_num);
		System.out.println("SwNoteServiceImpl listSwNote_rcv_tb listSwNote_rcv_tb.size()->" + listSwNote_rcv_tb.size());
		return listSwNote_rcv_tb;
	}

	@Override
	public List<com.oracle.s20210704.model.SwNote_tb> listSwNote_tb(int emp_num) {
		List<com.oracle.s20210704.model.SwNote_tb> listSwNote_tb = null;
		System.out.println("SwNoteServiceImpl listSwNote_tb Start..." );
		listSwNote_tb = snd.listSwNote_tb(emp_num);
		System.out.println("SwNoteServiceImpl listEmp empList.size()->" + listSwNote_tb.size());
		return listSwNote_tb;
	}

	@Override
	public int delete(String checks) {
		int result1 = 0;
		System.out.println("SwNoteServiceImpl delete Start..." );
		result1 = snd.delete(checks);
		return result1;
	}

	@Override
	public int delete2(String checks) {
		int result2 = 0;
		System.out.println("SwNoteServiceImpl delete2 Start..." );
		result2 = snd.delete2(checks);
		return result2;
	}
}