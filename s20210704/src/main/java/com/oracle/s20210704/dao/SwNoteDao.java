package com.oracle.s20210704.dao;

import java.util.List;

import com.oracle.s20210704.model.Emp;
import com.oracle.s20210704.model.SwNote_tb;

public interface SwNoteDao {
	List<Emp> listEmp();
	// ������ �����ϱ�
	int           insertNote_tb(SwNote_tb note_tb);

}