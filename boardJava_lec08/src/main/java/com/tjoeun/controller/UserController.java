package com.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjoeun.dto.UserDTO;
import com.tjoeun.service.UserService;
import com.tjoeun.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator userValidator = new UserValidator();
		binder.addValidators(userValidator);
	}
	
	
  @GetMapping("/login")
  public String login() {
  	return "user/login";
  }
  
  @GetMapping("/join")
  public String join(@ModelAttribute("joinUserDTO") UserDTO joinUserDTO) {
  	return "user/join";
  }
  
  @PostMapping("/join_procedure")
  public String join_procedure(@Valid @ModelAttribute("joinUserDTO") UserDTO joinUserDTO, 
  		                         BindingResult result) {
  	     
  	if(result.hasErrors()) {
  		return "user/join";  		
  	}
  	
  	userService.insertUser(joinUserDTO);
  	
  	return "user/join_success";
  }
  
  @GetMapping("/modify")
  public String modify() {
  	return "user/modify";
  }
  
  @GetMapping("/logout")
  public String logout() {
  	return "user/logout";
  }
  
}
