package com.oracle.s20210704.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JhCalendar {
	private int cal_num;
	private int emp_num;
	private String cal_cate;
	private String cal_title;
	private Date cal_date;
	private String cal_contents;
	private String cal_bgcolors;
}
