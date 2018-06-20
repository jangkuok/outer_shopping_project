package com.outer_shopping.project.dao;

import java.util.List;

import com.outer_shopping.project.vo.OuterVo;

public interface OuterDao {
	
	/**
	 * 아웃터 생성
	 * @param outer
	 */
	void insertOuter(OuterVo outer);
	
	
	/**
	 * 아웃터 목록
	 */
	List<OuterVo> selectListOuter();
	
	/**
	 * 아웃터 상세 정보
	 * @param outerId
	 * @return
	 */
	OuterVo selectOuterId(int outerNo);
}
