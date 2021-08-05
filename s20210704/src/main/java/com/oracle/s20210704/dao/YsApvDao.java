package com.oracle.s20210704.dao;

import java.util.List;

import com.oracle.s20210704.model.YsApv;
import com.oracle.s20210704.model.YsEmpCmt;

public interface YsApvDao {
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
	List<YsApv>    apv_ing(int apv_sq);
	int            unreadTotal(int emp_num);
	YsApv          sndDetail(int apv_sq);
	int            apvNoTotal(int emp_num);
	YsApv          nextEmp(int apv_sq);
	void           midSndDelete(int apv_sq);
	void           fnlSndDelete(int apv_sq);
}
