package com.oracle.s20210704.model;



import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JhRr {
	private int rr_num;
	private int emp_num;
	private int rr_type;
	private String rr_subject;
	private String rr_content;
	private int rr_hits;
	private String rr_path;
	private String rr_filename;
	private Date rr_date;
	
	private String search;   private String keyword;
	private String pageNum;  
	private int start; 		 private int end;

	private int empnum;
	private int rsubject;
	private int rnum;
	private String emp_name;
	
}
