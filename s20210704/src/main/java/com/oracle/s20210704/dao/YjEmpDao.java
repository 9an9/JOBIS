package com.oracle.s20210704.dao;

import java.util.List;

import com.oracle.s20210704.model.YjEmp;


public interface YjEmpDao {
	int           	total();
	List<YjEmp> 	empList(YjEmp emp);
	int			    updateRef(YjEmp emp);
	String		    deptSelect(int emp_num);
	List<YjEmp> 	searchListE(YjEmp emp);	
	List<YjEmp> 	searchListD(YjEmp emp);	
	String		    rankSelect(int emp_num);
	List<YjEmp> 	myInfo(int emp_num);
	String		    chkPw(int emp_num);	
	int 			changePw(YjEmp emp);
	int 		    updateInfo(YjEmp emp);	
	int 		    countEmp();		
	int 		    writeEmp(YjEmp emp);
	List<YjEmp> 	deptList();
	List<YjEmp> 	teamList(String dept);
	List<YjEmp> 	rankList();
	List<YjEmp> 	empMng(int empno);
	int 		    updateEmp(YjEmp emp);
	int			 	deleteEmp(int empno);
	List<YjEmp> 	dtList();
	int				countDept();
	int				countTeam(String dept);
	int				addDept(YjEmp emp);
	int 			addTeam(YjEmp emp);	
	String			getcodetD(String dept);
	int				deleteTeam(String team);
}
