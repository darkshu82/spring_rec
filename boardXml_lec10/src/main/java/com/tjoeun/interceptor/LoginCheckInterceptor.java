package com.tjoeun.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.dto.UserDTO;

public class LoginCheckInterceptor implements HandlerInterceptor{

	/*
	  Xml 설정 방식에서는 Interceptor 에서 주입받으므로
	  @Resource 를 사용함
	*/
	@Resource(name="loginUserDTO")
	@Lazy
	private UserDTO loginUserDTO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if(loginUserDTO.isUserIsLogin() == false) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_loggedin");
			return false;
		}
		return true;
	}
	
	

}
