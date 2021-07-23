package com.oracle.s20210704.service;

import java.sql.Date;
import java.util.List;

import com.oracle.s20210704.model.YsEmpCmt;



public interface YsEmpCmtService {
	int            cmtTotal();
	int            cmtDateTotal(YsEmpCmt ysEmpCmt);
	int            cmtDeptTotal(YsEmpCmt ysEmpCmt);
	int            cmtNameTotal(YsEmpCmt ysEmpCmt);
	int            cmtAllTotal(YsEmpCmt ysEmpCmt);
	List<YsEmpCmt> cmtList(YsEmpCmt ysEmpCmt);
	List<YsEmpCmt> cmtDateSearchList(YsEmpCmt ysEmpCmt);
	List<YsEmpCmt> cmtDeptSearchList(YsEmpCmt ysEmpCmt);
	List<YsEmpCmt> cmtNameSearchList(YsEmpCmt ysEmpCmt);
	List<YsEmpCmt> cmtAllSearchList(YsEmpCmt ysEmpCmt);
	///결근
	List<YsEmpCmt> absentList(Date absent);
	//상태수정
	void           cmtInsert(YsEmpCmt ysEmpCmt);
	
}
