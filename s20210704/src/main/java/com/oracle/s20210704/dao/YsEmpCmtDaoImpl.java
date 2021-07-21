package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.YsEmpCmt;


@Repository
public class YsEmpCmtDaoImpl implements YsEmpCmtDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<YsEmpCmt> cmtList(YsEmpCmt ysEmpCmt) {
		List<YsEmpCmt> cmtList = session.selectList("ysCmtList",ysEmpCmt);
		return cmtList;
	}

	@Override
	public int cmtTotal() {
		int cmtTotal = session.selectOne("ysCmtTotal");
		return cmtTotal;
	}

	@Override
	public List<YsEmpCmt> cmtDateSearchList(YsEmpCmt ysEmpCmt) {
		List<YsEmpCmt> cmtDateSearchList = session.selectList("ysCmtDateSearchList",ysEmpCmt);
		return cmtDateSearchList;
	}

	@Override
	public List<YsEmpCmt> cmtDeptSearchList(YsEmpCmt ysEmpCmt) {
		List<YsEmpCmt> cmtDeptSearchList = session.selectList("ysCmtDeptSearchList",ysEmpCmt);
		return cmtDeptSearchList;
	}

	@Override
	public List<YsEmpCmt> cmtNameSearchList(YsEmpCmt ysEmpCmt) {
		List<YsEmpCmt> cmtNameSearchList = session.selectList("ysCmtNameSearchList",ysEmpCmt);
		return cmtNameSearchList;
	}

	@Override
	public List<YsEmpCmt> cmtAllSearchList(YsEmpCmt ysEmpCmt) {
		List<YsEmpCmt> cmtAllSearchList = session.selectList("ysCmtAllSearchList",ysEmpCmt);
		return cmtAllSearchList;
	}

	@Override
	public int cmtDateTotal(YsEmpCmt ysEmpCmt) {
		int cmtDateTotal = session.selectOne("ysCmtDateTotal",ysEmpCmt);
		return cmtDateTotal;
	}

	@Override
	public int cmtDeptTotal(YsEmpCmt ysEmpCmt) {
		int cmtDeptTotal = session.selectOne("ysCmtDeptTotal",ysEmpCmt);
		return cmtDeptTotal;
	}

	@Override
	public int cmtNameTotal(YsEmpCmt ysEmpCmt) {
		int cmtNameTotal = session.selectOne("ysCmtNameTotal",ysEmpCmt);
		return cmtNameTotal;
	}

	@Override
	public int cmtAllTotal(YsEmpCmt ysEmpCmt) {
		int cmtAllTotal = session.selectOne("ysCmtAllTotal",ysEmpCmt);
		return cmtAllTotal;
	}

}