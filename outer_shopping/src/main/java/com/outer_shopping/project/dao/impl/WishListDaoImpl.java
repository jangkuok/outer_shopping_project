package com.outer_shopping.project.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outer_shopping.project.dao.WishListDao;
import com.outer_shopping.project.vo.WishListVo;

@Repository
public class WishListDaoImpl implements WishListDao {
	
	@Autowired
	private SqlSession session;

	/**
	 * mapper SQL_ID 메소드
	 * @param id
	 * @return
	 */
	private String makeSqlId(String id){
		return "com.outer_shopping.project.mapper.WishListMapper."+id;
	}
	
	/**
	 * 관심상품 등록
	 */
	@Override
	public void insertWishList(WishListVo wish) {
		try {
			session.insert(makeSqlId("insertWishList"), wish);
		}catch (Exception e) {
			System.out.println("insertWishList(dao) : ");
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 관심상품 삭제
	 */
	@Override
	public void deleteWishList(int wishNo) {
		try {
			session.delete(makeSqlId("deleteWishList"), wishNo);
		}catch (Exception e) {
			System.out.println("deleteWishList(dao) : ");
			e.printStackTrace();
		}
		
	}

	/**
	 * 회원 관심상품 목록
	 */
	@Override
	public List<WishListVo> selectWishList(String memberId) {
		
		 List<WishListVo> list = null;
		
		try {
			list = session.selectList(makeSqlId("selectWishList"), memberId);
		}catch (Exception e) {
			System.out.println("selectWishList(dao) : ");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 회원 관심상품 중복확인
	 */
	@Override
	public WishListVo selectWishListOverlapped(String memberId, int outerNo) {
		
		WishListVo wishList = new WishListVo();
		
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("memberId",memberId);
		input.put("outerNo",outerNo);
		
		try {
			wishList = session.selectOne(makeSqlId("selectWishListOverlapped"), input);
		}catch (Exception e) {
			System.out.println("selectWishListOverlapped(dao) : ");
			e.printStackTrace();
		}		
		
		return wishList;
	}
	
	
}
