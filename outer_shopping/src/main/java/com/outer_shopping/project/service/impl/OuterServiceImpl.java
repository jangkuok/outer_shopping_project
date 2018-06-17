package com.outer_shopping.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.OuterDao;
import com.outer_shopping.project.service.OuterService;
import com.outer_shopping.project.vo.OuterVo;

import lombok.extern.slf4j.Slf4j;

@Service("OuterService")
@Slf4j
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
	
	
}
