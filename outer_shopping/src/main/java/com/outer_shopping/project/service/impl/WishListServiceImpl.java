package com.outer_shopping.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outer_shopping.project.dao.WishListDao;
import com.outer_shopping.project.service.WishListSerice;
import com.outer_shopping.project.vo.WishListVo;

@Service("WishListSerice")
public class WishListServiceImpl implements WishListSerice {
	
	@Autowired
	private WishListDao dao;

	
	/**
	 * 관심상품 등록
	 */
	@Override
	public void createWishList(WishListVo wish) {
		try {
			dao.insertWishList(wish);
		}catch (Exception e) {
			System.out.println("createWishList(service) : ");
			e.printStackTrace();
		}
		
	}

	/**
	 * 관심상품 삭제
	 */	
	@Override
	public void removeWishList(int wishNo) {
		try {
			dao.deleteWishList(wishNo);
		}catch (Exception e) {
			System.out.println("removeWishList(service) : ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 회원 관심상품 목록
	 */
	@Override
	public List<WishListVo> getWishList(String memberId) {
		 List<WishListVo> list = null;
		try {
			list = dao.selectWishList(memberId);
		}catch (Exception e) {
			System.out.println("getWishList(service) : ");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 회원 관심상품 중복조회
	 */
	@Override
	public WishListVo getWishListOverlapped(String memberId, int outerNo) {
		
		WishListVo wishList = new WishListVo();
		try {
			wishList = dao.selectWishListOverlapped(memberId, outerNo);
		}catch (Exception e) {
			System.out.println("getWishListOverlapped(service) : ");
			e.printStackTrace();
		}
		return wishList;
	}
	
	

}
