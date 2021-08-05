package com.oracle.s20210704.controller;

import java.io.File;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.s20210704.model.Emp;
import com.oracle.s20210704.model.SwNote_rcv_tb;
import com.oracle.s20210704.model.SwNote_tb;
import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.service.JhRrService;
import com.oracle.s20210704.service.SwNoteService;
import com.oracle.s20210704.service.SwPaging;


@Controller
public class SwController {
	
	@Autowired
	private SwNoteService sns;
	
	@Autowired
	private JhRrService jrs;
	
	private static final Logger logger = LoggerFactory.getLogger(SwController.class);

	// 받은 쪽지함
	@GetMapping("note/receiveNote") 
	public String receiveNote(Model model, HttpSession session, SyMemberVO vo, SwNote_tb swnote_tb, String currentPage) {
		System.out.println("SwController receiveNote start...");
    	int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		int total = sns.total3(emp_num);
		SwPaging sp = new SwPaging(total, currentPage);
		System.out.println("SwController receiveNote total->"+total);
		swnote_tb.setStart(sp.getStart());   // 시작시 1
		swnote_tb.setEnd(sp.getEnd());       // 시작시 15
		swnote_tb.setEmp_num(emp_num);      
		List<SwNote_tb> listSwNote_tb = sns.listSwNote_tb(swnote_tb);
		model.addAttribute("total", total);
		model.addAttribute("listSwNote_tb", listSwNote_tb);
		model.addAttribute("sp",sp);
	return "note/receiveNote";
	}
	
	// 보낸 쪽지함
	@GetMapping("note/sentNote") 
 	public String sentNote(Model model, HttpSession session, SyMemberVO vo, SwNote_rcv_tb swnote_rcv_tb, String currentPage) {
		System.out.println("SwController sentNote Start...");
		int emp_num = (int)session.getAttribute("member"); 
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo); 
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo); 
		int total = sns.total2(emp_num);
		SwPaging sp = new SwPaging(total, currentPage);
		System.out.println("SwController receiveNote total->"+total);
		swnote_rcv_tb.setStart(sp.getStart());   // 시작시 1
		swnote_rcv_tb.setEnd(sp.getEnd());       // 시작시 10 
		swnote_rcv_tb.setEmp_num(emp_num);
		List<SwNote_rcv_tb> listSwNote_rcv_tb = sns.listSwNote_rcv_tb(swnote_rcv_tb); 
		model.addAttribute("total", total);
		model.addAttribute("listSwNote_rcv_tb", listSwNote_rcv_tb); 
		model.addAttribute("sp",sp);
	return "note/sentNote"; 
	}

	// 쪽지 보내기
	@GetMapping("note/sendNote")
	public String sendNote(Model model, HttpSession session, SyMemberVO vo, SwNote_tb swnote_tb, SwNote_rcv_tb swnote_rcv_tb) {
		System.out.println("SwController sendNote Start..."); 
		int emp_num = (int)session.getAttribute("member"); 
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo); 
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		List<Emp> listEmp = sns.listEmp();
		model.addAttribute("listEmp", listEmp); 
	 return "note/sendNote"; 
	 }
  
	// 쪽지 보내기 전송 & 파일 첨부
	@RequestMapping(value = "note/writeNoteTB", method = RequestMethod.POST) 
	public String writeNoteTB(Model model, HttpSession session, SyMemberVO vo, SwNote_tb swnote_tb, 
			SwNote_rcv_tb swnote_rcv_tb, HttpServletRequest request, MultipartFile file1, String currentPage) throws Exception{ 
		System.out.println("SwController writeNoteTB Start..."); 
		int emp_num = (int)session.getAttribute("member"); 
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);  
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo); 
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
	    int result1 = 0; 
		int result2 = 0; 
		int total = sns.total3(emp_num);
		SwPaging sp = new SwPaging(total, currentPage);
		swnote_tb.setStart(sp.getStart());   // 시작시 1
		swnote_tb.setEnd(sp.getEnd());       // 시작시 15
		swnote_tb.setEmp_num(emp_num);   
		SwNote_tb st = new SwNote_tb();
		swnote_tb.setNote_fl_nm(file1.getOriginalFilename());
		swnote_tb.setNote_fl_path(savedName);
		model.addAttribute("st", st);
		result1 = sns.insertNote_tb(swnote_tb); //여기서 파일이름, 파일경로를 넣음.
		result2 = sns.insertNote_rcv_tb(swnote_rcv_tb);
		List<Emp> listEmp = sns.listEmp(); 
		model.addAttribute("listEmp", listEmp);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("total", total);
		model.addAttribute("sp",sp);
		System.out.println("result1의 결과값은 -->" + result1);
		System.out.println("result2의 결과값은 -->" + result2); 
	return "note/sendNote"; 
	}

	private String uploadFile(String originalName, byte[] fileData , String uploadPath) 
		  throws Exception {
		UUID uid = UUID.randomUUID();
		File fileDirectory = new File(uploadPath);
		if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
		}
	    String savedName = uid.toString() + "_" + originalName;
	    File target = new File(uploadPath, savedName);
	    FileCopyUtils.copy(fileData, target);
	return savedName;
	}	 
	
	// 받은 쪽지함 삭제
	@RequestMapping("note/deleteNote") 
 	public String deleteNote(HttpServletRequest request, Model model, HttpSession session, SyMemberVO vo, SwNote_tb swnote_tb, SwNote_rcv_tb swnote_rcv_tb, String currentPage) { 
		System.out.println("SwController deleteNote Start ..." ); 
		int emp_num = (int)session.getAttribute("member"); 
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo); 
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);		
		
		try {
				request.setCharacterEncoding("utf-8"); 
				String zero = "0"; 
				String[] checks = request.getParameterValues("check1"); 
		for (int i=0;i<checks.length;i++){
			if(checks[i].equals(zero)) { 
				System.out.println("Zero i -> "+ i ); 
	  	} else {
			  System.out.println("i -> "+ i ); 
			  System.out.println("checks[i]->"+ checks[i]); 
			  int result1 = sns.delete1(checks[i]); 
			  int result2 = sns.delete2(checks[i]); 
			  System.out.println("result1의 결과값은 -->" + result1);
			  System.out.println("result2의 결과값은 -->" + result2); 
			  int total = sns.total();
			  SwPaging sp = new SwPaging(total, currentPage);
			  swnote_tb.setStart(sp.getStart());   // 시작시 1
			  swnote_tb.setEnd(sp.getEnd());       // 시작시 10 
			  swnote_tb.setEmp_num(emp_num); 
			  List<SwNote_tb> listSwNote_tb = sns.listSwNote_tb(swnote_tb);
			  model.addAttribute("total", total);
			  model.addAttribute("listSwNote_tb", listSwNote_tb);
			  model.addAttribute("sp",sp);
	  		} 
	  	} 
		} catch (UnsupportedEncodingException e) { 
		  	e.printStackTrace(); 
		} 
	return "note/receiveNote"; 
	}

	// 받은 쪽지함 상세보기 
 	@GetMapping("note/receiveDetailNote") 
 	public String receiveDetailNote(HttpServletRequest request, Model model, HttpSession session, SyMemberVO vo, SwNote_tb swnote_tb) { 
 		System.out.println("SwController receiveDetailNote Start ..." );
 		int result = 0;
 		int emp_num = (int)session.getAttribute("member"); 
 		vo.setEmp_num(emp_num); 
 		SyMemberVO svo = jrs.show(vo); 
 		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		List<SwNote_tb> receiveDetailNote = sns.receiveDetailNote(swnote_tb.getNote_sq());
		result = sns.update(swnote_tb.getNote_sq());
		System.out.println("SwController receiveDetailNote update의 결과는-->" + result);
		model.addAttribute("receiveDetailNote", receiveDetailNote); 
		model.addAttribute("result", result);
	return "note/receiveDetailNote"; 
	}
  
	// 보낸 쪽지함 상세보기
 	@GetMapping("note/sentDetailNote") 
 	public String sentDetailNote(HttpServletRequest request, Model model, HttpSession session, SyMemberVO vo, SwNote_rcv_tb swnote_rcv_tb) { 
 		System.out.println("SwController sentDetailNote Start ..." );
		int emp_num = (int)session.getAttribute("member"); 
		vo.setEmp_num(emp_num); 
		SyMemberVO svo = jrs.show(vo); 
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);			  
		List<SwNote_rcv_tb> sentDetailNote = sns.sentDetailNote(swnote_rcv_tb.getNote_sq());
		model.addAttribute("receiveDetailNote", sentDetailNote); 
	return "note/sentDetailNote"; 
 	}
 	
}