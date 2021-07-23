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
	public List<JhCalendar> calList() {
		List<JhCalendar> calList = jcd.calList();
		return calList;
	}
	
}
