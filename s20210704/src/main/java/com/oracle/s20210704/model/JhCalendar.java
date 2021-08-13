package com.oracle.s20210704.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JhCalendar {
	private int cal_num;
	private int emp_num;
	private String cal_cate;
	private String cal_title;
	private String cal_date;
	private String cal_contents;
	private String cal_bgcolor;
	private String first;
	private String last;
	//날짜에 관련된 달력정보
	private String dep_num;
	
}
