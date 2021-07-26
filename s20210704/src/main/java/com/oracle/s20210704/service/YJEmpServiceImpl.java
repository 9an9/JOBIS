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

}
