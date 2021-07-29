package com.oracle.s20210704.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Emp {
	private int    emp_num;		private String dep_num;
	private String team_num;	private String rnk_num;
	private String emp_name;	private String emp_pw;
	private String emp_phnum;	private String emp_zc_addr;
	private String emp_cm_addr;	private String emp_dt_addr;
	private String emp_email;	private Date emp_hiredate;
	private String ph_path;		private int	   ref;

}