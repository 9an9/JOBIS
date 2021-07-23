package com.oracle.s20210704.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.s20210704.model.JhCalendar;
import com.oracle.s20210704.model.JhRr;
import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.service.JhCalendarService;
import com.oracle.s20210704.service.JhPaging;
import com.oracle.s20210704.service.JhRrService;




@Controller
public class JhController {
	
	@Autowired
	private JhCalendarService jcs;
	@Autowired
	private JhRrService jrs;
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/template")
	public String template(Model model) {
		return "SpringTemplate";
	}
	
	@GetMapping(value = "calendar/calendar")
	public String calendar(Model model, HttpSession session, SyMemberVO vo) {
		System.out.println("일정");
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		return "calendar/calendar";
	}
	@GetMapping(value = "rr/rr")
	public String rrlist(JhRr jhRr, String currentPage ,Model model,HttpSession session, HttpServletRequest request, SyMemberVO vo) {
		System.out.println("세션 : "+ session.getAttribute("member"));
		System.out.println("JhController Start list...");
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		int total = jrs.total();
		System.out.println("JhController rrlist total=> "+ total);
		System.out.println("currentPage => " + currentPage);
		JhPaging jhpg = new JhPaging(total, currentPage);
		jhRr.setStart(jhpg.getStart());
		jhRr.setEnd(jhpg.getEnd());
		List<JhRr> listJhRr = jrs.listJhRr(jhRr);
		System.out.println("JhController list listJhRr.size()=>"+listJhRr);
		model.addAttribute("total", total);
		model.addAttribute("listJhRr", listJhRr);
		model.addAttribute("jhpg", jhpg);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		return "rr/rr";		
	}
	@GetMapping(value = "rr/detail")
	public String detail(HttpServletRequest request, int rr_num, Model model, HttpSession session, SyMemberVO vo) {
		System.out.println("JhController Start detail"+rr_num);
		System.out.println("JhController rr_num->" + rr_num);
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		JhRr jhRr = jrs.detail(rr_num);
		System.out.println("JhController detail->"+jhRr.getRr_num());
		System.out.println("JhController detail->"+jhRr.getRr_content());
		System.out.println("JhController detail->"+jhRr.getRr_subject());
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		model.addAttribute("jhRr", jhRr);
		return "rr/detail";
	}
	
	@GetMapping(value = "main")
	public String main(Model model, HttpSession session, SyMemberVO  vo) {	//Model model, HttpSession session, SyMemberVO vo도 사용
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		System.out.println(svo.getEmp_name());
		System.out.println(svo.getDcontent());
		System.out.println(svo.getRcontent());
		System.out.println(svo.getTcontent());
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		return "mainpage";
	}
	
}