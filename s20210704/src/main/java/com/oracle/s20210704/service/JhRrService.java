package com.oracle.s20210704.service;

import java.util.List;

import com.oracle.s20210704.model.JhRr;
import com.oracle.s20210704.model.SyMemberVO;


public interface JhRrService {

	List<JhRr> rrList();

	int total();

	List<JhRr> listJhRr(JhRr jhRr);

	JhRr detail(int rr_num);

	SyMemberVO show(SyMemberVO vo);

	int insert(JhRr jhRr);
	
	List<JhRr> listJhRr1(JhRr jhRr);
	
	int total0();
	
	int total1();
	
	int total2();
	
	int total3();

	int update(JhRr jhRr);
}
