package com.oracle.s20210704.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwNote_rcv_tb {
	private int  note_sq;	private int emp_num;
	private Date rcv_dt;	private int read_count;
}
