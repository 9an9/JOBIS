package com.oracle.s20210704.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JhFileController {
	private static final String FILE_SERVER_PATH = "C:/test";
	
	@RequestMapping("common/upload")
	public String upload(@RequestParam("uploadFile") MultipartFile file, ModelAndView mv, Model model) throws IllegalStateException, IOException {
		if(!file.getOriginalFilename().isEmpty()) {
			file.transferTo(new File(FILE_SERVER_PATH, file.getOriginalFilename()));
			model.addAttribute("msg", "File uploaded successfully.");
		}else {
			model.addAttribute("msg", "Please select a valid mediaFile...");
		}
		return "rr/rrwriteForm";
	}
}
