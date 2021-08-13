package com.oracle.s20210704.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SySurvey {
	
	private String survey_num;
	private int emp_num;
	private String survey_title;
    private int survey_state;
    private Date survey_stdate;
    private Date survey_fndate;

    
    
    private String survey_ques_content;
    private int survey_ques_id;
    
  
    private int survey_ans_content;
    
    
    private int start; 		 		
    private int end;
	
}
    

