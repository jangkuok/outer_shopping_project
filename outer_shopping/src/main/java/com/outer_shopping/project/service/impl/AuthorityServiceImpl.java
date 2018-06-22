
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
