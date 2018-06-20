package com.outer_shopping.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.ColorDao;
import com.outer_shopping.project.service.ColorService;
import com.outer_shopping.project.vo.ColorVo;

@Service("ColorService")
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorDao dao;

	@Override
	public List<ColorVo> getColorList(int sizeNo) {
			
			List<ColorVo> list = null;
			
			try {
				list = dao.selectColorList(sizeNo);
			}catch (Exception e) {
				System.out.println("getColorList(service) : ");
				e.printStackTrace();
			}	
			
			return list;
	}
	
	
}
