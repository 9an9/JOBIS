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
	public int insertNote_tb(com.oracle.s20210704.model.Note_tb note_tb) {
		System.out.println("SwNoteServiceImpl insertNote_tb Start..." );
		// DAO 쪽지함 저장하기 호출 
		int result = snd.insertNote_tb(note_tb);
		return 0;
	}
	

}
