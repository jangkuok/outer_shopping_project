package com.outer_shopping.project.service;

import java.util.List;

import com.outer_shopping.project.vo.OuterPictureVo;

public interface OuterPictureService {
	
	/**
	 * 상품 이미지 등록
	 * @param outerPictureVo
	 */
	void createOuterPicture(OuterPictureVo outerPictureVo); 
	
	
	/**
	 * 상품 이미지 삭제
	 * @param prictureNo
	 */
	void removeOuterPicture(int pictureNo); 
	
	/**
	 * 특정상품 이미지 목록
	 * @param outerNo
	 * @return
	 */
	List<OuterPictureVo> getOuterPictureList(int outerNo);
}
