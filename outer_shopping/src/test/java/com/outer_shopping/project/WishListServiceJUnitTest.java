package com.outer_shopping.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.outer_shopping.project.service.WishListSerice;
import com.outer_shopping.project.vo.WishListVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
      })

public class WishListServiceJUnitTest {
	
	private static final Logger log	= LoggerFactory.getLogger(WishListServiceJUnitTest.class);


	@Autowired
	private WishListSerice service;
	
 	/**
 	 * 관심상품 등록 TEST
 	 */
	@Test
	public void wishListInsertTest(){
		log.info("######### JUnit(wishListInsertTest) 테스트 ##############");
		
		String memberId = "kkkkkkkk";
		int outNo = 4;
		
		WishListVo wish = new WishListVo();
		
		wish.setWishNo(1);
		wish.setMemberId(memberId);
		wish.setOuterNo(outNo);
		
		//service.createWishList(wish);
	}

	/**
 	 * 관심상품 삭제 TEST
 	 */
	@Test
	public void remoceWishListTest(){
		log.info("######### JUnit(remoceWishListTest) 테스트 ##############");
		
		//service.removeWishList(5);
	}
	
	
	
	/**
 	 * 관심상품 목록 TEST
 	 */
	@Test
	public void wishListSelectTest(){
		log.info("######### JUnit(wishListSelectTest) 테스트 ##############");
		
		//service.getWishList("kkkkkkkk");
	}

	/**
 	 * 관심상품 중복조회 TEST
 	 */
	@Test
	public void wishListSelectOverlappedTest(){
		log.info("######### JUnit(wishListSelectOverlappedTest) 테스트 ##############");
		
		service.getWishListOverlapped("kkkkkkkk", 25);
	}	 
	

 	
}
