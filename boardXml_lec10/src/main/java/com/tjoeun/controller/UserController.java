package com.tjoeun.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjoeun.dto.UserDTO;
import com.tjoeun.service.UserService;
import com.tjoeun.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Resource(name="loginUserDTO")
	@Lazy
	private UserDTO loginUserDTO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator userValidator = new UserValidator();
		binder.addValidators(userValidator);
	}
	
	
	@GetMapping("/login")
  public String login(@ModelAttribute("validationLoginUserDTO") UserDTO validationLoginUserDTO,
                      @RequestParam(value="fail", defaultValue="false") boolean fail,
                      Model model){
  	model.addAttribute("fail", fail);
  	return "user/login";
  }
  
  @PostMapping("/login_procedure")
  public String login_procedure(@Valid @ModelAttribute("validationLoginUserDTO") UserDTO validationLoginUserDTO,
  		                          BindingResult result) {
  	if(result.hasErrors()) {
  		return "user/login";
  	}
     userService.getLoginUserInfo(validationLoginUserDTO);
  	
  	// loginUserDTO.isUserIsLogin() 이 true 이면 login 되었다는 것
  	if(loginUserDTO.isUserIsLogin()) {
  		return "user/login_success";
  	}
  	
  	return "user/login_failure";
  	
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
  	
  	loginUserDTO.setUserIsLogin(false);
  	
  	return "user/logout";
  }
  
  @GetMapping("/not_loggedin")
  public String notLoggedIn() {
  	return "user/not_loggedin";
  }
  
}
