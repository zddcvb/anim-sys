package com.yanxi.anim.sys.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yanxi.anim.sys.pojo.AnimAccout;
import com.yanxi.anim.sys.service.AccoutService;
import com.yanxi.anim.sys.service.JedisService;
import com.yanxi.anim.sys.utils.JsonUtils;

@Controller
public class LoginController {
	@Autowired
	private AccoutService accoutService;
	@Autowired
	private JedisService jedisService;

	/**
	 * 显示登录页面
	 * 
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/showLogin")
	public ModelAndView showLogin(ModelAndView modelAndView) {
		modelAndView.setViewName("/login");
		return modelAndView;
	}

	/**
	 * 登录，返回json数据，并设置cookie
	 * 
	 * @param modelAndView
	 * @param accout
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public AnimAccout login(ModelAndView modelAndView, AnimAccout accout, HttpServletRequest request,
			HttpServletResponse response) {
		String password = accout.getPassword();
		accout.setPassword(DigestUtils.md5Hex(password));
		AnimAccout animAccout = accoutService.findByUsernameAndPassword(accout);
		HttpSession session = request.getSession();
		if (animAccout != null) {
			String encode;
			try {
				// 保存至cookie
				System.out.println(animAccout);
				encode = URLEncoder.encode(JsonUtils.objectToJson(accout), "utf-8");
				Cookie cookie = new Cookie("animAccout", encode);
				response.addCookie(cookie);
				System.out.println(JsonUtils.objectToJson(animAccout));
				session.setAttribute("animAccout", JsonUtils.objectToJson(animAccout));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return animAccout;
	}

	/**
	 * 退出系统
	 * 
	 * @param modelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if ("animAccout".equals(name)) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					break;
				}
			}
		}
		String accoutType = jedisService.get("redis_accoutType");
		if (accoutType != null) {
			jedisService.delete("redis_accoutType");
		}
		modelAndView.setViewName("redirect:/showLogin");
		return modelAndView;
	}

}
