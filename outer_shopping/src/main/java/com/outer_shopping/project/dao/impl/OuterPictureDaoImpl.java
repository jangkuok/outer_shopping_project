package com.outer_shopping.project.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outer_shopping.project.dao.OuterPictureDao;
import com.outer_shopping.project.vo.OuterPictureVo;

@Repository
public class OuterPictureDaoImpl implements OuterPictureDao{
	
	@Autowired
	private SqlSession session;

	private String makeSqlId(String id){
		return "com.outer_shopping.project.mapper.OuterPictureMapper."+id;
	}
	
	@Override
	public void insertOuterPicture(OuterPictureVo outerPictureVo) {
		try {
			session.insert(makeSqlId("insertOuterPicture"), outerPictureVo);
		}catch (Exception e) {
			System.out.println("insertOuterPicture(dao) : ");
			e.printStackTrace();
		}	
	}
	
	
}
