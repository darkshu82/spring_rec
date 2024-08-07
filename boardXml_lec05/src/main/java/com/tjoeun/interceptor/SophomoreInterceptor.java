package com.tjoeun.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.beans.Sophomore;
import com.tjoeun.service.SophomoreService;

public class SophomoreInterceptor implements HandlerInterceptor{
	
	@Autowired
	private SophomoreService sophomoreService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		List<Sophomore> sophomoreList = sophomoreService.selectAll();
		System.out.println("sophomoreList (interceptor) : " + sophomoreList);
		request.setAttribute("sophomoreList", sophomoreList);
		return true;
	}
	
}
