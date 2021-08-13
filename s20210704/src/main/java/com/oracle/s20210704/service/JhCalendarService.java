package com.oracle.s20210704.service;

import java.util.List;

import com.oracle.s20210704.model.JhCalendar;



public interface JhCalendarService {

	List<JhCalendar> list(JhCalendar jhCalendar);

	int insert(JhCalendar jhCalendar);

	List<JhCalendar> dlist(JhCalendar jhCalendar);

	int delete(int cal_num);

	String depNum(int emp_num);

//	List<JhCalendar> list(JhCalendar jhCalendar);
}
