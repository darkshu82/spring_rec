package com.tjoeun.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.beans.Officer;
import com.tjoeun.service.OfficerService;

public class OfficerInterceptor implements HandlerInterceptor {
	
	// Xml 방식 @Autowired 설정도 가능함	
	@Autowired
	private OfficerService officerService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		List<Officer> officerList = officerService.selectAll();
		System.out.println("officerList (interceptor) : " + officerList);
		request.setAttribute("officerList", officerList);
		return true;   
	}

}



