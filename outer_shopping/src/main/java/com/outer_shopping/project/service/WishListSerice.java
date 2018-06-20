package com.outer_shopping.project.service;

import java.util.List;

import com.outer_shopping.project.vo.WishListVo;

public interface WishListSerice {
	
	void createWishList(WishListVo wish);
	
	List<WishListVo> getWishList(String memberId);
}
