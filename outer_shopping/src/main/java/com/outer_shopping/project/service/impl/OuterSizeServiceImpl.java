package com.outer_shopping.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.OuterSizeDao;
import com.outer_shopping.project.service.OuterSizeService;
import com.outer_shopping.project.vo.OuterSizeVo;


@Service("OuterSizeService")
public class OuterSizeServiceImpl implements OuterSizeService {
	
	
	@Autowired
	private OuterSizeDao sizeDao;
	

	/**
	 * 사이즈 등록
	 */
	@Override
	public void createOuterSize(OuterSizeVo size) {
		try {
			sizeDao.insertSize(size);
		}catch (Exception e) {
			System.out.println("createOuterSize(service) : ");
			e.printStackTrace();
		}
		
	}

	/**
	 * 사이즈 삭제
	 */
	@Override
	public void removeOuterSize(int outerNo) {
		try {
			sizeDao.deleteOuterSize(outerNo);
		}catch (Exception e) {
			System.out.println("removeOuterSize(service) : ");
			e.printStackTrace();
		}
	}

	@Override
	public List<OuterSizeVo> getListOuterSizeProduct(int outerNo) {
	
		List<OuterSizeVo> list = null;
		
		try {
			list = sizeDao.selectOuterSizeProduct(outerNo);
		}catch (Exception e) {
			System.out.println("getListOuterSizeProduct(service) : ");
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<OuterSizeVo> getListOuterSizeColor(int outerNo, String type) {
	
		List<OuterSizeVo> list = null;
		
		try {
			list = sizeDao.selectListOuterSizeColor(outerNo,type);
		}catch (Exception e) {
			System.out.println("getListOuterSizeColor(service) : ");
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
}
