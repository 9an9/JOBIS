package com.oracle.s20210704.service;

import java.util.List;

import com.oracle.s20210704.model.YjEmp;


public interface YjEmpService {
	int           	total();
	List<YjEmp> 	empList(YjEmp emp);
	int			    updateRef(YjEmp emp);
}
