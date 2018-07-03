package com.outer_shopping.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.OuterPictureDao;
import com.outer_shopping.project.service.OuterPictureService;
import com.outer_shopping.project.vo.OuterPictureVo;

@Service("OuterPictureService")
public class OuterPictureServiceImpl implements OuterPictureService{

	@Autowired
	private OuterPictureDao dao;
	
	@Override
	public void createOuterPicture(OuterPictureVo outerPictureVo) {
		try {
			dao.insertOuterPicture(outerPictureVo);
		}catch (Exception e) {
			System.out.println("createOuterPicture(service) : ");
			e.printStackTrace();
		}
		
	}
	
}
