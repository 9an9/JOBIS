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

import com.oracle.s20210704.model.YjEmp;
import com.oracle.s20210704.model.SwMsg;
import com.oracle.s20210704.model.SwMsg_rcv;
import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.service.JhRrService;
import com.oracle.s20210704.service.SwMsgService;
import com.oracle.s20210704.service.SwPaging;
import com.oracle.s20210704.service.YsApvService;


@Controller
public class SwController {
	
	@Autowired
	private SwMsgService sms;
	
	@Autowired
	private JhRrService jrs;
	
	@Autowired
	private YsApvService yas;
	
	private static final Logger logger = LoggerFactory.getLogger(SwController.class);
	
	// 보낸 메시지
	@GetMapping("message/sentMsg") 
 	public String sentMsg(Model model, HttpSession session, SyMemberVO vo, SwMsg_rcv swmsg_rcv, String currentPage) {
		System.out.println("SwController sentMsg Start...");
		int emp_num = (int)session.getAttribute("member"); 
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo); 
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo); 
		int total = sms.total(emp_num);
		SwPaging sp = new SwPaging(total, currentPage);
		swmsg_rcv.setStart(sp.getStart());   // 시작시 1
		swmsg_rcv.setEnd(sp.getEnd());       // 시작시 10 
		swmsg_rcv.setEmp_num(emp_num);
		List<SwMsg_rcv> msg_rcvList = sms.msg_rcvList(swmsg_rcv); 
		model.addAttribute("total", total);
		model.addAttribute("msg_rcvList", msg_rcvList); 
		model.addAttribute("sp",sp);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
	return "message/sentMsg"; 
	}
		
	// 받은 메시지
	@GetMapping("message/rcvMsg")
	public String rcvMsg(Model model, HttpSession session, SyMemberVO vo, SwMsg swmsg, String currentPage) {
		System.out.println("SwController rcvMsg start...");
    	int emp_num = (int)session.getAttribute("member");
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		
		int total = sms.total2(emp_num);
		SwPaging sp = new SwPaging(total, currentPage);
		swmsg.setStart(sp.getStart());   // 시작시 1
		swmsg.setEnd(sp.getEnd());       // 시작시 15
		swmsg.setEmp_num(emp_num);      
		List<SwMsg> msgList = sms.msgList(swmsg);
		model.addAttribute("total", total);
		model.addAttribute("msgList", msgList);
		model.addAttribute("sp",sp);

		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
	return "message/rcvMsg";
	}

	// 메시지 보내기 페이지
	@GetMapping("message/sendMsg")
	public String sendMsg(Model model, HttpSession session, SyMemberVO vo, SwMsg swmsg, SwMsg_rcv swmsg_rcv) {
		System.out.println("SwController sendMsg Start..."); 
		int emp_num = (int)session.getAttribute("member"); 
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo); 
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		List<YjEmp> listEmp = sms.listEmp();
		model.addAttribute("listEmp", listEmp); 
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
	return "message/sendMsg"; 
	}
  
	// 메시지 보내기 전송 & 파일 첨부
	@RequestMapping(value = "message/writeMsg", method = RequestMethod.POST) 
	public String writeMsg(Model model, HttpSession session, SyMemberVO vo, SwMsg swmsg, 
		SwMsg_rcv swmsg_rcv, HttpServletRequest request, MultipartFile file1, String currentPage) throws Exception{ 
		System.out.println("SwController writeMsg Start...");
		int emp_num = (int)session.getAttribute("member"); 
		vo.setEmp_num(emp_num);
		SyMemberVO svo = jrs.show(vo);  
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo); 
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
	    int result1 = 0; 
		int result2 = 0; 
		swmsg.setEmp_num(emp_num); 
		swmsg.setMsg_fl_nm(file1.getOriginalFilename());
		swmsg.setMsg_fl_path(savedName);
		result1 = sms.insertMsg(swmsg); 
		result2 = sms.insertMsg_rcv(swmsg_rcv);
		List<YjEmp> listEmp = sms.listEmp(); 
		model.addAttribute("listEmp", listEmp);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
	return "message/sendMsg"; 
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
	
	// 받은 메시지 삭제
	@RequestMapping("message/deleteMsg")
 	public String deleteMsg(HttpServletRequest request, Model model, HttpSession session, SyMemberVO vo, SwMsg swmsg, SwMsg_rcv swmsg_rcv, String currentPage) { 
		System.out.println("SwController deleteMsg Start ..." ); 
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
						  int result = sms.delete(checks[i]);  
						  int total = sms.total2(emp_num);
						  SwPaging sp = new SwPaging(total, currentPage);
						  swmsg.setStart(sp.getStart());   // 시작시 1
						  swmsg.setEnd(sp.getEnd());       // 시작시 15
						  swmsg.setEmp_num(emp_num);      
						  List<SwMsg> msgList = sms.msgList(swmsg);
						  model.addAttribute("total", total);
						  model.addAttribute("msgList", msgList);
						  model.addAttribute("sp",sp);
						  model.addAttribute("result", result);
						  System.out.println("result의 결과는 --> " + result);
				  } 
			  	} 
		}catch (UnsupportedEncodingException e) { 
				e.printStackTrace(); 
		} 
	return "message/rcvMsg"; 
	}

	// 받은 메시지 상세보기 
 	@GetMapping("message/rcvDetailMsg") 
 	public String rcvDetailMsg(HttpServletRequest request, Model model, HttpSession session, SyMemberVO vo, SwMsg swmsg) { 
 		System.out.println("SwController rcvDetailMsg Start ..." );
 		int result = 0;
 		int emp_num = (int)session.getAttribute("member"); 
 		vo.setEmp_num(emp_num); 
 		SyMemberVO svo = jrs.show(vo); 
 		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);
		List<SwMsg> rcvDetailMsg = sms.rcvDetailMsg(swmsg.getMsg_sq());
		result = sms.update(swmsg.getMsg_sq());
		model.addAttribute("rcvDetailMsg", rcvDetailMsg);
		model.addAttribute("result", result);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
	return "message/rcvDetailMsg"; 
	}
  
	// 보낸 메시지 상세보기
 	@GetMapping("message/sentDetailMsg") 
 	public String sentDetailMsg(HttpServletRequest request, Model model, HttpSession session, SyMemberVO vo, SwMsg_rcv swmsg_rcv) { 
 		System.out.println("SwController sentDetailMsg Start ..." );
		int emp_num = (int)session.getAttribute("member"); 
		vo.setEmp_num(emp_num); 
		SyMemberVO svo = jrs.show(vo); 
		model.addAttribute("emp_num",emp_num);
		model.addAttribute("svo",svo);			  
		List<SwMsg_rcv> sentDetailMsg = sms.sentDetailMsg(swmsg_rcv.getMsg_sq());
		model.addAttribute("sentDetailMsg", sentDetailMsg); 
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
	return "message/sentDetailMsg"; 
 	}
 	
}