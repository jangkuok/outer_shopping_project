package com.outer_shopping.project.service;

import java.util.List;

import com.outer_shopping.project.vo.OrderCheckVo;
import com.outer_shopping.project.vo.OrderProductVo;

public interface OrderProductService {
	
	
	void addOrderCheck(OrderCheckVo check);
	
	void addOrderProduct(List<OrderProductVo> productList);
	
	int getSeq();
	
	
	/**
	 * 주문 취소
	 * @param orderId
	 */
	void handingUpdateOrder(int orderNo, String handing);
	
	/**
	 * 해당 회원 주문 목록
	 * @param memberId
	 * @return
	 */
	List<OrderCheckVo> getMemberOrderList(String memberId); 
	
	/**
	 * 주문 관련 상품 목록 
	 * @param orderId
	 * @return
	 */
	List<OrderProductVo> getOrderProductList(int orderId);
}
