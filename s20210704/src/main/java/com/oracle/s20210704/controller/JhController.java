package com.oracle.s20210704.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	//일정
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
	
	//자료실리스트
	@GetMapping(value = "rr/rr")
	public String rrlist(JhRr jhRr, String currentPage ,Model model,HttpSession session, HttpServletRequest request, SyMemberVO vo,String rr_type) {
		System.out.println("세션 : "+ session.getAttribute("member"));
		System.out.println("JhController Start list...");
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		int total = 0;
		if(rr_type != null ) {	//문서양식바로가기	
			total = jrs.total0();
		}else {                // 자료실
			total = jrs.total1();
		}
		System.out.println("JhController rrlist total=> "+ total);
		System.out.println("currentPage => " + currentPage);
		JhPaging jhpg = new JhPaging(total, currentPage);
		jhRr.setStart(jhpg.getStart());
		jhRr.setEnd(jhpg.getEnd());
		List<JhRr> listJhRr = null;
		if(rr_type != null ) {
			int rr_type2 = Integer.parseInt(rr_type);
			jhRr.setRr_type(rr_type2);
			listJhRr = jrs.listJhRr1(jhRr);
		}else {			
			listJhRr = jrs.listJhRr(jhRr);
		}
		System.out.println("JhController list listJhRr.size()=>"+listJhRr);
		model.addAttribute("total0", total);
		model.addAttribute("total1", total);
		model.addAttribute("listJhRr", listJhRr);
		model.addAttribute("jhpg", jhpg);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		return "rr/rr";		
	}
	// 자료실 게시글 상세보기
	@GetMapping(value = "rr/detail")
	public String detail(HttpServletRequest request, int rr_num, Model model, HttpSession session, SyMemberVO vo, int detail_num) {
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
		model.addAttribute("detail_num", detail_num);
		return "rr/detail";
	}
	// 자료실 작성 폼
	@GetMapping(value = "rr/rrwriteForm")
	public String rrwriteForm(Model model, HttpSession session, SyMemberVO vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		System.out.println("rrwriteForm");
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		return "rr/rrwriteForm";
	}
	// 자료실 작성
	@RequestMapping(value = "rr/rrwrite", method = RequestMethod.POST)
	public String write(JhRr jhRr, Model model, HttpSession session, SyMemberVO vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		System.out.println("JhController write Start...");
		int result = jrs.insert(jhRr);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		if(result > 0) return "redirect:rr";
		else {
			return "forward:rrwriteForm";
		}
	}
	
	//동호회 리스트
	@GetMapping(value = "board/clubList")
	public String clubList(JhRr jhRr, String currentPage2 ,Model model,HttpSession session, HttpServletRequest request, SyMemberVO vo) {
		System.out.println("세션 : "+ session.getAttribute("member"));
		System.out.println("JhController Start list...");
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		int total = jrs.total2();							//동호회 rr_type = 2
		System.out.println("JhController rrlist total=> "+ total);//total1 -> total로 변경
		System.out.println("currentPage => " + currentPage2);
		JhPaging jhpg2 = new JhPaging(total, currentPage2);	//jhpg1 -> jhpg변경,//total1 -> total로 변경
		jhRr.setStart(jhpg2.getStart());					//jhpg1 -> jhpg변경
		jhRr.setEnd(jhpg2.getEnd());						//jhpg1 -> jhpg변경
		jhRr.setRr_type(2);
		
		List<JhRr> listJhRr1 = jrs.listJhRr1(jhRr);	//listJhRr1 -> listJhRr로 변경하면된다.
		System.out.println("JhController list listJhRr.size()=>"+listJhRr1);
		model.addAttribute("total2", total);		//total1 -> total로 변경
		model.addAttribute("listJhRr1", listJhRr1);	//listJhRr1 -> listJhRr로 변경하면된다.
		model.addAttribute("jhpg2", jhpg2);			//jhpg1 -> jhpg변경
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		return "board/clubList";		
	}
	// 동호회 게시글 상세보기
	@GetMapping(value = "board/clubListdetail")
	public String clubListdetail(HttpServletRequest request, int rr_num, Model model, HttpSession session, SyMemberVO vo, int detail_num) {
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
		model.addAttribute("detail_num", detail_num);
		return "board/clubListdetail";
	}
	//동호회 작성폼
	@GetMapping(value = "board/clubwriteForm")
	public String clubwriteForm(Model model, HttpSession session, SyMemberVO vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		System.out.println("clubwriteForm");
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		return "board/clubwriteForm";
	}
	//동호회 작성
	@RequestMapping(value = "board/clubwrite", method = RequestMethod.POST)
	public String clubwrite(JhRr jhRr, Model model, HttpSession session, SyMemberVO vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		System.out.println("JhController clubwrite Start...");
		int result = jrs.insert(jhRr);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		if(result > 0) return "redirect:clubList";
		else {
			return "forward:clubwriteForm";
		}
	}
	
	//동호회 업데이트 폼
	@GetMapping(value = "board/clubupdateForm")
	public String clubupdateForm(int rr_num, Model model, HttpSession session, SyMemberVO vo) {
		System.out.println("JhController clubupdateForm Start..");
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		
		JhRr jhRr = jrs.detail(rr_num);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		model.addAttribute("jhRr", jhRr);
		model.addAttribute("rr_num",rr_num);
		return "board/clubupdateForm";
	}
	
	//동호회 업데이트
	@PostMapping(value = "board/clubupdate")
	public String clubupdate(JhRr jhRr, Model model, HttpSession session, SyMemberVO vo) {
		int cu = jrs.update(jhRr);
		System.out.println("jrs.update(jhRr) cu --> " + cu);
		model.addAttribute("cu", cu);
		model.addAttribute("cu1", "Message Test");
		return "redirect:clubList";
	}
	
	//공지사항 리스트
	@GetMapping(value = "board/noticeList")
	public String noticeList(JhRr jhRr, String currentPage3 ,Model model,HttpSession session, HttpServletRequest request, SyMemberVO vo) {
		System.out.println("세션 : "+ session.getAttribute("member"));
		System.out.println("JhController Start list...");
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		int total = jrs.total3();							//동호회 rr_type = 2
		System.out.println("JhController rrlist total=> "+ total);//total1 -> total로 변경
		System.out.println("currentPage => " + currentPage3);
		JhPaging jhpg3 = new JhPaging(total, currentPage3);	//jhpg1 -> jhpg변경,//total1 -> total로 변경
		jhRr.setStart(jhpg3.getStart());					//jhpg1 -> jhpg변경
		jhRr.setEnd(jhpg3.getEnd());						//jhpg1 -> jhpg변경
		jhRr.setRr_type(3);
				
		List<JhRr> listJhRr1 = jrs.listJhRr1(jhRr);	//listJhRr1 -> listJhRr로 변경하면된다.
		System.out.println("JhController list listJhRr.size()=>"+listJhRr1);
		model.addAttribute("total3", total);		//total1 -> total로 변경
		model.addAttribute("listJhRr1", listJhRr1);	//listJhRr1 -> listJhRr로 변경하면된다.
		model.addAttribute("jhpg3", jhpg3);			//jhpg1 -> jhpg변경
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		return "board/noticeList";		
	}
	//공지사항 상세보기
	@GetMapping(value = "board/noticeListdetail")
	public String noticeListdetail(HttpServletRequest request, int rr_num, Model model, HttpSession session, SyMemberVO vo, int detail_num) {
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
		model.addAttribute("detail_num", detail_num);
		return "board/noticeListdetail";
	}
	
	// 공지사항 작성폼
	@GetMapping(value = "board/noticewriteForm")
	public String noticewriteForm(Model model, HttpSession session, SyMemberVO vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		System.out.println("noticewriteForm");
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		return "board/noticewriteForm";
	}
	// 공지사항 작성
	@RequestMapping(value = "board/noticewrite", method = RequestMethod.POST)
	public String noticewrite(JhRr jhRr, Model model, HttpSession session, SyMemberVO vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		System.out.println("JhController write Start...");
		int result = jrs.insert(jhRr);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		if(result > 0) return "redirect:noticeList";
		else {
			return "forward:noticewriteForm";
		}
	}
	
	

}