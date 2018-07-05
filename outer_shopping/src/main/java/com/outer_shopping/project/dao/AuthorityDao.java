package com.outer_shopping.project.dao;

import com.outer_shopping.project.vo.AuthorityVo;

public interface AuthorityDao {
	/**
	 * 권한 삽입(생성)
	 * @param authority
	 */
	void insertAuthority(AuthorityVo authority);
	
	/**
	 * 권한 정보 갱신 수정(생성)
	 * @param authority
	 * @return
	 */
	void updateAuthority(AuthorityVo authority);
	
	/**
	 * 권한 삭제
	 * @param loginId
	 */
	void deleteAuthority(String loginId);
	
	/**
	 * 아이디로 권한 정보를 조회.
	 * @param loginId
	 * @return
	 */
	AuthorityVo selectAuthorityById(String loginId);
}