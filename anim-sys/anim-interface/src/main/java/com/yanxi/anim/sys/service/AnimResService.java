package com.yanxi.anim.sys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.pojo.AnimRes;
import com.yanxi.anim.sys.service.base.BaseService;

public interface AnimResService extends BaseService<AnimRes> {
	/**
	 * 根据资源分类的id查找所有的素材
	 * @param resCatagoryId
	 * @return
	 */
	public List<AnimRes> findByResCatagoryId(String resCatagoryId);

	public PageInfo<AnimRes> findResByResNameAndResCataId(String resNameQuery, String resCatagortyId, int pageNum);

	public AnimRes findByName(String resName);

	public PageInfo<AnimRes> findResByQueryCondition(String resNameQuery, String parentId, int pageNum,
			Integer queryType);

	public void updateByName(AnimRes animRes,String resCatagortyId);


}
