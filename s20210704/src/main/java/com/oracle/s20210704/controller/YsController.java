package com.oracle.s20210704.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.s20210704.model.YsEmpCmt;
import com.oracle.s20210704.service.YsEmpCmtService;
import com.oracle.s20210704.service.YsPaging;



@Controller
public class YsController {

	@Autowired
	private YsEmpCmtService yecs;
	
	
	@GetMapping(value = "cmt/cmt")
	public String cmt(Model model , YsEmpCmt ysEmpCmt,String currentPage) {
		int cmtTotal = yecs.cmtTotal();
		YsPaging yp = new YsPaging(cmtTotal, currentPage);
		ysEmpCmt.setStart(yp.getStart());
		ysEmpCmt.setEnd(yp.getEnd());
		List<YsEmpCmt> cmtList = yecs.cmtList(ysEmpCmt);
		model.addAttribute("cmtList", cmtList);
		model.addAttribute("yp", yp);
		return "cmt/cmt";
	}
	
	@PostMapping(value = "cmt/cmtSearch")
	public String searchDateCmt(Model model , YsEmpCmt ysEmpCmt,String currentPage) {
		int cmtTotal = 0;
		//상황별로 total 가져오기
		//날짜,이름 입력한경우
		if(ysEmpCmt.getSearchDept().equals("") && !ysEmpCmt.getSearchName().equals("")) { 
			cmtTotal = yecs.cmtNameTotal(ysEmpCmt);
		//날짜,부서 입력한경우
		} else if(!ysEmpCmt.getSearchDept().equals("") && ysEmpCmt.getSearchName().equals("")) {
			cmtTotal = yecs.cmtDeptTotal(ysEmpCmt);
		//날짜 입력한경우
		}else if(!ysEmpCmt.getSearchDept().equals("") && !ysEmpCmt.getSearchName().equals("")) {
			cmtTotal = yecs.cmtAllTotal(ysEmpCmt);	
		//날짜,부서,이름 입력한경우
		}else {
			cmtTotal = yecs.cmtDateTotal(ysEmpCmt);	
		}
		
		List<YsEmpCmt> cmtList = null;
		
		//페이징
		YsPaging yp = new YsPaging(cmtTotal, currentPage);
		ysEmpCmt.setStart(yp.getStart());
		ysEmpCmt.setEnd(yp.getEnd());
		
		//상황별로 페이징된 상태로 list 가져오기
		//날짜,이름 입력한경우
		if(ysEmpCmt.getSearchDept().equals("") && !ysEmpCmt.getSearchName().equals("")) {
			cmtList = yecs.cmtNameSearchList(ysEmpCmt);
		//날짜,부서 입력한경우
		} else if(!ysEmpCmt.getSearchDept().equals("") && ysEmpCmt.getSearchName().equals("")) {
			cmtList = yecs.cmtDeptSearchList(ysEmpCmt);
		//날짜 입력한경우
		}else if(!ysEmpCmt.getSearchDept().equals("") && !ysEmpCmt.getSearchName().equals("")) {
			cmtList = yecs.cmtAllSearchList(ysEmpCmt);		
		//날짜,부서,이름 입력한경우
		}else {
			cmtList = yecs.cmtDateSearchList(ysEmpCmt);	
		}
		model.addAttribute("ysEmpCmt", ysEmpCmt);
		model.addAttribute("cmtList", cmtList);
		model.addAttribute("yp", yp);
		return "cmt/cmt";
		//커밋테스트 2
	}
	
	@PostMapping(value = "cmt/absent")
	public String absent(Model model , YsEmpCmt ysEmpCmt) {
		
		Date absent = ysEmpCmt.getAbsent();
		
		System.out.println(ysEmpCmt.getAbsent());
		
		List<YsEmpCmt> absentList = yecs.absentList(absent);
		
		System.out.println(absentList.get(0).getEmp_name());
		
		
		model.addAttribute("absent", absent);
		model.addAttribute("absentList", absentList);

		return "cmt/absent";
	}
	
	@GetMapping(value = "cmt/absentMD")
	public String absentMD(int num, String dt,YsEmpCmt ysEmpCmt) {
		int emp_num = num;
		String cmt_str = dt + "09:00:00";
		String cmt_end = dt + "18:00:00";
		System.out.println("num : "+emp_num);
		System.out.println("dt : "+cmt_str);
		System.out.println("dt : "+cmt_end);
		ysEmpCmt.setEmp_num(num);
		ysEmpCmt.setMd_str(cmt_str);
		ysEmpCmt.setMd_end(cmt_end);
		yecs.cmtInsert(ysEmpCmt);
		return "redirect:cmt";
	}
	/////////////////테스트/////
	@GetMapping(value = "cmt/mycmt")
	public String t1 () {
		System.out.println("나의근태");
		return "redirect:/";
	}
	@GetMapping(value = "apv/apvRcv")
	public String t2 () {
		System.out.println("보낸결재");
		return "redirect:/";
	}
	@GetMapping(value = "apv/apvSnd")
	public String t3 () {
		System.out.println("받은결재");
		return "redirect:/";
	}
	@GetMapping(value = "apv/apvWrite")
	public String t4 () {
		System.out.println("결재작성");
		return "redirect:/";
	}
	@GetMapping(value = "emp/empList")
	public String t5 () {
		System.out.println("사원관리");
		return "redirect:/";
	}
	@GetMapping(value = "emp/myInfoUpdate")
	public String t6 () {
		System.out.println("개인 정보 수정");
		return "redirect:/";
	}

	@GetMapping(value = "note/sendNote")
	public String t9 () {
		System.out.println("쪽지보내기");
		return "redirect:/";
	}
	@GetMapping(value = "note/sentNote")
	public String t11 () {
		System.out.println("보낸쪽지함");
		return "redirect:/";
	}
	@GetMapping(value = "note/receiveNote")
	public String t12 () {
		System.out.println("받은쪽지함");
		return "redirect:/";
	}
	@GetMapping(value = "board/noticeList")
	public String t13 () {
		System.out.println("공지");
		return "redirect:/";
	}
	@GetMapping(value = "board/surveyList")
	public String t14 () {
		System.out.println("설문");
		return "redirect:/";
	}
	@GetMapping(value = "board/clubList")
	public String t15 () {
		System.out.println("동호회");
		return "redirect:/";
	}


}
