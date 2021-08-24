package com.oracle.s20210704.service;

import java.util.List;
import com.oracle.s20210704.model.SwMsg;
import com.oracle.s20210704.model.SwMsg_rcv;
import com.oracle.s20210704.model.YjEmp;


public interface SwMsgService {
	List<SwMsg> 	   msgList(SwMsg swmsg);
	List<SwMsg_rcv>    msg_rcvList(SwMsg_rcv swmsg_rcv);
	List<YjEmp>  	   listEmp();   
	List<SwMsg_rcv>    sentDetailMsg(int note_sq);
	List<SwMsg> 	   rcvDetailMsg(int note_sq);
	int 		       total(int emp_num); 
	int    			   delete(String checks);
	int 			   total2(int emp_num); 
	int     		   insertMsg(SwMsg swmsg);
	int				   insertMsg_rcv(SwMsg_rcv swmsg_rcv);
	int				   unreadMsg(int emp_num);
	int				   update(int note_sq);
	}