package com.outer_shopping.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.outer_shopping.project.service.MemberService;
import com.outer_shopping.project.service.WishListSerice;
import com.outer_shopping.project.vo.MemberVo;
import com.outer_shopping.project.vo.WishListVo;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private WishListSerice wishListService;
	
	//회원가입 성공
	@RequestMapping("/successJoinPage.do")
	public String successPage() {
		
		return "/member/successJoinPage";
	}	

	/**
	 * 회원가입 폼
	 */
	@RequestMapping(value = "/joinCheck.do", method = RequestMethod.POST)
	public ModelAndView joinForm(Model model,@Valid @ModelAttribute("memberVo") MemberVo memberVo,
								BindingResult errors) {
	
		ModelAndView mv = new ModelAndView();
	        
		//에러 발생시 
		if(errors.hasErrors()) {
			System.out.println("회원가입 에러");
			logger.info("###########회원가입 에러###########");

			mv.addObject("error","error");
			mv.addObject("memberVo", memberVo);
			mv.setViewName("joinPage");
			
		}else{

			service.joinMember(memberVo,memberVo.getId(),memberVo.getPw());
			
			mv.addObject("member", memberVo);
			mv.setViewName("member/successJoinPage");
	       
		}
			
		return mv;
	}	

	/**
	 * 아이디 중복확인
	 */
	@RequestMapping(value="/checkMemberId.do", method = RequestMethod.POST)
	@ResponseBody
	public String MemberidCheck(@RequestParam(value="id",required=false) String id) {
		
		int cnt = 3;
		
		if(id.length() >= 8 ) {
				cnt = service.checkMemberId(id);
		}
		System.out.println(id);
		
		return String.valueOf(cnt);
	}
	
	/**
	 * 회원 정보 확인(마이페이지) 
	 */
	@RequestMapping(value="/myPage.do", method = RequestMethod.POST)
	public String myPage(Model model,@RequestParam(value="id",required=false) String id) {
		
		model.addAttribute("memberVo", service.viewMember(id));
		
		return "member/myPage";
	}
	
	/**
	 * 수정페이지 이동 
	 */
	@RequestMapping(value="/modifyPage.do", method = RequestMethod.POST)
	public String modifyPage(Model model,@RequestParam(value="id",required=false) String id) {
		
		model.addAttribute("memberVo", service.viewMember(id));
		
		return "member/modifyPage";
	}
	
	/**
	 * 회원정보 수정하기
	 */
	@RequestMapping(value = "/modifyCheck.do", method = RequestMethod.POST)
	public ModelAndView modifyCheck(Model model,@Valid @ModelAttribute("memberVo") MemberVo memberVo,
								BindingResult errors) {
	
		ModelAndView mv = new ModelAndView();
	        
		//에러 발생시 
		if(errors.hasErrors()) {
			System.out.println("회원수정 에러");
			logger.info("###########회원수정 에러###########");
			
			mv.addObject("error","error");
			mv.addObject("memberVo", memberVo);
			mv.setViewName("member/modifyPage");
			
		}else{

			service.modifyMember(memberVo);
			mv.addObject("memberVo", memberVo);
			mv.setViewName("member/myPage");
		}
			
		return mv;
	}	
	/**
	 * 회원정보 삭제
	 */
	@RequestMapping(value = "/deleteMember.do", method = RequestMethod.POST)
	public String deleteMember(Model model,@RequestParam(value="id",required=false) String id,
			@RequestParam(value="pw",required=false) String pw, @RequestParam(value="pw2",required=false) String pw2, HttpSession session,
			RedirectAttributes redirectAttributes) {
		
		System.out.println("1" + pw + "2" + pw2);
		
		if(pw.equals(pw2)) {
			service.deleteMember(id);
			
			session.invalidate();
		}else {

			model.addAttribute("msg", "deleteError");
			model.addAttribute("memberVo", service.viewMember(id));
			
			return "member/myPage";
		}
			
		return "mainPage";
	}
	
	/**
	 * 관심상품 조회
	 */
	@RequestMapping(value = "/wishListSearch.do", method = RequestMethod.POST)
	public String wishListSearch(Model model,@RequestParam(value="id",required=false) String id) {
		
		List<WishListVo> list = wishListService.getWishList(id);
		
		model.addAttribute("list", list);

		return "member/wishListPage";
	}
	
}
