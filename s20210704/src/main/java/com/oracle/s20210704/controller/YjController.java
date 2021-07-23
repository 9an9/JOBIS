package com.oracle.s20210704.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.model.YjEmp;
import com.oracle.s20210704.service.JhRrService;
import com.oracle.s20210704.service.YjEmpService;
import com.oracle.s20210704.service.YjPaging;



@Controller
public class YjController {

	@Autowired
	private YjEmpService es;
	@Autowired
	private JhRrService jrs;
	
	@RequestMapping(value = "emp/empList")
	public String empList(YjEmp emp, String currentPage, HttpSession session, SyMemberVO  vo, Model model) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);

		System.out.println("YjController Start empList...");
		int total = es.total();
		System.out.println("YjController total--> " + total);
		System.out.println("currentPage=>" + currentPage);
		//                     14     NULL(0,1....)
		YjPaging pg = new YjPaging(total, currentPage);
		emp.setStart(pg.getStart());   // 시작시 1
		emp.setEnd(pg.getEnd());       // 시작시 10 
		List<YjEmp> empList = es.empList(emp);
		System.out.println("YjEmpController list empList.size()=>" + empList.size());
		model.addAttribute("total", total);
		model.addAttribute("empList",empList);
		model.addAttribute("pg",pg);
		return "emp/empList";
		
	}
	
	@ResponseBody
	@PostMapping(value = "/updateRef")
	public String updateRef(int empno, int ref, HttpSession session, SyMemberVO  vo, Model model) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		
		System.out.println("YjEmpController updateRef Start...");
		System.out.println("YjEmpController empno--> " + empno);
		System.out.println("YjEmpController ref--> " + ref);
		int result = es.updateRef(empno, ref);
		return "emp/empList";
	}

}
