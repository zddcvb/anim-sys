package com.yanxi.anim.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/show_login")
	public ModelAndView showLogin(ModelAndView modelAndView) {

		modelAndView.setViewName("/login");
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView modelAndView){
		modelAndView.setViewName("/index");
		return modelAndView;
	}
}
