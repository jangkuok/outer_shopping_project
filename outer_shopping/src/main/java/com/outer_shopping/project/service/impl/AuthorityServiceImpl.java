
package com.outer_shopping.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.AuthorityDao;
import com.outer_shopping.project.service.AuthorityService;
import com.outer_shopping.project.vo.AuthorityVo;

@Service("AuthorityService")
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	private AuthorityDao authorityDao;
	
	
	
	
	
	/**
	 * 권한 등록
	 */
	@Override
	public void createAuthority(AuthorityVo authority) {
		try {
			authorityDao.insertAuthority(authority);
		}catch (Exception e) {
			System.out.println("createAuthority(service) : ");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 권한 수정
	 */
	@Override
	public void modifyAuthority(AuthorityVo authority) {
		try {
			authorityDao.updateAuthority(authority);
		}catch (Exception e) {
			System.out.println("modifyAuthority(service) : ");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 권한 삭제
	 */
	@Override
	public void removeAuthority(String loginId) {
		try {
			authorityDao.deleteAuthority(loginId);
		}catch (Exception e) {
			System.out.println("removeAuthority(service) : ");
			e.printStackTrace();
		}
	}

	/**
	 * 권한 확인
	 */
	@Override
	public AuthorityVo findAuthority(String loginId) {
		
		AuthorityVo authority = new AuthorityVo();
		
		try {
			authority = authorityDao.selectAuthorityById(loginId);
		} catch (Exception e) {
			System.out.println("findAuthority(service) : ");
			e.printStackTrace();
		}
		
		return authority;
	}

}
