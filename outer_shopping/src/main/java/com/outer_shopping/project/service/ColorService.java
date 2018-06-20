package com.outer_shopping.project.service;

import java.util.List;

import com.outer_shopping.project.vo.ColorVo;

public interface ColorService {
	
	List<ColorVo> getColorList(int sizeNo);
}
