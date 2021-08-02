package com.oracle.s20210704.service;

import java.util.List;

import com.oracle.s20210704.model.YjEmp;


public interface YjEmpService {
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
}
