package com.oracle.s20210704.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.model.SySurvey;
import com.oracle.s20210704.service.SyMemberService;
import com.oracle.s20210704.service.SyPaging;
import com.oracle.s20210704.service.SySurveyService;
import com.oracle.s20210704.service.YsApvService;






@Controller
public class SyMemberController{
	
	@Autowired
	private YsApvService    yas;
	
	@Autowired
	private SyMemberService service;
	
	@Autowired
	private SySurveyService  sss;


	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login( SyMemberVO  vo, Model model,HttpSession session) throws Exception{
		String a = null;
		//HttpSession session = req.getSession(); 
		SyMemberVO login = service.login(vo);
		
		if(login == null) {
			session.setAttribute("member", null);
			System.out.println("로그인실패");
            return "/login";
		}else {
			session.setAttribute("member",login.getEmp_num());
			System.out.println("로그인성공");
			a = "redirect:main";
		}
		
		return a;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
			
		session.invalidate();
		
		return "redirect:/";
	}


		@GetMapping(value = "board/surveyList")
		public String sslist(SySurvey sySurvey,Model model,String currentPage,HttpSession session, HttpServletRequest request, SyMemberVO vo) {
			System.out.println("세션 : "+ session.getAttribute("member"));
			System.out.println("SyMemberController Start list...");
			int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
			vo.setEmp_num(emp_num);								//모든 코딩에 추가
			SyMemberVO svo = sss.show(vo);		                 //모든 코딩에 추가
		   int surveyTotal= 0;
			
		   int unreadTotal = yas.unreadTotal(emp_num);
		   int apvNoTotal  = yas.apvNoTotal(emp_num);
		   model.addAttribute("unreadTotal", unreadTotal);
		   model.addAttribute("apvNoTotal", apvNoTotal);
			SyPaging syp = new SyPaging(surveyTotal,currentPage);
			sySurvey.setStart(syp.getStart());
			sySurvey.setEnd(syp.getEnd());
			List<SySurvey> ssList = sss.ssList(sySurvey);
			model.addAttribute("ssList",ssList);
			model.addAttribute("sysurvey",sySurvey);
			model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
			model.addAttribute("svo",svo);						//모든 코딩에 추가
			model.addAttribute("syp",syp);
			
			return "board/surveyList";		
		
		}
		
	//섦누조사 게싣글 보기
			@GetMapping(value = "board/surveyListdetail")
			public String surveyListdetail(HttpServletRequest request,Model model, int survey_num,  HttpSession session, SyMemberVO vo, int detail_num) throws Exception {
				
				int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
				vo.setEmp_num(emp_num);								//모든 코딩에 추가
				SyMemberVO svo = sss.show(vo);						//모든 코딩에 추가
				SySurvey sySurvey = sss.detail(survey_num);
				int unreadTotal = yas.unreadTotal(emp_num);
				int apvNoTotal  = yas.apvNoTotal(emp_num);
				model.addAttribute("unreadTotal", unreadTotal);
				model.addAttribute("apvNoTotal", apvNoTotal);
			
				model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
				model.addAttribute("svo",svo);						//모든 코딩에 추가
				model.addAttribute("sySurvey", sySurvey);
				model.addAttribute("detail_num", detail_num);
				return "board/surveyListdetail";
			}
			
//	//설문조사 답변 저장
//			@RequestMapping(value="board/surveyanswwrite", method = RequestMethod.POST)
//			public String surveyanswwrite(SySurvey sySurvey, Model model, HttpSession session, SyMemberVO vo)throws Exception {
//				int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
//				vo.setEmp_num(emp_num);								//모든 코딩에 추가
//				SyMemberVO svo = sss.show(vo);						//모든 코딩에 추가
//				
//				int survey_num =(int)session.getAttribute("survey_num");
//				sySurvey.setSurvey_num(survey_num);
//				
//				
//	
//				System.out.println("SyMemberController surveyanswwrite Start...");
//				model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
//				model.addAttribute("svo",svo);	//모든 코딩에 추가
//				model.addAttribute("survey_num",survey_num);
//				int result =sss.insertansw(sySurvey);
//				if(result > 0) return "redirect:surveyList";
//				else {
//					return "forward:surveyListdetail";
//				}
//				
//				
//				
//			}
	//설문조사 작성 폼
			@GetMapping(value = "board/surveywriteForm")
			public String surveywriteForm(Model model, HttpSession session, SyMemberVO vo) {
				
				int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
				vo.setEmp_num(emp_num);								//모든 코딩에 추가
				SyMemberVO svo = sss.show(vo);						//모든 코딩에 추가
				System.out.println("surveywriteForm");
				int unreadTotal = yas.unreadTotal(emp_num);
				int apvNoTotal  = yas.apvNoTotal(emp_num);
				model.addAttribute("unreadTotal", unreadTotal);
				model.addAttribute("apvNoTotal", apvNoTotal);
				model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
				model.addAttribute("svo",svo);			
				return "board/surveywriteForm";
			}
	//설문조사 작성
			@RequestMapping(value = "board/surveywrite", method = RequestMethod.POST)
			public String surveywrite(SySurvey sySurvey, Model model, HttpSession session, SyMemberVO vo)throws Exception {
				
				int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
				vo.setEmp_num(emp_num);								//모든 코딩에 추가
				SyMemberVO svo = sss.show(vo);						//모든 코딩에 추가
				System.out.println("SyMemberController surveywrite Start...");
				
				int unreadTotal = yas.unreadTotal(emp_num);
				int apvNoTotal  = yas.apvNoTotal(emp_num);
				model.addAttribute("unreadTotal", unreadTotal);
				model.addAttribute("apvNoTotal", apvNoTotal);
				int result =sss.insert(sySurvey);
				model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
				model.addAttribute("svo",svo);						//모든 코딩에 추가
				if(result > 0) return "redirect:surveyList";
				else {
					return "forward:surveywriteForm";
				}
			}}
	
