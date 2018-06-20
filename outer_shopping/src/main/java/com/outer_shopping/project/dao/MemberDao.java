/**
 * 
 */
package com.outer_shopping.project.dao;

import java.util.List;

import com.outer_shopping.project.vo.MemberVo;

/**
 * DAO
 * @author 김장규
 *
 */
public interface MemberDao {
	
	/**
     * 회원 유무 확인 
     * @param id 아이디
     * @return boolean
     */
	boolean isMember(String id);
	
	/**
	 * 회원정보 삽입(생성)
	 * 
	 * @param member 회원정보 객체(VO)
	 */
	void insertMember(MemberVo member);
	
	/**
	 * 회원정보 갱신(수정)
	 * 
	 * @param member 회원정보 객체(VO)

	 */
	void updateMember(MemberVo member);
	

	/**
	 * 개별 회원정보 삭제
	 * 
	 * @param id 아이디
	 */
	void deleteMember(String id);
	

	/**
	 * 전체 회원정보 조회(검색)
	 * 
	 * @return 전체 회원정보
	 */
	List<MemberVo> getAllMembers();

	
	/**
	 * 로그인 체크
	 * @param member
	 * @return boolean
	 */
	//boolean loginCheck(MemberVo member);
	boolean loginCheck(String id, String pw);
	
	/**
	 * 회원 정보
	 * @param id
	 * @return MemberVo
	 */
	MemberVo getMember(String id);

}
