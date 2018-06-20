package com.outer_shopping.project.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outer_shopping.project.dao.ColorDao;
import com.outer_shopping.project.vo.ColorVo;

@Repository
public class ColorDaoImpl implements ColorDao {

	@Autowired
	private SqlSession session;
	
	/**
	 * mapper SQL_ID 메소드
	 * @param id
	 * @return
	 */
	private String makeSqlId(String id){
		return "com.outer_shopping.project.mapper.ColorMapper."+id;
	}

	@Override
	public List<ColorVo> selectColorList(int sizeNo) {
		
		List<ColorVo> list = null;
		
		try {
			list = session.selectList(makeSqlId("selectColor"), sizeNo);
		}catch (Exception e) {
			System.out.println("selectColorList(dao) : ");
			e.printStackTrace();
		}	
		
		return list;
	}
	
	
}
