package com.oracle.s20210704.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210704.dao.SyMemberDao;
import com.oracle.s20210704.model.SyMemberVO;



@Service
public class SyMemberServiceImpl implements SyMemberService {

	@Autowired 
	private SyMemberDao dao;
	
	@Override
	public void register(SyMemberVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SyMemberVO login(SyMemberVO vo){
		// TODO Auto-generated method stub
		return dao.login(vo);
	}
	

}
