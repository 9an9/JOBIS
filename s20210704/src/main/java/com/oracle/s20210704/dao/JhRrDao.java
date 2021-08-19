package com.oracle.s20210704.dao;

import java.util.List;

import com.oracle.s20210704.model.JhRr;
import com.oracle.s20210704.model.SyMemberVO;



public interface JhRrDao {

	List<JhRr> rrList();

	int total();

	List<JhRr> listJhRr(JhRr jhRr);
	
	//삭제가능
	List<JhRr> listJhRr1(JhRr jhRr);
	
	List<JhRr> listJhRr2(JhRr jhRr);
	
	JhRr detail(int rr_num);

	SyMemberVO show(SyMemberVO vo);

	int insert(JhRr jhRr);

	int insert1(JhRr jhRr);
	
	//삭제가능
	int total0();
	//삭제가능
	int total1();
	//삭제가능
	int total2();
	//삭제가능
	int total3();
	//수정기능
	int update(JhRr jhRr);
	//삭제기능
	int delete(int rr_num);

	String depNum(int emp_num);
}
