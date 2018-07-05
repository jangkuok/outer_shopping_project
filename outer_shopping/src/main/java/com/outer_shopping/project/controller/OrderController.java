package com.outer_shopping.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.outer_shopping.project.service.MemberService;
import com.outer_shopping.project.service.OrderProductService;
import com.outer_shopping.project.vo.OrderCheckVo;
import com.outer_shopping.project.vo.OrderProductVo;
import com.outer_shopping.project.vo.ProductVo;

@Controller
@RequestMapping("/member")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OrderProductService orderservice;
	/**
	 * 상세페이지 -> 주문하기 page 이동
	 */
	@RequestMapping(value = "/orderPage.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String viewAndOrder(Model model,@RequestParam(value="productList[]",required=false) List<String> productList,
			@RequestParam(value="loginId",required=false) String id) {

		List<ProductVo> list = new ArrayList<>();
		
		int no = 1;
		
		//세션에 상품이 없을 경우
		for(int i = 0; i< productList.size(); i++) {			
			
			ProductVo cart = new ProductVo();
			
			cart.setCartNo(no);
			cart.setProductNo(Integer.parseInt(productList.get(i).toString()));		i++;
			cart.setProductName(productList.get(i).toString());						i++;
			cart.setProductColor(productList.get(i).toString());					i++;
			cart.setProductSize(productList.get(i).toString());						i++;
			cart.setProductPrice(productList.get(i).toString());					i++;
			no++;
			
			list.add(cart);
		}	
		
		model.addAttribute("memberVo", memberService.viewMember(id));
		model.addAttribute("orderNo", orderservice.getSeq()+1);
		model.addAttribute("orderList", list);
		
		logger.info("############# 주문 페이지 이동 #############");
		return "/member/orderPage";
	}
	
	/**
	 * 장바구니 -> 주문하기 page 이동
	 */
	@RequestMapping(value = "/orderPages.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String cartAndOrder(Model model,@RequestParam(value="productList[]",required=false) List<String> productList,
			@RequestParam(value="loginId",required=false) String id) {

		List<ProductVo> list = new ArrayList<>();
		
		System.out.println(productList);
	
		for(int i = 0; i< productList.size(); i++) {			
			
			ProductVo cart = new ProductVo();
			
			cart.setCartNo(Integer.parseInt(productList.get(i).toString()));		i++;
			cart.setProductNo(Integer.parseInt(productList.get(i).toString())); 	i++;
			cart.setProductName(productList.get(i).toString());						i++;
			cart.setProductColor(productList.get(i).toString());					i++;
			cart.setProductSize(productList.get(i).toString());						i++;
			cart.setProductPrice(productList.get(i).toString());
			
			list.add(cart);
		}	
		
		System.out.println(list);
		
		model.addAttribute("memberVo", memberService.viewMember(id));
		model.addAttribute("orderNo", orderservice.getSeq()+1);
		model.addAttribute("orderList", list);
		
		logger.info("############# 주문 페이지 이동 #############");
		return "/member/orderPage";
	}
	
	
	/**
	 *	상품주문 
	 */
	@RequestMapping(value = "/orderProduct.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String orderProduct(Model model,@RequestParam(value="productList[]",required=false) List<String> productList,
			@RequestParam(value="deliveryInfoList[]",required=false) List<String> deliveryInfoList,
			@RequestParam(value="loginId",required=false) String id, @RequestParam(value="orderNo",required=false) int orderNo) {
		
		OrderCheckVo check = new OrderCheckVo();
		
		System.out.println(id);
		
		//주문 정보 등록
		check.setMemberId(id);
		check.setAddress(deliveryInfoList.get(0) + ")" + deliveryInfoList.get(1) + " " + deliveryInfoList.get(2));
		check.setPhoneNum(deliveryInfoList.get(3));
		check.setEmail(deliveryInfoList.get(4));
		check.setTotalPrice(Integer.parseInt(deliveryInfoList.get(5)));	
		check.setMessage(deliveryInfoList.get(6));
		
		orderservice.addOrderCheck(check);
		logger.info("############# 주문 정보 등록 #############");
		
		//주문에 관한 상품 등록
		List<OrderProductVo> list = new ArrayList<>();
		
		for (int i = 1; i < productList.size(); i++) {
			
			System.out.println(i);
			OrderProductVo product = new OrderProductVo();
			
			product.setOuterNo(Integer.parseInt(productList.get(i))); i++;
			product.setProductName(productList.get(i)); i++;
			product.setProductColor(productList.get(i)); i++;
			product.setProductSize(productList.get(i)); i++;
			product.setProductPrice(Integer.parseInt(productList.get(i)));i++;
			product.setOrderNo(orderNo);
			
			list.add(product);
		}
		
		orderservice.addOrderProduct(list);
		logger.info("############# 주문 상품 등록 #############");
		
		
		logger.info("############# 상품 주문 완료 #############");
		return "redirect:/member/orderSuccessPage.do";
	}
	
	@RequestMapping(value = "/orderSuccessPage.do", method = RequestMethod.GET)
	public String createWishList() {
		logger.info("############# 주문성공 페이지 이동 #############");
		return "member/orderSuccessPage";	
	}
}
