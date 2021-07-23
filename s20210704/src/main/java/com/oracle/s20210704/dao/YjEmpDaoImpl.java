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
	public int updateRef(int empno, int ref) {
		int result = 0;
		System.out.println("YjEmpDaoImpl updateRef Start...");
		try {
			
		} catch (Exception e) {

		}
		return 0;
	}

}
