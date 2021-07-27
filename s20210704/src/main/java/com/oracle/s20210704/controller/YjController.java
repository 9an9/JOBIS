package com.oracle.s20210704.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	//사원정보관리 출력
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
		
		String dept = es.deptSelect(emp_num);
		System.out.println("YjEmpController empList dept--> " + dept);
		
		List<YjEmp> empList = es.empList(emp);
		System.out.println("YjEmpController list empList.size()=>" + empList.size());
		
		model.addAttribute("total", total);
		model.addAttribute("dept", dept);
		model.addAttribute("empList",empList);
		model.addAttribute("pg",pg);
		return "emp/empList";
		
	}
	
	@RequestMapping(value = "emp/updateRef", method = RequestMethod.POST)
	public String updateRef(int empno, int ref, YjEmp emp, HttpSession session, SyMemberVO  vo, Model model) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		
		emp.setEmpno(empno);
		emp.setRef(ref);
		System.out.println("YjEmpController updateRef Start...");
		System.out.println("YjEmpController updateRef empno--> " + empno);
		System.out.println("YjEmpController updateRef ref--> " + ref);
		int result = es.updateRef(emp);
		System.out.println("YjEmpController updateRef result--> " + result);
		model.addAttribute("result", result);
//		String referer = request.getHeader("Referer"); // 헤더에서 이전 페이지를 읽는다.HttpServletRequest request
//		return "redirect:"+referer;//이전 페이지 새로고침
		return "forward:empList";
	}
	
	@RequestMapping(value = "emp/searchList", method = RequestMethod.POST)
	public String searchList(int search, String keyword, YjEmp emp, HttpSession session, SyMemberVO  vo, Model model) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);

		String dept = es.deptSelect(emp_num);
		System.out.println("YjEmpController empList dept--> " + dept);
		
		emp.setKeyword(keyword);
		List<YjEmp> searchList = null;
		if(search==0) {
			searchList = es.searchListE(emp);
		}else {
			searchList = es.searchListD(emp);
		}
		System.out.println("YjEmpController list empList.size()=>" + searchList.size());

		model.addAttribute("dept", dept);
		model.addAttribute("keyword", keyword);
		model.addAttribute("empList",searchList);

		return "emp/searchList";

	}

}
