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
	
	

}
