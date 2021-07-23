package com.oracle.s20210704.service;

import java.util.List;

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

}
