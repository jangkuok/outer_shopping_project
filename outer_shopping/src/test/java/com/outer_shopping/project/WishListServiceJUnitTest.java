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
 	 * 아웃터 등록 TEST
 	 */
	@Test
	public void WishListInsertTest(){
		log.info("######### JUnit(WishListInsertTest) 테스트 ##############");
		
		String memberId = "kkkkkkkk";
		int outNo = 4;
		
		WishListVo wish = new WishListVo();
		
		wish.setWishNo(1);
		wish.setMemberId(memberId);
		wish.setOuterNo(outNo);
		
		//service.createWishList(wish);
		
		
	}

	/**
 	 * 관심상품 목록 TEST
 	 */
	@Test
	public void WishListSelectTest(){
		log.info("######### JUnit(WishListSelectTest) 테스트 ##############");
		
		
		
		service.getWishList("kkkkkkkk");
		
	}

	 
	
	/**
	 * 아웃터 상세정보 출력 TEST
	 */
/*	@Test
	public void SelectOuterIdTest(){
		log.info("######### JUnit(SelectOuterIdTest) 테스트 ##############");
		
		int outerNo = 4;
		int sizeNo = 8;
		String sizeType = "S";
		
		//service.getOuter(outerNo);
		
		
		sizeService.getListOuterSizeColor(outerNo,sizeType);
		
		
 	} 
*/
 	
}
