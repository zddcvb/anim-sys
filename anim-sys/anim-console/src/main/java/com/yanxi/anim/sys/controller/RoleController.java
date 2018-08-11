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
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.constant.BatchUrl;
import com.yanxi.anim.sys.pojo.AnimDept;
import com.yanxi.anim.sys.pojo.AnimRes;
import com.yanxi.anim.sys.pojo.AnimRole;
import com.yanxi.anim.sys.service.AnimDeptService;
import com.yanxi.anim.sys.service.AnimRoleService;
import com.yanxi.anim.sys.utils.DateFormate;
import com.yanxi.anim.sys.utils.IdGeneratorUtils;
import com.yanxi.anim.sys.utils.POIUtils;

/**
 * 岗位信息
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private AnimRoleService animRoleService;
	@Autowired
	private AnimDeptService animDeptService;
	private static Logger logger = Logger.getLogger(RoleController.class);


	@RequestMapping("/save")
	public String save(Model model, HttpServletRequest request) {
		logger.info("=================RoleController save==========================");
		String pageNum = request.getParameter("pageNum");
		String roleNameQuery = request.getParameter("roleNameQuery");
		String deptNameQuery = request.getParameter("deptNameQuery");
		model.addAttribute("roleNameQuery", roleNameQuery);
		model.addAttribute("deptNameQuery", deptNameQuery);
		model.addAttribute("pageNum", pageNum);
		List<AnimDept> animDepts = animDeptService.findAll();
		if (animDepts != null) {
			model.addAttribute("deptList", animDepts);
		}
		return "/role/role_save";
	}

	@RequestMapping("/save_role")
	public String saveRole(HttpServletRequest request) {
		logger.info("=================RoleController saveRole==========================");
		String roleName = request.getParameter("roleName");
		String roleDesc = request.getParameter("roleDesc");
		String roleCreatetime = request.getParameter("roleCreatetime");
		String roleDuty = request.getParameter("roleDuty");
		String deptId = request.getParameter("deptId");
		String pageNum = request.getParameter("pageNum");
		String roleNameQuery = request.getParameter("roleNameQuery");
		String deptNameQuery = request.getParameter("deptNameQuery");
		AnimRole animRole = new AnimRole();
		animRole.setRoleId(IdGeneratorUtils.generatorUUID());
		animRole.setRoleDesc(roleDesc);
		animRole.setRoleName(roleName);
		animRole.setRoleDuty(roleDuty);
		animRole.setDeptId(deptId);
		animRole.setRoleCreatetime(roleCreatetime);
		animRole.setRoleUpdatetime(roleCreatetime);
		animRole.setIsdeleted(false);

		animRoleService.insert(animRole);
		return "redirect:/role/list?pageNum=" + Integer.parseInt(pageNum) + "&roleNameQuery=" + roleNameQuery
				+ "&deptNameQuery=" + deptNameQuery;
	}

	@RequestMapping("/edit/{roleId}")
	public String edit(Model model, @PathVariable String roleId, HttpServletRequest request) {
		logger.info("=================RoleController edit==========================");
		String pageNum = request.getParameter("pageNum");
		model.addAttribute("pageNum", pageNum);
		AnimRole animRole = animRoleService.findById(roleId);
		if (animRole != null) {
			AnimDept animDept = animDeptService.findById(animRole.getDeptId());
			animRole.setAnimDept(animDept);
			model.addAttribute("animRole", animRole);
		}
		return "/role/role_edit";
	}

	@RequestMapping("/edit_role")
	public String editRole(HttpServletRequest request) {
		logger.info("=================RoleController editRole==========================");
		String roleId = request.getParameter("roleId");
		String roleName = request.getParameter("roleName");
		String roleDesc = request.getParameter("roleDesc");
		String roleDuty = request.getParameter("roleDuty");
		String deptId = request.getParameter("deptId");
		String pageNum = request.getParameter("pageNum");
		String roleNameQuery = request.getParameter("roleNameQuery");
		String deptNameQuery = request.getParameter("deptNameQuery");
		AnimRole animRole = animRoleService.findById(roleId);
		animRole.setRoleName(roleName);
		animRole.setRoleDesc(roleDesc);
		animRole.setRoleDuty(roleDuty);
		animRole.setDeptId(deptId);
		animRole.setRoleUpdatetime(DateFormate.formateDateToString(new Date()));
		animRoleService.update(animRole);
		return "redirect:/role/list?pageNum=" + Integer.parseInt(pageNum) + "&roleNameQuery=" + roleNameQuery
				+ "&deptNameQuery=" + deptNameQuery;
	}

	@RequestMapping("/delete/{roleId}")
	public String deleteById(@PathVariable String roleId, HttpServletRequest request) {
		logger.info("=================RoleController deleteById==========================");
		String pageNum = request.getParameter("pageNum");
		animRoleService.deleteById(roleId);
		return "redirect:/role/list?pageNum=" + Integer.parseInt(pageNum);
	}

	@RequestMapping("/update/{roleId}")
	public String udapteById(@PathVariable String roleId, HttpServletRequest request) {
		logger.info("=================RoleController udapteById==========================");
		String pageNum = request.getParameter("pageNum");
		String roleNameQuery = request.getParameter("roleNameQuery");
		String deptNameQuery = request.getParameter("deptNameQuery");
		AnimRole animRole = animRoleService.findById(roleId);
		Boolean isdeleted = animRole.getIsdeleted();
		logger.info("isdeleted:" + isdeleted);
		if (isdeleted) {
			animRole.setIsdeleted(false);
		} else {
			animRole.setIsdeleted(true);
		}

		animRoleService.update(animRole);
		return "redirect:/role/list?pageNum=" + Integer.parseInt(pageNum) + "&roleNameQuery=" + roleNameQuery
				+ "&deptNameQuery=" + deptNameQuery;
	}

	@RequestMapping("/list")
	public String queryForCondition(HttpServletRequest request, @RequestParam(defaultValue = "0") int pageNum,
			Model model) {
		logger.info("=================RoleController queryForCondition==========================");
		String roleNameQuery = request.getParameter("roleNameQuery");
		String deptNameQuery = request.getParameter("deptNameQuery");
		logger.info(roleNameQuery + ":" + deptNameQuery);
		// 查询部门id
		AnimDept animDept = null;
		String deptId = null;
		logger.info(StringUtils.isEmpty(deptNameQuery));
		if (!StringUtils.isEmpty(deptNameQuery)) {
			animDept = animDeptService.findByName(deptNameQuery);
			deptId = animDept.getDeptId();
			logger.info(deptId);
		}
		PageInfo<AnimRole> pageInfo = animRoleService.findRolesByRoleNameAndDeptId(roleNameQuery, deptId, pageNum);
		List<AnimRole> animRoles = new ArrayList<>();
		for (AnimRole animRole : pageInfo.getList()) {
			AnimDept dept = animDeptService.findById(animRole.getDeptId());
			animRole.setAnimDept(dept);
			animRoles.add(animRole);
		}
		pageInfo.setList(animRoles);
		logger.info(pageInfo);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("roleNameQuery", roleNameQuery);
		model.addAttribute("deptNameQuery", deptNameQuery);
		return "/role/role_list";
	}

	@RequestMapping("/view/{roleId}")
	public String view(HttpServletRequest request, @PathVariable String roleId, Model model) {
		logger.info("=================RoleController view==========================");
		String pageNum = request.getParameter("pageNum");
		String roleNameQuery = request.getParameter("roleNameQuery");
		String deptNameQuery = request.getParameter("deptNameQuery");
		model.addAttribute("roleNameQuery", roleNameQuery);
		model.addAttribute("deptNameQuery", deptNameQuery);
		model.addAttribute("pageNum", pageNum);
		AnimRole animRole = animRoleService.findById(roleId);
		AnimDept animDept = animDeptService.findById(animRole.getDeptId());
		animRole.setAnimDept(animDept);
		model.addAttribute("animRole", animRole);
		return "/role/role_view";
	}

	@RequestMapping("/view/back")
	public String back(HttpServletRequest request) {
		logger.info("=================RoleController back==========================");
		String pageNum = request.getParameter("pageNum");
		String roleNameQuery = request.getParameter("roleNameQuery");
		String deptNameQuery = request.getParameter("deptNameQuery");
		logger.info(pageNum + ":" + roleNameQuery + ":" + deptNameQuery);
		return "redirect:/role/list?pageNum=" + Integer.parseInt(pageNum) + "&roleNameQuery=" + roleNameQuery
				+ "&deptNameQuery=" + deptNameQuery;
	}

	@RequestMapping("/batchAll")
	public String batchAll() {
		logger.info("=================RoleController batchAll==========================");
		POIUtils poiUtils = new POIUtils();
		List<AnimRole> animRoles = poiUtils.redRoleData(BatchUrl.ROLE);
		if (animRoles != null) {
			for (AnimRole animRole : animRoles) {
				AnimDept animDept = animDeptService.findByName(animRole.getAnimDept().getDeptName());
				if (animDept != null) {
					animRole.setDeptId(animDept.getDeptId());
				}
				AnimRole role = animRoleService.findByName(animRole.getRoleName());
				if (role != null) {
					animRole.setRoleId(role.getRoleId());
					animRoleService.update(animRole);
				} else {
					animRole.setRoleId(IdGeneratorUtils.generatorUUID());
					animRoleService.insert(animRole);
				}
			}
		}
		return "redirect:/role/list";
	}
}
