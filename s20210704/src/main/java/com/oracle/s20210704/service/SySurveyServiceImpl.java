package com.oracle.s20210704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210704.dao.SySurveyDao;
import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.model.SySurvey;

@Service
public class SySurveyServiceImpl implements SySurveyService{
	
	@Autowired
		private SySurveyDao ssd;
	
	
	@Override
	public List<SySurvey> ssList(){
		List<SySurvey> ssList =ssd.ssList();
		return ssList;
	}
	
	@Override
	public List<SySurvey> ssList(SySurvey sySurvey) {
		List<SySurvey> ssList = ssd.ssList(sySurvey);
		return ssList;
	}
	
	@Override
	public SySurvey detail(int survey_num) {
		System.out.println("SySurveyServiceImpl detail...");
		SySurvey sySurvey= null;
		sySurvey = ssd.detail(survey_num);
		System.out.println("SySurveyServiceImpl detail=>"+survey_num);
		return sySurvey;
	}
	
   @Override
	public int surveyTotal() {
		int surveyTotal = ssd.surveyTotal();
		return surveyTotal;
	}
	
   @Override
   public int insert(SySurvey sySurvey) {
	int result=0;
	System.out.println("SyServiceImpl Start...");
	result = ssd.insert(sySurvey);
	return result;
}
   
//   @Override
//   public int insertansw(SySurvey sySurvey) {
//	   int result=0;
//		System.out.println("SyServiceImpl Start...");
//		result = ssd.insertansw(sySurvey);
//		return result;
//}
	@Override
	public SyMemberVO show(SyMemberVO vo) {
		System.out.println("SySurveyServiceImpl show...");
		SyMemberVO svo = null;
		svo = ssd.show(vo);
		return svo;

		
		


}


	}
