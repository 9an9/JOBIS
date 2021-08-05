package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.SwNote_rcv_tb;
import com.oracle.s20210704.model.SwNote_tb;
import com.oracle.s20210704.model.Emp;


@Repository
public class SwNoteDaoImpl implements SwNoteDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<SwNote_tb> receiveDetailNote(int note_sq) {
		List<SwNote_tb> receiveDetailNote = null;
		System.out.println("SwEmpDaoImpl receiveDetailNote() Start ..." );
		try {
			receiveDetailNote = session.selectList("receiveDetailNote", note_sq);
		} catch (Exception e) {
			System.out.println("SwEmpDaoImpl receiveDetailNote() Exception->"+e.getMessage());
		}
	return receiveDetailNote;
	}
	
	@Override
	public List<SwNote_rcv_tb> listSwNote_rcv_tb(SwNote_rcv_tb swnote_rcv_tb) {
		List<SwNote_rcv_tb> SwNote_rcv_tbList = null;
		System.out.println("SwEmpDaoImpl listSwNote_rcv_tb() Start ..." );
		try {
			SwNote_rcv_tbList = session.selectList("listSwNote_rcv_tb", swnote_rcv_tb);
		} catch (Exception e) {
			System.out.println("SwEmpDaoImpl listSwNote_rcv_tb Exception->"+e.getMessage());
		}
	return SwNote_rcv_tbList;
	}
	
	@Override
	public List<SwNote_tb> listSwNote_tb(SwNote_tb swnote_tb) {
		List<SwNote_tb> SwNote_tbList = null;
		System.out.println("SwEmpDaoImpl listSwNote_tb() Start ..." );
		try {
			// Naming Rule 
			SwNote_tbList = session.selectList("listSwNote_tb", swnote_tb);
		} catch (Exception e) {
			System.out.println("SwEmpDaoImpl listSwNote_tb Exception->"+e.getMessage());
		}
	return SwNote_tbList;
	}
	
	@Override
	public List<Emp> listEmp() {
		List<Emp> empList = null;
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
	public int insertNote_tb(SwNote_tb swnote_tb) {
		int result1 = 0;
		System.out.println("SwNoteDaoImpl insertNote_tb Start ..." );
		try {
			result1 = session.insert("insertNote_tb", swnote_tb);
		} catch (Exception e) {
			System.out.println("SwNoteDaoImpl insertNote_tb Exception->"+e.getMessage());
		}
	return result1;
	}

	@Override
	public int insertNote_rcv_tb(SwNote_rcv_tb swnote_rcv_tb) {
		int result2 = 0;
		System.out.println("SwNoteDaoImpl insert Note_rcv_tb Start ..." );
		try {
			result2 = session.insert("insertSwNote_rcv_tb", swnote_rcv_tb);
		} catch (Exception e) {
			System.out.println("SwNoteDaoImpl insert Note_rcv_tb Exception->"+e.getMessage());
		}
	return result2;
	}

	@Override
	public int delete1(String checks) {
		System.out.println("SwNoteDaoImpl delete1 Start...");
		int result1 = 0;
		try {
			result1  = session.delete("delete1", checks);
			System.out.println("SwNoteDaoImpl delete1 result1->" + result1);
		} catch (Exception e) {
			System.out.println("SwNoteDaoImpl delete1 Exception->"+e.getMessage());
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
			System.out.println("SwNoteDaoImpl delete2 result2->" + result2);
		} catch (Exception e) {
			System.out.println("SwNoteDaoImpl delete2 Exception->"+e.getMessage());
		}
	return result2;
	}
	
	@Override
	public List<SwNote_rcv_tb> sentDetailNote(int note_sq) {
		List<SwNote_rcv_tb> sentDetailNote = null;
		System.out.println("SwEmpDaoImpl sentDetailNote() Start ..." );
		try {
			// Naming Rule 
			sentDetailNote = session.selectList("sentDetailNote", note_sq);
		} catch (Exception e) {
			System.out.println("SwEmpDaoImpl sentDetailNote() Exception->"+e.getMessage());
		}
	return sentDetailNote;
	}
	
	@Override
	public int update(int note_sq) {
		System.out.println("SwEmpDaoImpl update start..");
		int result = 0;
		try {
			result  = session.update("read_count_update", note_sq);
		} catch (Exception e) {
			System.out.println("SwEmpImpl update Exception->"+e.getMessage());
		}
	return result;
	}
	
	@Override
	public int total() {
		int tot = 0;
		System.out.println("SwEmpDaoImpl total() Start ..." );
		try {
			 tot = session.selectOne("receiveNoteCount");
		} catch (Exception e) {
			System.out.println("SwEmpDaoImpl total Exception->"+e.getMessage());
		}
	return tot;
	}

	@Override
	public int total2(int emp_num) {
		int tot = 0;
		System.out.println("SwEmpDaoImpl total2() Start ..." );
		try {
			  // session -> Mapper ID total 호출 
			 tot = session.selectOne("receiveNoteCount2", emp_num);
			System.out.println("SwEmpDaoImpl Start total2..." );
		} catch (Exception e) {
			System.out.println("SwEmpDaoImpl total2 Exception->"+e.getMessage());
		}	
	return tot;
	}

	@Override
	public int total3(int emp_num) {
		int tot = 0;
		System.out.println("SwEmpDaoImpl total3() Start ..." );
		try {
			  // session -> Mapper ID total 호출 
			 tot = session.selectOne("receiveNoteCount3", emp_num);
			System.out.println("SwEmpDaoImpl Start total3..." );
		} catch (Exception e) {
			System.out.println("SwEmpDaoImpl total3 Exception->"+e.getMessage());
		}		
	return tot;
	}
}