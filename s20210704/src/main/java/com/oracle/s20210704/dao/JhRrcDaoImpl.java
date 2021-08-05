package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.JhReplyVO;

@Repository
public class JhRrcDaoImpl implements JhRrcDao {

	@Autowired
	private SqlSession session;
	//댓글조회
	@Override
	public List<JhReplyVO> readReply(int rr_num) throws Exception {
		return session.selectList("readReply", rr_num);
	}
	//댓글작성
	@Override
	public void writeReply(JhReplyVO jvo) throws Exception {
		session.insert("writeReply", jvo);
	}
	@Override
	public void updateReply(JhReplyVO jvo) throws Exception {
		session.update("updateReply", jvo);
	}
	@Override
	public int deleteReply(int rrc_num){
		int result = 0;
		try {
			result = session.delete("deleteReply", rrc_num);
		} catch (Exception e) {
			System.out.println("JhRrcDaoImpl delete Exception-> " +e.getMessage());
		}
		return result;
	}

}
