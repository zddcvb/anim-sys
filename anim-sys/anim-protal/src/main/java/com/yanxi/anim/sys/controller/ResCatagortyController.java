package com.yanxi.anim.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yanxi.anim.sys.pojo.AnimResCatagorty;
import com.yanxi.anim.sys.service.AnimResCatagortyService;

@Controller
public class ResCatagortyController {
	@Autowired
	private AnimResCatagortyService resCatagortyService;
	private static Logger logger = Logger.getLogger(ResCatagortyController.class);

	@RequestMapping("/rescatas")
	public ModelAndView list(ModelAndView modelAndView) {
		List<List<AnimResCatagorty>> lists = new ArrayList<>();

		// 1、查找所有
		List<AnimResCatagorty> parents = resCatagortyService.findParent();
		if (parents != null) {
			logger.info("parents:" + parents);
			// 根据parentId查找所有数据，保存至list中
			for (AnimResCatagorty parent : parents) {
				List<AnimResCatagorty> catagorties = resCatagortyService.findAllByParentId(parent.getResCatagortyId());

				lists.add(catagorties);
			}
		}
		modelAndView.addObject("resCataLists", lists);
		modelAndView.setViewName("/res_cata");
		return modelAndView;
	}

	@RequestMapping("/res_cata/{id}")
	public ModelAndView getById(@PathVariable String id, ModelAndView modelAndView) {
		modelAndView.setViewName("forward:/res/list?parentId=" + id);
		return modelAndView;

	}
}
