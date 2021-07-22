package com.oracle.s20210704.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YsEmpCmt {
	//emp
	private  int   emp_num;      private String dep_num;      private String team_num;
	private String rnk_num;      private String emp_name;     private String emp_pw;
	private String emp_cm_addr;  private String emp_dt_addr;  private String emp_email;
	private  Date  emp_hiredate; private  int   ref;          private String emp_phnum;
	private String ph_path;
	
	
	//comm
	private String code;
	private String content;
	
	
	//cmt
	private int  cmt_num;      private Date cmt_srt;
	private Date cmt_end;      private Date cmt_md;
	
	
	//조회용
	private String dcontent;     private String tcontent;     private String rcontent;
	private String srttime;      private String endtime;      private String cmt_date;
	private String pageNum;      private  int   start;        private  int   end;
	private String md_str;       private String md_end;
	
	//검색용
	private Date   searchStart;  private Date   searchEnd;    private String searchDept;
	private String searchName;   private Date   absent;
}
