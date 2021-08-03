package com.oracle.s20210704.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.model.YsApv;
import com.oracle.s20210704.model.YsEmpCmt;
import com.oracle.s20210704.service.JhRrService;
import com.oracle.s20210704.service.YsApvService;
import com.oracle.s20210704.service.YsEmpCmtService;
import com.oracle.s20210704.service.YsPaging;



@Controller
public class YsController {

	@Autowired
	private YsEmpCmtService yecs;
	
	@Autowired
	private YsApvService    yas;
	
	@Autowired
	private JhRrService jrs;
	
	@GetMapping(value = "cmt/cmt")
	public String cmt(Model model , YsEmpCmt ysEmpCmt,String currentPage, HttpSession session, SyMemberVO  vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);
		
		int cmtTotal = yecs.cmtTotal();
		YsPaging yp = new YsPaging(cmtTotal, currentPage);
		ysEmpCmt.setStart(yp.getStart());
		ysEmpCmt.setEnd(yp.getEnd());
		List<YsEmpCmt> cmtList = yecs.cmtList(ysEmpCmt);
		model.addAttribute("cmtList", cmtList);
		model.addAttribute("yp", yp);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
		
		return "cmt/cmt";
	}
	
	@PostMapping(value = "cmt/cmtSearch")
	public String searchDateCmt(Model model , YsEmpCmt ysEmpCmt,String currentPage, HttpSession session, SyMemberVO  vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);
		
		
		
		int cmtTotal = 0;
		//상황별로 total 가져오기
		//날짜,이름 입력한경우
		if(ysEmpCmt.getSearchDept().equals("") && !ysEmpCmt.getSearchName().equals("")) { 
			cmtTotal = yecs.cmtNameTotal(ysEmpCmt);
		//날짜,부서 입력한경우
		} else if(!ysEmpCmt.getSearchDept().equals("") && ysEmpCmt.getSearchName().equals("")) {
			cmtTotal = yecs.cmtDeptTotal(ysEmpCmt);
		//날짜 입력한경우
		}else if(!ysEmpCmt.getSearchDept().equals("") && !ysEmpCmt.getSearchName().equals("")) {
			cmtTotal = yecs.cmtAllTotal(ysEmpCmt);	
		//날짜,부서,이름 입력한경우
		}else {
			cmtTotal = yecs.cmtDateTotal(ysEmpCmt);	
		}
		
		List<YsEmpCmt> cmtList = null;
		
		//페이징
		YsPaging yp = new YsPaging(cmtTotal, currentPage);
		ysEmpCmt.setStart(yp.getStart());
		ysEmpCmt.setEnd(yp.getEnd());
		
		//상황별로 페이징된 상태로 list 가져오기
		//날짜,이름 입력한경우
		if(ysEmpCmt.getSearchDept().equals("") && !ysEmpCmt.getSearchName().equals("")) {
			cmtList = yecs.cmtNameSearchList(ysEmpCmt);
		//날짜,부서 입력한경우
		} else if(!ysEmpCmt.getSearchDept().equals("") && ysEmpCmt.getSearchName().equals("")) {
			cmtList = yecs.cmtDeptSearchList(ysEmpCmt);
		//날짜 입력한경우
		}else if(!ysEmpCmt.getSearchDept().equals("") && !ysEmpCmt.getSearchName().equals("")) {
			cmtList = yecs.cmtAllSearchList(ysEmpCmt);		
		//날짜,부서,이름 입력한경우
		}else {
			cmtList = yecs.cmtDateSearchList(ysEmpCmt);	
		}
		model.addAttribute("ysEmpCmt", ysEmpCmt);
		model.addAttribute("cmtList", cmtList);
		model.addAttribute("yp", yp);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
		
		return "cmt/cmt";
		//커밋테스트 2
	}
	
	@PostMapping(value = "cmt/absent")
	public String absent(Model model , YsEmpCmt ysEmpCmt, HttpSession session, SyMemberVO  vo) {
		
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);
		
		
		
		Date absent = ysEmpCmt.getAbsent();
		
		System.out.println(ysEmpCmt.getAbsent());
		
		List<YsEmpCmt> absentList = yecs.absentList(absent);
		
		System.out.println(absentList.get(0).getEmp_name());
		
		
		model.addAttribute("absent", absent);
		model.addAttribute("absentList", absentList);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);

		return "cmt/absent";
	}
	
	@GetMapping(value = "cmt/absentMD")
	public String absentMD(Model model ,int num, String dt,YsEmpCmt ysEmpCmt, HttpSession session, SyMemberVO  vo) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("emp_num",emp_num);				//모든 코딩에 추가
		model.addAttribute("svo",svo);
		
		String cmt_str = dt + "09:00:00";
		String cmt_end = dt + "18:00:00";
		System.out.println("num : "+num);
		System.out.println("dt : "+cmt_str);
		System.out.println("dt : "+cmt_end);
		ysEmpCmt.setEmp_num(num);
		ysEmpCmt.setMd_str(cmt_str);
		ysEmpCmt.setMd_end(cmt_end);
		yecs.cmtInsert(ysEmpCmt);
		return "redirect:cmt";
	}
	@GetMapping(value = "cmt/mycmt")
	public String mycmt(Model model ,HttpSession session, SyMemberVO  vo, YsEmpCmt ysEmpCmt,String currentPage) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		
		int mycmtTotal = yecs.mycmtTotal(emp_num);
		model.addAttribute("mycmtTotal", mycmtTotal);
				
		YsPaging yp = new YsPaging(mycmtTotal, currentPage);
		ysEmpCmt.setStart(yp.getStart());
		ysEmpCmt.setEnd(yp.getEnd());
		ysEmpCmt.setEmp_num(emp_num);
		
		List<YsEmpCmt> mycmtList = yecs.mycmtList(ysEmpCmt);
		model.addAttribute("mycmtList", mycmtList);
		model.addAttribute("yp", yp);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
		
		return "cmt/mycmt";
	}
	@PostMapping(value = "cmt/cmtMD")
	public String mycmt(int state,String dt,int cmt_num,YsEmpCmt ysEmpCmt,String currentPage,RedirectAttributes redirect) {
		String cmt_str = null;
		String cmt_end = null;
		if(state == 1) {            //지각,연장
			cmt_str = dt + "09:01:00";
			cmt_end = dt + "21:01:00";
		}else if(state == 2) {      //지각,조퇴
			cmt_str = dt + "09:01:00";
			cmt_end = dt + "13:00:00";
		}else if(state == 3) {      //지각
			cmt_str = dt + "09:01:00";
			cmt_end = dt + "18:00:00";
		}else if(state == 4) {      //연장
			cmt_str = dt + "09:00:00";
			cmt_end = dt + "21:01:00";
		}else if(state == 5) {      //조퇴
			cmt_str = dt + "09:00:00";
			cmt_end = dt + "13:00:00";
		}else {                     //정상
			cmt_str = dt + "09:00:00";
			cmt_end = dt + "18:00:00";
		}
		ysEmpCmt.setCmt_num(cmt_num);
		ysEmpCmt.setMd_str(cmt_str);
		ysEmpCmt.setMd_end(cmt_end);
		yecs.cmtChange(ysEmpCmt);
		redirect.addAttribute("currentPage", currentPage);
		return "redirect:cmt";
	}
	
	/////////   결재      /////////
	
	//snd가 받은결제..연결점 잘못잡아서 그냥 이대로 진행
	@GetMapping(value = "apv/apvSnd")
	public String apvSnd(Model model ,HttpSession session, SyMemberVO vo,YsApv ysApv,String currentPage) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		model.addAttribute("emp_num", emp_num);
		
		int rcv_num = emp_num;
		int rcvTotal = yas.rcvTotal(rcv_num);
		
		YsPaging yp = new YsPaging(rcvTotal, currentPage);
		ysApv.setStart(yp.getStart());
		ysApv.setEnd(yp.getEnd());
		ysApv.setApv_mid_emp(rcv_num);
		
		List<YsApv> rcvList = yas.apv_RcvList(ysApv);
		model.addAttribute("rcvList", rcvList);
		model.addAttribute("yp", yp);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
		
		return "apv/apvSnd";
	}
	
	//rcv가 보낸결제..연결점 잘못잡아서 그냥 이대로 진행
	@GetMapping(value = "apv/apvRcv")
	public String apvRcv(Model model ,HttpSession session, SyMemberVO vo,YsApv ysApv,String currentPage) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		model.addAttribute("emp_num", emp_num);
		
		int snd_num = emp_num;
		int sndTotal = yas.sndTotal(snd_num);
		
		YsPaging yp = new YsPaging(sndTotal, currentPage);
		ysApv.setStart(yp.getStart());
		ysApv.setEnd(yp.getEnd());
		ysApv.setApv_snd(snd_num);
		
		List<YsApv> sndList = yas.apv_SndList(ysApv);
		model.addAttribute("sndList", sndList);
		model.addAttribute("yp", yp);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
		
		return "apv/apvRcv";
	}
	@GetMapping(value = "apv/apvWrite")
	public String apvWrite(Model model ,HttpSession session, SyMemberVO vo,YsApv ysApv) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		model.addAttribute("emp_num", emp_num);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
		
		
		return "apv/apvWrite";
	}
	
	@PostMapping(value = "apv/apvWrite")
	public String apvInsert(HttpServletRequest request, MultipartFile file1,YsApv ysApv) throws Exception {
		if(file1.isEmpty()) { ysApv.setApv_pl_nm("");}
		else {			
			String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
			String saveName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
			ysApv.setApv_pl_nm(saveName);
			
		}
		if(ysApv.getFnlChk() == 1) {        // 중간 결재자가 없는 경우 
			System.out.println("중간x");
			yas.fnlRcvInsert(ysApv);
		}else {                             // 중간 결재자가 있는 경우
			System.out.println("중간 o");
			yas.midRcvInsert(ysApv);
		}
		return "redirect:apvRcv";
	}
	
	@GetMapping(value = "apv/apvRcvDetail")
	public String apvRcvDetail(Model model ,HttpSession session, SyMemberVO vo,YsApv ysApv,int sq) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		model.addAttribute("emp_num", emp_num);
		
		ysApv.setApv_sq(sq);
		ysApv.setRcv_num(emp_num);

		YsApv rcvDetail = yas.rcvDetail(ysApv);
		model.addAttribute("rcvDetail", rcvDetail);
		
		List<YsApv> apv_ing = yas.apv_ing(sq);
		model.addAttribute("apv_ing", apv_ing);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
		
		return "apv/apvRcvDetail";
	}
	
	@PostMapping(value = "apv/apvok")
	public String apvok(YsApv ysApv) {
	
		if(ysApv.getApv_ok() == 1) {        //다음 결재가 중간결재인경우
			yas.midOk(ysApv);
		}else if(ysApv.getApv_ok() == 2) {  //다음 결재가 최종결재인경우
			yas.midToFnlOk(ysApv);
		}else if(ysApv.getApv_ok() == 3) {  //다음 결재가 없고 지금이 최종결재인경우
			yas.fnlOk(ysApv);
		}

		return "redirect:apvSnd";
	}
	@GetMapping(value = "apv/apvno")
	public String apvnp(int sq,String nono, YsApv ysApv) {
		ysApv.setApv_sq(sq);
		ysApv.setApv_no(nono);
		yas.apv_no(ysApv);
		return "redirect:apvSnd";
	}
	
	@GetMapping(value = "apv/apvSndDetail")
	public String apvSndDetail(Model model ,HttpSession session, SyMemberVO vo, int sq) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		model.addAttribute("emp_num", emp_num);
		
		YsApv sndDetail = yas.sndDetail(sq);
		model.addAttribute("sndDetail", sndDetail);
		
		List<YsApv> apv_ing = yas.apv_ing(sq);
		model.addAttribute("apv_ing", apv_ing);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
		
		return "apv/apvSndDetail";
	}
	
	@GetMapping(value = "apv/apvReWrite")
	public String apvReWrite(Model model ,HttpSession session, SyMemberVO vo, int sq) {
		int emp_num = (int)session.getAttribute("member");	//모든 코딩에 추가
		vo.setEmp_num(emp_num);								//모든 코딩에 추가
		SyMemberVO svo = jrs.show(vo);
		model.addAttribute("svo",svo);
		model.addAttribute("emp_num", emp_num);
		
		YsApv sndDetail = yas.sndDetail(sq);
		model.addAttribute("sndDetail", sndDetail);
		
		int unreadTotal = yas.unreadTotal(emp_num);
		int apvNoTotal  = yas.apvNoTotal(emp_num);
		model.addAttribute("unreadTotal", unreadTotal);
		model.addAttribute("apvNoTotal", apvNoTotal);
		
		YsApv nextEmp   = yas.nextEmp(sq);
		model.addAttribute("nextEmp", nextEmp);
		
		return "apv/apvReWrite";
	}
	
	@PostMapping(value = "apv/apvReWrite")
	public String apvReInsert(HttpServletRequest request, MultipartFile file1, YsApv ysApv)throws Exception {
		System.out.println("왔음1");
		if(ysApv.getApv_pl_nm().equals("change") || ysApv.getApv_pl_nm() == "change") {
			System.out.println("왔음2");
			String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
			String saveName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
			ysApv.setApv_pl_nm(saveName);			
		}
		System.out.println("왔음3");
		if(ysApv.getFnlChk() == 1) {        // 중간 결재자가 없는 경우 
			System.out.println("중간x");
			yas.fnlSndDelete(ysApv.getApv_sq());
			yas.fnlRcvInsert(ysApv);
		}else {                             // 중간 결재자가 있는 경우
			System.out.println("중간 o");
			yas.midSndDelete(ysApv.getApv_sq());
			yas.midRcvInsert(ysApv);
		}
		
		return "redirect:apvRcv";	
	}
	
	private String uploadFile(String orginalName, byte[] fileData, String uploadPath) throws Exception{
		UUID uid = UUID.randomUUID();
		// Directory 생성
		File fileDirectory = new File(uploadPath);
		if(!fileDirectory.exists()) {
			fileDirectory.mkdirs();
		}
		String savedName = uid.toString() + "_" + orginalName;
		File target = new File(uploadPath,savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
  @GetMapping(value = "apv/ysdownload")
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
  
  
  @GetMapping(value = "apv/fileDelete")
	public void uploadFileDelete(HttpServletRequest request, Model model,String fileName) throws Exception{
	   try {
		  String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		  String deleteFile = uploadPath + fileName;
		  upFileDelete(deleteFile);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
  	private void upFileDelete(String deleteFileName)   throws Exception {
		File file = new File(deleteFileName); 
		if( file.exists() ){ 
			file.delete();
		}
	}
	
}
