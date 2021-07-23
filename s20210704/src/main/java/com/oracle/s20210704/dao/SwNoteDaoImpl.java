package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SwNoteDaoImpl implements SwNoteDao{

	@Autowired
	private SqlSession session;

	@Override
	public List<com.oracle.s20210704.model.Emp> listEmp() {
		List<com.oracle.s20210704.model.Emp> empList = null;
		System.out.println("SwEmpDaoImpl listEmp Start ..." );
		try {
			// Naming Rule 
			empList = session.selectList("swEmpListAll");
		} catch (Exception e) {
			System.out.println("SwEmpDaoImpl listEmp Exception->"+e.getMessage());
		}
		return empList;
	}

	@Override
	public int insertNote_tb(com.oracle.s20210704.model.Note_tb note_tb) {
		int result = 0;
		System.out.println("SwNoteDaoImpl insert Start ..." );
		try {
			result = session.insert("insertNote_tb", note_tb);
		} catch (Exception e) {
			System.out.println("SwNoteDaoImpl insertNote_tb Exception->"+e.getMessage());
		}
		return result;
	}

}
