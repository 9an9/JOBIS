package com.oracle.s20210704.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.s20210704.model.JhCalendar;
import com.oracle.s20210704.model.JhReplyVO;
import com.oracle.s20210704.model.JhRr;
import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.service.JhCalendarService;
import com.oracle.s20210704.service.JhPaging;
import com.oracle.s20210704.service.JhRrService;
import com.oracle.s20210704.service.JhRrcService;

import oracle.jdbc.proxy.annotation.Post;




@Controller
public class JhController {
	
	@Autowired
	private JhCalendarService jcs;
	@Autowired
	private JhRrService jrs;
	@Autowired
	private JhRrcService jrcs;
	
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
		model.addAttribute("svo",svo);//모든 코딩에 추가
		System.out.println(emp_num+"rrr");
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
	public String detail(HttpServletRequest request, int rr_num, Model model, HttpSession session, SyMemberVO vo, int detail_num) throws Exception {
		System.out.println("JhController Start detail"+rr_num);
		System.out.println("JhController rr_num->" + rr_num);
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		JhRr jhRr = jrs.detail(rr_num);
		//jrcs.writeReply(jvo);
		System.out.println("JhController detail->"+jhRr.getRr_num());
		System.out.println("JhController detail->"+jhRr.getRr_content());
		System.out.println("JhController detail->"+jhRr.getRr_subject());
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		model.addAttribute("jhRr", jhRr);
		model.addAttribute("detail_num", detail_num);
		// 댓글조회부분 삭제가능
		List<JhReplyVO> replyList = jrcs.readReply(jhRr.getRr_num());	//댓글목록
		model.addAttribute("replyList", replyList);						//댓글목록
		//
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
	public String write(JhRr jhRr, Model model, HttpSession session, SyMemberVO vo, HttpServletRequest request, MultipartFile file1) throws Exception { 
																		  //파일업로드 HttpServletRequest request, MultipartFile file1
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");	//파일업로드
		String saveName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);//파일업로드
		jhRr.setRr_filename(saveName);															//파일업로드
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		System.out.println("JhController write Start...");
		int result = jrs.insert(jhRr);						//mpRequest 삭제가
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		if(result > 0) return "redirect:rr";
		else {
			return "forward:rrwriteForm";
		}
	}
	
	// 자료실 업데이트 폼
	@GetMapping(value = "rr/rrupdateForm")
	public String rrupdateForm(int rr_num, Model model, HttpSession session, SyMemberVO vo) {
		System.out.println("JhController clubupdateForm Start..");
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		
		JhRr jhRr = jrs.detail(rr_num);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		model.addAttribute("jhRr", jhRr);
		model.addAttribute("rr_num",rr_num);
		return "rr/rrupdateForm";
	}
	
	// 자료실 업데이트
	@PostMapping(value = "rr/rrupdate")
	public String rrupdate(JhRr jhRr, Model model, HttpSession session, SyMemberVO vo) {
		int cu = jrs.update(jhRr);
		System.out.println("jrs.update(jhRr) cu --> " + cu);
		model.addAttribute("cu", cu);
		model.addAttribute("cu1", "Message Test");
		return "redirect:rr";
	}
	
	//자료실 삭제
	@GetMapping(value = "rr/rrdelete")
	public String rrdelete(int rr_num, Model model, HttpSession session, SyMemberVO vo) {
		System.out.println("JhController rrdelete Start...");
		int result = jrs.delete(rr_num);
		return "redirect:rr";
	}
	
	//자료실 댓글 작성
	@RequestMapping(value = "rr/replyWrite", method = RequestMethod.POST)
	public String replyWrite(HttpServletRequest request, HttpSession session,JhReplyVO rvo, Model model) throws Exception {
		int emp_num = (int)session.getAttribute("member");	//로그인
		jrcs.writeReply(rvo);
		return "redirect:detail?rr_num="+rvo.getRr_num()+"&detail_num="+emp_num;
		
	}
	//자료실 댓글 삭제
	@RequestMapping(value = "rr/replyDelete", method = RequestMethod.GET)
	public String replyDelete(int rrc_num, JhReplyVO rvo, Model model, HttpSession session, HttpServletRequest request) {
		int emp_num = (int)session.getAttribute("member");
		int result = jrcs.deleteReply(rrc_num);
		return "redirect:detail?rr_num="+rvo.getRr_num()+"&detail_num="+emp_num;
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
	
	//동호회 삭제
	@GetMapping(value = "board/clubdelete")
	public String clubdelete(int rr_num, Model model, HttpSession session, SyMemberVO vo) {
		System.out.println("JhController clubdelete Start...");
		int result = jrs.delete(rr_num);
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
	
	// 공지사항 업데이트 폼
	@GetMapping(value = "board/noticeupdateForm")
	public String noticeupdateForm(int rr_num, Model model, HttpSession session, SyMemberVO vo) {
		System.out.println("JhController noticeupdateForm Start...");
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);						//모든 코딩에 추가
		
		JhRr jhRr = jrs.detail(rr_num);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);						//모든 코딩에 추가
		model.addAttribute("jhRr", jhRr);
		model.addAttribute("rr_num",rr_num);
		
		return "board/noticeupdateForm";
	}
	
	// 공지사항 업데이트
	@PostMapping(value = "board/noticeupdate")
	public String noticeupdate(JhRr jhRr, Model model, HttpSession session, SyMemberVO vo) {
		int cu = jrs.update(jhRr);
		System.out.println("jrs.update(jhRr) cu --> " + cu);
		model.addAttribute("cu", cu);
		model.addAttribute("cu1", "Message Test");
		return "redirect:noticeList";
	}
	
	//공지사항 삭제
	@GetMapping(value = "board/noticedelete")
	public String noticedelete(int rr_num, Model model, HttpSession session, SyMemberVO vo) {
		System.out.println("JhController noticedelete Start...");
		int result = jrs.delete(rr_num);
		return "redirect:noticeList";
	}
	
	//파일 다운로드
	 @GetMapping(value = "hhh")
	 public void fileDownload(HttpServletRequest request, HttpServletResponse response,String fileName)
	 throws ServletException, IOException {
	 	try {
	 		request.setCharacterEncoding("utf-8");
	 		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
	 				  
	 		// 다운받을 파일의 전체 경로를 filePath에 저장
	 		String filePath = uploadPath + fileName;
	 		// 다운받을 파일을 불러옴
	 		File file = new File(filePath);
	 		byte b[] = new byte[4096];
	 		// page의 ContentType등을 동적으로 바꾸기 위해 초기화시킴
	 		response.reset();
	 		response.setContentType("application/octet-stream");
	 		// 한글 인코딩
	 		String Encoding = new String(fileName.getBytes("UTF-8"), "8859_1");
	 		// 파일 링크를 클릭했을 때 다운로드 저장 화면이 출력되게 처리하는 부분
	 		response.setHeader("Content-Disposition", "attachment; filename = " + Encoding);
	 		// 파일의 세부 정보를 읽어오기 위해서 선언
	 		FileInputStream in = new FileInputStream(filePath);
	 		// 파일에서 읽어온 세부 정보를 저장하는 파일에 써주기 위해서 선언
	 		ServletOutputStream out2 = response.getOutputStream();
	 		int numRead;
	 		// 바이트 배열 b의 0번 부터 numRead번 까지 파일에 써줌 (출력)
	 		while((numRead = in.read(b, 0, b.length)) != -1){
	 			out2.write(b, 0, numRead);
	 		}  
	 		out2.flush();
	 		out2.close();
	 		in.close();
	 	 
	 	} catch (Exception e) {
	 		System.out.println(e.getMessage());
	 	} 
	 			
	 }
	 //파일 업로드
	 private String uploadFile(String orginalName, byte[] fileData, String uploadPath) throws Exception {
		 UUID uid = UUID.randomUUID();
		 File fileDirectory = new File(uploadPath);
		 if(!fileDirectory.exists()) {
			 fileDirectory.mkdirs();
		 }
		 String savedName = uid.toString() + "_" + orginalName;
		 File target = new File(uploadPath, savedName);
		 FileCopyUtils.copy(fileData, target);
		 return savedName;
	 }
	 
	 
	
}