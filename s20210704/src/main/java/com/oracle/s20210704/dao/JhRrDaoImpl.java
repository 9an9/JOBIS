package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.JhRr;
import com.oracle.s20210704.model.SyMemberVO;



@Repository
public class JhRrDaoImpl implements JhRrDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<JhRr> rrList() {
		List<JhRr> rrList = session.selectList("jhRrList");
		return rrList;
	}

	@Override
	public int total() {
		int tot = 0;
		System.out.println("JhRrDaoImpl Start total...");
		try {
			tot = session.selectOne("jhRrtotal");
			System.out.println("jhRrDaoImpl Start total...");
		} catch(Exception e) {
			System.out.println("jhRrDaoImpl total Exception-> "+e.getMessage());
		}
		return tot;
	}

	@Override
	public List<JhRr> listJhRr(JhRr jhRr) {
		List<JhRr> jhRrList = null;
		System.out.println("JhRrDaoImpl listjhRr Start...");
		try {
			jhRrList = session.selectList("jhRrListAll", jhRr);
		} catch(Exception e) {
			System.out.println("JhRrDaoImpl listjhRr Exception ->" + e.getMessage());
		}
		return jhRrList;
	}

	@Override
	public JhRr detail(int rr_num) {
		System.out.println("JhRrDaoImpl detail start...");
		JhRr jhRr = new JhRr();
		try {
			jhRr = session.selectOne("jhRrSelOne", rr_num);		
			System.out.println("JhRrDaoImpl detail getRrcontent->" + jhRr.getRr_content());
		} catch(Exception e) {
			System.out.println("JhRrDaoImpl detail Exception-> "+e.getMessage());
		}
		return jhRr;
	}

	@Override
	public SyMemberVO show(SyMemberVO vo) {
		System.out.println("JhRrDaoImpl SyMemberVO show start...");
		SyMemberVO syMemberVO = null;
		try {
			syMemberVO = session.selectOne("jhshow", vo);
		} catch (Exception e) {
			System.out.println("JhRrDaoImplyu SyMemeberVO Exception->" + e.getMessage());
		}
		return syMemberVO;
	}

}
