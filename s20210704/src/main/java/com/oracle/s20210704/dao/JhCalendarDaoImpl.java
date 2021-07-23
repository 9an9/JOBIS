package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.JhCalendar;



@Repository
public class JhCalendarDaoImpl implements JhCalendarDao {
	
	@Autowired
	private  SqlSession session;

	@Override
	public List<JhCalendar> calList() {
		List<JhCalendar> calList = session.selectList("jhCalList");
		return calList;
	}
}
