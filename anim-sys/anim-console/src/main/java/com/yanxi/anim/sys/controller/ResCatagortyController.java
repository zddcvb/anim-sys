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
import com.yanxi.anim.sys.pojo.AnimResCatagorty;
import com.yanxi.anim.sys.service.AnimResCatagortyService;
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
@RequestMapping("/res_catagorty")
public class ResCatagortyController {
	@Autowired
	private AnimResCatagortyService animResCatagortyService;
	private static Logger logger = Logger.getLogger(ResCatagortyController.class);

	@RequestMapping("/save")
	public String save(Model model, HttpServletRequest request) {
		logger.info("========================ResCatagortyController save===================");
		String pageNum = request.getParameter("pageNum");
		String resCatagortyNameQuery = request.getParameter("resCatagortyNameQuery");
		model.addAttribute("resCatagortyNameQuery", resCatagortyNameQuery);
		model.addAttribute("pageNum", pageNum);
		List<AnimResCatagorty> animResCatagorties = animResCatagortyService.findAll();
		if (animResCatagorties != null) {
			model.addAttribute("resCatagortyList", animResCatagorties);
		}
		return "/res_catagorty/res_catagorty_save";
	}

	@RequestMapping("/save_res_catagorty")
	public String save_res_catagorty(HttpServletRequest request) {
		logger.info("========================ResCatagortyController saveres_catagorty===================");
		String resCatagortyName = request.getParameter("resCatagortyName");
		String resCatagortyCreatetime = request.getParameter("resCatagortyCreatetime");
		String parentId = request.getParameter("parentId");
		String pageNum = request.getParameter("pageNum");
		String resCatagortyNameQuery = request.getParameter("resCatagortyNameQuery");
		AnimResCatagorty animResCatagorty = new AnimResCatagorty();
		animResCatagorty.setResCatagortyId(IdGeneratorUtils.generatorUUID());
		animResCatagorty.setResCatagortyName(resCatagortyName);
		animResCatagorty.setResCatagortyCreatetime(resCatagortyCreatetime);
		animResCatagorty.setResCatagortyUpdatetime(resCatagortyCreatetime);
		animResCatagorty.setIsdeleted(false);
		animResCatagorty.setParentId(parentId);
		animResCatagortyService.insert(animResCatagorty);
		return "redirect:/res_catagorty/list?pageNum=" + Integer.parseInt(pageNum) + "&resCatagortyNameQuery="
				+ resCatagortyNameQuery;
	}

	@RequestMapping("/edit/{resCatagortyId}")
	public String edit(Model model, @PathVariable String resCatagortyId, HttpServletRequest request) {
		logger.info("========================ResCatagortyController edit===================");
		String pageNum = request.getParameter("pageNum");
		model.addAttribute("pageNum", pageNum);
		AnimResCatagorty animResCatagorty = animResCatagortyService.findById(resCatagortyId);
		if (animResCatagorty != null) {
			List<AnimResCatagorty> parents = animResCatagortyService.findAll();
			AnimResCatagorty parent = animResCatagortyService.findById(animResCatagorty.getParentId());
			animResCatagorty.setParent(parent);
			model.addAttribute("animResCatagorty", animResCatagorty);
			model.addAttribute("parents", parents);
		}
		return "/res_catagorty/res_catagorty_edit";
	}

	@RequestMapping("/edit_res_catagorty")
	public String editres_catagorty(HttpServletRequest request) {
		logger.info("========================ResCatagortyController editres_catagorty===================");
		String resCatagortyId = request.getParameter("resCatagortyId");
		String resCatagortyName = request.getParameter("resCatagortyName");
		String parentId = request.getParameter("parentId");
		String pageNum = request.getParameter("pageNum");
		String resCatagortyNameQuery = request.getParameter("resCatagortyNameQuery");
		AnimResCatagorty animResCatagorty = animResCatagortyService.findById(resCatagortyId);
		animResCatagorty.setResCatagortyName(resCatagortyName);
		animResCatagorty.setResCatagortyUpdatetime(DateFormate.formateDateToString(new Date()));
		animResCatagorty.setParentId(parentId);
		animResCatagortyService.update(animResCatagorty);
		return "redirect:/res_catagorty/list?pageNum=" + Integer.parseInt(pageNum) + "&resCatagortyNameQuery="
				+ resCatagortyNameQuery;
	}

	@RequestMapping("/delete/{resCatagortyId}")
	public String deleteById(@PathVariable String resCatagortyId, HttpServletRequest request) {
		logger.info("========================ResCatagortyController deleteById===================");
		String pageNum = request.getParameter("pageNum");
		animResCatagortyService.deleteById(resCatagortyId);
		return "redirect:/res_catagorty/list?pageNum=" + Integer.parseInt(pageNum);
	}

	@RequestMapping("/update/{res_catagortyId}")
	public String udapteById(@PathVariable String res_catagortyId, HttpServletRequest request) {
		logger.info("========================ResCatagortyController udapteById===================");
		String pageNum = request.getParameter("pageNum");
		String resCatagortyNameQuery = request.getParameter("resCatagortyNameQuery");
		AnimResCatagorty animResCatagorty = animResCatagortyService.findById(res_catagortyId);
		Boolean isdeleted = animResCatagorty.getIsdeleted();
		logger.info("isdeleted:" + isdeleted);
		if (isdeleted) {
			animResCatagorty.setIsdeleted(false);
		} else {
			animResCatagorty.setIsdeleted(true);
		}

		animResCatagortyService.update(animResCatagorty);
		return "redirect:/res_catagorty/list?pageNum=" + Integer.parseInt(pageNum) + "&resCatagortyNameQuery="
				+ resCatagortyNameQuery;
	}

	@RequestMapping("/list")
	public String queryForCondition(HttpServletRequest request, @RequestParam(defaultValue = "0") int pageNum,
			Model model) {
		logger.info("========================ResCatagortyController queryForCondition===================");
		String resCatagortyNameQuery = request.getParameter("resCatagortyNameQuery");
		logger.info(resCatagortyNameQuery);
		PageInfo<AnimResCatagorty> pageInfo = animResCatagortyService.findByName(resCatagortyNameQuery, pageNum);
		List<AnimResCatagorty> animResCatagorties = new ArrayList<>();
		for (AnimResCatagorty animResCatagorty : pageInfo.getList()) {
			AnimResCatagorty parent = animResCatagortyService.findById(animResCatagorty.getParentId());
			animResCatagorty.setParent(parent);
			animResCatagorties.add(animResCatagorty);
		}
		pageInfo.setList(animResCatagorties);
		logger.info(pageInfo);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("resCatagortyNameQuery", resCatagortyNameQuery);
		return "/res_catagorty/res_catagorty_list";
	}

	@RequestMapping("/view/{resCatagortyId}")
	public String view(HttpServletRequest request, @PathVariable String resCatagortyId, Model model) {
		logger.info("========================ResCatagortyController view===================");
		String pageNum = request.getParameter("pageNum");
		String resCatagortyNameQuery = request.getParameter("resCatagortyNameQuery");
		model.addAttribute("resCatagortyNameQuery", resCatagortyNameQuery);
		model.addAttribute("pageNum", pageNum);
		AnimResCatagorty animResCatagorty = animResCatagortyService.findById(resCatagortyId);
		AnimResCatagorty resCatagorty = animResCatagortyService.findById(animResCatagorty.getParentId());
		animResCatagorty.setParent(resCatagorty);
		model.addAttribute("animResCatagorty", animResCatagorty);
		return "/res_catagorty/res_catagorty_view";
	}

	@RequestMapping("/view/back")
	public String back(HttpServletRequest request) {
		logger.info("========================ResCatagortyController back===================");
		String pageNum = request.getParameter("pageNum");
		String resCatagortyNameQuery = request.getParameter("resCatagortyNameQuery");
		logger.info(pageNum + ":" + resCatagortyNameQuery);
		return "redirect:/res_catagorty/list?pageNum=" + Integer.parseInt(pageNum) + "&resCatagortyNameQuery="
				+ resCatagortyNameQuery;
	}

	@RequestMapping("/batchAll")
	public String batchAll() {
		logger.info("========================ResCatagortyController batchAll===================");
		POIUtils poiUtils = new POIUtils();
		List<AnimResCatagorty> animResCatagorties = poiUtils.redResCatagortyData(BatchUrl.RES_CATA);
		logger.info("rescata:" + animResCatagorties);
		if (animResCatagorties != null) {
			for (AnimResCatagorty animResCatagorty : animResCatagorties) {
				AnimResCatagorty resCatagorty = animResCatagortyService
						.findByName(animResCatagorty.getResCatagortyName());
				AnimResCatagorty parent = animResCatagortyService
						.findByName(animResCatagorty.getParent().getResCatagortyName());
				if (parent != null) {
					animResCatagorty.setParentId(parent.getResCatagortyId());
				}
				if (resCatagorty != null) {
					animResCatagorty.setResCatagortyId(resCatagorty.getResCatagortyId());
					animResCatagortyService.update(animResCatagorty);
				} else {
					animResCatagorty.setResCatagortyId(IdGeneratorUtils.generatorUUID());
					animResCatagortyService.insert(animResCatagorty);
				}
			}
		}
		return "redirect:/res_catagorty/list";
	}
}
