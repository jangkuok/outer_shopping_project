package com.outer_shopping.project.dao.impl;

import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 이미지 등록
	 */
	@Override
	public void insertOuterPicture(OuterPictureVo outerPictureVo) {
		try {
			session.insert(makeSqlId("insertOuterPicture"), outerPictureVo);
		}catch (Exception e) {
			System.out.println("insertOuterPicture(dao) : ");
			e.printStackTrace();
		}	
	}

	
	/**
	 * 이미지삭제
	 */
	@Override
	public void deleteOuterPicture(int pictureNo) {
		try {
			session.delete(makeSqlId("deleteOuterPicture"), pictureNo);
		}catch (Exception e) {
			System.out.println("deleteOuterPicture(dao) : ");
			e.printStackTrace();
		}	
	}

	/**
	 * 특정상품 이미지 목록
	 */
	@Override
	public List<OuterPictureVo> selectOuterPictureList(int outerNo) {
		
		List<OuterPictureVo> list = new ArrayList<>();
		
		try {
			session.selectList(makeSqlId("selectOuterPictureList"), outerNo);
		}catch (Exception e) {
			System.out.println("selectOuterPictureList(dao) : ");
			e.printStackTrace();
		}	
		
		return list;
	}
	
	
}
