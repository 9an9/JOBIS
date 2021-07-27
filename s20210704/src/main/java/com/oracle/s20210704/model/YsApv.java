package com.oracle.s20210704.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YsApv {

	//APV
	private  int   apv_sq;        private String apv_type;    private  int   apv_snd;
	private  int   apv_mid;       private  int   apv_fnl;     private String apv_title;
	private String apv_content;   private String apv_pl_ph;   private String apv_pl_nm;
	private  Date  apv_date;      private String apv_no;      private  int   apv_ok;
	
	//APV_MID
	private  int   apv_mid_num;
	private  int   apv_mid_emp;
	private  int   apv_mid_ok;
	
	//조회용
	private String srt_name;      private String mid_name;    private String fnl_name;
	private  int   start;         private  int   end;         private  int   fnlChk;
}
