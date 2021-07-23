package com.oracle.s20210704.service;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class YjPaging {
	private int currentPage = 1;	private int rowPage   = 15;
	private int pageBlock = 5;		
	private int start;				private int end;
	private int startPage;			private int endPage;
	private int total;				private int totalPage;

	public YjPaging(int total, String currentPage1) {
		this.total = total;
		if (currentPage1 != null) {
			this.currentPage = Integer.parseInt(currentPage1);			
		}
		start = (currentPage - 1) * rowPage + 1;  // 시작시 1
		end   = start + rowPage - 1;              // 시작시 10 
		totalPage = (int) Math.ceil((double)total / rowPage);  // 시작시 2
		startPage = currentPage - (currentPage - 1) % pageBlock; // 시작시 1
		endPage = startPage + pageBlock - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
	}
}
