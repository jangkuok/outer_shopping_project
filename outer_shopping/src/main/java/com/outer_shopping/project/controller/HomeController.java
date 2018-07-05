package com.outer_shopping.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.outer_shopping.project.service.AuthorityService;
import com.outer_shopping.project.service.MemberService;
import com.outer_shopping.project.service.OuterService;
import com.outer_shopping.project.service.OuterSizeService;
import com.outer_shopping.project.vo.AuthorityVo;
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
	private AuthorityService authorityService;
	
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
		
		logger.info("############# 메인페이지 이동 #############");
		
		return "main/mainPage";
	}
	
	/**
	 * 회원가입 페이지 이동
	 */
	@RequestMapping(value = "/joinPage.do", method = RequestMethod.GET)
	public String joinPage(Model model) {
		
		if(!model.containsAttribute("memberVo")) 
			model.addAttribute("memberVo", new MemberVo());
		
		logger.info("############# 회원가입페이지 이동 #############");
		
		return "joinPage";
	}	
	

	/**
	 * 아이디 중복확인
	 */
	@RequestMapping(value="/checkMember.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String memberIdCheck(@RequestParam(value="joinId",required=false) String joinId) {
		
		logger.info("############# 아이디 중복확인 #############");
		int cnt = 3;
		
		if(joinId.length() >= 8 ) {
			cnt = memberService.checkMemberId(joinId);
		}

		return Integer.toString(cnt);
	}
	
	
	/**
	 * 회원가입
	 */
	@RequestMapping(value = "/joinCheck.do", method = RequestMethod.POST)
	public ModelAndView joinForm(Model model,@Valid @ModelAttribute("memberVo") MemberVo memberVo,
								BindingResult errors) {
	
		ModelAndView mv = new ModelAndView();
	        
		//에러 발생시 
		if(errors.hasErrors()) {
			logger.info("############# 회원가입 에러 #############");
			
			mv.addObject("error","error");
			mv.addObject("memberVo", memberVo);
			mv.setViewName("joinPage");
			
			return mv;
		}else{
			AuthorityVo authority = new AuthorityVo();
			
			authority.setLoginId(memberVo.getId());
			authority.setLoginPw(memberVo.getPw());
			authority.setLoginAuthority("ROLE_USER");

			authorityService.createAuthority(authority);
			
			memberService.joinMember(memberVo,memberVo.getId(),memberVo.getPw());
			
			mv.addObject("member", memberVo);
			mv.setViewName("member/successJoinPage");
	       
			logger.info("############# 회원가입 완료 #############");
		}
			
		return mv;
	}	

	/**
	 * 로그인 페이지 이동
	 */
	@RequestMapping(value = "/loginFormPage.do", method = RequestMethod.GET)
	public String loginFormPage(Model model) {
		
		logger.info("############# 로그인 페이지 이동 #############");
		
		return "loginFormPage";
	}
}
