package com.oracle.s20210704.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwMsg {
	
	private int    msg_sq;			private int msg_type;
	private int    emp_num;			private String msg_title;
	private String msg_content; 	private String msg_fl_nm;
	private String msg_fl_path; 	private Date   snd_dt;
	
	// 조회용
	private int    emp_num2;
	private String emp_name;
	private Date   read_dt;
		
	//페이징
	private int start;			private int end;
	
	}
