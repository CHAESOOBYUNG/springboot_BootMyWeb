package com.coding404.myweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.Practice1VO;
import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.practice1.Practice1Service;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.Criteria1;
import com.coding404.myweb.util.Page1VO;
import com.coding404.myweb.util.PageVO;

@Controller
@RequestMapping("/practice1")
public class Practice1Controller {
	
	@Autowired
	@Qualifier("practice1Service")
	private Practice1Service practice1Service;
	
	//등록화면
	@GetMapping("/topicReg")
	public String topicReg() {
		
		return "practice1/topicReg";
	}
	
	//목록화면 전체
	@GetMapping("/topicListAll")
	public String topicListAll(Model model, Criteria1 cri1) {
		//페이지
		ArrayList<Practice1VO> list = practice1Service.getListAll(cri1); 
		int total = practice1Service.getTotal(cri1);
		
		Page1VO page1VO = new Page1VO(cri1, total);
		
		//데이터 저장
		model.addAttribute("list", list);
		model.addAttribute("pageVO", page1VO);
		
		return "practice1/topicListAll";
	}
	
	//목록화면 자신
	@GetMapping("/topicListMe")
	public String topicListMe(Model model, Criteria1 cri1) {
		
		//페이지
		ArrayList<Practice1VO> list = practice1Service.getListMe(cri1); 
		int total = practice1Service.getTotal(cri1);
				
		Page1VO page1VO = new Page1VO(cri1, total);
				
		//데이터 저장
		model.addAttribute("list", list);
		model.addAttribute("pageVO", page1VO);
		
		return "practice1/topicListMe";
	}
	
	//상세화면 - 화면에서는 topic_name를 넘긴다
		@GetMapping("topicDetail")
		public String productDetail(@RequestParam("topic_name") int topic_name,
									Model model) {
			
			//데이터 저장
			Practice1VO practice1VO = practice1Service.getDetail(topic_name);
			model.addAttribute("practice1VO", practice1VO);
			
			return "practice1/topicDetail";
		}
	
	//수정화면 
	@GetMapping("/topicModify")
	public String topicModify() {
		
		return "practice1/topicModify";
	}
	
	//등록 폼
	@PostMapping("/topicForm")
	public String topicForm(Practice1VO vo,
							RedirectAttributes RA) {
		
		//vo를 등록
		System.out.println(vo.toString());
		int result = practice1Service.regist(vo);
		
		if(result == 1) { //성공
			RA.addFlashAttribute("msg", vo.getTopic_title() + "이 정상적으로 등록되었습니다");
		} else { //실패
			RA.addAttribute("msg", "등록실패, 관리자에게 문의하세요");
		}
		
		return "redirect:/practice1/topicListAll";
	}
	
	//수정
	@PostMapping("/topicUpdate")
	public String topicUpdate(@Valid Practice1VO vo,
							  Errors errors,
							  RedirectAttributes RA,
							  Model model) {
		System.out.println(vo.toString());
		if(errors.hasErrors()) {
			
			List<FieldError> list = errors.getFieldErrors();
			
			for(FieldError err : list) {
				
				if(err.isBindingFailure()) {
					model.addAttribute("valid_" + err.getField(), "형식을 확인하세요");
				} else {
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
				}
			}
			
			model.addAttribute("practice1VO", vo);
			
			return "practice1/topicDetail";
		}
		
		//업데이트
		int result = practice1Service.update(vo);
		if(result == 1) {
			RA.addFlashAttribute("msg", vo.getTopic_name() + "이 수정되었습니다");
		} else {
			RA.addFlashAttribute("msg", "수정에 실패했습니다.");
		}
		
		return "redirect:practice1/topicListAll";
	}
	
	//삭제
	@PostMapping("/topicDelete")
	public String topicDelete(@RequestParam("topic_id") int topic_id,
							  RedirectAttributes RA) {
		
		int result = practice1Service.delete(topic_id);
		
		if(result == 1) {
			RA.addAttribute("msg", "글이 삭제되었습니다");
		} else {
			RA.addFlashAttribute("msg", "삭제에 실패했습니다");
		}
		
		return "redirect practice1/topicListAll";
	}
}
	

