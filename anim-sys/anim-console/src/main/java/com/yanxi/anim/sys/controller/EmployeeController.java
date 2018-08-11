package com.yanxi.anim.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.solr.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.yanxi.anim.sys.constant.BatchUrl;
import com.yanxi.anim.sys.constant.ConstantUrl;
import com.yanxi.anim.sys.pojo.AnimDept;
import com.yanxi.anim.sys.pojo.AnimEmployee;
import com.yanxi.anim.sys.pojo.AnimRole;
import com.yanxi.anim.sys.pojo.QueryCondition;
import com.yanxi.anim.sys.service.AnimDeptService;
import com.yanxi.anim.sys.service.AnimEmployeeService;
import com.yanxi.anim.sys.service.AnimRoleService;
import com.yanxi.anim.sys.utils.AgeUtils;
import com.yanxi.anim.sys.utils.DateFormate;
import com.yanxi.anim.sys.utils.IdGeneratorUtils;
import com.yanxi.anim.sys.utils.JsonUtils;
import com.yanxi.anim.sys.utils.POIUtils;
import com.yanxi.anim.sys.utils.QueryConditionUtils;

/**
 * 岗位信息
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private AnimEmployeeService animEmployeeService;
	@Autowired
	private AnimDeptService animDeptService;

	@Autowired
	private AnimRoleService animRoleService;

	private static Logger logger = Logger.getLogger(EmployeeController.class);

	/**
	 * 跳转至save网页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/save")
	public String save(Model model, HttpServletRequest request) {
		logger.info("=========EmployeeController save==========");
		String pageNum = request.getParameter("pageNum");
		// 封装查询条件
		QueryCondition queryCondition = QueryConditionUtils.queryEmployee(request);
		modelAddQuery(model, queryCondition);
		model.addAttribute("pageNum", pageNum);
		List<AnimRole> animRoles = animRoleService.findAll();
		if (animRoles != null) {
			model.addAttribute("roleList", animRoles);
		}
		return ConstantUrl.EMPLOYEE_SAVE;
	}

	/**
	 * 保存数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/save_employee")
	public String saveEmployee(HttpServletRequest request, AnimEmployee employee) {
		logger.info("=========EmployeeController saveEmployee==========");
		String pageNum = request.getParameter("pageNum");
		// 封装查询条件
		QueryCondition queryCondition = QueryConditionUtils.queryEmployee(request);
		AnimEmployee animEmployee = getAnimEmployee(employee, 1, null);
		animEmployeeService.insert(animEmployee);
		return redirectList(pageNum, queryCondition);
	}

	/**
	 * 跳转至edit页面
	 * 
	 * @param model
	 * @param employeeId
	 * @param request
	 * @return
	 */
	@RequestMapping("/edit/{employeeId}")
	public String edit(Model model, @PathVariable String employeeId, HttpServletRequest request) {
		logger.info("=========EmployeeController edit==========");
		String pageNum = request.getParameter("pageNum");
		model.addAttribute("pageNum", pageNum);
		AnimEmployee animEmployee = animEmployeeService.findById(employeeId);
		if (animEmployee != null) {
			AnimRole animRole = animRoleService.findById(animEmployee.getRoleId());
			animEmployee.setAnimRole(animRole);
			// 查询所有的岗位信息和部门信息，
			List<AnimRole> animRoles = animRoleService.findAll();
			model.addAttribute("animEmployee", animEmployee);
			model.addAttribute("roleList", animRoles);
		}
		return ConstantUrl.EMPLOYEE_EDIT;
	}

	/**
	 * 更新数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/edit_employee")
	public String editEmployee(HttpServletRequest request, AnimEmployee employee) {
		logger.info("=========EmployeeController editEmployee==========");
		String employeeId = request.getParameter("employeeId");
		String pageNum = request.getParameter("pageNum");
		// 封装查询条件
		QueryCondition queryCondition = QueryConditionUtils.queryEmployee(request);
		AnimEmployee animEmployee = getAnimEmployee(employee, 2, employeeId);
		animEmployeeService.update(animEmployee);
		return redirectList(pageNum, queryCondition);
	}

	/**
	 * 删除单个数据
	 * 
	 * @param employeeId
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete/{employeeId}")
	public String deleteById(@PathVariable String employeeId, HttpServletRequest request) {
		logger.info("=========EmployeeController deleteById==========");
		String pageNum = request.getParameter("pageNum");
		animEmployeeService.deleteById(employeeId);
		return ConstantUrl.EMPLOYEE_REDIRECT_LIST_PAGE + Integer.parseInt(pageNum);
	}

	/**
	 * 设置员工是否离职
	 * 
	 * @param employeeId
	 * @param request
	 * @return
	 */
	@RequestMapping("/update/{employeeId}")
	public String udapteById(@PathVariable String employeeId, HttpServletRequest request) {
		logger.info("=========EmployeeController udapteById==========");
		String pageNum = request.getParameter("pageNum");
		// 封装查询条件
		QueryCondition queryCondition = QueryConditionUtils.queryEmployee(request);
		AnimEmployee animEmployee = animEmployeeService.findById(employeeId);
		Boolean isdeleted = animEmployee.getIsleaved();
		logger.info("isdeleted:" + isdeleted);
		if (isdeleted) {
			animEmployee.setIsleaved(false);
		} else {
			animEmployee.setIsleaved(true);
		}
		animEmployee.setEmployeeUpdatetime(DateFormate.formateDateToString(new Date()));
		animEmployeeService.update(animEmployee);
		return redirectList(pageNum, queryCondition);
	}

	/**
	 * 展示所有的页面
	 * 
	 * @param request
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String queryForCondition(HttpServletRequest request, QueryCondition queryCondition,
			@RequestParam(defaultValue = "1") int pageNum, Model model) {
		logger.info("=========EmployeeController queryForCondition==========");
		logger.info("query:" + queryCondition);
		// 封装查询条件
		model.addAttribute("query", queryCondition);
		// 查询部门id
		AnimDept animDept = null;
		String deptId = null;
		// 获取部门id
		if (!StringUtils.isEmpty(queryCondition.getDeptNameQuery())) {
			animDept = animDeptService.findByName(queryCondition.getDeptNameQuery());
			if (animDept != null) {
				deptId = animDept.getDeptId();
				logger.info(deptId);
			}
		}
		AnimRole animRole = null;
		String roleId = null;
		if (!StringUtil.isEmpty(queryCondition.getRoleNameQuery())) {
			animRole = animRoleService.findByName(queryCondition.getRoleNameQuery());
			if (animRole != null) {
				logger.info(animRole);
				roleId = animRole.getRoleId();
			}
		}
		PageInfo<AnimEmployee> pageInfo = animEmployeeService
				.findEmployeesByQueryCondition(queryCondition.getEmployeeNameQuery(), roleId, deptId, pageNum);
		List<AnimEmployee> animEmployees = new ArrayList<>();
		for (AnimEmployee animEmployee : pageInfo.getList()) {
			// 保存dept信息
			AnimDept dept = animDeptService.findById(animEmployee.getDeptId());
			animEmployee.setAnimDept(dept);
			// 保存岗位信息
			AnimRole role = animRoleService.findById(animEmployee.getRoleId());
			animEmployee.setAnimRole(role);
			animEmployees.add(animEmployee);
		}
		pageInfo.setList(animEmployees);
		logger.info(pageInfo);
		model.addAttribute("pageInfo", pageInfo);

		return ConstantUrl.EMPLOYEE_LIST;
	}

	/**
	 * 查看数据
	 * 
	 * @param request
	 * @param employeeId
	 * @param model
	 * @return
	 */
	@RequestMapping("/view/{employeeId}")
	public String view(HttpServletRequest request, QueryCondition queryCondition, @PathVariable String employeeId,
			Model model) {
		logger.info("=========EmployeeController view==========");
		String pageNum = request.getParameter("pageNum");
		// 封装查询条件
		model.addAttribute("query", queryCondition);
		model.addAttribute("pageNum", pageNum);
		AnimEmployee animEmployee = animEmployeeService.findById(employeeId);
		// 存放部门信息
		AnimDept animDept = animDeptService.findById(animEmployee.getDeptId());
		animEmployee.setAnimDept(animDept);
		// 存放岗位信息
		AnimRole animRole = animRoleService.findById(animEmployee.getRoleId());
		animEmployee.setAnimRole(animRole);
		model.addAttribute("animEmployee", animEmployee);
		return ConstantUrl.EMPLOYEE_VIEW;
	}

	/**
	 * 返回上一级
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/view/back",method=RequestMethod.GET)
	public String back(HttpServletRequest request, QueryCondition queryCondition) {
		logger.info("=========EmployeeController back==========");
		String pageNum = request.getParameter("pageNum");
		logger.info("queryCondition:" + queryCondition);
		// 封装查询条件
		return redirectList(pageNum, queryCondition);
	}

	/**
	 * 批处理插入和更新数据操作
	 * 
	 * @return
	 */
	@RequestMapping("/batchAll")
	public String batch() {
		logger.info("=========EmployeeController batch==========");
		// 读取excel表格，形成数据
		POIUtils pOIUtils = new POIUtils();
		List<AnimEmployee> animEmployees = pOIUtils.readEmployeeDate(BatchUrl.EMPLOYEE);
		for (AnimEmployee animEmployee : animEmployees) {
			logger.info(animEmployee.getAnimRole());
			// 获得部门和岗位信息
			AnimRole animRole = animRoleService.findByName(animEmployee.getAnimRole().getRoleName());
			logger.info(animRole);
			animEmployee.setRoleId(animRole.getRoleId());
			animEmployee.setDeptId(animRole.getDeptId());
			String employeeCardnum = animEmployee.getEmployeeCardnum();
			AnimEmployee card = animEmployeeService.findByCard(employeeCardnum);
			// 如果数据库中，则，执行更新操作
			if (card != null) {
				animEmployee.setEmployeeId(card.getEmployeeId());
				animEmployeeService.update(animEmployee);
			} else {
				// 如果数据库中没有，则执行插入操作
				animEmployee.setEmployeeId(IdGeneratorUtils.generatorUUID());
				animEmployeeService.insert(animEmployee);
			}
		}
		return ConstantUrl.EMPLOYEE_REDIRECT_LIST;
	}

	/**
	 * 更新数据
	 * 
	 * @param request
	 * @param flag
	 * @param employeeId
	 * @return
	 */
	private AnimEmployee getAnimEmployee(AnimEmployee employee, int flag, String employeeId) {
		logger.info("=========EmployeeController getAnimEmployee==========");
		logger.info("employee:" + employee);
		AnimEmployee animEmployee = null;
		if (flag == 1) {
			animEmployee = new AnimEmployee();
			animEmployee.setEmployeeId(IdGeneratorUtils.generatorUUID());
			animEmployee.setIsleaved(false);
			animEmployee.setEmployeeWorkedTime(employee.getEmployeeWorkedTime());
			animEmployee.setEmployeeCreatetime(DateFormate.formateDateToString(new Date()));
		} else if (flag == 2) {
			animEmployee = animEmployeeService.findById(employeeId);
		}
		animEmployee.setEmployeeSex(employee.getEmployeeSex());
		animEmployee.setEmployeeAge(AgeUtils.getAge(employee.getEmployeeBorn()));
		animEmployee.setEmployeeBorn(employee.getEmployeeBorn());
		animEmployee.setEmployeeName(employee.getEmployeeName());
		animEmployee.setEmployeeCardnum(employee.getEmployeeCardnum());
		// 根据岗位信息保存部门信息
		AnimRole animRole = animRoleService.findById(employee.getRoleId());
		animEmployee.setDeptId(animRole.getDeptId());
		animEmployee.setRoleId(employee.getRoleId());

		animEmployee.setEmployeeSchool(employee.getEmployeeSchool());
		animEmployee.setEmployeeMajor(employee.getEmployeeMajor());
		animEmployee.setEmployeeEducation(employee.getEmployeeEducation());
		animEmployee.setEmployeeFamilyAddress(employee.getEmployeeFamilyAddress());
		animEmployee.setEmployeeNowAddress(employee.getEmployeeNowAddress());
		animEmployee.setEmployeeTelephone(employee.getEmployeeTelephone());
		animEmployee.setEmployeeWechant(employee.getEmployeeWechant());
		animEmployee.setEmployeeQq(employee.getEmployeeQq());
		animEmployee.setEmployeeUpdatetime(DateFormate.formateDateToString(new Date()));
		return animEmployee;
	}

	/**
	 * 拼接redirect listurl
	 * 
	 * @param pageNum
	 * @param queryCondition
	 * @return
	 */
	private String redirectList(String pageNum, QueryCondition queryCondition) {
		logger.info("=========EmployeeController redirectList==========");
		return ConstantUrl.EMPLOYEE_REDIRECT_LIST_PAGE + Integer.parseInt(pageNum) + "&employeeNameQuery="
				+ queryCondition.getEmployeeNameQuery() + "&roleNameQuery=" + queryCondition.getRoleNameQuery()
				+ "&deptNameQuery=" + queryCondition.getDeptNameQuery();
	}

	/**
	 * 将查询条件封装到model中
	 * 
	 * @param model
	 * @param queryCondition
	 */
	private void modelAddQuery(Model model, QueryCondition queryCondition) {
		logger.info("=========EmployeeController modelAddQuery==========");
		model.addAttribute("employeeNameQuery", queryCondition.getEmployeeNameQuery());
		model.addAttribute("roleNameQuery", queryCondition.getRoleNameQuery());
		model.addAttribute("deptNameQuery", queryCondition.getDeptNameQuery());
	}
}
