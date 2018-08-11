package com.yanxi.anim.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.yanxi.anim.sys.mapper.AnimResCatagortyMapper;
import com.yanxi.anim.sys.pojo.AnimResCatagorty;
import com.yanxi.anim.sys.pojo.AnimResCatagortyExample;
import com.yanxi.anim.sys.pojo.AnimResCatagortyExample.Criteria;
import com.yanxi.anim.sys.service.AnimResCatagortyService;
import com.yanxi.anim.sys.utils.ListPageInfo;

@Service
public class AnimResCatagortyServiceImpl implements AnimResCatagortyService {
	@Autowired
	private AnimResCatagortyMapper animResCatagortyMapper;

	@Override
	public AnimResCatagorty findById(String id) {
		return animResCatagortyMapper.selectByPrimaryKey(id);
	}

	@Override
	public AnimResCatagorty findByIdAndName(String id, String name) {
		AnimResCatagortyExample example = new AnimResCatagortyExample();
		example.createCriteria().andResCatagortyIdEqualTo(id).andResCatagortyNameEqualTo(name);
		AnimResCatagorty animResCatagorty = animResCatagortyMapper.selectByExample(example).get(0);
		if (animResCatagorty != null) {
			return animResCatagorty;
		}
		return null;
	}

	@Override
	public List<AnimResCatagorty> findAll() {
		AnimResCatagortyExample example = new AnimResCatagortyExample();
		example.createCriteria();
		List<AnimResCatagorty> animResCatagorties = animResCatagortyMapper.selectByExample(example);
		if (animResCatagorties.size() > 0) {
			return animResCatagorties;
		}
		return null;
	}

	@Override
	public int insert(AnimResCatagorty animResCatagorty) {
		return animResCatagortyMapper.insert(animResCatagorty);
	}

	@Override
	public int update(AnimResCatagorty animResCatagorty) {
		return animResCatagortyMapper.updateByPrimaryKey(animResCatagorty);
	}

	@Override
	public int deleteById(String id) {
		return animResCatagortyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteAll() {
		AnimResCatagortyExample example = new AnimResCatagortyExample();
		example.createCriteria();
		return animResCatagortyMapper.deleteByExample(example);
	}

	@Override
	public AnimResCatagorty findByName(String resCatagortyNameQuery) {
		AnimResCatagortyExample example = new AnimResCatagortyExample();
		example.createCriteria().andResCatagortyNameEqualTo(resCatagortyNameQuery);
		List<AnimResCatagorty> list = animResCatagortyMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public PageInfo<AnimResCatagorty> findByName(String resCatagortyNameQuery, int pageNum) {
		PageHelper.startPage(pageNum, ListPageInfo.PAGE_SIZE);
		AnimResCatagortyExample example = new AnimResCatagortyExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtil.isEmpty(resCatagortyNameQuery)) {
			criteria.andResCatagortyNameEqualTo(resCatagortyNameQuery);
		}
		example.setOrderByClause("res_catagorty_createTime asc");
		List<AnimResCatagorty> list = animResCatagortyMapper.selectByExample(example);
		PageInfo<AnimResCatagorty> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<AnimResCatagorty> findAllByParentId(String parentId) {
		if (parentId != null) {
			AnimResCatagortyExample example = new AnimResCatagortyExample();
			example.createCriteria().andParentIdEqualTo(parentId);
			List<AnimResCatagorty> animResCatagorties = animResCatagortyMapper.selectByExample(example);
			return animResCatagorties;
		}
		return null;
	}

	@Override
	public List<AnimResCatagorty> findParent() {
		AnimResCatagortyExample example = new AnimResCatagortyExample();
		example.createCriteria().andParentIdIsNull();
		List<AnimResCatagorty> list = animResCatagortyMapper.selectByExample(example);
		if (list != null) {
			return list;
		}
		return null;
	}

	@Override
	public List<AnimResCatagorty> findByResCatagortyName() {
		List<AnimResCatagorty> resCatagorties = animResCatagortyMapper.findByResCatagortyName();
		if (resCatagorties != null) {
			return resCatagorties;
		}
		return null;
	}


}
