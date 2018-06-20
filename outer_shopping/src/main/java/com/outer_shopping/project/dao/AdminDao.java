package com.outer_shopping.project.dao;

import com.outer_shopping.project.vo.AdminVo;

public interface AdminDao {

	/**
	 * 아이디로 유저 정보를 조회.
	 * @param loginId
	 * @return
	 */
	AdminVo selectAdminById(String loginId);
}
