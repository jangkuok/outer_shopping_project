package com.outer_shopping.project.dao;

import java.util.List;

import com.outer_shopping.project.vo.ColorVo;

public interface ColorDao {
	
	/**
	 * 색상조회 등록
	 * @param sizeNo
	 */
	List<ColorVo> selectColorList(int sizeNo);
}
