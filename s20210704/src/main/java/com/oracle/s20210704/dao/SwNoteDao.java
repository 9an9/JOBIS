package com.oracle.s20210704.dao;

import java.util.List;

import com.oracle.s20210704.model.Emp;
import com.oracle.s20210704.model.Note_tb;

public interface SwNoteDao {
	List<Emp> listEmp();
	// 쪽지함 저장하기
	int           insertNote_tb(Note_tb note_tb);

}