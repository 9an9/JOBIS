package com.oracle.s20210704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210704.dao.JhRrcDao;
import com.oracle.s20210704.model.JhReplyVO;

@Service
public class JhRrcServiceImpl implements JhRrcService {

	@Autowired
	private JhRrcDao jrcd;
	//댓글 조호
	@Override
	public List<JhReplyVO> readReply(int rr_num) throws Exception {
		
		return jrcd.readReply(rr_num);
	}
	//댓글 작성
	@Override
	public void writeReply(JhReplyVO jvo) throws Exception {
		jrcd.writeReply(jvo);
	}
	//댓글 수정
	@Override
	public void updateReply(JhReplyVO jvo) throws Exception {
		jrcd.updateReply(jvo);
	}
	//댓글 삭제
	@Override
	public int deleteReply(int rrc_num) {
		int result = 0;
		System.out.println("JhRrcServiceImpl deleteReply");
		result = jrcd.deleteReply(rrc_num);
		return result;
	}

}
