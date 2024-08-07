package com.tjoeun.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.beans.Developer;
import com.tjoeun.service.DeveloperService;

public class DeveloperInterceptor implements HandlerInterceptor {

	// Xml 방식 @Autowired 설정도 가능함
	@Autowired
	private DeveloperService developerService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		List<Developer> developerList = developerService.selectAll();
		System.out.println("developerList (interceptor) : " + developerList);
		request.setAttribute("developerList", developerList);
		return true;   
	}

}



