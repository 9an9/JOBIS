package com.oracle.s20210704.service;

import java.util.List;

import com.oracle.s20210704.model.YsApv;

public interface YsApvService {
	int         rcvTotal(int rcv_num);
	int         sndTotal(int snd_num);
	List<YsApv> apv_RcvList(YsApv ysApv);
	List<YsApv> apv_SndList(YsApv ysApv);
}
