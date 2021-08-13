package com.oracle.s20210704.service;

import java.util.List;

import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.model.SySurvey;

public interface SySurveyService {

	List<SySurvey> ssList();
	int surveyTotal();
	int insert(SySurvey sySurvey);
	List<SySurvey> ssList(SySurvey sySurvey);
	
	
	SySurvey detail(int survey_num);
	SyMemberVO show(SyMemberVO vo);
	
//	//설문조사 답변 값 입력
//		int insertansw(SySurvey sySurvey);
	
	

}
