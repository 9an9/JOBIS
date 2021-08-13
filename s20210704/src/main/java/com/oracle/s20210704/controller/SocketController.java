package com.oracle.s20210704.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.service.JhRrService;

@Controller
public class SocketController {
	@Autowired
	private JhRrService jrs;
	
	@RequestMapping("/chat/chat")
	public ModelAndView chat(Model model, HttpSession session, SyMemberVO vo) {
		System.out.println("SocketController chat Start...");
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat/chat");
		return mv;
	}

}
