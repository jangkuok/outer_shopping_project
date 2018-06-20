package com.outer_shopping.project.dao;

import java.util.List;

import com.outer_shopping.project.vo.WishListVo;

public interface WishListDao {
	
	/**
	 * 관심상품 등록
	 * @param wish
	 */
	void insertWishList(WishListVo wish);
	
	/**
	 * 회원 관심상품 목록
	 * @param memberId
	 * @return
	 */
	List<WishListVo> selectWishList(String memberId);
}
