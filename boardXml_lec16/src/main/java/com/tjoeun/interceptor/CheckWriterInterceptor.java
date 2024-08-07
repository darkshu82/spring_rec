package com.tjoeun.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.dto.ContentDTO;
import com.tjoeun.dto.UserDTO;
import com.tjoeun.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	
	/*
	  Xml 설정 방식에서는 Interceptor 에서는 주입받을 수 있으므로함
	  직접 주입 받아서 사용함
	*/
	@Resource(name="loginUserDTO")
	@Lazy
	private UserDTO loginUserDTO;
	
	@Autowired
	private BoardService boardService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		int contentIdx = Integer.parseInt(request.getParameter("content_idx"));
		ContentDTO contentDTO = boardService.getContent(contentIdx);
		
		if(contentDTO.getContent_writer_idx() != loginUserDTO.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/board/cant_write");
			return false;
		}
		
		return true;
		
	}
	
	
	
	
	
	

}
