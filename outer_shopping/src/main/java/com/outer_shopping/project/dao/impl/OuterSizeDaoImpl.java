package com.outer_shopping.project.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outer_shopping.project.dao.OuterSizeDao;
import com.outer_shopping.project.vo.OuterSizeVo;



@Repository
public class OuterSizeDaoImpl implements OuterSizeDao {
	
	@Autowired
	private SqlSession session;
	
	/**
	 * mapper SQL_ID 메소드
	 * @param id
	 * @return
	 */
	private String makeSqlId(String id){
		return "com.outer_shopping.project.mapper.OuterSizeMapper."+id;
	}
	

	/**
	 * 사이즈 등록
	 */
	@Override
	public void insertSize(OuterSizeVo size) {
		try {
			session.insert(makeSqlId("insertSize"), size);
		}catch (Exception e) {
			System.out.println("insertSize(dao) : ");
			e.printStackTrace();
		}	
		
	}

	@Override
	public List<OuterSizeVo> selectListOuterSizeColor(int outerNo, String type) {
		
		List<OuterSizeVo> list = null;
		
		try {
			
			Map<String, Object> input = new HashMap<String, Object>();
			input.put("outerNo",outerNo);
			input.put("type",type);
			
			list = session.selectList(makeSqlId("selectSizeColorCheck"), input);
		}catch (Exception e) {
			System.out.println("selectListOuterSizeColor(dao) : ");
			e.printStackTrace();
		}	
		
		return list;
	}

	
	
	
}
