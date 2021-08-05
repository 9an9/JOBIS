package com.oracle.s20210704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210704.dao.YjEmpDao;
import com.oracle.s20210704.model.YjEmp;





@Service
public class YJEmpServiceImpl implements YjEmpService {

	@Autowired
	private   YjEmpDao      ed;

	
	@Override
	public int total() {
		System.out.println("YjEmpServiceImpl Start total..." );
		int totCnt = ed.total();
		System.out.println("YjEmpServiceImpl total totCnt->"+totCnt );
		return totCnt;
	}


	@Override
	public List<YjEmp> empList(YjEmp emp) {
		List<YjEmp> empList = null;
		System.out.println("YjEmpServiceImpl listEmp Start..." );
		empList = ed.empList(emp);
		System.out.println("YjEmpServiceImpl listEmp empList.size()->" +empList.size());
		return empList;
	}


	@Override
	public int updateRef(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpServiceImpl updateRef Start...");
		result = ed.updateRef(emp);
		System.out.println("YjEmpServiceImpl updateRef result--> " + result);
		return result;
	}


	@Override
	public String deptSelect(int emp_num) {
		String dept = null;
		System.out.println("YjEmpServiceImpl deptSelect Start...");
		dept = ed.deptSelect(emp_num);
		return dept;
	}


	@Override
	public List<YjEmp> searchListE(YjEmp emp) {
		List<YjEmp> searchListE = null;
		System.out.println("YjEmpServiceImpl searchListE Start..." );
		searchListE = ed.searchListE(emp);
		System.out.println("YjEmpServiceImpl listEmp searchListE.size()->" +searchListE.size());
		return searchListE;
	}


	@Override
	public List<YjEmp> searchListD(YjEmp emp) {
		List<YjEmp> searchListD = null;
		System.out.println("YjEmpServiceImpl searchListD Start..." );
		searchListD = ed.searchListD(emp);
		System.out.println("YjEmpServiceImpl listEmp searchListD.size()->" +searchListD.size());
		return searchListD;
	}


	@Override
	public String rankSelect(int emp_num) {
			String rank = null;
			System.out.println("YjEmpServiceImpl rankSelect Start...");
			rank = ed.rankSelect(emp_num);
			return rank;
	}


	@Override
	public List<YjEmp> myInfo(int emp_num) {
		List<YjEmp> myInfo = null;
		System.out.println("YjEmpServiceImpl myInfo Start..." );
		myInfo = ed.myInfo(emp_num);
		System.out.println("YjEmpServiceImpl myInfo myInfo.size()->" +myInfo.size());
		return myInfo;
	}


	@Override
	public String chkPw(int emp_num) {
		String emp_pw = null;
		System.out.println("YjEmpServiceImpl chkPw Start...");
		emp_pw = ed.chkPw(emp_num);
		return emp_pw;
	}


	@Override
	public int changePw(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpServiceImpl changePw Start...");
		result = ed.changePw(emp);
		System.out.println("YjEmpServiceImpl changePw result--> " + result);
		return result;
	}


	@Override
	public int updateInfo(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpServiceImpl updateInfo Start...");
		result = ed.updateInfo(emp);
		System.out.println("YjEmpServiceImpl updateInfo result--> " + result);
		return result;
	}


	@Override
	public int countEmp() {
		int result = 0;
		System.out.println("YjEmpServiceImpl countEmp Start...");
		result = ed.countEmp();
		System.out.println("YjEmpServiceImpl countEmp result--> " + result);
		return result;
	}


	@Override
	public int writeEmp(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpServiceImpl writeEmp Start...");
		result = ed.writeEmp(emp);
		System.out.println("YjEmpServiceImpl writeEmp result--> " + result);
		return result;
	}


	@Override
	public List<YjEmp> deptList() {
		List<YjEmp> deptList = null;
		System.out.println("YjEmpServiceImpl deptList Start..." );
		deptList = ed.deptList();
		System.out.println("YjEmpServiceImpl deptList deptList.size()->" +deptList.size());
		return deptList;
	}


	@Override
	public List<YjEmp> teamList(String dept) {
		List<YjEmp> teamList = null;
		System.out.println("YjEmpServiceImpl teamList Start..." );
		teamList = ed.teamList(dept);
		System.out.println("YjEmpServiceImpl deptList teamList.size()->" +teamList.size());
		return teamList;
	}


	@Override
	public List<YjEmp> rankList() {
		List<YjEmp> rankList = null;
		System.out.println("YjEmpServiceImpl rankList Start..." );
		rankList = ed.rankList();
		System.out.println("YjEmpServiceImpl rankList rankList.size()->" +rankList.size());
		return rankList;
	}


	@Override
	public List<YjEmp> empMng(int empno) {
		List<YjEmp> empMng = null;
		System.out.println("YjEmpServiceImpl empMng Start..." );
		empMng = ed.empMng(empno);
		System.out.println("YjEmpServiceImpl empMng myInfo.size()->" +empMng.size());
		return empMng;
	}


	@Override
	public int updateEmp(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpServiceImpl updateEmp Start...");
		result = ed.updateEmp(emp);
		System.out.println("YjEmpServiceImpl updateEmp result--> " + result);
		return result;
	}


	@Override
	public int deleteEmp(int empno) {
		int result = 0;
		System.out.println("YjEmpServiceImpl deleteEmp Start...");
		result = ed.deleteEmp(empno);
		System.out.println("YjEmpServiceImpl deleteEmp result--> " + result);
		return result;
	}


	@Override
	public List<YjEmp> dtList() {
		List<YjEmp> dtList = null;
		System.out.println("YjEmpServiceImpl dtList Start..." );
		dtList = ed.dtList();
		System.out.println("YjEmpServiceImpl dtList dtList.size()->" +dtList.size());
		return dtList;
	}


	@Override
	public int countDept() {
		int result = 0;
		System.out.println("YjEmpServiceImpl countDept Start...");
		result = ed.countDept();
		System.out.println("YjEmpServiceImpl countDept result--> " + result);
		return result;
	}


	@Override
	public int countTeam(String dept) {
		int result = 0;
		System.out.println("YjEmpServiceImpl countTeam Start...");
		result = ed.countTeam(dept);
		System.out.println("YjEmpServiceImpl countTeam result--> " + result);
		return result;
	}


	@Override
	public int addDept(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpServiceImpl addDept Start...");
		result = ed.addDept(emp);
		System.out.println("YjEmpServiceImpl addDept result--> " + result);
		return result;		
	}


	@Override
	public int addTeam(YjEmp emp) {
		int result = 0;
		System.out.println("YjEmpServiceImpl addTeam Start...");
		result = ed.addTeam(emp);
		System.out.println("YjEmpServiceImpl addTeam result--> " + result);
		return result;		
	}


	@Override
	public String getcodetD(String dept) {
		String result = null;
		System.out.println("YjEmpServiceImpl getcodetD Start...");
		result = ed.getcodetD(dept);
		System.out.println("YjEmpServiceImpl getcodetD result--> " + result);		
		return result;
	}


	@Override
	public int deleteTeam(String team) {
		int result = 0;
		System.out.println("YjEmpServiceImpl deleteTeam Start...");
		result = ed.deleteTeam(team);
		System.out.println("YjEmpServiceImpl deleteTeam result--> " + result);
		return result;	
	}

}
