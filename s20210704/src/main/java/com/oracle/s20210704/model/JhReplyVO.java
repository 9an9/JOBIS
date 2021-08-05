package com.oracle.s20210704.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JhReplyVO {
	private int rr_num;		//글번호
	private int rrc_num;	//댓글번호
	private String rrc_content; //내용
	private int emp_num;
	private Date rrc_date;
	

}

