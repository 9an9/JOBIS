package com.oracle.s20210704.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwNote_tb {
                                  
	private int    note_sq;		private int    emp_num;
	private String note_nm; 	private String note_cnt;
	private String note_fl_nm;  private String note_fl_link;
	private Date   snd_dt;

	private int    emp_num2;
	
	// 조회용
	private String emp_name;
	private Date   rcv_dt;
}
