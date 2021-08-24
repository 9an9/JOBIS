package com.oracle.s20210704.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwMsg_rcv {
	
	private int  msg_sq;		private int emp_num;
	private Date read_dt;		private int read_count;
	
	//조회용
	private String emp_name;	private int    emp_num2;
	private String msg_title;	private String msg_content;
	private String msg_fl_nm;	private String msg_fl_path;
	private Date   snd_dt;		private String recv_emp_name;
	
	//페이징
	private int start;			private int end;
	}