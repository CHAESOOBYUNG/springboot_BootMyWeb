package com.coding404.myweb.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;

@Data
public class Page1VO {
	
	private int start;
	private int end;
	private boolean prev;
	private boolean next;
	
	private int page;
	private int amount;
	private int total;
	private int realEnd;
	
	private Criteria1 cri;
	
	private List<Integer> pageList;//start~end페이지 까지 번호
	
	public Page1VO(Criteria1 cri, int total) {
		
		this.page = cri.getPage();
		this.amount = cri.getAmount();
		this.total = total;
		this.cri = cri;
		
		this.end = (int)Math.ceil(this.page / 10.0 ) * 10;
		
		this.start = this.end - 10 + 1;
		
		this.realEnd = (int)Math.ceil(this.total / (double)this.amount );
		
		if(this.end > this.realEnd) {
			this.end = this.realEnd;
		}
		
		this.prev = this.start > 1;
		
		this.next = this.realEnd > this.end;
		
		this.pageList = IntStream.rangeClosed(this.start, this.end).boxed().collect( Collectors.toList() );
		
	}
}
