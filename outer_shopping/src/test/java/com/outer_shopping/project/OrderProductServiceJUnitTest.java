package com.outer_shopping.project;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.outer_shopping.project.service.ColorService;
import com.outer_shopping.project.service.OrderProductService;
import com.outer_shopping.project.service.OuterService;
import com.outer_shopping.project.service.OuterSizeService;
import com.outer_shopping.project.vo.ColorVo;
import com.outer_shopping.project.vo.OrderCheckVo;
import com.outer_shopping.project.vo.OrderProductVo;
import com.outer_shopping.project.vo.OuterSizeVo;
import com.outer_shopping.project.vo.OuterVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
      })

public class OrderProductServiceJUnitTest {
	
	private static final Logger log	= LoggerFactory.getLogger(OrderProductServiceJUnitTest.class);


	@Autowired
	private OrderProductService service;
	
	
 	/**
 	 * 주문 등록 TEST
 	 */
	@Test
	public void OrderProductTest(){
		log.info("######### JUnit(OrderProductTest) 테스트 ##############");
		
		OrderCheckVo check = new OrderCheckVo();
		check.setOrderNo(1);
		check.setTotalPrice(50000);
		check.setMemberId("kkkkkkkk");
		
		check.setAddress("487-855)경기도 성남시 분당구 수내로 181, 312동 1201호");
		check.setEmail("jangkuok@naver.com");
		check.setMessage("빠른배송 부탁드립니다.");
		check.setPhoneNum("01087791763");
		check.setHanding("");
		Date date = new Date(new java.util.Date().getTime());
		check.setOrderDate(date);
		
		//service.addOrderCheck(check);
		
		List<OrderProductVo> list = new ArrayList<>();
		
		for (int i = 0; i < 2; i++) {
			OrderProductVo product = new OrderProductVo();
				
			String test = Integer.toString(i);
			
			product.setProductNo(1);
			product.setProductColor(test);
			product.setProductPrice(i);
			product.setProductSize(test);
			product.setProductName(test);
			product.setOrderNo(1);
			
			list.add(product);
		}
	
		//service.addOrderProduct(list);
	}

	@Test
	public void selectSeqTest(){
		log.info("######### JUnit(selectSeqTest) 테스트 ##############");
	
		//System.out.println(service.getSeq()+1);
	}
	
	@Test
	public void deleteTest(){
		log.info("######### JUnit(deleteTest) 테스트 ##############");
	
		service.handingUpdateOrder(74,"입금완료");
	}
	
	@Test
	public void selectOrderListTest(){
		log.info("######### JUnit(selectOrderListTest) 테스트 ##############");
	
		service.getMemberOrderList("kkkkkkkk");
	}
	
	@Test
	public void selectOrderProductListTest(){
		log.info("######### JUnit(selectOrderProductListTest) 테스트 ##############");
	
		service.getOrderProductList(76);
	}
 	
 	
 	
 	
 	

}
