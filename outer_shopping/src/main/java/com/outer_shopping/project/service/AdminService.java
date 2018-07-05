package com.outer_shopping.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.outer_shopping.project.dao.AdminDao;
import com.outer_shopping.project.vo.AdminVo;

public interface AdminService {
	
	
	
	AdminVo findAdmin(String id);
}
