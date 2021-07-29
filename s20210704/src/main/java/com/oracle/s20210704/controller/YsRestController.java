package com.oracle.s20210704.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.s20210704.model.YsEmpCmt;
import com.oracle.s20210704.service.YsApvService;

@RestController
public class YsRestController {
	
	@Autowired
	private YsApvService    yas;
	
	@RequestMapping("/rcvList1")
	public List<YsEmpCmt> rcvList1(int emp_num) {
		System.out.println("1.같은 소속이면서 직급이 대리인 휴가를 가지않은 사람들 목록");
		return yas.rcvList1(emp_num);
	}
	@RequestMapping("/rcvList2")
	public List<YsEmpCmt> rcvList2(int emp_num) {
		System.out.println("2.같은 부서이면서 직급이 팀장인 사람");
		return yas.rcvList2(emp_num);
	}
	@RequestMapping("/rcvList3")
	public List<YsEmpCmt> rcvList3(int emp_num) {
		System.out.println("3.같은 부서의 직급이 부장인 사람");
		return yas.rcvList3(emp_num);
	}
	@RequestMapping("/rcvList4")
	public List<YsEmpCmt> rcvList4() {
		System.out.println("4.부서명이 임원이면서 직급이 대표가 아니고  휴가를 가지않은 사람들 목록");
		return yas.rcvList4();
	}
	@RequestMapping("/rcvList5")
	public List<YsEmpCmt> rcvList5() {
		System.out.println("5.부서명이 총무부이면서 직급이 사원인 휴가를 가지않은 사람들 목록");
		return yas.rcvList567("사원");
	}
	@RequestMapping("/rcvList6")
	public List<YsEmpCmt> rcvList6() {
		System.out.println("6.부서명이 총무부이면서 직급이 대리인 휴가를 가지않은 사람들 목록");
		return yas.rcvList567("대리");
	}
	@RequestMapping("/rcvList7")
	public List<YsEmpCmt> rcvList7() {
		System.out.println("7.부서명이 총무부이면서 직급이 팀장인 휴가를 가지않은 사람들 목록");
		return yas.rcvList567("팀장");
	}
	@RequestMapping("/rcvList8")
	public List<YsEmpCmt> rcvList8() {
		System.out.println("8.부서명이 총무부이면서 직급이 부장인 사람");
		return yas.rcvList8();
	}
}
