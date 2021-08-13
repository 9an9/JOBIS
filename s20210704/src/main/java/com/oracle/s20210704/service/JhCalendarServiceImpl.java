package com.oracle.s20210704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210704.dao.JhCalendarDao;
import com.oracle.s20210704.model.JhCalendar;



@Service
public class JhCalendarServiceImpl implements JhCalendarService {
	
	@Autowired
	private JhCalendarDao jcd;

	@Override
	public List<JhCalendar> list(JhCalendar jhCalendar) {
		List<JhCalendar> list = jcd.list(jhCalendar);
		return list;
	}

	@Override
	public int insert(JhCalendar jhCalendar) {
		int result = 0;
		System.out.println("jhCalendarServiceImpl Start");
		result = jcd.insert(jhCalendar);
		return result;
	}

	@Override
	public List<JhCalendar> dlist(JhCalendar jhCalendar) {
		System.out.println("JhCalendarServiceImpl dlist Start");
		List<JhCalendar> dlist = jcd.dlist(jhCalendar);
		System.out.println("dlist" + dlist);
		return dlist;
	}

	@Override
	public int delete(int cal_num) {
		int result = 0;
		System.out.println("JhCalendarServiceImpl delete Start");
		result = jcd.delete(cal_num);
		return result;
	}

	@Override
	public String depNum(int emp_num) {
		String depnum = null;
		System.out.println("JhCalendarServiceImpl depNum Start");
		depnum = jcd.depNum(emp_num);
		return depnum;
	}
}

