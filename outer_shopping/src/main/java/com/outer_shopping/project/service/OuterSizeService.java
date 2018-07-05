package com.outer_shopping.project.service;

import java.util.List;

import com.outer_shopping.project.vo.OuterSizeVo;

public interface OuterSizeService {
	
	void createOuterSize(OuterSizeVo size);
	
	
	void removeOuterSize(int outerNo);
	
	List<OuterSizeVo> getListOuterSizeProduct(int outerNo);
	
	List<OuterSizeVo> getListOuterSizeColor(int outerNo, String type);
}
