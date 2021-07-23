package com.oracle.s20210704.service;

import java.util.List;

// 비지니스 업무 수행
public interface SwNoteService {
	List<com.oracle.s20210704.model.Emp>     listEmp();   // 전송사원 선택
	// 쪽지함 저장하기
	int           insertNote_tb(com.oracle.s20210704.model.Note_tb note_tb);
}
