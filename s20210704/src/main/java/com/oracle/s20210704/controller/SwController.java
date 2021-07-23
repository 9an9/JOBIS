package com.oracle.s20210704.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.s20210704.model.Emp;
import com.oracle.s20210704.model.SwNote_tb;
import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.service.JhRrService;
import com.oracle.s20210704.service.SwNoteService;


@Controller
public class SwController {
	@Autowired
	private SwNoteService sns;
	
	@Autowired
	private JhRrService jrs;
	

	@GetMapping("note/sendNote")
	public String sendNoteForm(Model model, HttpSession session, SyMemberVO  vo) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		System.out.println("SwController sendNoteForm Start...");
		// 보낼 사원 선택 
		List<Emp> listEmp = sns.listEmp();
		System.out.println("SwController sendNoteForm listEmp.size()->"+listEmp.size());
		 model.addAttribute("listEmp", listEmp); 
		return "note/sendNote";
	}
	
	@GetMapping("note/receiveNote")
	public String receiveNoteForm(Model model, HttpSession session, SyMemberVO  vo) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		return "note/receiveNote";
	}
	
	@GetMapping("note/sentNote")
	public String sentNoteForm(Model model, HttpSession session, SyMemberVO  vo) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		return "note/sentNote";
	}
	
	
	@GetMapping("note/writeNoteTB")
	public String writeNoteTB(Model model, HttpSession session, SyMemberVO  vo, SwNote_tb swnote_tb) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		System.out.println("SwController sendNoteForm Start...");
		System.out.println("SwController sendNoteForm note_tb.getEmp_num()->"+swnote_tb.getEmp_num());
		System.out.println("SwController sendNoteForm note_tb.getNote_nm()->"+swnote_tb.getNote_nm());
		System.out.println("SwController sendNoteForm note_tb.getNote_cnt()->"+swnote_tb.getNote_cnt());
		System.out.println("SwController sendNoteForm note_tb.getEmp_num()->"+swnote_tb.getEmp_num());
		return "note/sendNote";
	}
	
//
//	public String main(Model model, HttpSession session, SyMemberVO  vo) {
//		int emp_num = (int)session.getAttribute("member");
//		vo.setEmp_num(emp_num);
//		SyMemberVO svo = jrs.show(vo);
//		model.addAttribute("svo",svo);
//	}
}
