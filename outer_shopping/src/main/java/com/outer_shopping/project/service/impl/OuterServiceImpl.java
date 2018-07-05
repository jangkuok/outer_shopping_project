package com.outer_shopping.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.OuterDao;
import com.outer_shopping.project.service.OuterService;
import com.outer_shopping.project.vo.OuterVo;


@Service("OuterService")
public class OuterServiceImpl implements OuterService {

	@Autowired
	private OuterDao dao;
	
	/**
	 * 아웃터 등록
	 */
	@Override
	public void createOuter(OuterVo outer) {
		try {
			dao.insertOuter(outer);
		}catch (Exception e) {
			System.out.println("createOuter(service) : ");
			e.printStackTrace();
		}
	}
	

	/**
	 * 아웃터 수정
	 */
	@Override
	public void modifyOuter(OuterVo outer) {
		try {
			dao.updateOuter(outer);
		}catch (Exception e) {
			System.out.println("modifyOuter(service) : ");
			e.printStackTrace();
		}
	}

	
	/**
	 * 아웃터 삭제
	 */	
	@Override
	public void removeOuter(int outerNo) {
		try {
			dao.deleteOuter(outerNo);
		}catch (Exception e) {
			System.out.println("removeOuter(service) : ");
			e.printStackTrace();
		}
	}


	/**
	 * 아웃터 목록
	 */
	@Override
	public List<OuterVo> findOuterList() {
		
		List<OuterVo> list = null;
		
		try {
			list = dao.selectListOuter();
		}catch (Exception e) {
			System.out.println("findOuterList(service) : ");
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 아웃터 상세 정보
	 */
	@Override
	public OuterVo getOuter(int outerNo) {
		
		OuterVo outer = new OuterVo();
		
		try {
			outer = dao.selectOuterId(outerNo);
		}catch (Exception e) {
			System.out.println("getOuter(service) : ");
			e.printStackTrace();
		}
		
		return outer;
	}
	
	
	
}
