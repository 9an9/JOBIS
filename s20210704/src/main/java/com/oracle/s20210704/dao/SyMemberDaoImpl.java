package com.oracle.s20210704.dao;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.SyMemberVO;



@Repository
public class SyMemberDaoImpl implements SyMemberDao{
	
	@Autowired 
	private SqlSession sql;

	@Override
	public SyMemberVO register(SyMemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SyMemberVO login(SyMemberVO vo) {
		// TODO Auto-generated method stub
		return sql.selectOne("sylogin",vo);
	}
	
	
	

}
