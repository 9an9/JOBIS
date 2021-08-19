package com.oracle.s20210704.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210704.dao.JhRrDao;
import com.oracle.s20210704.model.JhRr;
import com.oracle.s20210704.model.SyMemberVO;



@Service
public class JhRrServiceImpl implements JhRrService {
	
	@Autowired
	private JhRrDao jrd;
	
	
	@Override
	public List<JhRr> rrList() {
		List<JhRr> rrList = jrd.rrList();
		return rrList;
	}

	@Override
	public int total() {
		System.out.println("JhRrServiceImpl Start total...");
		int totCnt = jrd.total();
		System.out.println("JhRrServiceImpl total totcont-> " + totCnt);
		return totCnt;
	}

	@Override
	public List<JhRr> listJhRr(JhRr jhRr) {
		List<JhRr> jhRrList = null;
		System.out.println("JhRrServiceImpl listJhRr Start...");
		jhRrList = jrd.listJhRr(jhRr);
		System.out.println("JhRrServiceImpl listJhRr jhRrList.size()->"+jhRrList.size());
		return jhRrList;
	}
	//삭제가능
	@Override
	public List<JhRr> listJhRr1(JhRr jhRr) {
		List<JhRr> jhRrList1 = null;
		System.out.println("JhRrServiceImpl listJhRr1 Start...");
		jhRrList1 = jrd.listJhRr1(jhRr);
		System.out.println("JhRrServiceImpl listJhRr jhRrList1.size()->"+jhRrList1.size());
		return jhRrList1;
	}
	@Override
	public List<JhRr> listJhRr2(JhRr jhRr) {
		List<JhRr> jhRrList2 = null;
		System.out.println("JhRrServiceImpl listJhRr1 Start...");
		jhRrList2 = jrd.listJhRr2(jhRr);
		System.out.println("JhRrServiceImpl listJhRr jhRrList1.size()->"+jhRrList2.size());
		return jhRrList2;
	}
	@Override
	public JhRr detail(int rr_num) {
		System.out.println("JhRrServiceImpl detail...");
		JhRr jhRr = null;
		jhRr = jrd.detail(rr_num);
		System.out.println("JhRrServiceImpl detail=>"+rr_num);
		return jhRr;
	}

	@Override
	public SyMemberVO show(SyMemberVO vo) {
		System.out.println("JhRrServiceImpl show...");
		SyMemberVO svo = null;
		svo = jrd.show(vo);
		return svo;
	}
	//글쓰기
	@Override
	public int insert(JhRr jhRr) {
		int result = 0;
		System.out.println("JhRrServiceImpl Start...");
		result = jrd.insert(jhRr);
		return result;
	}
	
	@Override
	public int insert1(JhRr jhRr) {
		int result = 0;
		System.out.println("JhRrServiceImpl Start...");
		result = jrd.insert1(jhRr);
		return result;
	}
	//삭제가능
	@Override
	public int total0() {
		System.out.println("JhRrServiceImpl Start total0()");
		int totCnt0 = jrd.total0();
		System.out.println("JhRrServiceImpl total0 totcnt->" + totCnt0);
		return totCnt0;
	}
	
	//삭제가능
	@Override
	public int total1() {
		System.out.println("JhRrServiceImpl Start total1()");
		int totCnt1 = jrd.total1();
		System.out.println("JhRrServiceImpl total1 totcont-> " + totCnt1);
		return totCnt1;
	}
	
	@Override
	public int total2() {
		System.out.println("JhRrServiceImpl Start total2()");
		int totCnt2 = jrd.total2();
		System.out.println("JhRrServiceImpl total2 totcnt->" + totCnt2);
		return totCnt2;
	}

	@Override
	public int total3() {
		System.out.println("JhRrServiceImpl Start total3()");
		int totCnt3 = jrd.total3();
		System.out.println("JhRrServiceImpl total3 totcnt->" + totCnt3);
		return totCnt3;
	}
	//수정
	@Override
	public int update(JhRr jhRr) {
		System.out.println("JhRrServiceImpl update...");
		int cu = 0;
		cu = jrd.update(jhRr);
		return cu;
	}

	@Override
	public int delete(int rr_num) {
		int result = 0;
		System.out.println("JhRrServiceImpl delete...");
		result = jrd.delete(rr_num);
		return result;
	}

	@Override
	public String depNum(int emp_num) {
		String depnum = null;
		System.out.println("JhCalendarServiceImpl depNum Start");
		depnum = jrd.depNum(emp_num);
		return depnum;
	}


}
