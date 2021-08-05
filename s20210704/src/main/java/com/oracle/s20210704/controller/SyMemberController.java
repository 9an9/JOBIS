package com.oracle.s20210704.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.s20210704.model.SyMemberVO;
//import com.oracle.s20210704.model.SySurvey;
import com.oracle.s20210704.service.SyMemberService;
//import com.oracle.s20210704.service.SySurveyService;





@Controller
public class SyMemberController{
	
	
	@Autowired
	private SyMemberService service;
	
//	@Autowired
//	private SySurveyService  sss;

	
	
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
	
	
	

//	//설문조사리스트
//		@GetMapping(value = "board/surveyList")
//		public String sslist(SySurvey sySurvey,Model model,String currentPage,HttpSession session, HttpServletRequest request, SyMemberVO vo) {
//			System.out.println("세션 : "+ session.getAttribute("member"));
//			System.out.println("SyMemberController Start list...");
//			int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
//			vo.setEmp_num(emp_num);								//모든 코딩에 추가
//			SyMemberVO svo = sss.show(vo);		                 //모든 코딩에 추가
//		   
//			
//			int surveyTotal =sss.surveyTotal();
//			SyPaging sp = new SyPaging(surveyTotal,currentPage);
//			sySurvey.setStart(sp.getStart());
//			sySurvey.setEnd(sp.getEnd());
//			List<SySurvey> ssList = sss.ssList(sySurvey);
//			model.addAttribute("ssList",ssList);
//			model.addAttribute("sysurvey",sySurvey);
//			model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
//			model.addAttribute("svo",svo);						//모든 코딩에 추가
//			model.addAttribute("sp",sp);
//			
//			return "board/surveyList";		
//		}
		
		
	


}