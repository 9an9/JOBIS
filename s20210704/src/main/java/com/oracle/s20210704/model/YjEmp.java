package com.oracle.s20210704.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YjEmp {
	//사원관리
	private int emp_num;			private String emp_name;
	private String emp_email;		private String emp_phnum;		
	private String emp_hiredate;	private int ref;
	private String emp_zc_addr;		private String emp_cm_addr;
	private String emp_dt_addr;		private String dep_num;
	private String team_num;		private String rnk_num;
	private String ph_name;

	//조회용
	private String dept;			private String team;
	private String rank;			private String dcode;
	private String tcode;			private String rcode;
	private String address;
	
	private int search;   			private String keyword;
	private String pageNum;  
	private int start; 		 		private int end;
	
	private int empno;
	
	//개인정보수정
	private String emp_pw;			private String newpw;
	private String ph_path;
	

	
}
