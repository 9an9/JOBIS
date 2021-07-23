package com.oracle.s20210704.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.service.SyMemberService;




@Controller
public class SyMemberController{
	
	
	@Autowired
	SyMemberService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login( SyMemberVO  vo, Model model,HttpSession session) throws Exception{
		String a = null;
		//HttpSession session = req.getSession(); 
		SyMemberVO login = service.login(vo);
		
		if(login == null) {
			session.setAttribute("member", null);
			model.addAttribute("msg", 1);
			System.out.println("���Ӥ�����");
			a = "redirect:/";
		}else {
			session.setAttribute("member", login.getEmp_num());
			System.out.println("���ä����Ǥ�");
			a = "redirect:main";
		}
		
		return a;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	
 

}