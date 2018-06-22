package com.outer_shopping.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.AdminDao;
import com.outer_shopping.project.service.AdminService;
import com.outer_shopping.project.vo.AdminVo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;

	/**
	 * 관리자 찾기
	 */
	@Override
	public AdminVo findAdmin(String id) {
		
		AdminVo admin = new AdminVo();
		
		try {
			admin = dao.selectAdminById(id);
		} catch (Exception e) {
			System.out.println("findAdmin(service) : ");
			e.printStackTrace();
		}
		
		return admin;
	}
	
	
}
