package com.outer_shopping.project.service;

import java.util.List;

import com.outer_shopping.project.vo.OuterSizeVo;

public interface OuterSizeService {
	
	void createOuterSize(OuterSizeVo size);
	
	List<OuterSizeVo> getListOuterSizeColor(int outerNo, String type);
}
