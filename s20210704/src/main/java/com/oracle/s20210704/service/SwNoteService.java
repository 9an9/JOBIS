package com.oracle.s20210704.service;

import java.util.List;

// �����Ͻ� ���� ����
public interface SwNoteService {
	List<com.oracle.s20210704.model.Emp>     listEmp();   // ���ۻ�� ����
	// ������ �����ϱ�
	int           insertNote_tb(com.oracle.s20210704.model.Note_tb note_tb);
}
