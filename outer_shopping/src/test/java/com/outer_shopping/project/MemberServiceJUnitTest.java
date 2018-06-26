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
import com.outer_shopping.project.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
      })
public class MemberServiceJUnitTest {
	
	private static final Logger log	= LoggerFactory.getLogger(MemberServiceJUnitTest.class);

	@Autowired
	private MemberService service;
	
 	/**
 	 * 회원가입 TEST
 	 */
 	@Test
	public void MemberInsertTest(){
		log.info("######### JUnit(MemberInsertTest) 테스트 ##############");
		
		MemberVo member = new MemberVo();
		
		member.setId("kkkkkkkk");
		member.setPw("kkkkkkkk");
		member.setName("kim");
		member.setEmail("jangkuok@naver.com");
		member.setPhoneNum("01087791763");
		member.setZipcode("000");
		member.setAddress("경기도 성남시 분당구");
		member.setAddress2("312동 1201호");
		member.setSex("남");
		member.setGrade("브론즈");
		member.setEnabled(1);
		
		//service.joinMember(member,member.getId(),member.getPw());
		
	}

 	/**
 	 * 중복확인 TEST
 	 */
/*	@Test
	public void MemberIdCheck(){
		
		log.info("######### JUnit(MemberIdCheck) 테스트 ##############");
		
		String id = "123";
		boolean flag = false;
		
		log.info("********************************");
		log.info("중복확인 : {}", service.checkMemberId(id));
		
		if(service.checkMemberId(id) == 1) {
			flag = true;
		}
		
		assertTrue(flag);
		log.info("********************************");
	}
*/
 	/**
 	 * 로그인 CHECK TEST
 	 */
/*	@Test
	public void loginCheck() {
		log.info("######### JUnit(loginCheck) 테스트 ##############");
		
		String id = "xxxxxxxx";
		String pw = "xxxxxxxx";
		boolean flag = false;
		
		log.info("********************************");
		log.info("로그인 확인 : {}", service.loginMember(id, pw));
		
		if(service.loginMember(id, pw) == true) {
			flag = true;
		}
		
		assertTrue(flag);
		log.info("********************************");
	}
*/
 	/**
 	 * 회원 정보 수정 TEST
 	 */

	@Test
	public void MemberModifyTest(){
		log.info("######### JUnit(MemberModifyTest) 테스트 ##############");
		
		MemberVo member = new MemberVo();
		
		member.setId("kkkkkkkk");
		member.setPw("jjjjjjjj");
		member.setName("kim");
		member.setEmail("jangkuok@naver.com");
		member.setPhoneNum("01087791763");
		member.setZipcode("000");
		member.setAddress("경기도 성남시 분당구");
		member.setSex("남");
		member.setGrade("브론즈");
		member.setEnabled(1);
		
		service.modifyMember(member);
	}
	 	
	/**
 	 * 회원탈퇴 TEST
 	 */
/*
	@Test
	public void MemberDeleteTest(){
		log.info("######### JUnit(MemberDeleteTest) 테스트 ##############");
		
		String id = "ddddddddd";
		
		service.deleteMember(id);
		
	}
	*/
}
