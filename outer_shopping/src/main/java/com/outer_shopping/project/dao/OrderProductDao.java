package com.outer_shopping.project.dao;


import java.util.List;

import com.outer_shopping.project.vo.OrderCheckVo;
import com.outer_shopping.project.vo.OrderProductVo;

public interface OrderProductDao {
	/**
	 * 주문 등록
	 * @param check
	 */
	void insertOrderCheck(OrderCheckVo check);
	
	/**
	 * 주문한 상품 등록
	 * @param product
	 */
	void insertOrderProduct(OrderProductVo product);
	
	/**
	 * 주문 시퀀스 찾기
	 * @return
	 */
	int selectSeq();
	
	/**
	 * 주문 상태 수정
	 * @param orderNo
	 */
	void handingUpdateOrder(int orderNo,String handing);
	
	/**
	 * 해당 회원 주문 목록
	 * @param memberId
	 * @return
	 */
	List<OrderCheckVo> selectMemberOrderList(String memberId); 
	
	/**
	 * 주문 관련 상품 목록 
	 * @param orderId
	 * @return
	 */
	List<OrderProductVo> selectOrderProductList(int orderId);
}
