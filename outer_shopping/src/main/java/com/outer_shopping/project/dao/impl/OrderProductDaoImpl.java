package com.outer_shopping.project.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outer_shopping.project.dao.OrderProductDao;
import com.outer_shopping.project.vo.OrderCheckVo;
import com.outer_shopping.project.vo.OrderProductVo;

@Repository
public class OrderProductDaoImpl implements OrderProductDao {

	@Autowired
	private SqlSession session;
	
	private String makeSqlId(String id){
		return "com.outer_shopping.project.mapper.OrderProductMapper."+id;
	}

	 
	/**
	 * 주문 등록
	 */
	@Override
	public void insertOrderCheck(OrderCheckVo check) {
		try {
			session.insert(makeSqlId("insertOrder"), check);
		}catch (Exception e) {
			System.out.println("insertOuter(dao) : ");
			e.printStackTrace();
		}	
	}
	
	/**
	 * 상품 등록
	 */
	@Override
	public void insertOrderProduct(OrderProductVo product) {
		try {
			session.insert(makeSqlId("insertOrderProduct"), product);
		}catch (Exception e) {
			System.out.println("insertOrderProduct(dao) : ");
			e.printStackTrace();
		}	
	}

	/**
	 * 시퀀스 찾기
	 */
	@Override
	public int selectSeq() {
		return session.selectOne(makeSqlId("selectSequence"));
	}

	/**
	 * 주문 상태 수정
	 */
	@Override
	public void handingUpdateOrder(int orderNo, String handing) {
		try {
			
			Map<String, Object> input = new HashMap<String, Object>();
			input.put("orderNo",orderNo);
			input.put("handing",handing);
			
			session.update(makeSqlId("handingUpdateOrder"), input);
		}catch (Exception e) {
			System.out.println("handingUpdateOrder(dao) : ");
			e.printStackTrace();
		}	
		
	}
	
	/**
	 * 해당 회원 주문 목록
	 */
	@Override
	public List<OrderCheckVo> selectMemberOrderList(String memberId) {
		
		List<OrderCheckVo> list = new ArrayList<>();
		
		try {
			list = session.selectList(makeSqlId("selectMemberOrderList"), memberId);
		}catch (Exception e) {
			System.out.println("selectMemberOrderList(dao) : ");
			e.printStackTrace();
		}	
		
		return list;
	}

	/**
	 * 주문 관련 상품 목록 
	 */
	@Override
	public List<OrderProductVo> selectOrderProductList(int orderId) {
		
		List<OrderProductVo> list = new ArrayList<>();
		
		try {
			list = session.selectList(makeSqlId("selectOrderProductList"), orderId);
		}catch (Exception e) {
			System.out.println("selectOrderProductList(dao) : ");
			e.printStackTrace();
		}	
		
		return list;
	}	
	
	
	
	
	
}
