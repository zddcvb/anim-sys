package com.yanxi.anim.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.yanxi.anim.sys.mapper.AnimResMapper;
import com.yanxi.anim.sys.pojo.AnimRes;
import com.yanxi.anim.sys.pojo.AnimResExample;
import com.yanxi.anim.sys.pojo.AnimResExample.Criteria;
import com.yanxi.anim.sys.service.AnimResService;
import com.yanxi.anim.sys.utils.ListPageInfo;

@Service
public class AnimResServiceImpl implements AnimResService {
	@Autowired
	private AnimResMapper animResMapper;

	@Override
	public AnimRes findById(String id) {
		return animResMapper.selectByPrimaryKey(id);
	}

	@Override
	public AnimRes findByIdAndName(String id, String name) {
		AnimResExample example = new AnimResExample();
		example.createCriteria().andResIdEqualTo(id).andResNameEqualTo(name);
		List<AnimRes> animRess = animResMapper.selectByExample(example);
		if (animRess != null && animRess.size() >= 0) {
			return animRess.get(0);
		}
		return null;
	}

	@Override
	public List<AnimRes> findByResCatagoryId(String resCatagoryId) {
		AnimResExample example = new AnimResExample();
		example.createCriteria().andResCatagortyIdEqualTo(resCatagoryId);
		List<AnimRes> animResList = animResMapper.selectByExample(example);
		if (animResList.size() > 0) {
			return animResList;
		}
		return null;
	}

	@Override
	public List<AnimRes> findAll() {
		AnimResExample example = new AnimResExample();
		example.createCriteria();
		List<AnimRes> animResList = animResMapper.selectByExample(example);
		if (animResList.size() > 0) {
			return animResList;
		}
		return null;
	}

	@Override
	public int insert(AnimRes animRes) {
		return animResMapper.insert(animRes);
	}

	@Override
	public int update(AnimRes animRes) {
		return animResMapper.updateByPrimaryKey(animRes);
	}

	@Override
	public int deleteById(String id) {
		return animResMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteAll() {
		AnimResExample example = new AnimResExample();
		example.createCriteria();
		int index = animResMapper.deleteByExample(example);
		return index;
	}

	@Override
	public PageInfo<AnimRes> findResByResNameAndResCataId(String resNameQuery, String resCatagortyId, int pageNum) {
		PageHelper.startPage(pageNum, ListPageInfo.PAGE_SIZE);
		AnimResExample example = new AnimResExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtil.isEmpty(resNameQuery)) {
			criteria.andResNameEqualTo(resNameQuery);
		}
		if (!StringUtil.isEmpty(resCatagortyId)) {
			criteria.andResCatagortyIdEqualTo(resCatagortyId);
		}
		example.setOrderByClause("res_catagorty_id asc");
		List<AnimRes> list = animResMapper.selectByExample(example);
		PageInfo<AnimRes> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public AnimRes findByName(String resName) {
		AnimResExample example = new AnimResExample();
		example.createCriteria().andResNameEqualTo(resName);
		List<AnimRes> list = animResMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public PageInfo<AnimRes> findResByQueryCondition(String resNameQuery, String parentId, int pageNum,
			Integer queryType) {
		PageHelper.startPage(pageNum, ListPageInfo.PAGE_SIZE_VIEW);
		AnimResExample example = new AnimResExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtil.isEmpty(resNameQuery)) {
			if (queryType == 0) {
				criteria.andResNameEqualTo(resNameQuery);
			} else if (queryType == 1) {
				criteria.andResNameLike("%" + resNameQuery + "%");
			}
		}
		if (!StringUtil.isEmpty(parentId)) {
			criteria.andResCatagortyIdEqualTo(parentId);
		} else {
			criteria.andResCatagortyIdIsNotNull();
		}
		example.setOrderByClause("res_name asc");
		List<AnimRes> list = animResMapper.selectByExample(example);
		PageInfo<AnimRes> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public void updateByName(AnimRes animRes, String resCatagortyId) {

		AnimResExample example = new AnimResExample();
		example.createCriteria().andResNameEqualTo(animRes.getResName()).andResCatagortyIdEqualTo(resCatagortyId);
		List<AnimRes> list = animResMapper.selectByExample(example);
		System.out.println(list);
		if (list != null && list.size() > 0) {
			AnimRes res = list.get(0);
			res.setResViewUrl(animRes.getResViewUrl());
			animResMapper.updateByPrimaryKey(res);
		}
	}

}
