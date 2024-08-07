package com.tjoeun.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.beans.Officer;
import com.tjoeun.service.OfficerService;

public class OfficerInterceptor implements HandlerInterceptor  {
	/*
	 (Java 방식에서는) 
    Interceptor 에서는 객체를 주입받지 못함
      ㄴ 생성자를 통해서 객체를 할당함
           ㄴ ServletAppContext.java 에서 주입받음
  @Autowired
  private OfficerService officerService;
  */
  private OfficerService officerService;
  
  public OfficerInterceptor(OfficerService officerService) {
  	this.officerService = officerService;
  }
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
  	
  	List<Officer> officerList = officerService.selectAll();
  	System.out.println("officerList (interceptor) : " + officerList);
  	request.setAttribute("officerList", officerList);
  	
  	return true;
  }
  
}
