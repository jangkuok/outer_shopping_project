package com.outer_shopping.project.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outer_shopping.project.dao.MemberDao;
import com.outer_shopping.project.vo.MemberVo;


@Repository
public class MemberDaoImpl implements MemberDao {
	
	
	@Autowired
	private SqlSession session;
	
/*	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	*/
	
	/**
	 * mapper SQL_ID 메소드
	 * @param id
	 * @return
	 */
	private String makeSqlId(String id){
		return "com.outer_shopping.project.mapper.MemberMapper."+id;
	}

	/**
	 * 아이디 중복 체크
	 */
	@Override
	public boolean isMember(String id){
		
		boolean result = false;
		
		try {
			if(session.selectOne(makeSqlId("selectMemberId"), id) != null ) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("isMember(dao) : ");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 회원가입
	 */
	@Override
	public void insertMember(MemberVo member){
		
		try {
			session.insert(makeSqlId("insertMember"),member);
			System.out.println("회원 등록 완료");
		} catch (Exception e) {
			System.out.println("insertMember(dao) : ");
			e.printStackTrace();
		}
		/*
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {

					session.insert(makeSqlId("insertMember"),member);
				} catch (Exception e) {
					System.out.println("insertMember : ");
				}
				
			}
		});*/
	}

	/**
	 * 회원정보 수정
	 */
	@Override
	public void updateMember(MemberVo member){
		try {
			session.update(makeSqlId("updateMember"),member);
		} catch (Exception e) {
			System.out.println("updateMember(dao) : ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 회원정보 삭제
	 */
	@Override
	public void deleteMember(String id){
		try {
			session.delete(makeSqlId("deleteMember"),id);
		} catch (Exception e) {
			System.out.println("deleteMember(dao) : ");
			e.printStackTrace();
		}		
	}

	/**
	 * 전체 회원 목록 조회
	 */
	@Override
	public List<MemberVo> getAllMembers() {
		return null;
	}

	/**
	 * 로그인 체크
	 */
	@Override
	public boolean loginCheck(String id, String pw) {
		
		boolean result = false;
		
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("id",id);
		input.put("pw",pw);
		
		try {
			result = session.selectOne(makeSqlId("selectLoginCheck"), input) != null ? true : false;
		} catch (Exception e) {
			System.out.println("loginCheck(dao) : ");
			e.printStackTrace();
		}
		return result;
	}
	

	/**
	 * 회원 정보 조회
	 */
	@Override
	public MemberVo getMember(String id) {
		
		MemberVo member = new MemberVo();
		
		try {
			member = session.selectOne(makeSqlId("selectMember"),id);
		} catch (Exception e) {
			System.out.println("deleteMember(dao) : ");
			e.printStackTrace();
		}	
		
		return member;
	}


	



	
}
