package com.tjoeun.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.beans.Developer;
import com.tjoeun.service.DeveloperService;

public class DeveloperInterceptor implements HandlerInterceptor{
	/*
	 (Java 방식에서는)  
    Interceptor 에서는 객체를 주입받지 못함
      ㄴ 생성자를 통해서 객체를 할당함
           ㄴ ServletAppContext.java 에서 주입받음
  @Autowired
  private DeveloperService developerService;
  */
	private DeveloperService developerService;
	
	public DeveloperInterceptor(DeveloperService developerService){
		this.developerService = developerService;
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// Database 로부터 받은 Developer 객체 5 개를 저장하고 있는
		// List<Delveloper> 를 
		// request.setAttrbiute("developerList", developerList); 을 호출해서
		// request scope 에 올림
		// DeveloperInterceptor 의 url pattern 을 /** 로 지정했기 때문에
		// 현재 project 의 모든 page 가 열리기 직전에
		// developerList 객체가 request scope 에 올라감
		// 현재 project 의 모든 page 에서 developerList 객체를 사용할 수 있음
		
		List<Developer> developerList = developerService.selectAll();
		
		request.setAttribute("developerList", developerList);
		
		return true;
	}

}
