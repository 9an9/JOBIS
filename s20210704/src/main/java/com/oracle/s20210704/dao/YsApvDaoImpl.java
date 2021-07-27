package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.YsApv;

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


}
