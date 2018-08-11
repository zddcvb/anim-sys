package com.yanxi.anim.sys.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.solr.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.constant.BatchUrl;
import com.yanxi.anim.sys.pojo.AnimRes;
import com.yanxi.anim.sys.pojo.AnimResCatagorty;
import com.yanxi.anim.sys.pojo.QueryCondition;
import com.yanxi.anim.sys.service.AnimResCatagortyService;
import com.yanxi.anim.sys.service.AnimResService;
import com.yanxi.anim.sys.service.FastdfsService;
import com.yanxi.anim.sys.utils.CommonUtil;
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
@RequestMapping("/res")
public class ResController {
	@Autowired
	private AnimResService animResService;
	@Autowired
	private AnimResCatagortyService animResCatagortyService;

	@Autowired
	private FastdfsService fastdfsService;

	private static Logger logger = Logger.getLogger(ResController.class);

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/save")
	public String save(Model model, HttpServletRequest request, QueryCondition queryCondition) {
		logger.info("=========ResController save===========");
		String pageNum = request.getParameter("pageNum");
		model.addAttribute("query", queryCondition);
		model.addAttribute("pageNum", pageNum);
		List<AnimResCatagorty> animResCatagorties = animResCatagortyService.findAll();
		if (animResCatagorties != null) {
			model.addAttribute("resCatagorties", animResCatagorties);
		}
		return "/res/res_save";
	}

	/**
	 * 提交表单数据，保存数据到数据库中
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/save_res")
	public String saveRes(HttpServletRequest request, QueryCondition queryCondition) {
		logger.info("=========ResController saveRes===========");
		AnimRes animRes = new AnimRes();
		String resName = request.getParameter("resName");
		String resCatagortyId = request.getParameter("resCatagortyId");
		String pageNum = request.getParameter("pageNum");

		// 获取下载文件信息,上传文件，并保存上传的地址
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		boolean multipart = commonsMultipartResolver.isMultipart(request);
		logger.info("multipart:" + multipart);
		if (multipart) {
			MultipartRequest multipartRequest = (MultipartRequest) request;
			Iterator<String> fileNames = multipartRequest.getFileNames();
			while (fileNames.hasNext()) {
				MultipartFile file = multipartRequest.getFile(fileNames.next());
				String uploadFile = fastdfsService.uploadFile(file);
				logger.info("uploadFile:" + uploadFile);
				if (file.getOriginalFilename().endsWith(".jpg")) {
					animRes.setResReviewUrl(uploadFile);
				} else if (file.getOriginalFilename().endsWith(".fla")) {
					// 获取上传fla文件的大小
					long resSize = fastdfsService.getSizeByFileId(uploadFile);
					animRes.setResSize(CommonUtil.getDataSize(resSize));
					animRes.setResUrl(uploadFile);
				}
			}
		}
		animRes.setResId(IdGeneratorUtils.generatorUUID());
		animRes.setResName(resName);
		animRes.setResCatagortyId(resCatagortyId);
		// 设置创建和更新日期
		String date = DateFormate.formateDateToString(new Date());
		animRes.setResCreatetime(date);
		animRes.setResUpdatetime(date);
		animRes.setIsdeleted(false);

		animResService.insert(animRes);
		return "redirect:/res/list?pageNum=" + Integer.parseInt(pageNum) + "&resNameQuery="
				+ queryCondition.getResNameQuery() + "&resCatagortyNameQuery="
				+ queryCondition.getResCatagortyNameQuery();
	}

	@RequestMapping("/edit/{resId}")
	public String edit(Model model, @PathVariable String resId, HttpServletRequest request) {
		logger.info("=========ResController edit===========");
		String pageNum = request.getParameter("pageNum");
		model.addAttribute("pageNum", pageNum);
		AnimRes animRes = animResService.findById(resId);
		if (animRes != null) {
			List<AnimResCatagorty> resCatagorties = animResCatagortyService.findAll();
			AnimResCatagorty animResCatagorty = animResCatagortyService.findById(animRes.getResCatagortyId());
			animRes.setAnimResCatagorty(animResCatagorty);
			model.addAttribute("animRes", animRes);
			model.addAttribute("resCatagorties", resCatagorties);
		}
		return "/res/res_edit";
	}

	@RequestMapping("/edit_res")
	public String editRole(HttpServletRequest request, QueryCondition queryCondition, AnimRes res) {
		logger.info("=========ResController editRole===========");
		String pageNum = request.getParameter("pageNum");
		AnimRes animRes = animResService.findById(res.getResId());
		animRes.setResName(res.getResName());
		animRes.setResCatagortyId(res.getResCatagortyId());
		animRes.setResUpdatetime(DateFormate.formateDateToString(new Date()));
		animResService.update(animRes);
		return "redirect:/res/list?pageNum=" + Integer.parseInt(pageNum) + "&resNameQuery="
				+ queryCondition.getResNameQuery() + "&resCatagortyNameQuery="
				+ queryCondition.getResCatagortyNameQuery();
	}

	/**
	 * 刪除素材，并同步將服务器中的数据也一起删除
	 * 
	 * @param resId
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete/{resId}")
	public String deleteById(@PathVariable String resId, HttpServletRequest request) {
		logger.info("=========ResController deleteById===========");
		String pageNum = request.getParameter("pageNum");
		// 获取资源的预览图和下载地址,并删除
		AnimRes animRes = animResService.findById(resId);
		if (animRes != null) {
			String resUrl = animRes.getResUrl();
			String resReviewUrl = animRes.getResReviewUrl();
			if (resUrl != null || resReviewUrl != null) {
				fastdfsService.deleteById(animRes.getResReviewUrl());
				fastdfsService.deleteById(animRes.getResUrl());
			}
			// 删除资源
			animResService.deleteById(resId);
		}

		return "redirect:/res/list?pageNum=" + Integer.parseInt(pageNum);
	}

	@RequestMapping("/deleteAll")
	public String deleteAll() {
		animResService.deleteAll();
		return "redirect:/res/list?pageNum=1";
	}

	@RequestMapping("/update/{resId}")
	public String udapteById(@PathVariable String resId, HttpServletRequest request, QueryCondition queryCondition) {
		logger.info("=========ResController  udapteById===========");
		String pageNum = request.getParameter("pageNum");
		AnimRes animRes = animResService.findById(resId);
		Boolean isdeleted = animRes.getIsdeleted();
		logger.info("isdeleted:" + isdeleted);
		if (isdeleted) {
			animRes.setIsdeleted(false);
		} else {
			animRes.setIsdeleted(true);
		}
		animRes.setResUpdatetime(DateFormate.formateDateToString(new Date()));
		animResService.update(animRes);
		return "redirect:/res/list?pageNum=" + Integer.parseInt(pageNum) + "&resNameQuery="
				+ queryCondition.getResNameQuery() + "&resCatagortyNameQuery="
				+ queryCondition.getResCatagortyNameQuery();
	}

	/**
	 * 显示所有的数据
	 * 
	 * @param queryCondition
	 * @param request
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String queryForCondition(QueryCondition queryCondition, HttpServletRequest request,
			@RequestParam(defaultValue = "1") int pageNum, Model model) {
		logger.info(queryCondition + ":" + queryCondition);
		// 查询部门id
		AnimResCatagorty animResCatagorty = null;
		String parentId = null;
		if (!StringUtils.isEmpty(queryCondition.getResCatagortyNameQuery())) {
			animResCatagorty = animResCatagortyService.findByName(queryCondition.getResCatagortyNameQuery());
			parentId = animResCatagorty.getResCatagortyId();
			logger.info("parentId:" + parentId);
		}
		PageInfo<AnimRes> pageInfo = animResService.findResByResNameAndResCataId(queryCondition.getResNameQuery(),
				parentId, pageNum);
		List<AnimRes> animRess = new ArrayList<>();
		for (AnimRes animRes : pageInfo.getList()) {
			AnimResCatagorty parent = animResCatagortyService.findById(animRes.getResCatagortyId());
			logger.info("parent:" + parent);
			animRes.setAnimResCatagorty(parent);
			animRess.add(animRes);
		}
		pageInfo.setList(animRess);
		logger.info("pageInfo:" + pageInfo);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("query", queryCondition);
		return "/res/res_list";
	}

	@RequestMapping("/view/{resId}")
	public String view(HttpServletRequest request, @PathVariable String resId, Model model) {
		logger.info("=========ResController view===========");
		String pageNum = request.getParameter("pageNum");
		String resNameQuery = request.getParameter("resNameQuery");
		String resCatagortyNameQuery = request.getParameter("resCatagortyNameQuery");
		model.addAttribute("resNameQuery", resNameQuery);
		model.addAttribute("resCatagortyNameQuery", resCatagortyNameQuery);
		model.addAttribute("pageNum", pageNum);
		AnimRes animRes = animResService.findById(resId);
		AnimResCatagorty animResCatagorty = animResCatagortyService.findById(animRes.getResCatagortyId());
		animRes.setAnimResCatagorty(animResCatagorty);
		model.addAttribute("animRes", animRes);
		return "/res/res_view";
	}

	@RequestMapping("/view/back")
	public String back(HttpServletRequest request) {
		logger.info("=========ResController back===========");
		String pageNum = request.getParameter("pageNum");
		String resNameQuery = request.getParameter("resNameQuery");
		String resCatagortyNameQuery = request.getParameter("resCatagortyNameQuery");
		logger.info(pageNum + ":" + resNameQuery + ":" + resCatagortyNameQuery);
		return "redirect:/res/list?pageNum=" + Integer.parseInt(pageNum) + "&resNameQuery=" + resNameQuery
				+ "&resCatagortyNameQuery=" + resCatagortyNameQuery;
	}

	/**
	 * 批量更新素材，通过xls形式，固定的文件夹是：d:/xls
	 * 
	 * @return
	 */
	@RequestMapping("/batch/xls")
	public String batchAll() {
		logger.info("=========ResController  batchAll===========");
		POIUtils poiUtils = new POIUtils();
		List<AnimRes> animRess = poiUtils.redResData(BatchUrl.RES);
		if (animRess != null) {
			for (AnimRes animRes : animRess) {
				AnimResCatagorty resCatagorty = animResCatagortyService
						.findByName(animRes.getAnimResCatagorty().getResCatagortyName());
				if (resCatagorty != null) {
					animRes.setResCatagortyId(resCatagorty.getResCatagortyId());
				}
				AnimRes res = animResService.findByName(animRes.getResName());
				if (res != null) {
					animRes.setResId(res.getResId());
					animResService.update(animRes);
				} else {
					animRes.setResId(IdGeneratorUtils.generatorUUID());
					animResService.insert(animRes);
				}
			}
		}
		return "redirect:/res/list";
	}

	/**
	 * 批量更新素材，通过文件夹形式，固定的文件夹是：d:/res
	 * 
	 * @return
	 */
	@RequestMapping("/batch/file")
	public String uploadFile() {
		logger.info("=========ResController uploadFile===========");
		fastdfsService.clearCache();
		List<AnimRes> res = fastdfsService.uploadFile(new File(BatchUrl.RES_FILE));
		logger.info("res:" + res);
		for (AnimRes animRes : res) {
			animResService.insert(animRes);
		}
		return "redirect:/res/list";
	}
	@RequestMapping("/batch/file/view")
	public ModelAndView updateViewImg(ModelAndView modelAndView){
		logger.info("=========ResController uploadFile===========");
		fastdfsService.updateBatch(new File(BatchUrl.RES_FILE));
		logger.info("=========ResController updateViewImg success===========");
		modelAndView.setViewName("redirect:/res/list");
		return modelAndView;
		
	}
}
