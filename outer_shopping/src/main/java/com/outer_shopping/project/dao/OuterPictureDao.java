package com.outer_shopping.project.dao;

import java.util.List;

import com.outer_shopping.project.vo.OuterPictureVo;

public interface OuterPictureDao {
	
	/**
	 * 이미지 등록
	 * @param outerPictureVo
	 */
	void insertOuterPicture(OuterPictureVo outerPictureVo);
	
	
	void deleteOuterPicture(int pictureNo);
	
	/**
	 * 특정상품 이미지 목록출력
	 * @param outerNo
	 * @return 
	 */
	List<OuterPictureVo> selectOuterPictureList(int outerNo);
}
