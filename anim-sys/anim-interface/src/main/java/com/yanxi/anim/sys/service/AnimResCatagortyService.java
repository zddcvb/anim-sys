package com.yanxi.anim.sys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.pojo.AnimResCatagorty;
import com.yanxi.anim.sys.service.base.BaseService;

public interface AnimResCatagortyService extends BaseService<AnimResCatagorty>{

	AnimResCatagorty findByName(String resCatagortyNameQuery);

	PageInfo<AnimResCatagorty> findByName(String resCatagortyNameQuery, int pageNum);

	List<AnimResCatagorty> findAllByParentId(String parentId);

	List<AnimResCatagorty> findParent();

	List<AnimResCatagorty> findByResCatagortyName();

}
