package com.tjoeun.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.dto.BoardInfoDTO;
import com.tjoeun.dto.UserDTO;
import com.tjoeun.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor {
	/*
	 Xml 방식 
	  Interceptor 에서 객체를 주입받지 않고
	    ㄴ 생성자를 통해서 객체를 할당함
	         ㄴ ServletAppContext.java 에서 주입받음
	@Autowired
	private TopMenuService topMenuService;
	*/
	
	/*
	  Xml 방식에서는 Interceptor 에서 바로 주입받을 수도 있음
	                                         ㄴ @Autowired
	*/
	@Autowired
	private TopMenuService topMenuService;
	
	@Resource(name="loginUserDTO")	
	@Lazy
	private UserDTO loginUserDTO;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		List<BoardInfoDTO> topMenuList = topMenuService.getTopMenuList();
		System.out.println("topMenuList (interceptor) : " + topMenuList);
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserDTO", loginUserDTO);
		return true;   
	}

}



