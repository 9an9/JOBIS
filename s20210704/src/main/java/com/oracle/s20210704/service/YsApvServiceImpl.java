package com.oracle.s20210704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210704.dao.YsApvDao;
import com.oracle.s20210704.model.YsApv;

@Service
public class YsApvServiceImpl implements YsApvService {

	@Autowired
	private YsApvDao yad;
	
	@Override
	public int rcvTotal(int rcv_num) {
		int rcvTotal = yad.rcvTotal(rcv_num);
		return rcvTotal;
	}
	
	@Override
	public List<YsApv> apv_RcvList(YsApv ysApv) {
		List<YsApv> apv_RcvList = yad.apv_RcvList(ysApv);
		return apv_RcvList;
	}


}
