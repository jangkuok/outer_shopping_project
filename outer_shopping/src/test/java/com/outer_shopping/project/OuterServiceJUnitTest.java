package com.outer_shopping.project;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.outer_shopping.project.service.MemberService;
import com.outer_shopping.project.service.OuterService;
import com.outer_shopping.project.vo.MemberVo;
import com.outer_shopping.project.vo.OuterVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
      })
public class OuterServiceJUnitTest {
	
	private static final Logger log	= LoggerFactory.getLogger(OuterServiceJUnitTest.class);

	@Autowired
	private OuterService service;
	
 	/**
 	 * 회원가입 TEST
 	 */
 	@Test
	public void OuterInsertTest(){
		log.info("######### JUnit(OuterInsertTest) 테스트 ##############");
		
		OuterVo outer = new OuterVo();
		
		outer.setOuterNo(1);
		outer.setType("코트");
		outer.setName("바바리코트no1");
		outer.setSize("M");
		outer.setContent("봄과 가을철에 재격인 바바리코트");
		outer.setPrice(19000);
		outer.setColor("회색");
		outer.setAmount(30);
		
		service.createOuter(outer);
		
	}

}
