package com.outer_shopping.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.outer_shopping.project.service.OuterService;
import com.outer_shopping.project.service.OuterSizeService;
import com.outer_shopping.project.service.WishListSerice;
import com.outer_shopping.project.vo.ProductVo;
import com.outer_shopping.project.vo.OuterSizeVo;
import com.outer_shopping.project.vo.OuterVo;
import com.outer_shopping.project.vo.WishListVo;

@Controller
@RequestMapping("/outer")
public class OuterController {
	
	private static final Logger logger = LoggerFactory.getLogger(OuterController.class);
	
	@Autowired
	private OuterService service;
	
	@Autowired
	private OuterSizeService sizeService;
	
	@Autowired
	private WishListSerice wishService;
	
	/**
	 * 아웃터 상세 정보
	 */
	@RequestMapping("/outerView.do")
	public String outerView(Model model, @RequestParam(value="outerNo",required=false) int outerNo) {
		
		OuterVo outer = new OuterVo();
		outer = service.getOuter(outerNo);
	
		model.addAttribute("outer", outer);
		
		logger.info("############# 아웃터 상세페이지 이동 #############");
		return "outerViewPage";
	}
	
	/**
	 * 아웃터 사이즈 확인
	 */
	@RequestMapping(value = "/outerSizeCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public List<OuterSizeVo> outerSizeCheck(@RequestParam(value="outerNo",required=false) int outerNo,
			@RequestParam(value="type",required=false) String type) {
		
			List<OuterSizeVo> list = sizeService.getListOuterSizeColor(outerNo, type);
		
			logger.info("############# 아웃터 사이즈 확인 #############");
			return list;
	}

	
	/**
	 * 관심상품 등록
	 */
	@RequestMapping(value = "/createWishList.do", method = RequestMethod.POST)
	@ResponseBody
	public String createWishList(@RequestParam(value="outerNo",required=false) int outerNo,
			@RequestParam(value="id",required=false) String memberId) {
	
		
			WishListVo wish = new WishListVo();

			wish.setOuterNo(outerNo);
			wish.setMemberId(memberId);
			
			if(wishService.getWishListOverlapped(memberId, outerNo) != null) {
				logger.info("############# 관심상품 존재 #############");
				
				return "존재";
			}
			
			wishService.createWishList(wish);
			logger.info("############# 관심상품 등록 완료 #############");
			return "등록완료";	
	}
	
	/**
	 * 카트 등록 
	 */
	@RequestMapping(value = "/addCart.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String addcart(Model model,@RequestParam(value="productList[]",required=false) List<String> productList,
			@RequestParam(value="outerNo",required=false) int outerNo,
			HttpSession session, RedirectAttributes ra) {
		//현재 세션에 있는 list
		List<ProductVo> sessionList = (List)session.getAttribute("cart");
		
		List<ProductVo> newList = new ArrayList<>();
			
		int no = 1;
		
		for(int i = 0; i< productList.size(); i++) {	
			
			ProductVo cart = new ProductVo();	
			cart.setCartNo(no);
			cart.setProductNo(Integer.parseInt(productList.get(i).toString()));	i++;
			cart.setProductName(productList.get(i).toString()); 				i++;
			cart.setProductSize(productList.get(i).toString()); 				i++;
			cart.setProductColor(productList.get(i).toString()); 				i++;
			cart.setProductPrice(productList.get(i).toString()); 				i++;
			no++;
			
			newList.add(cart);
		}

		if(session.getAttribute("cart") != null){
			for(int i = 0; i < newList.size(); i++) {
				for(int j = 0; j < sessionList.size(); j++) {
					//추가한 상품 번호, 사이즈, 색상 중복 체크
					if(newList.get(i).getProductNo() == sessionList.get(j).getProductNo() && 
							newList.get(i).getProductSize().equals(sessionList.get(j).getProductSize()) &&
							newList.get(i).getProductColor().equals(sessionList.get(j).getProductColor())) {
						
						ra.addAttribute("addNo", "error");
						ra.addAttribute("outerNo",outerNo);
						
						logger.info("############# 장바구니 존재 #############");
						return "redirect:/outer/outerView.do";
					}
				}
			}
			for(int i = 0; i < sessionList.size(); i++) {
					//기존 상품들 새로운 세션list에 담기
					ProductVo cart = new ProductVo();
					
					cart.setCartNo(no);
					cart.setProductNo(sessionList.get(i).getProductNo());
					cart.setProductName(sessionList.get(i).getProductName());
					cart.setProductColor(sessionList.get(i).getProductColor());
					cart.setProductSize(sessionList.get(i).getProductSize());
					cart.setProductPrice(sessionList.get(i).getProductPrice());				
					no++;
					
					newList.add(cart); 
			}
		}
		
		session.setAttribute("cart", newList);
		
		logger.info("############# 장바구니 등록 완료 #############");
		return "redirect:/outer/cartPage.do";
	}
	
	@RequestMapping(value = "/cartPage.do", method = RequestMethod.GET)
	public String createWishList(HttpSession session) {
		logger.info("############# 장바구니페이지 이동 #############");

		return "cartPage";	
	}
	
	
	/**
	 * 카트 삭제
	 */
	@RequestMapping(value = "/deleteCart.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCart(@RequestParam(value="checkList[]",required=false) List<String> checkList, HttpSession session) {
		//취소하고 남은 상품을 새로운 세션에 담을 list 
		List<ProductVo> newlist = new ArrayList<>();
		
		//현재 세션에 존재하는 상품 list
		List<ProductVo> sessionList =  (List)session.getAttribute("cart");
	
		int no = 1;
		
		//선택한 상품 삭제
		for(int i = 0; i < checkList.size(); i++) {		
			for(int j = 0; j < sessionList.size(); j++) {
				if(sessionList.get(j).getCartNo() == Integer.parseInt(checkList.get(i))) {
					sessionList.remove(j);
				}
			}
		}
		
		//새로운 세션에 List담기
		for(int j = 0; j < sessionList.size(); j++) {
			
			ProductVo cart = new ProductVo();					
			cart.setCartNo(no);
			cart.setProductNo(sessionList.get(j).getProductNo());
			cart.setProductName(sessionList.get(j).getProductName());
			cart.setProductColor(sessionList.get(j).getProductColor());
			cart.setProductSize(sessionList.get(j).getProductSize());
			cart.setProductPrice(sessionList.get(j).getProductPrice());
			no++;
			
			newlist.add(cart); 
		}
		
		logger.info("############# 장바구니 상품 삭제 #############");
		session.setAttribute("cart", newlist);
		
		if(newlist.size() == 0) {
			session.invalidate();
			return "삭제";
		}
		
		return "삭제";
	}
}
