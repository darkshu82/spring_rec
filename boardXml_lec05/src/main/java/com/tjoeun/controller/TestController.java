package com.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	@GetMapping("/developer")
	public String developer(){
		return "test/developer";
	}   
	@GetMapping("/officer")
	public String officer(){
		return "test/officer";
	}
	@GetMapping("/sophomore")
	public String sophomore(){
		return "test/sophomore";
	}
}



