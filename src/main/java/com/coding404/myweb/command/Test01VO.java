package com.coding404.myweb.command;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Test01VO {
	private Integer pk; //관리자 인증키
	private Integer emp_key; //사원코드
	private String address; //사원 주소
	private Integer salary; //사원 급여
}
