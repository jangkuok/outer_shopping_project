package com.outer_shopping.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.AuthorityDao;
import com.outer_shopping.project.dao.MemberDao;
import com.outer_shopping.project.service.MemberService;
import com.outer_shopping.project.vo.AuthorityVo;
import com.outer_shopping.project.vo.MemberVo;


@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;
	
	@Autowired
	private AuthorityDao authorityDao;
	
	
	/**
	 * 중복확인
	 */
	@Override
	public int checkMemberId(String id) {
		
		int flag = 0;
		
		try {
			if(dao.isMember(id) == true){
				//1 = 아이디 존재
				flag = 1;
			}else {
				flag = 0;
			}
		} catch (Exception e) {
			System.out.println("checkMemberId(service) : ");
			e.printStackTrace();
		}
		return flag;
	}


	/**
	 * 회원가입
	 */
	@Override
	public void joinMember(MemberVo memberVo, String id, String pw){
		try {
			
			AuthorityVo vo = new AuthorityVo();
			
			vo.setLoginId(id);
			vo.setLoginId(pw);
			vo.setLoginAuthority("ROLE_USER");
			
			authorityDao.insertAuthority(vo);
			
			dao.insertMember(memberVo);
		} catch (Exception e) {
			System.out.println("joinMember(service) : ");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 회원정보 수정
	 */
	@Override
	public void modifyMember(MemberVo memberVo) {
		try {
			dao.updateMember(memberVo);
		} catch (Exception e) {
			System.out.println("modifyMember(service) : ");
			e.printStackTrace();
		}
	}


	/**
	 * 회원 탈퇴
	 */
	@Override
	public void deleteMember(String id) {
		try {
			dao.deleteMember(id);
		} catch (Exception e) {
			System.out.println("deleteMember(service) : ");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 로그인 확인
	 */
/*	@Override
	public boolean loginMember(String id, String pw) {
		 
		boolean result = dao.loginCheck(id,pw);
		
		try {
			if(result == true){
				System.out.println("아이디 존재");
			}
		} catch (Exception e) {
			System.out.println("loginMember(service) : ");
			e.printStackTrace();
		}
		return result;
	}*/
	
	/**
	 * 회원 정보
	 */
	@Override
	public MemberVo viewMember(String id) {
		
		MemberVo memberVo = new MemberVo();
		
		try {
			memberVo = dao.getMember(id);
		} catch (Exception e) {
			System.out.println("viewMember(service) : ");
			e.printStackTrace();
		}
		
		return memberVo;
	}

}
