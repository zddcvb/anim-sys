package com.yanxi.anim.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/home_top")
	public String top() {
		return "/home/top";
	}

	@RequestMapping("/home_right")
	public String right() {
		return "/home/right";
	}

	@RequestMapping("/home_left")
	public String left() {
		return "/home/left";
	}

	@RequestMapping("/home_bottom")
	public String bottom() {
		return "/home/bottom";
	}
}
