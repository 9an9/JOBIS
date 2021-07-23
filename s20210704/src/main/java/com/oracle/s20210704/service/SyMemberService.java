package com.oracle.s20210704.service;

import com.oracle.s20210704.model.SyMemberVO;

public interface SyMemberService {
	
	public void register(SyMemberVO vo) ;
	
	public SyMemberVO login(SyMemberVO vo) ;

}
