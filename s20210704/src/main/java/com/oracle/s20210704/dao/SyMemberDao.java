package com.oracle.s20210704.dao;

import com.oracle.s20210704.model.SyMemberVO;

public interface SyMemberDao {
	
	public SyMemberVO register(SyMemberVO vo); 
	
	
	public SyMemberVO login(SyMemberVO vo); 


}
