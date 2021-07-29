package com.oracle.s20210704.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210704.model.Emp;
import com.oracle.s20210704.model.SwNote_rcv_tb;
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
	
	
	@GetMapping("note/sendNote") // 쪽지 보내기
	public String sendNote(Model model, HttpSession session, SyMemberVO  vo, SwNote_tb swnote_tb, SwNote_rcv_tb swnote_rcv_tb) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		
		System.out.println("SwController sendNote Start...");
		List<Emp> listEmp = sns.listEmp();
		System.out.println("SwController sendNote listEmp.size()->"+listEmp.size());
		model.addAttribute("listEmp", listEmp); 
		return "note/sendNote";
	}
	
	@GetMapping("note/writeNoteTB") // 쪽지 보내기 전송
	public String writeNoteTB(Model model, HttpSession session, SyMemberVO vo, SwNote_tb swnote_tb, SwNote_rcv_tb swnote_rcv_tb) {
		System.out.println("SwController writeNoteTB Start...");
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		int result = 0;
		int result2 = 0;
		result2 = sns.insertNote_tb(swnote_tb);
		result 	= sns.insertNote_rcv_tb(swnote_rcv_tb);
		List<Emp> listEmp = sns.listEmp();
		model.addAttribute("listEmp", listEmp); 
		System.out.println("result의 결과값은 -->" + result);
		System.out.println("result2의 결과값은 -->" + result2);
		return "note/sendNote";
	}
	
	@GetMapping("note/sentNote") // 보낸 쪽지함
	public String sentNote(Model model, HttpSession session, SyMemberVO  vo, SwNote_tb swnote_tb, SwNote_rcv_tb swnote_rcv_tb) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		List<SwNote_rcv_tb> listSwNote_rcv_tb = sns.listSwNote_rcv_tb(emp_num);
//		List<listSwNote_tb> 	SentNoteList   	  = sns.listSwNote_tb(emp_num); // 보낸편지함 로직구현
		model.addAttribute("listSwNote_rcv_tb", listSwNote_rcv_tb); 
//		model.addAttribute("listSwNote_tb", listSwNote_tb); 
		return "note/sentNote";
	}
	
	@GetMapping("note/receiveNote") // 받은 쪽지함
	public String receiveNote(Model model, HttpSession session, SyMemberVO vo, SwNote_tb swnote_tb) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		
		System.out.println("SwController receiveNote start...");
		System.out.println("SwController receiveNote emp_num->"+emp_num);
		List<SwNote_tb> listSwNote_tb = sns.listSwNote_tb(emp_num);
		model.addAttribute("listSwNote_tb", listSwNote_tb);
		return "note/receiveNote";
	}
	
	@RequestMapping("note/deleteNote") // 받은 쪽지함 삭제
	public String deleteNote(HttpServletRequest request, Model model, HttpSession session, SyMemberVO vo, SwNote_tb swnote_tb, SwNote_rcv_tb swnote_rcv_tb) {
		int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		System.out.println("SwController deleteNote Start ..." );
		try {
			request.setCharacterEncoding("utf-8");
			String   zero	= "0";
			String[] checks = request.getParameterValues("check1");
			 for(int i=0;i<checks.length;i++){
				  if(checks[i].equals(zero)) {
					  System.out.println("Zero i -> "+ i );
				  } else {
				      System.out.println("i -> "+ i );
				      System.out.println("checks[i]->"+ checks[i]);
				      int result1 = sns.delete(checks[i]);
				      int result2 = sns.delete2(checks[i]);
				      System.out.println("result1의 결과값은 -->" + result1);
				      System.out.println("result2의 결과값은 -->" + result2);
				      List<SwNote_rcv_tb> listSwNote_rcv_tb = sns.listSwNote_rcv_tb(emp_num);
					  List<SwNote_tb> 	listSwNote_tb 	  = sns.listSwNote_tb(emp_num);
					  model.addAttribute("listSwNote_rcv_tb", listSwNote_rcv_tb); 
					  model.addAttribute("listSwNote_tb", listSwNote_tb);
				  }
			 }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return "note/receiveNote";
	}
}