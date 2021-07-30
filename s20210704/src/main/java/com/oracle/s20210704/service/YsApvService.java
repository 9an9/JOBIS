package com.oracle.s20210704.service;

import java.util.List;

import com.oracle.s20210704.model.YsApv;
import com.oracle.s20210704.model.YsEmpCmt;

public interface YsApvService {
	int            rcvTotal(int rcv_num);
	int            sndTotal(int snd_num);
	List<YsApv>    apv_RcvList(YsApv ysApv);
	List<YsApv>    apv_SndList(YsApv ysApv);
	List<YsEmpCmt> rcvList1(int emp_num);
	List<YsEmpCmt> rcvList2(int emp_num);
	List<YsEmpCmt> rcvList3(int emp_num);
	List<YsEmpCmt> rcvList4();
	List<YsEmpCmt> rcvList567(String rnk);
	List<YsEmpCmt> rcvList8();
	void           midRcvInsert(YsApv ysApv);
	void           fnlRcvInsert(YsApv ysApv);
	YsApv          rcvDetail(YsApv ysApv);
	void           midOk(YsApv ysApv);
	void           midToFnlOk(YsApv ysApv);
	void           fnlOk(YsApv ysApv);
	void		   apv_no(YsApv ysApv);
}
