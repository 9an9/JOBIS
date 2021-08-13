package com.oracle.s20210704.dao;

import java.util.List;

import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.model.SySurvey;

public interface SySurveyDao {
	List<SySurvey> ssList();
	List<SySurvey> ssList(SySurvey sySurvey);
	
    SySurvey detail(int survey_num);
    
	List<SySurvey> listSySurvey(SySurvey sySurvey);
	
	SyMemberVO show(SyMemberVO vo);


	int surveyTotal();
	//설문조사 글 값 입력
	int insert(SySurvey sySurvey);
//	//설문조사 답변 값 입력
//	int insertansw(SySurvey sySurvey);
}
