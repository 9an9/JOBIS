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
	public List<YsApv> apv_RcvList(YsApv ysApv) {
		List<YsApv> apv_RcvList = session.selectList("ysApvRcvList", ysApv);
		return apv_RcvList;
	}

}
