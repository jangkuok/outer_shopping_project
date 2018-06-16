package com.outer_shopping.project.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.outer_shopping.project.service.MemberService;
import com.outer_shopping.project.vo.MemberVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService service;
	
	/**
	 * 메인페이지
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage() {
		
		return "mainPage";
	}
	
	/**
	 * 회원가입 페이지 이동
	 */
	@RequestMapping(value = "/joinPage.do", method = RequestMethod.GET)
	public String joinPage(Model model) {
		
		if(!model.containsAttribute("memberVo")) 
			model.addAttribute("memberVo", new MemberVo());
		
		return "/member/joinPage";
	}	
	
	/**
	 * 로그인
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginForm(HttpSession session,Model model, @RequestParam(value="id",required=false) String id,@RequestParam(value="pw",required=false) String pw) {

		if(service.loginMember(id, pw) == true) {
			
			MemberVo member = new MemberVo();	
			member = service.viewMember(id); 
			
			session.setAttribute("loginId", id);
			session.setAttribute("userName", member.getName());	
		}else {
			model.addAttribute("msg","error");
		}
		
		return "mainPage";
	}
	
	/**
	 * 로그아웃
	 */
	@RequestMapping(value ="/logout.do", method = RequestMethod.POST)
	public ModelAndView logout(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		session.invalidate();
		
		mv.setViewName("mainPage");
		
		return mv;
	}
}
