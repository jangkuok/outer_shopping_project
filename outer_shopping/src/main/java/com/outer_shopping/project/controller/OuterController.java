package com.outer_shopping.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.outer_shopping.project.service.ColorService;
import com.outer_shopping.project.service.OuterService;
import com.outer_shopping.project.service.OuterSizeService;
import com.outer_shopping.project.service.WishListSerice;
import com.outer_shopping.project.vo.ColorVo;
import com.outer_shopping.project.vo.OuterSizeVo;
import com.outer_shopping.project.vo.OuterVo;
import com.outer_shopping.project.vo.WishListVo;

@Controller
@RequestMapping("/outer")
public class OuterController {
	@Autowired
	private OuterService service;
	
	@Autowired
	private OuterSizeService sizeService;
	
	@Autowired
	private WishListSerice wishService;
	
	@RequestMapping("/outerView.do")
	public String outerView(Model model, @RequestParam(value="outerNo",required=false) int outerNo) {
		
		OuterVo outer = new OuterVo();
		outer = service.getOuter(outerNo);
	
		model.addAttribute("outer", outer);

		
		return "outerViewPage";
	}
	
	@RequestMapping(value = "/outerSizeCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public List<OuterSizeVo> outerSizeCheck(@RequestParam(value="outerNo",required=false) int outerNo,
			@RequestParam(value="type",required=false) String type) {
		
			List<OuterSizeVo> list = sizeService.getListOuterSizeColor(outerNo, type);
		
			return list;
	}
	
	@RequestMapping(value = "/createWishList.do", method = RequestMethod.POST)
	@ResponseBody
	public String createWishList(@RequestParam(value="outerNo",required=false) int outerNo,
			@RequestParam(value="id",required=false) String memberId) {
		
			WishListVo wish = new WishListVo();

			wish.setOuterNo(outerNo);
			wish.setMemberId(memberId);
			
			wishService.createWishList(wish);
			
			return "등록완료";
			
	}
}
