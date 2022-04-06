package com.coding404.myweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.product.ProductService;

@RestController
public class AjaxController {

	//프로덕트 서비스 영역으로 연결
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/getCategory")
	public ArrayList<CategoryVO> getCategory() {
		
		ArrayList<CategoryVO> list = productService.getCategory();
		//화면에 필요한 형식으로 변경해서 List<Map> 반환해도 됩니다.

		return list;
	}
	
	
}
