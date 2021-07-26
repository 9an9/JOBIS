package com.oracle.s20210704.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.model.YsEmpCmt;
import com.oracle.s20210704.service.JhRrService;
import com.oracle.s20210704.service.YsEmpCmtService;
import com.oracle.s20210704.service.YsPaging;



@Controller
public class YsController {

	@Autowired
	private YsEmpCmtService yecs;
	
	@Autowired
	private JhRrService jrs;
	
	@GetMapping(value = "cmt/cmt")
	public String cmt(Model model , YsEmpCmt ysEmpCmt,String currentPage, HttpSession session, SyMemberVO  vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);
		
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
	public String searchDateCmt(Model model , YsEmpCmt ysEmpCmt,String currentPage, HttpSession session, SyMemberVO  vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);
		
		
		
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
	public String absent(Model model , YsEmpCmt ysEmpCmt, HttpSession session, SyMemberVO  vo) {
		
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);
		
		
		
		Date absent = ysEmpCmt.getAbsent();
		
		System.out.println(ysEmpCmt.getAbsent());
		
		List<YsEmpCmt> absentList = yecs.absentList(absent);
		
		System.out.println(absentList.get(0).getEmp_name());
		
		
		model.addAttribute("absent", absent);
		model.addAttribute("absentList", absentList);

		return "cmt/absent";
	}
	
	@GetMapping(value = "cmt/absentMD")
	public String absentMD(Model model ,int num, String dt,YsEmpCmt ysEmpCmt, HttpSession session, SyMemberVO  vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);
		
		String cmt_str = dt + "09:00:00";
		String cmt_end = dt + "18:00:00";
		System.out.println("num : "+num);
		System.out.println("dt : "+cmt_str);
		System.out.println("dt : "+cmt_end);
		ysEmpCmt.setEmp_num(num);
		ysEmpCmt.setMd_str(cmt_str);
		ysEmpCmt.setMd_end(cmt_end);
		yecs.cmtInsert(ysEmpCmt);
		return "redirect:cmt";
	}
	@GetMapping(value = "cmt/mycmt")
	public String mycmt(Model model ,HttpSession session, SyMemberVO  vo, YsEmpCmt ysEmpCmt,String currentPage) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		
		int mycmtTotal = yecs.mycmtTotal(emp_num);
		model.addAttribute("mycmtTotal", mycmtTotal);
				
		YsPaging yp = new YsPaging(mycmtTotal, currentPage);
		ysEmpCmt.setStart(yp.getStart());
		ysEmpCmt.setEnd(yp.getEnd());
		ysEmpCmt.setEmp_num(emp_num);
		
		List<YsEmpCmt> mycmtList = yecs.mycmtList(ysEmpCmt);
		model.addAttribute("mycmtList", mycmtList);
		model.addAttribute("yp", yp);
		
		return "cmt/mycmt";
	}
	@PostMapping(value = "cmt/cmtMD")
	public String mycmt(int state,String dt,int cmt_num,YsEmpCmt ysEmpCmt,String currentPage,RedirectAttributes redirect) {
		String cmt_str = null;
		String cmt_end = null;
		if(state == 1) {            //지각,연장
			cmt_str = dt + "09:01:00";
			cmt_end = dt + "21:01:00";
		}else if(state == 2) {      //지각,조퇴
			cmt_str = dt + "09:01:00";
			cmt_end = dt + "13:00:00";
		}else if(state == 3) {      //지각
			cmt_str = dt + "09:01:00";
			cmt_end = dt + "18:00:00";
		}else if(state == 4) {      //연장
			cmt_str = dt + "09:00:00";
			cmt_end = dt + "21:01:00";
		}else if(state == 5) {      //조퇴
			cmt_str = dt + "09:00:00";
			cmt_end = dt + "13:00:00";
		}else {                     //정상
			cmt_str = dt + "09:00:00";
			cmt_end = dt + "18:00:00";
		}
		ysEmpCmt.setCmt_num(cmt_num);
		ysEmpCmt.setMd_str(cmt_str);
		ysEmpCmt.setMd_end(cmt_end);
		yecs.cmtChange(ysEmpCmt);
		redirect.addAttribute("currentPage", currentPage);
		return "redirect:cmt";
	}

}
