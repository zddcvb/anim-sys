package com.yanxi.anim.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yanxi.anim.sys.pojo.AnimDept;
import com.yanxi.anim.sys.pojo.AnimEmployee;
import com.yanxi.anim.sys.pojo.AnimRole;
import com.yanxi.anim.sys.service.AnimDeptService;
import com.yanxi.anim.sys.service.AnimEmployeeService;
import com.yanxi.anim.sys.service.AnimRoleService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private AnimEmployeeService employeeService;
	@Autowired
	private AnimDeptService deptService;
	@Autowired
	private AnimRoleService roleService;
	@RequestMapping("/info")
	@ResponseBody
	public ModelAndView showList(ModelAndView modelAndView,String employeeId) {
		AnimEmployee animEmployee = employeeService.findById(employeeId);
		//
		AnimDept animDept = deptService.findById(animEmployee.getDeptId());
		animEmployee.setAnimDept(animDept);
		//
		AnimRole animRole = roleService.findById(animEmployee.getRoleId());
		animEmployee.setAnimRole(animRole);
		if (animEmployee!=null) {
			modelAndView.addObject("employee", animEmployee);
		}
		modelAndView.setViewName("/info/empInfo");
		return modelAndView;
	}

}
