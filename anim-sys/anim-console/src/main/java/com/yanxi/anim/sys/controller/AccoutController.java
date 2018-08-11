package com.yanxi.anim.sys.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.pojo.AnimAccout;
import com.yanxi.anim.sys.pojo.AnimEmployee;
import com.yanxi.anim.sys.pojo.QueryCondition;
import com.yanxi.anim.sys.service.AccoutService;
import com.yanxi.anim.sys.service.AnimEmployeeService;
import com.yanxi.anim.sys.utils.DateFormate;
import com.yanxi.anim.sys.utils.IdGeneratorUtils;

@Controller
@RequestMapping("/accout")
public class AccoutController {
	@Autowired
	private AccoutService accoutService;
	@Autowired
	private AnimEmployeeService employeeService;

	@RequestMapping("/list")
	public ModelAndView list(ModelAndView modelAndView, @RequestParam(defaultValue = "1") int pageNum,
			QueryCondition query) {
		PageInfo<AnimAccout> pageInfo = accoutService.findAllByPage(pageNum, query.getNameQuery());
		modelAndView.addObject("pageNum", pageNum);
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.setViewName("/accout/accout_list");
		return modelAndView;
	}

	@RequestMapping("/batchAll")
	public ModelAndView batchAll(ModelAndView modelAndView) {
		List<AnimEmployee> employees = employeeService.findAll();
		for (AnimEmployee animEmployee : employees) {
			AnimAccout accout = new AnimAccout();
			accout.setUsername(animEmployee.getEmployeeName());
			accout.setPassword(DigestUtils.md5Hex("123456"));
			String date = DateFormate.formateDateToString(new Date());
			accout.setAccoutCreatetime(date);
			accout.setAccoutUpdatetime(date);
			accout.setId(IdGeneratorUtils.generatorUUID());
			accout.setAccoutType(2);
			accout.setProfileUrl(null);
			accout.setEmployeeId(animEmployee.getEmployeeId());
			if (animEmployee.getIsleaved()) {
				accout.setIsdeleted(false);
			} else {
				accout.setIsdeleted(true);
			}
			accoutService.insert(accout);
		}
		modelAndView.setViewName("redirect:/accout/list");
		return modelAndView;
	}

	@RequestMapping("/update/password/{id}")
	public ModelAndView initPassword(@PathVariable String id, ModelAndView modelAndView, HttpServletRequest request,
			QueryCondition query) {
		String pageNum = request.getParameter("pageNum");
		AnimAccout animAccout = accoutService.findById(id);
		animAccout.setPassword(DigestUtils.md5Hex("123456"));
		animAccout.setAccoutUpdatetime(DateFormate.formateDateToString(new Date()));
		accoutService.update(animAccout);
		modelAndView.addObject("pageNum", pageNum);
		modelAndView.addObject("query", query);
		modelAndView.setViewName("redirect:/accout/list");
		return modelAndView;
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView deleteById(@PathVariable String id, ModelAndView modelAndView, HttpServletRequest request,
			QueryCondition query) {
		String pageNum = request.getParameter("pageNum");
		accoutService.deleteById(id);
		modelAndView.addObject("pageNum", pageNum);
		modelAndView.addObject("query", query);
		modelAndView.setViewName("redirect:/accout/list");
		return modelAndView;
	}
	@RequestMapping("/deleteAll")
	public ModelAndView deleteAll(ModelAndView modelAndView) {
		accoutService.deleteAll();
		modelAndView.setViewName("redirect:/accout/list");
		return modelAndView;
	}

	@RequestMapping("/update/state/{id}")
	public ModelAndView updateState(@PathVariable String id, ModelAndView modelAndView, HttpServletRequest request,
			QueryCondition query) {
		String pageNum = request.getParameter("pageNum");
		AnimAccout animAccout = accoutService.findById(id);
		if (animAccout.getIsdeleted()) {
			animAccout.setIsdeleted(false);
		} else {
			animAccout.setIsdeleted(true);
		}
		animAccout.setAccoutUpdatetime(DateFormate.formateDateToString(new Date()));
		accoutService.update(animAccout);
		modelAndView.addObject("pageNum", pageNum);
		modelAndView.addObject("query", query);
		modelAndView.setViewName("redirect:/accout/list");
		return modelAndView;
	}

	@RequestMapping("/insert")
	@ResponseBody
	public AnimAccout insert() {
		AnimAccout accout = new AnimAccout();
		accout.setId(IdGeneratorUtils.generatorUUID());
		accout.setUsername("admin");
		accout.setPassword(DigestUtils.md5Hex("123456789"));
		accout.setAccoutType(0);
		String date = DateFormate.formateDateToString(new Date());
		accout.setAccoutCreatetime(date);
		accout.setAccoutUpdatetime(date);
		accout.setEmployeeId(null);
		accout.setIsdeleted(true);
		accoutService.insert(accout);
		return accout;
	}
	@RequestMapping("/save")
	public ModelAndView save(ModelAndView modelAndView,HttpServletRequest request,QueryCondition query){
		String pageNum = request.getParameter("pageNum");
		modelAndView.addObject("pageNum", pageNum);
		modelAndView.addObject("query", query);
		modelAndView.setViewName("/accout/accout_save");
		return modelAndView;
	}
	@RequestMapping("/save_data")
	public ModelAndView saveDate(ModelAndView modelAndView,HttpServletRequest request,QueryCondition query,AnimAccout accout){
		AnimAccout animAccout=new AnimAccout();
		animAccout.setId(IdGeneratorUtils.generatorUUID());
		String date=DateFormate.formateDateToString(new Date());
		animAccout.setAccoutCreatetime(date);
		animAccout.setAccoutUpdatetime(date);
		animAccout.setIsdeleted(true);
		animAccout.setUsername(accout.getUsername().trim());
		animAccout.setPassword(DigestUtils.md5Hex(accout.getPassword()));
		animAccout.setEmployeeId(null);
		animAccout.setProfileUrl(null);
		accoutService.insert(animAccout);
		String pageNum = request.getParameter("pageNum");
		modelAndView.addObject("pageNum", pageNum);
		modelAndView.addObject("query", query);
		modelAndView.setViewName("redirect:/accout/list");
		return modelAndView;
	}
	
}
