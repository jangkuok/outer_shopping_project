package com.outer_shopping.project.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outer_shopping.project.dao.AdminDao;
import com.outer_shopping.project.vo.AdminVo;
import com.outer_shopping.project.vo.AuthorityVo;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SqlSession session;
	
	/**
	 * mapper SQL_ID 메소드
	 * @param id
	 * @return
	 */
	private String makeSqlId(String id){
		return "com.outer_shopping.project.mapper.AdminMapper."+id; 
	}
	
	@Override
	public AdminVo selectAdminById(String loginId) {
		
		AdminVo amdin = new AdminVo();
		
		try {
			amdin = session.selectOne(makeSqlId("selectAdminById"),loginId);
		} catch (Exception e) {
			System.out.println("selectAdminById(dao) : ");
			e.printStackTrace();
		}
		
		return amdin;
	}
	
}
