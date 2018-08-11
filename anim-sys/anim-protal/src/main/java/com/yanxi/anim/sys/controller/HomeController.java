package com.yanxi.anim.sys.controller;

import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yanxi.anim.sys.pojo.AnimAccout;
import com.yanxi.anim.sys.pojo.AnimResCatagorty;
import com.yanxi.anim.sys.service.AnimResCatagortyService;
import com.yanxi.anim.sys.utils.JsonUtils;

@Controller
public class HomeController {
	@Autowired
	private AnimResCatagortyService animResCatagortyService;
	private static Logger logger = Logger.getLogger(HomeController.class);

	/**
	 * 跳转至index.jsp
	 * 
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("/index");
		return modelAndView;
	}

	/**
	 * 跳转是top.jsp
	 * 
	 * @param modelAndView
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/home_top")
	public ModelAndView top(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		AnimAccout animAccout = null;
		try {
			if (cookies.length > 1) {
				for (Cookie cookie : cookies) {
					String name = cookie.getName();
					if ("animAccout".equals(name)) {
						String jsonData = cookie.getValue();
						animAccout = JsonUtils.jsonToPojo(URLDecoder.decode(jsonData, "utf-8"), AnimAccout.class);
						break;
					}
				}
			} else {
				animAccout = new AnimAccout();
				animAccout.setUsername("请登录");
			}
		} catch (Exception exception) {
			animAccout = new AnimAccout();
			animAccout.setUsername("请登录");
		}
		modelAndView.addObject("animAccout", animAccout);
		modelAndView.setViewName("/home/top");
		return modelAndView;
	}

	/**
	 * 跳转至right.jsp
	 * 
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/home_right")
	public ModelAndView right(ModelAndView modelAndView) {
		modelAndView.setViewName("/home/right");
		return modelAndView;
	}

	/**
	 * 跳转至left页面
	 * 
	 * @param modelAndView
	 * @param request
	 * @return
	 */
	@RequestMapping("/home_left")
	public ModelAndView left(ModelAndView modelAndView, HttpServletRequest request) {

		// 查询所有的分类信息
		List<AnimResCatagorty> catagorties = null;
		HttpSession session = request.getSession();
		String jsonData = (String) session.getAttribute("catagorties");

		if (jsonData != null) {
			logger.info("session");
			catagorties = JsonUtils.jsonToList(jsonData, AnimResCatagorty.class);
		} else {
			logger.info("数据库");
			catagorties = animResCatagortyService.findByResCatagortyName();
			session.setAttribute("catagorties", JsonUtils.listToJson(catagorties));
			session.setMaxInactiveInterval(3600 * 24);
		}
		if (catagorties != null) {
			modelAndView.addObject("resCatas", catagorties);
		}
		String json = (String) session.getAttribute("animAccout");
		if (json != null) {
			AnimAccout accout = JsonUtils.jsonToPojo(json, AnimAccout.class);
			System.out.println(accout);
			modelAndView.addObject("accout_session", accout);
		}
		modelAndView.setViewName("/home/left");
		return modelAndView;
	}

	/**
	 * 跳转至bottom页面
	 * 
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/home_bottom")
	public ModelAndView bottom(ModelAndView modelAndView) {
		modelAndView.setViewName("/home/bottom");
		return modelAndView;
	}
}
