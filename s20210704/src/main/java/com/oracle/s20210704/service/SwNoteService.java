package com.oracle.s20210704.service;

import java.util.List;

import com.oracle.s20210704.model.SwNote_tb;
import com.oracle.s20210704.model.SwNote_rcv_tb;
import com.oracle.s20210704.model.Emp;


public interface SwNoteService {
	List<Emp>  		       listEmp();   
	List<SwNote_rcv_tb>    listSwNote_rcv_tb(SwNote_rcv_tb swnote_rcv_tb);
	List<SwNote_rcv_tb>    sentDetailNote(int note_sq);
	List<SwNote_tb> 	   listSwNote_tb(SwNote_tb swnote_tb);
	List<SwNote_tb> 	   receiveDetailNote(int note_sq);
	
	int     total();			//전체 Count
	int 	total2(int emp_num);//emp_num 기준 Count
	int 	total3(int emp_num);//emp_num 기준 Count
	int     delete1(String checks);
	int     delete2(String checks);
	int     insertNote_tb	  (SwNote_tb swnote_tb);
	int		insertNote_rcv_tb (SwNote_rcv_tb swnote_rcv_tb);
	int		update(int note_sq);
}