package com.oracle.s20210704.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.SyMemberVO;
import com.oracle.s20210704.model.SySurvey;


@Repository
public class SySurveyDaoImpl implements SySurveyDao{
	
	@Autowired
	private SqlSession session;
	
@Override
public List<SySurvey> ssList() {
	List<SySurvey> ssList = session.selectList("sySurveyList");
	
	return ssList;
}
    @Override
	public List<SySurvey> ssList(SySurvey sySurvey) {
		List<SySurvey> ssList = session.selectList("sySurveyList",sySurvey);
		return ssList;
	}
	
   
   @Override
   public SySurvey detail(int survey_num) {
	SySurvey sySurvey =new SySurvey();
	try {
		sySurvey = session.selectOne("sySurveySelOne", survey_num);		
		System.out.println("sysurveyDaoImpl detail getSurveycontent->" + sySurvey.getSurvey_title());
	} catch(Exception e) {
		System.out.println("SySurveyDaoImpl detail Exception-> "+e.getMessage());
	}
	return sySurvey;
}
   
	@Override
	public int surveyTotal() {
		int surveyTotal =session.selectOne("sySurveyTotal");
		return surveyTotal;
	}
	@Override
	public SyMemberVO show(SyMemberVO vo) {
		System.out.println("JhRrDaoImpl SyMemberVO show start...");
		SyMemberVO syMemberVO = null;
		try {
			syMemberVO = session.selectOne("jhshow", vo);
			System.out.println("JhRrDaoImpl vo"+vo);
		} catch (Exception e) {
			System.out.println("JhRrDaoImplyu SyMemeberVO Exception->" + e.getMessage());
		}
		return syMemberVO;
	}

	@Override
	public List<SySurvey> listSySurvey(SySurvey SySurvey) {
		List<SySurvey> SySurveyList = null;
		System.out.println("SySurveyDaoImpl listSySurvey Start...");
		try {
			SySurveyList = session.selectList("SySurveyListAll", SySurvey);
		} catch(Exception e) {
			System.out.println("SySurveyDaoImpl listSySurvey Exception ->" + e.getMessage());
		}
		return SySurveyList;	
	}
	//설문조사 글 작성
	@Override
	public int insert(SySurvey sySurvey) {
		int result = 0;
		System.out.println("SySurveyDaoImpl insert Start...");
		try {
			result = session.insert("syInsertsySurvey", sySurvey);
		} catch (Exception e ) {
			System.out.println("SySurveyDaoImpl insert Exception -> "+e.getMessage());
		}
		return result;
	}
//	//설문조사 답변 작성
//	@Override
//	public int insertansw(SySurvey sySurvey) {
//		int result = 0;
//		System.out.println("SySurveyDaoImpl insertansw Start...");
//		try {
//			result = session.insert("syInsertSurveyAnsw", sySurvey);
//		} catch (Exception e ) {
//			System.out.println("SySurveyDaoImpl insertansw Exception -> "+e.getMessage());
//		}
//		return result;
//	
//	}
}
