package com.oracle.s20210704.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YjEmp {
	//사원관리
	private String emp_num;			private String emp_name;
	private String emp_email;		private String emp_phnum;		
	private String emp_hiredate;	private int ref;
	private String emp_zc_addr;		private String emp_cm_addr;
	private String emp_dt_addr;		

	//조회용
	private String dept;			private String team;
	private String rank;			private String address;
	
	private int search;   		private String keyword;
	private String pageNum;  
	private int start; 		 		private int end;
	
	private int empno;
	

	
}
