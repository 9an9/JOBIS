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
	public List<JhCalendar> list(JhCalendar jhCalendar) {
		List<JhCalendar> list = session.selectList("jhList",jhCalendar);
		return list;
	}

	@Override
	public int insert(JhCalendar jhCalendar) {
		int result = 0;
		System.out.println("JhCalendarDaoImpl insert Start...");
		try {
			result = session.insert("jhInsertJhCalendar", jhCalendar);
		} catch(Exception e) {
			System.out.println("jhCalendarDaoImpl insert Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public List<JhCalendar> dlist(JhCalendar jhCalendar) {
		System.out.println("JhCalendarDaoImpl dlist Start");
		List<JhCalendar> dlist = session.selectList("jhDList", jhCalendar);
		System.out.println("JhCalendarDaoImpl " + dlist);
		return dlist;
	}

	@Override
	public int delete(int cal_num) {
		int result = 0;
		System.out.println("JhCalendarDaoImpl deleter start");
		try {
			result = session.delete("jhCDelete",cal_num);
			System.out.println("jhCalendarDaoImpl delete result -> "+result);
		} catch(Exception e) {
			System.out.println("jhCalendarDaoImpl delete Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public String depNum(int emp_num) {
		String depnum = null;
		System.out.println("JhCalendarDaoImpl depNum Start..");
		try {
			depnum = session.selectOne("depNum", emp_num);
		} catch(Exception e) {
			System.out.println("JhCalendarDaoImpl depNum Exception -> " + e.getMessage());
		}
		return depnum;
	}
}
