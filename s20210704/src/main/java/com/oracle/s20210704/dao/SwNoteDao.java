package com.oracle.s20210704.dao;

import java.util.List;

import com.oracle.s20210704.model.Emp;
import com.oracle.s20210704.model.SwNote_rcv_tb;
import com.oracle.s20210704.model.SwNote_tb;

public interface SwNoteDao {
	List<Emp> listEmp();
	List<SwNote_rcv_tb> listSwNote_rcv_tb(int emp_num);
	List<SwNote_tb>		listSwNote_tb(int emp_num);
//	List<SentNoteList>	SentNoteList(int emp_num);
	int          		delete(String checks);
	int           		delete2(String checks);
	int           		insertNote_tb(SwNote_tb note_tb);
	int           		insertNote_rcv_tb(SwNote_rcv_tb note_rcv_tb);
}