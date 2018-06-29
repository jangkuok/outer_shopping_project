package com.outer_shopping.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.OrderProductDao;
import com.outer_shopping.project.service.OrderProductService;
import com.outer_shopping.project.vo.OrderCheckVo;
import com.outer_shopping.project.vo.OrderProductVo;

@Service("OrderProductService")
public class OrderProductServiceImpl implements OrderProductService {
	
	@Autowired
	private OrderProductDao dao;

	

	@Override
	public void addOrderCheck(OrderCheckVo check) {
		try {
			dao.insertOrderCheck(check);
		}catch (Exception e) {
			System.out.println("addOrderProduct(service) : ");
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderProduct(List<OrderProductVo> productList) {
		try {
			for (int i = 0; i < productList.size(); i++) {
				dao.insertOrderProduct(productList.get(i));
			}
		}catch (Exception e) {
			System.out.println("addOrderProduct(service) : ");
			e.printStackTrace();
		}
		
	}

	@Override
	public int getSeq() {
		return dao.selectSeq();
	}

	
	@Override
	public void handingUpdateOrder(int orderNo, String handing) {
		try {
			dao.handingUpdateOrder(orderNo,handing);
		}catch (Exception e) {
			System.out.println("handingUpdateOrder(service) : ");
			e.printStackTrace();
		}	
	}
	
	
	@Override
	public List<OrderCheckVo> getMemberOrderList(String memberId) {
		
		List<OrderCheckVo> list = new ArrayList<>();
		
		try {
			list = dao.selectMemberOrderList(memberId);
		}catch (Exception e) {
			System.out.println("getMemberOrderList(service) : ");
			e.printStackTrace();
		}	
		
		return list;
	}

	
	@Override
	public List<OrderProductVo> getOrderProductList(int orderId) {
		List<OrderProductVo> list = new ArrayList<>();
		
		try {
			list = dao.selectOrderProductList(orderId);
		}catch (Exception e) {
			System.out.println("getOrderProductList(service) : ");
			e.printStackTrace();
		}	
		
		return list;
	}





	
	
}
