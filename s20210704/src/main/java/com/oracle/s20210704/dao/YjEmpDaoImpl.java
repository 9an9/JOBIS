package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.YjEmp;

@Repository
public class YjEmpDaoImpl implements YjEmpDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public int total() {
		int tot = 0;
		System.out.println("YjEmpDaoImpl Start total..." );
		try {
			 tot = session.selectOne("empTotal");
			System.out.println("YjEmpDaoImpl Start total..." );
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl total Exception->"+e.getMessage());
		}
		return tot;
	}

	@Override
	public List<YjEmp> empList(YjEmp emp) {
		List<YjEmp> empList = null;
		System.out.println("YjEmpDaoImpl empList Start ..." );
		try {
			// Naming Rule 
			empList = session.selectList("empListAll", emp);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl empList Exception->"+e.getMessage());
		}
		return empList;
	}

	@Override
	public int updateRef(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpDaoImpl updateRef Start...");
		try {
			result = session.update("updateRef", emp);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl updateRef Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public String deptSelect(int emp_num) {
		String dept = null;
		System.out.println("YjEmpDaoImpl deptSelect Start...");
		try {
			dept = session.selectOne("deptSelect", emp_num);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl deptSelect Exception->"+e.getMessage());
		}
		return dept;
	}

	@Override
	public List<YjEmp> searchListE(YjEmp emp) {
		List<YjEmp> searchListE = null;
		System.out.println("YjEmpDaoImpl searchListE Start ..." );
		try {
			// Naming Rule 
			searchListE = session.selectList("searchListE", emp);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl searchListE Exception->"+e.getMessage());
		}
		return searchListE;
	}

	@Override
	public List<YjEmp> searchListD(YjEmp emp) {
		List<YjEmp> searchListD = null;
		System.out.println("YjEmpDaoImpl searchListD Start ..." );
		try {
			// Naming Rule 
			searchListD = session.selectList("searchListD", emp);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl searchListD Exception->"+e.getMessage());
		}
		return searchListD;
	}

	@Override
	public String rankSelect(int emp_num) {
		String rank = null;
		System.out.println("YjEmpDaoImpl rankSelect Start...");
		try {
			rank = session.selectOne("rankSelect", emp_num);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl rankSelect Exception->"+e.getMessage());
		}
		return rank;
	}

}