package com.outer_shopping.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.outer_shopping.project.service.MemberService;
import com.outer_shopping.project.service.OuterService;
import com.outer_shopping.project.service.OuterSizeService;
import com.outer_shopping.project.vo.MemberVo;
import com.outer_shopping.project.vo.OuterSizeVo;
import com.outer_shopping.project.vo.OuterVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OuterService outerService;
	

	
	/**
	 * 메인페이지
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage(Model model) {
		
		List<OuterVo> list = outerService.findOuterList();
		
		System.out.println(list);
		model.addAttribute("list",list);
		
		return "mainPage";
	}
	
	/**
	 * 회원가입 페이지 이동
	 */
	@RequestMapping(value = "/joinPage.do", method = RequestMethod.GET)
	public String joinPage(Model model) {
		
		if(!model.containsAttribute("memberVo")) 
			model.addAttribute("memberVo", new MemberVo());
		
		return "joinPage";
	}	
	
}
