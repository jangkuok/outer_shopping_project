/**
 * 
 */
package com.outer_shopping.project.service;

import javax.servlet.http.HttpSession;

import com.outer_shopping.project.vo.MemberVo;

/**
 * @author 김장규
 *
 */
public interface MemberService {
	
	/**
	 * id 중복확인
	 * @param id
	 */
	int checkMemberId(String id);
	
	/**
	 * 개인회원 가입하기
	 * @param member
	 */
	void joinMember(MemberVo memberVo, String id, String pw);
	
	/**
	 * 회원 정보 수정하기
	 * @param memberVo
	 */
	void modifyMember(MemberVo memberVo);

	/**
	 * 회원 탈퇴하기
	 * @param id
	 */
	void deleteMember(String id);
	
	/**
	 * 회원 로그인
	 * @param id 
	 * @param pw
	 * @return boolean
	 */
	//boolean loginMember(String id, String pw);
	
	/**
	 * 로그인한 회원 정보
	 * @param member
	 * @return MemberVo
	 */
	MemberVo viewMember(String id);
}
