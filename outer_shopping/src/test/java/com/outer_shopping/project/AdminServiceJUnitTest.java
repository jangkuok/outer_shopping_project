package com.outer_shopping.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.outer_shopping.project.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
      })
public class AdminServiceJUnitTest {
	
	private static final Logger log	= LoggerFactory.getLogger(AdminServiceJUnitTest.class);

	@Autowired
	private AdminService service;
	
 	/**
 	 * 로그인 CHECK TEST
 	 */
	@Test
	public void loginCheck() {
		log.info("######### JUnit(loginCheck) 테스트 ##############");
		
		String id = "adminuser";
		boolean flag = false;
		
		log.info("********************************");
		log.info("로그인 확인 : {}", service.findAdmin(id));
		
		service.findAdmin(id);
		
		log.info("********************************");
	}

 
}
