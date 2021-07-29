package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.YsApv;
import com.oracle.s20210704.model.YsEmpCmt;

@Repository
public class YsApvDaoImpl implements YsApvDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public int rcvTotal(int rcv_num) {
		int rcvTotal = session.selectOne("ysRcvTotal", rcv_num);
		return rcvTotal;
	}
	
	@Override
	public List<YsApv> apv_RcvList(YsApv ysApv) {
		List<YsApv> apv_RcvList = session.selectList("ysApvRcvList", ysApv);
		return apv_RcvList;
	}

	@Override
	public int sndTotal(int snd_num) {
		int sndTotal = session.selectOne("ysSndTotal", snd_num);
		return sndTotal;
	}

	@Override
	public List<YsApv> apv_SndList(YsApv ysApv) {
		List<YsApv> apv_SndList = session.selectList("ysApvSndList", ysApv);
		return apv_SndList;
	}

	@Override
	public List<YsEmpCmt> rcvList1(int emp_num) {
		List<YsEmpCmt> rcvList1 = session.selectList("ysRcvList1", emp_num);
		return rcvList1;
	}

	@Override
	public List<YsEmpCmt> rcvList2(int emp_num) {
		List<YsEmpCmt> rcvList2 = session.selectList("ysRcvList2", emp_num);
		return rcvList2;
	}

	@Override
	public List<YsEmpCmt> rcvList3(int emp_num) {
		List<YsEmpCmt> rcvList3 = session.selectList("ysRcvList3", emp_num);
		return rcvList3;
	}

	@Override
	public List<YsEmpCmt> rcvList4() {
		List<YsEmpCmt> rcvList4 = session.selectList("ysRcvList4");
		return rcvList4;
	}

	@Override
	public List<YsEmpCmt> rcvList567(String rnk) {
		List<YsEmpCmt> rcvList567 = session.selectList("ysRcvList567", rnk);
		return rcvList567;
	}

	@Override
	public List<YsEmpCmt> rcvList8() {
		List<YsEmpCmt> rcvList8 = session.selectList("ysRcvList8");
		return rcvList8;
	}

	@Override
	public void midRcvInsert(YsApv ysApv) {
		session.insert("ysMidRcvInsert", ysApv);	
	}

	@Override
	public void fnlRcvInsert(YsApv ysApv) {
		session.insert("ysFnlRcvInsert", ysApv);
	}

	@Override
	public YsApv rcvDetail(YsApv ysApv) {
		YsApv rcvDetail = new YsApv();
		String chk = session.selectOne("ysRcvChk", ysApv);
		if(chk != null) {      //중간결재
			System.out.println("중간결재입니다");
			rcvDetail = session.selectOne("ysMidRcv", ysApv);
		}else {            //최종결재
			System.out.println("최종결재입니다");
			rcvDetail = session.selectOne("ysFnlRcv", ysApv);
		}	
		return rcvDetail;
	}

	@Override
	public void midOk(YsApv ysApv) {
		session.update("ysMidOk", ysApv);
		
	}

	@Override
	public void midToFnlOk(YsApv ysApv) {
		session.update("ysMTFok", ysApv);
		
	}

	@Override
	public void fnlOk(YsApv ysApv) {
		session.update("ysFnlOk", ysApv);
		
	}


}
