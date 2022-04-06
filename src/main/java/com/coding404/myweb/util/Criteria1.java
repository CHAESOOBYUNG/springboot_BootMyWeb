package com.coding404.myweb.util;

import lombok.Data;

@Data //getter, setter
public class Criteria1 {
	
	private int page;
	private int amount;
	

	//검색키워드 추가
	private String searchTitle;
	private String searchName;
	private String searchContent;
	private String searchPrice;
	private String startDate;
	private String endDate;
	
	
	public Criteria1() {
		this(1, 10);
	}
	public Criteria1(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}
	

}
