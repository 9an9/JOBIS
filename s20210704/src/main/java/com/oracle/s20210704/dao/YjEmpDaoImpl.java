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

	@Override
	public List<YjEmp> myInfo(int emp_num) {
		List<YjEmp> myInfo = null;
		System.out.println("YjEmpDaoImpl myInfo Start ..." );
		try {
			// Naming Rule 
			myInfo = session.selectList("myInfo", emp_num);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl myInfo Exception->"+e.getMessage());
		}
		return myInfo;
	}

	@Override
	public String chkPw(int emp_num) {
		String emp_pw = null;
		System.out.println("YjEmpDaoImpl chkPw Start...");
		try {
			emp_pw = session.selectOne("chkPw", emp_num);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl chkPw Exception->"+e.getMessage());
		}
		return emp_pw;
	}

	@Override
	public int changePw(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpDaoImpl changePw Start...");
		try {
			result = session.update("changePw", emp);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl changePw Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int updateInfo(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpDaoImpl updateInfo Start...");
		try {
			result = session.update("updateInfo", emp);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl updateInfo Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int countEmp() {
		int result = 0;
		System.out.println("YjEmpDaoImpl countEmp Start...");
		try {
			result = session.selectOne("countEmp");
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl countEmp Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int writeEmp(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpDaoImpl writeEmp Start...");
		try {
			result = session.insert("writeEmp", emp);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl writeEmp Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public List<YjEmp> deptList() {
		List<YjEmp> deptList = null;
		System.out.println("YjEmpDaoImpl deptList Start ..." );
		try {
			// Naming Rule 
			deptList = session.selectList("deptList");
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl deptList Exception->"+e.getMessage());
		}
		return deptList;
	}

	@Override
	public List<YjEmp> teamList(String dept) {
		List<YjEmp> teamList = null;
		System.out.println("YjEmpDaoImpl teamList Start ..." );
		try {
			// Naming Rule 
			teamList = session.selectList("teamList",dept);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl teamList Exception->"+e.getMessage());
		}
		return teamList;
	}

	@Override
	public List<YjEmp> rankList(String dcode) {
		List<YjEmp> rankList = null;
		System.out.println("YjEmpDaoImpl rankList Start ..." );
		try {
			if(dcode == "110") {
				rankList = session.selectList("rankList1");
			}else {
				rankList = session.selectList("rankList2");
			}
			
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl rankList Exception->"+e.getMessage());
		}
		return rankList;
	}

	@Override
	public List<YjEmp> empMng(int empno) {
		List<YjEmp> empMng = null;
		System.out.println("YjEmpDaoImpl empMng Start ..." );
		try {
			// Naming Rule 
			empMng = session.selectList("empMng", empno);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl empMng Exception->"+e.getMessage());
		}
		return empMng;
	}

	@Override
	public int updateEmp(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpDaoImpl updateEmp Start...");
		try {
			result = session.update("updateEmp", emp);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl updateEmp Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int deleteEmp(int empno) {
		int result = 0;
		System.out.println("YjEmpDaoImpl deleteEmp Start...");
		try {
			result = session.delete("deleteEmp", empno);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl deleteEmp Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public List<YjEmp> dtList() {
		List<YjEmp> dtList = null;
		System.out.println("YjEmpDaoImpl dtList Start ..." );
		try {
			// Naming Rule 
			dtList = session.selectList("dtList");
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl dtList Exception->"+e.getMessage());
		}
		return dtList;
	}

	@Override
	public int countDept() {
		int result = 0;
		System.out.println("YjEmpDaoImpl countDept Start...");
		try {
			result = session.selectOne("countDept");
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl countDept Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int countTeam(String dept) {
		int result = 0;
		System.out.println("YjEmpDaoImpl countTeam Start...");
		try {
			result = session.selectOne("countTeam", dept);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl countTeam Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int addDept(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpDaoImpl addDept Start...");
		try {
			result = session.insert("addDept", emp);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl addDept Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int addTeam(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpDaoImpl addTeam Start...");
		try {
			result = session.insert("addTeam", emp);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl addTeam Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public String getcodetD(String dept) {
		String result = null;
		System.out.println("YjEmpDaoImpl getcodetD Start...");
		try {
			result = session.selectOne("getcodetD", dept);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl getcodetD Exception->"+e.getMessage());
		}
		return result;		
	}

	@Override
	public int deleteTeam(String team) {
		int result = 0;
		System.out.println("YjEmpDaoImpl deleteTeam Start...");
		try {
			result = session.delete("deleteTeam", team);
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl deleteTeam Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public List<YjEmp> empListE() {
		List<YjEmp> empListE = null;
		System.out.println("YjEmpDaoImpl empListE Start ..." );
		try {
			// Naming Rule 
			empListE = session.selectList("empListE");
		} catch (Exception e) {
			System.out.println("YjEmpDaoImpl empListE Exception->"+e.getMessage());
		}
		return empListE;
	}

}
