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
import com.outer_shopping.project.vo.CartVo;
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
			HttpSession session, RedirectAttributes ra) {
		
		List<CartVo> list = new ArrayList<>();
		
		//세션에 상품이 없을 경우
		if(session.getAttribute("cart") == null) {
			for(int i = 0; i< productList.size(); i++) {			
				
				CartVo cart = new CartVo();
				
				cart.setCartNo(i);
				cart.setProductNo(Integer.parseInt(productList.get(i).toString()));
				i++;
				cart.setProductName(productList.get(i).toString());
				i++;
				cart.setProductColor(productList.get(i).toString());
				i++;
				cart.setProductSize(productList.get(i).toString());
				i++;
				cart.setProductPrice(productList.get(i).toString());
				i++;
				
				list.add(cart);
			}
			
			session.setAttribute("cart", list);
		}
		//세션에 상품이 있을 경우
		else if(session.getAttribute("cart") != null) {
			
			List<CartVo> arraylist =  (List)session.getAttribute("cart");
			for(int i=0; i < arraylist.size(); i++) {
				
				for(int j = 0; j < list.size(); j++) {
					if(arraylist.get(i).getProductNo() == list.get(j).getProductNo() && 
							arraylist.get(i).getProductSize().equals(list.get(j).getProductSize()) &&
								arraylist.get(i).getProductColor().equals(list.get(j).getProductColor()) &&
									arraylist.get(i).getProductName().equals(list.get(j).getProductName())) {
						
						ra.addAttribute("addNo", "error");
						ra.addAttribute("outerNo",arraylist.get(i).getProductNo());
						logger.info("############# 장바구니 존재 #############");
						return "redirect:/outer/outerView.do";
					}
				}
				CartVo cart = new CartVo();
				
				cart.setCartNo(i);
				cart.setProductNo(arraylist.get(i).getProductNo());
				cart.setProductName(arraylist.get(i).getProductName());
				cart.setProductColor(arraylist.get(i).getProductColor());
				cart.setProductSize(arraylist.get(i).getProductSize());
				cart.setProductPrice(arraylist.get(i).getProductPrice());
			 
			    list.add(cart); 
			    System.out.println(list);
			}		
			session.setAttribute("cart", list);
		}			
		
		logger.info("############# 장바구니 등록 완료 #############");
		return "redirect:/outer/cartPage.do";
	}
	
	@RequestMapping(value = "/cartPage.do", method = RequestMethod.GET)
	public String createWishList() {
		logger.info("############# 장바구니페이지 이동 #############");
		return "cartPage";	
	}
	
	
	/**
	 * 카트 삭제
	 */
	@RequestMapping(value = "/deleteCart.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCart(@RequestParam(value="checkList[]",required=false) List<String> checkList, HttpSession session) {
		
		List<CartVo> list = new ArrayList<>();
		
		List<CartVo> arraylist =  (List)session.getAttribute("cart");
	
		for(int i=0; i < arraylist.size(); i++) {			
			for(int j = 0; j < checkList.size(); j++) {
				if(arraylist.get(i).getCartNo() == Integer.parseInt(checkList.get(j))) {
					arraylist.remove(i);
				}else {
					CartVo cart = new CartVo();					
					cart.setCartNo(i);
					cart.setProductNo(arraylist.get(i).getProductNo());
					cart.setProductName(arraylist.get(i).getProductName());
					cart.setProductColor(arraylist.get(i).getProductColor());
					cart.setProductSize(arraylist.get(i).getProductSize());
					cart.setProductPrice(arraylist.get(i).getProductPrice());
				 
				    list.add(cart); 
				}
			}
		}
		
		session.setAttribute("cart", list);
	
		return "삭제";
	}
}
