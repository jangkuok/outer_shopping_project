package com.outer_shopping.project.service;

import com.outer_shopping.project.vo.AuthorityVo;

/**
 * 전체사용자 관련 업무로직 처리
 */
public interface AuthorityService {
	/**
	 * 로그인아이디로 전체사용자 조회하기
	 * @param loginId
	 * @return
	 */
	AuthorityVo findAuthority(String loginId);
}
