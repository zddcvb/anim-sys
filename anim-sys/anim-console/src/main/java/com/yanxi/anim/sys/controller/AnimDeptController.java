package com.yanxi.anim.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.constant.BatchUrl;
import com.yanxi.anim.sys.pojo.AnimDept;
import com.yanxi.anim.sys.service.AnimDeptService;
import com.yanxi.anim.sys.utils.DateFormate;
import com.yanxi.anim.sys.utils.IdGeneratorUtils;
import com.yanxi.anim.sys.utils.POIUtils;

@Controller
@RequestMapping("/dept")
public class AnimDeptController {
	@Autowired
	private AnimDeptService animDeptService;

	private static Logger logger = Logger.getLogger(AnimDeptController.class);

	/**
	 * 查询所有，通过/deptList
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/deptList")
	public String findAll(Model model) {
		logger.info("===================AnimDeptController findAll===============");
		List<AnimDept> animDepts = animDeptService.findAll();
		logger.info("animDepts:" + animDepts);
		List<AnimDept> depts = new ArrayList<>();
		if (animDepts != null) {
			for (AnimDept animDept : animDepts) {
				// 设置上级部门
				AnimDept parent = animDeptService.findById(animDept.getParentId());
				animDept.setParent(parent);
				// 查询下级部门
				List<AnimDept> children = animDeptService.findChildrenByParentId(animDept.getDeptId());
				animDept.setChildren(children);
				depts.add(animDept);
			}
			logger.info("depts:" + depts);
			model.addAttribute("deptList", depts);
		}
		return "/dept/dept_list";
	}

	/**
	 * 查询所有，根据parentId,只显示一个层级的信息
	 * 
	 * @param parentId
	 * @param model
	 * @return
	 */
	@RequestMapping("/list/{parentId}")
	public String list(@PathVariable String parentId, @RequestParam(defaultValue = "1") int pageNum, Model model) {
		logger.info("===================AnimDeptController list===============");
		// model.addAttribute("parentId", parentId);
		logger.info(parentId + ":" + pageNum);
		// 查找上级部门
		AnimDept dept = animDeptService.findById(parentId);
		if (dept == null) {
			dept = new AnimDept();
			dept.setDeptId("0");
			model.addAttribute("parent", dept);
		} else {
			logger.info("上级部门不为空");
			model.addAttribute("parent", dept);
		}
		// 1、查找所有的上级部门，通过parentid来查询
		PageInfo<AnimDept> pageInfo = null;
		if (parentId.equals("0")) {
			pageInfo = animDeptService.findParentDept(parentId, pageNum);
			if (pageInfo != null) {
				model.addAttribute("pageInfo", pageInfo);
			}
		} else {
			pageInfo = animDeptService.findChildrenByParentId(parentId, pageNum);
			List<AnimDept> depts = new ArrayList<>();
			if (pageInfo != null) {
				logger.info("animDepts:" + pageInfo);
				for (AnimDept animDept : pageInfo.getList()) {
					AnimDept parent = animDeptService.findById(parentId);
					animDept.setParent(parent);
					depts.add(animDept);
				}
				pageInfo.setList(depts);
				model.addAttribute("pageInfo", pageInfo);
			}
		}
		return "/dept/dept_list_page";
	}

	/**
	 * 返回上一级，通过parentId来实现
	 * 
	 * @param parentId
	 * @param model
	 * @return
	 */
	@RequestMapping("/back/{parentId}")
	public String back(@PathVariable String parentId, Model model) {
		logger.info("===================AnimDeptController back===============");
		AnimDept animDept = animDeptService.findById(parentId);
		List<AnimDept> children = animDeptService.findChildrenByParentId(animDept.getParentId());
		model.addAttribute("deptList", children);
		// 查找上级部门
		AnimDept parent = animDeptService.findById(animDept.getParentId());
		model.addAttribute("parent", parent);
		if (parent == null) {
			return "redirect:/dept/list/0";
		}
		return "redirect:/dept/list/" + parent.getDeptId();
	}

	/**
	 * 跳转至添加页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(Model model, @RequestParam(defaultValue = "0") String pageNum, HttpServletRequest request) {
		logger.info("===================AnimDeptController save===============");
		String parentId = request.getParameter("parentId");
		model.addAttribute("parentId", parentId);
		// 查找上级部门
		List<AnimDept> parents = animDeptService.findAllDeptByDeleted(false);
		if (parents != null) {
			logger.info("上级部门的数量："+parents.size());
			model.addAttribute("parents", parents);
			model.addAttribute("pageNum", pageNum);
		}
		return "/dept/dept_save";
	}

	/**
	 * 保存数据，重定向到list页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveDept")
	public String saveDept(HttpServletRequest request,AnimDept dept) {
		logger.info("===================AnimDeptController saveDept===============");
		logger.info("dept:"+dept);
		AnimDept animDept = new AnimDept();
		String parentId = request.getParameter("parentId");
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		animDept.setParentId(parentId);
		animDept.setIsdeleted(false);
		animDept.setDeptCreatetime(dept.getDeptCreatetime());
		animDept.setDeptUpdatetime(DateFormate.formateDateToString(new Date()));
		animDept.setDeptDesc(dept.getDeptDesc());
		animDept.setDeptName(dept.getDeptName());
		animDept.setDeptId(IdGeneratorUtils.generatorUUID());
		animDeptService.insert(animDept);
		return "redirect:/dept/list/" + parentId + "?pageNum=" + Integer.parseInt(pageNum);
	}

	/**
	 * 修改功能，设置部门是否移除
	 * 
	 * @param deptId
	 * @return
	 */
	@RequestMapping("/modify/{deptId}")
	public String modifyById(@PathVariable String deptId, HttpServletRequest request) {
		logger.info("===================AnimDeptController modifyById===============");
		String pageNum = request.getParameter("pageNum");
		AnimDept animDept = animDeptService.findById(deptId);
		Boolean isdeleted = animDept.getIsdeleted();
		logger.info(isdeleted);
		if (isdeleted) {
			animDept.setIsdeleted(false);
		} else {
			animDept.setIsdeleted(true);
		}
		int update = animDeptService.update(animDept);
		logger.info("更新數量："+update);
		return "redirect:/dept/list/" + animDept.getParentId() + "?pageNum=" + Integer.parseInt(pageNum);
	}

	/**
	 * 查看部门信息
	 * 
	 * @param deptId
	 * @param model
	 * @return
	 */
	@RequestMapping("/view/{deptId}")
	public String viewDept(@PathVariable String deptId, Model model) {
		logger.info("===================AnimDeptController viewDept===============");
		AnimDept animDept = animDeptService.findById(deptId);
		// 设置parent
		AnimDept parent = animDeptService.findById(animDept.getParentId());
		animDept.setParent(parent);
		// 设置children
		List<AnimDept> children = animDeptService.findChildrenByParentId(animDept.getDeptId());
		animDept.setChildren(children);
		model.addAttribute("animDept", animDept);
		return "/dept/dept_view";
	}

	/**
	 * 删除所有
	 * 
	 * @return
	 */
	@RequestMapping("/deleteAll")
	public String deleteAll(@RequestParam(defaultValue = "0") String parentId) {
		logger.info("===================AnimDeptController deleteAll===============");
		// AnimDept animDept = animDeptService.findById(parentId);
		animDeptService.deleteChildren(parentId);
		return "redirect:/dept/list/" + parentId;
	}

	/**
	 * 根据id删除数据
	 * 
	 * @param deptId
	 * @return
	 */
	@RequestMapping("/delete/{deptId}")
	public String deleteById(@PathVariable String deptId, HttpServletRequest request) {
		logger.info("===================AnimDeptController deleteById===============");
		String pageNum = request.getParameter("pageNum");
		logger.info("pageNum:" + pageNum);
		AnimDept animDept = animDeptService.findById(deptId);
		animDeptService.deleteById(deptId);
		return "redirect:/dept/list/" + animDept.getParentId() + "?pageNum=" + Integer.parseInt(pageNum);
	}

	/**
	 * 跳转至编辑页面
	 * 
	 * @param deptId
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit/{deptId}")
	public String edit(@PathVariable String deptId, Model model, HttpServletRequest request) {
		logger.info("===================AnimDeptController edit===============");
		String pageNum = request.getParameter("pageNum");
		model.addAttribute("pageNum", pageNum);
		logger.info(pageNum);
		List<AnimDept> parents = animDeptService.findAll();
		model.addAttribute("parents", parents);
		// 1、通過id查找部门信息
		AnimDept animDept = animDeptService.findById(deptId);
		logger.info(animDept);
		// 2、获取上级部门信息
		String parentId = animDept.getParentId();
		AnimDept parent = animDeptService.findById(parentId);
		animDept.setParent(parent);
		// 3、获取下级部门信息
		List<AnimDept> children = animDeptService.findChildrenByParentId(deptId);
		animDept.setChildren(children);
		// 4、提交数据，返回到ui界面中
		model.addAttribute("animDept", animDept);
		return "/dept/dept_edit";
	}

	/**
	 * 更新数据，重定向到list页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/editDept")
	public String editDept(HttpServletRequest request) {
		logger.info("===================AnimDeptController editDept===============");
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String deptDesc = request.getParameter("deptDesc");
		String parentId = request.getParameter("parentId");
		// String deptCreatetime = request.getParameter("deptCreatetime");
		String pageNum = request.getParameter("pageNum");
		logger.info(pageNum);
		AnimDept animDept = animDeptService.findById(deptId);
		animDept.setDeptName(deptName);
		animDept.setDeptDesc(deptDesc);
		animDept.setDeptUpdatetime(DateFormate.formateDateToString(new Date()));
		animDept.setParentId(parentId);
		animDeptService.update(animDept);
		return "redirect:/dept/list/" + parentId + "?pageNum=" + Integer.parseInt(pageNum);
	}

	@RequestMapping("/batchAll")
	public String batchAll(HttpServletRequest request) {
		logger.info("===================AnimDeptController batchAll===============");
		String parentId = request.getParameter("parentId");
		POIUtils poiUtils = new POIUtils();
		List<AnimDept> animDepts = poiUtils.redDeptData(BatchUrl.DEPT);
		if (animDepts != null) {
			for (AnimDept animDept : animDepts) {
				AnimDept dept = animDeptService.findByName(animDept.getDeptName());
				String deptName = animDept.getParent().getDeptName();
				if ("null".equals(deptName) || deptName == null) {
					animDept.setParentId("0");
				}
				if (dept != null) {
					animDept.setDeptId(dept.getDeptId());
					animDeptService.update(animDept);
				} else {
					animDept.setDeptId(IdGeneratorUtils.generatorUUID());
					animDeptService.insert(animDept);
				}
			}
		}
		return "redirect:/dept/list/" + parentId;
	}
}
