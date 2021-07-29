package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.SwNote_rcv_tb;
import com.oracle.s20210704.model.SwNote_tb;


@Repository
public class SwNoteDaoImpl implements SwNoteDao{

	@Autowired
	private SqlSession session;

	@Override
	public List<com.oracle.s20210704.model.SwNote_rcv_tb> listSwNote_rcv_tb(int emp_num) {
		List<com.oracle.s20210704.model.SwNote_rcv_tb> SwNote_rcv_tbList = null;
		System.out.println("SwEmpDaoImpl listSwNote_rcv_tb() Start ..." );
		System.out.println("SwEmpDaoImpl listSwNote_rcv_tb() emp_num->"+emp_num);
		try {
			// Naming Rule 
			SwNote_rcv_tbList = session.selectList("swNote_rcv_tbListAll", emp_num);
		} catch (Exception e) {
			System.out.println("SwEmpDaoImpl SwNote_rcv_tbList Exception->"+e.getMessage());
		}
		return SwNote_rcv_tbList;
	}
	
	@Override
	public List<com.oracle.s20210704.model.SwNote_tb> listSwNote_tb(int emp_num) {
		List<com.oracle.s20210704.model.SwNote_tb> SwNote_tbList = null;
		System.out.println("SwEmpDaoImpl listSwNote_tb() Start ..." );
		System.out.println("SwEmpDaoImpl listSwNote_tb() emp_num->"+emp_num);
		try {
			// Naming Rule 
			SwNote_tbList = session.selectList("swNote_tbListAll", emp_num);
		} catch (Exception e) {
			System.out.println("SwEmpDaoImpl listSwNote_tb Exception->"+e.getMessage());
		}
		return SwNote_tbList;
	}
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
	public int insertNote_tb(com.oracle.s20210704.model.SwNote_tb swnote_tb) {
		int result = 0;
		System.out.println("SwNoteDaoImpl insert Start ..." );
		try {
			result = session.insert("insertNote_tb", swnote_tb);
		} catch (Exception e) {
			System.out.println("SwNoteDaoImpl insertNote_tb Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int insertNote_rcv_tb(com.oracle.s20210704.model.SwNote_rcv_tb swnote_rcv_tb) {
		int result2 = 0;
		System.out.println("SwNoteDaoImpl Note_rcv_tb insert Start ..." );
		try {
			result2 = session.insert("insertSwNote_rcv_tb", swnote_rcv_tb);
		} catch (Exception e) {
			System.out.println("SwNote_rcv_tb DaoImpl insertswNote_rcv_tb Exception->"+e.getMessage());
		}
		return result2;
	}

	@Override
	public int delete(String checks) {
		System.out.println("SwNoteDaoImpl delete Start...");
		int result1 = 0;
		try {
			result1  = session.delete("delete", checks);
			System.out.println("SwNoteDaoImpl noteDelete result1->" + result1);
		} catch (Exception e) {
			System.out.println("SwNoteDaoImpl noteDelete Exception->"+e.getMessage());
		}

		// TODO Auto-generated method stub
		return result1;
	}

	@Override
	public int delete2(String checks) {
		System.out.println("SwNoteDaoImpl delete2 Start...");
		int result2 = 0;
		try {
			result2  = session.delete("delete2", checks);
			System.out.println("SwNoteDaoImpl noteDelete result2->" + result2);
		} catch (Exception e) {
			System.out.println("SwNoteDaoImpl noteDelete Exception->"+e.getMessage());
		}

		// TODO Auto-generated method stub
		return result2;
	}

//	@Override
//	public List<com.oracle.s20210704.model.SwNote_tb> SentNoteList(int emp_num) {
//		List<com.oracle.s20210704.model.SwNote_tb> SentNoteList = null;
//		System.out.println("SwEmpDaoImpl SentNoteList() Start ..." );
//		System.out.println("SwEmpDaoImpl SentNoteList() emp_num->"+emp_num);
//		try {
//			// Naming Rule 
//			SentNoteList = session.selectList("SentNoteList", emp_num);
//		} catch (Exception e) {
//			System.out.println("SwEmpDaoImpl listSwNote_tb Exception->"+e.getMessage());
//		}
//		return SentNoteList;
//	}
}