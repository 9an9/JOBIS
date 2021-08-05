package com.oracle.s20210704.dao;





import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210704.model.SyMemberVO;
//import com.oracle.s20210704.model.SySurvey;



@Repository
public class SyMemberDaoImpl implements SyMemberDao{
	
	@Autowired 
	private SqlSession sql;

//	@Override
//	public List<SySurvey> ssList(){
//		List<SySurvey> ssList =sql.selectList("sySurveyList");
//		return ssList;
//		
//	}
//	
//	@Override
//	public List<SySurvey> listSySurvey(SySurvey sySurvey) {
//		List<SySurvey> sySurveyList =null;
//		return sySurveyList;
//	}


	@Override
	public SyMemberVO login(SyMemberVO vo) {
		// TODO Auto-generated method stub
		return sql.selectOne("sylogin",vo);
	}
}