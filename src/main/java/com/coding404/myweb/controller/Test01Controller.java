package com.coding404.myweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coding404.myweb.command.Test01VO;

@RestController
public class Test01Controller {
	@GetMapping("/getTest01Path/{pk}/{emp_key}") 
	public Test01VO getTest01Path(@PathVariable("pk") int pk,
							      @PathVariable("emp_key") int emp_key) {
	
		return new Test01VO(1, 1, "ddd", 11);
}
