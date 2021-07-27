package com.oracle.s20210704.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YsRestController {

	@RequestMapping("/rcvList1")
	public String rcvList1() {
		System.out.println("ajax1 성공");
		return "안녕하세요1";
	}
	@RequestMapping("/rcvList2")
	public String rcvList2() {
		System.out.println("ajax2 성공");
		return "안녕하세요2";
	}
	@RequestMapping("/rcvList3")
	public String rcvList3() {
		System.out.println("ajax3 성공");
		return "안녕하세요3";
	}
	@RequestMapping("/rcvList4")
	public String rcvList4() {
		System.out.println("ajax4 성공");
		return "안녕하세요4";
	}
	@RequestMapping("/rcvList5")
	public String rcvList5() {
		System.out.println("ajax5 성공");
		return "안녕하세요5";
	}
	@RequestMapping("/rcvList6")
	public String rcvList6() {
		System.out.println("ajax6 성공");
		return "안녕하세요6";
	}
	@RequestMapping("/rcvList7")
	public String rcvList7() {
		System.out.println("ajax7 성공");
		return "안녕하세요7";
	}
	@RequestMapping("/rcvList8")
	public String rcvList8() {
		System.out.println("ajax8 성공");
		return "안녕하세요8";
	}
}
