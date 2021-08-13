package com.oracle.s20210704.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.s20210704.model.JhCalendar;
import com.oracle.s20210704.model.JhReplyVO;

@Service
public interface JhRrcService {
	//댓글 조회
	public List<JhReplyVO> readReply(int rr_num) throws Exception;
	//댓글 작성
	public void writeReply(JhReplyVO jvo) throws Exception;
	//댓글 수정
	public void updateReply(JhReplyVO jvo) throws Exception;
	//댓글 삭제
	int deleteReply(int rrc_num);
}