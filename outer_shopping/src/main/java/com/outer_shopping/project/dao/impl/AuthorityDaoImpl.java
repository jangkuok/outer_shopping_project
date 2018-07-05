package com.outer_shopping.project.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outer_shopping.project.dao.AuthorityDao;
import com.outer_shopping.project.vo.AuthorityVo;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {

	@Autowired
	private SqlSession session;
	
	/**
	 * mapper SQL_ID 메소드
	 * @param id
	 * @return
	 */
	private String makeSqlId(String id){
		return "com.outer_shopping.project.mapper.AuthorityMapper."+id;
	}
	
	/**
	 * 권한 등록
	 */
	@Override
	public void insertAuthority(AuthorityVo authority) {
		try {
			session.insert(makeSqlId("insertAuthority"),authority);
		} catch (Exception e) {
			System.out.println("insertAuthority(dao) : ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 권한 업데이트
	 */
	@Override
	public void updateAuthority(AuthorityVo authority) {
		try {
			session.update(makeSqlId("updateAuthority"),authority);
		} catch (Exception e) {
			System.out.println("updateAuthority(dao) : ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 권한 삭제
	 */
	@Override
	public void deleteAuthority(String loginId) {
		try {
			session.delete(makeSqlId("deleteAuthority"),loginId);
		} catch (Exception e) {
			System.out.println("deleteAuthority(dao) : ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 권한 조회
	 */
	@Override
	public AuthorityVo selectAuthorityById(String loginId) {
		
		AuthorityVo authority = new AuthorityVo();
		
		try {
			authority = session.selectOne(makeSqlId("selectAuthorityById"),loginId);
		} catch (Exception e) {
			System.out.println("selectAuthorityById(dao) : ");
			e.printStackTrace();
		}
		
		return authority;
	}
}
