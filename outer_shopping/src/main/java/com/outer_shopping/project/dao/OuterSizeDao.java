package com.outer_shopping.project.dao;

import java.util.List;

import com.outer_shopping.project.vo.OuterSizeVo;

public interface OuterSizeDao {
	
	/**
	 * 사이즈 등록
	 * @param size
	 */
	void insertSize(OuterSizeVo size);
	
	List<OuterSizeVo> selectListOuterSizeColor(int outerNo,String type);
}
