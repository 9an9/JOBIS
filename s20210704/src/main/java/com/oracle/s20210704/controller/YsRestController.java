package com.oracle.s20210704.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YsRestController {

	@RequestMapping("/rcvList1")
	public String rcvList1() {
		System.out.println("ajax 성공");
		return "안녕하세요";
	}
}
