package com.outer_shopping.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.OuterPictureDao;
import com.outer_shopping.project.service.OuterPictureService;
import com.outer_shopping.project.vo.OuterPictureVo;

@Service("OuterPictureService")
public class OuterPictureServiceImpl implements OuterPictureService{

	@Autowired
	private OuterPictureDao dao;
	
	/**
	 * 상품 이미지 등록
	 */
	@Override
	public void createOuterPicture(OuterPictureVo outerPictureVo) {
		try {
			dao.insertOuterPicture(outerPictureVo);
		}catch (Exception e) {
			System.out.println("createOuterPicture(service) : ");
			e.printStackTrace();
		}
		
	}

	
	
	/**
	 * 상품 이미지 삭제
	 */
	@Override
	public void removeOuterPicture(int pictureNo) {
		try {
			dao.deleteOuterPicture(pictureNo);
		}catch (Exception e) {
			System.out.println("removeOuterPicture(service) : ");
			e.printStackTrace();
		}
		
	}




	/**
	 * 특정상품 이미지 목록
	 */
	@Override
	public List<OuterPictureVo> getOuterPictureList(int outerNo) {
		List<OuterPictureVo> list = new ArrayList<>();
		
		try {
			dao.selectOuterPictureList(outerNo);
		}catch (Exception e) {
			System.out.println("getOuterPictureList(service) : ");
			e.printStackTrace();
		}	
		
		return list;
	}
	
	
}
