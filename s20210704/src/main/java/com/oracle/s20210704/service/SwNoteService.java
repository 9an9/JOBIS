package com.oracle.s20210704.service;

import java.util.List;


public interface SwNoteService {
	List<com.oracle.s20210704.model.Emp>  		   listEmp();   
	List<com.oracle.s20210704.model.SwNote_rcv_tb> listSwNote_rcv_tb(int emp_num);
	List<com.oracle.s20210704.model.SwNote_tb> 	   listSwNote_tb(int emp_num);
	int     delete(String checks);
	int     delete2(String checks);
	int     insertNote_tb	   (com.oracle.s20210704.model.SwNote_tb swnote_tb);
	int		insertNote_rcv_tb(com.oracle.s20210704.model.SwNote_rcv_tb swnote_rcv_tb);
}