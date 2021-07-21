package com.oracle.s20210704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210704.dao.YsEmpCmtDao;
import com.oracle.s20210704.model.YsEmpCmt;



@Service
public class YsEmpCmtServiceImpl implements YsEmpCmtService {
	
	@Autowired
	private YsEmpCmtDao ydcd;
	
	@Override
	public List<YsEmpCmt> cmtList(YsEmpCmt ysEmpCmt) {
		List<YsEmpCmt> cmtList = ydcd.cmtList(ysEmpCmt);
		return cmtList;
	}

	@Override
	public int cmtTotal() {
		int cmtTotal = ydcd.cmtTotal();
		return cmtTotal;
	}

	@Override
	public List<YsEmpCmt> cmtDateSearchList(YsEmpCmt ysEmpCmt) {
		 List<YsEmpCmt> cmtDateSearchList = ydcd.cmtDateSearchList(ysEmpCmt);
		return cmtDateSearchList;
	}

	@Override
	public List<YsEmpCmt> cmtDeptSearchList(YsEmpCmt ysEmpCmt) {
		List<YsEmpCmt> cmtDeptSearchList = ydcd.cmtDeptSearchList(ysEmpCmt);
		return cmtDeptSearchList;
	}

	@Override
	public List<YsEmpCmt> cmtNameSearchList(YsEmpCmt ysEmpCmt) {
		List<YsEmpCmt> cmtNameSearchList = ydcd.cmtNameSearchList(ysEmpCmt);
		return cmtNameSearchList;
	}

	@Override
	public List<YsEmpCmt> cmtAllSearchList(YsEmpCmt ysEmpCmt) {
		List<YsEmpCmt> cmtAllSearchList = ydcd.cmtAllSearchList(ysEmpCmt);
		return cmtAllSearchList;
	}

	@Override
	public int cmtDateTotal(YsEmpCmt ysEmpCmt) {
		int cmtDateTotal = ydcd.cmtDateTotal(ysEmpCmt);
		return cmtDateTotal;
	}

	@Override
	public int cmtDeptTotal(YsEmpCmt ysEmpCmt) {
		int cmtDeptTotal = ydcd.cmtDeptTotal(ysEmpCmt);
		return cmtDeptTotal;
	}

	@Override
	public int cmtNameTotal(YsEmpCmt ysEmpCmt) {
		int cmtNameTotal = ydcd.cmtNameTotal(ysEmpCmt);
		return cmtNameTotal;
	}

	@Override
	public int cmtAllTotal(YsEmpCmt ysEmpCmt) {
		int cmtAllTotal = ydcd.cmtAllTotal(ysEmpCmt);
		return cmtAllTotal;
	}

}