package com.outer_shopping.project;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.outer_shopping.project.service.OuterService;
import com.outer_shopping.project.service.OuterSizeService;
import com.outer_shopping.project.vo.OuterSizeVo;
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
	
	@Autowired
	private OuterSizeService sizeService;
	
/*	@Autowired
	private ColorService colorService;*/
	
 	/**
 	 * 아웃터 등록 TEST
 	 */
	@Test
	public void OuterInsertTest(){
		log.info("######### JUnit(OuterInsertTest) 테스트 ##############");
		
		OuterVo outer = new OuterVo();
		
		outer.setOuterNo(4);
		outer.setType("자켓");
		outer.setName("청자켓");
		outer.setContent("좋은 청자켓");
		outer.setPrice(25000);
		
		Date date = new Date(new java.util.Date().getTime());
		outer.setInsertDate(date);
		
		//service.createOuter(outer);
	
		OuterSizeVo size = new OuterSizeVo();
		
		size.setOuterNo(4);
		size.setSizeNo(2);
		size.setType("M");
		size.setChest(52);
		size.setShoulder(54);
		size.setSleeve(58);
		size.setWhole(80);
		size.setAmount(10);
		size.setColor("진파랑");
		
		
		//sizeService.createOuterSize(size);
		
	}

	/**
 	 * 아웃터 목록 TEST
 	 */
/*	@Test
	public void OuterSelectTest(){
		log.info("######### JUnit(OuterSelectTest) 테스트 ##############");
		
		service.findOuterList();
		
	}
*/
	 
	
	
	/**
	 * 아웃터 상세정보 출력 TEST
	 */
 	@Test
	public void SelectOuterIdTest(){
		log.info("######### JUnit(SelectOuterIdTest) 테스트 ##############");
		
		int outerNo = 4;
		int sizeNo = 8;
		String sizeType = "S";
		
		//service.getOuter(outerNo);
		
		
		//sizeService.getListOuterSizeColor(outerNo,sizeType);
		

		
 	} 

 	
 	
 	
 	
 	
 	

}
