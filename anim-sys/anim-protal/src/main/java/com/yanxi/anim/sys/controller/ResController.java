package com.yanxi.anim.sys.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.pojo.AnimRes;
import com.yanxi.anim.sys.pojo.AnimResCatagorty;
import com.yanxi.anim.sys.pojo.QueryCondition;
import com.yanxi.anim.sys.service.AnimResCatagortyService;
import com.yanxi.anim.sys.service.AnimResService;
import com.yanxi.anim.sys.service.FastdfsService;

@Controller
@RequestMapping("/res")
public class ResController {
	@Autowired
	private AnimResService animResService;
	@Autowired
	private AnimResCatagortyService animResCatagortyService;
	@Autowired
	private FastdfsService fastdfsService;
	@Value("${FDFS_URL}")
	private String fastUrl;

	private static Logger logger = Logger.getLogger(ResController.class);

	/**
	 * 展示所有的
	 * 
	 * @param request
	 * @param response
	 * @param modelAndView
	 * @param pageNum
	 * @param queryCondition
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/list")
	public ModelAndView resList(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView,
			@RequestParam(defaultValue = "1") int pageNum, QueryCondition queryCondition)
					throws UnsupportedEncodingException {
		logger.info(request.getRemoteAddr());
		// 查询分类id
		AnimResCatagorty animResCatagorty = null;
		String parentId = null;
		logger.info("resCatagortyName:" + queryCondition.getResCatagortyNameQuery() + ":" + pageNum);
		if (!StringUtils.isEmpty(queryCondition.getResCatagortyNameQuery())) {
			animResCatagorty = animResCatagortyService.findByName(queryCondition.getResCatagortyNameQuery());
			if (animResCatagorty != null) {
				parentId = animResCatagorty.getResCatagortyId();
				logger.info("parentId:" + parentId);
			}
		}
		String resName = queryCondition.getResNameQuery();
		PageInfo<AnimRes> pageInfo = animResService.findResByQueryCondition(resName, parentId, pageNum,
				queryCondition.getQueryType());
		List<AnimRes> res = new ArrayList<>();
		List<AnimRes> list = pageInfo.getList();
		if (pageInfo != null) {
			for (AnimRes as : list) {
				String resUrl = as.getResUrl();
				String resReviewUrl = as.getResReviewUrl();
				resReviewUrl = fastUrl + resReviewUrl;
				as.setResUrl(resUrl);
				as.setResReviewUrl(resReviewUrl);
				res.add(as);
			}
		}
		pageInfo.setList(res);
		// logger.info("pageInfo:" + pageInfo);
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("pageNum", pageNum);
		modelAndView.addObject("query", queryCondition);
		modelAndView.setViewName("/res");
		return modelAndView;

	}

	/**
	 * 实现本地下载：IOUtils
	 * 
	 * @param request
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/downLoad1")
	public ModelAndView downRes(HttpServletRequest request, ModelAndView modelAndView) {
		String[] url = request.getParameterValues("url");
		logger.info("file down url:" + url[0]);
		if (url != null) {
			for (String resUrl : url) {
				fastdfsService.downLoadFile(resUrl, new File("d:/load"));
			}
		}
		modelAndView.setViewName("redirect:/res/list");
		return modelAndView;
	}

	/**
	 * 下载文件，调用浏览器的下载功能
	 * 
	 * @param request
	 * @param response
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping("/downLoad")
	public ModelAndView download(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView,
			QueryCondition queryCondition) {
		String pageNum = request.getParameter("pageNum");
		String[] url = request.getParameterValues("url");
		logger.info(url == null);
		if (url != null) {
			for (String resUrl : url) {
				logger.info("start download");
				logger.info("file down url:" + resUrl);
				fastdfsService.downLoadFileForBrown(resUrl, response);
				logger.info("end download");
			}
			return null;
		}
		modelAndView.addObject("pageNum", pageNum);
		modelAndView.addObject("query", queryCondition);
		modelAndView.setViewName("redirect:/res/list");
		return modelAndView;
	}

	/**
	 * 预览大图时实现下载功能
	 * 
	 * @param request
	 * @param modelAndView
	 * @param response
	 * @return
	 */
	@RequestMapping("/download/view")
	public ModelAndView download_view(HttpServletRequest request, ModelAndView modelAndView,
			HttpServletResponse response) {
		String url = request.getParameter("resUrl");
		if (url != null) {
			fastdfsService.downLoadFileForBrown(url, response);
		}
		return null;
	}

	@RequestMapping("/test")
	public ModelAndView test(ModelAndView modelAndView) {
		modelAndView.setViewName("/test");
		return modelAndView;
	}
}
