
package com.outer_shopping.project.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.outer_shopping.project.dao.AdminDao;
import com.outer_shopping.project.dao.AuthorityDao;
import com.outer_shopping.project.dao.MemberDao;
import com.outer_shopping.project.vo.AdminVo;
import com.outer_shopping.project.vo.AuthorityVo;
import com.outer_shopping.project.vo.MemberVo;


@Component
public class UserAuthenticationProvider implements AuthenticationProvider{

   @Autowired
   private AuthorityDao authorityDao;
   @Autowired
   private MemberDao memberDao;
   @Autowired
   private AdminDao adminDao; 
   //@Autowired
   //private PasswordEncoder encoder;

   @Override
   public Authentication authenticate(Authentication authentication) throws AuthenticationException {
      
      String loginId = authentication.getName();//사용자가 입력한 ID
      String loginPw = (String)authentication.getCredentials();//사용자가 입력한 PW
      
      //권한 조회
      AuthorityVo authority = authorityDao.selectAuthorityById(loginId);
      
      if(authority == null){
         throw new UsernameNotFoundException("등록되지 않은 계정입니다.");
      }
      
      String userAuthority = authority.getLoginAuthority();
      
      if (!userAuthority.equals("ROLE_USER") && !userAuthority.equals("ROLE_ADMIN")) {
    	  
         throw new UsernameNotFoundException("권한 입력에 오류가 있는 사용자 입니다.");
      }
      
      if(userAuthority.equals("ROLE_USER")){
    	  
         //ID체크
         MemberVo member = memberDao.getMember(loginId);  
         
         if(member == null){
            //해당ID의 회원이 없으면 로그인 실패
            throw new UsernameNotFoundException("등록되지 않은 ID입니다.");
         }
         
         //PW체크
         //if(!encoder.matches(loginPw,member.getPw())){
            
         if(!(loginId.equals(member.getId()) && loginPw.equals(member.getPw()))){   
            System.out.println(loginId +" "+ member.getId() + " " + loginPw + " " + member.getPw());
            //Pw가 일치하지 않으면 로그인 실패 
            throw new BadCredentialsException("입력하신 ID와 패스워드가 일치하지 않습니다.");
         }
         //인증 성공
         List<SimpleGrantedAuthority> list=new ArrayList<>();
         list.add(new SimpleGrantedAuthority(userAuthority));

         return new UsernamePasswordAuthenticationToken(member, null, list);
      }
      
      //권한이 admin
      if(userAuthority.equals("ROLE_ADMIN")){
         //ID체크   
         AdminVo admin = adminDao.selectAdminById(loginId);
         
         if(admin == null){//해당ID의 회원이 없으면 로그인 실패
            throw new UsernameNotFoundException("등록되지 않은 ID입니다.");
         }
         
         //PW체크
         //if(!encoder.matches(loginPw,admin.getPw())){
         if(!(loginId.equals(admin.getAdminId()) && loginPw.equals(admin.getPw()))){
            //Pw가 일치하지 않으면 로그인 실패
            throw new BadCredentialsException("입력하신 ID와 패스워드가 일치하지 않습니다.");
         }
         //인증 성공
         List<SimpleGrantedAuthority> list=new ArrayList<>();
         list.add(new SimpleGrantedAuthority(userAuthority));
         return new UsernamePasswordAuthenticationToken(admin, null, list);
      }
      return null;//- 인증 실패
   }
   
   public boolean supports(Class<?> authentication) {
      return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
   }

}