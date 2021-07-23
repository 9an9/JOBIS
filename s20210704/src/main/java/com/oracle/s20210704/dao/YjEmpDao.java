package com.oracle.s20210704.dao;

import java.util.List;

import com.oracle.s20210704.model.YjEmp;


public interface YjEmpDao {
	int           	total();
	List<YjEmp> 	empList(YjEmp emp);
	int			    updateRef(int empno, int ref);
}
