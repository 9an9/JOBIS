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

}
