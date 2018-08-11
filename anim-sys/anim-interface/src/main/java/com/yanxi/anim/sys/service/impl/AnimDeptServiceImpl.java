package com.yanxi.anim.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.mapper.AnimDeptMapper;
import com.yanxi.anim.sys.pojo.AnimDept;
import com.yanxi.anim.sys.pojo.AnimDeptExample;
import com.yanxi.anim.sys.service.AnimDeptService;
import com.yanxi.anim.sys.utils.ListPageInfo;

@Service
public class AnimDeptServiceImpl implements AnimDeptService {
	@Autowired
	private AnimDeptMapper animDeptMapper;

	@Override
	public AnimDept findById(String deptId) {
		if (deptId == null) {
			return null;
		}
		AnimDept animDept = animDeptMapper.selectByPrimaryKey(deptId);
		return animDept;
	}

	@Override
	public AnimDept findByName(String deptName) {
		AnimDeptExample example = new AnimDeptExample();
		example.createCriteria().andDeptNameEqualTo(deptName);
		List<AnimDept> selectByExample = animDeptMapper.selectByExample(example);
		if (selectByExample.size() < 1) {
			return null;
		}
		return selectByExample.get(0);
	}

	@Override
	public List<AnimDept> findAll() {
		AnimDeptExample example = new AnimDeptExample();
		example.createCriteria();
		List<AnimDept> list = animDeptMapper.selectByExample(example);
		if (list.size() < 1) {
			return null;
		}
		return list;
	}

	@Override
	public int insert(AnimDept animDept) {
		int insert = animDeptMapper.insert(animDept);
		return insert;
	}

	@Override
	public int update(AnimDept animDept) {
		int key = animDeptMapper.updateByPrimaryKey(animDept);
		return key;
	}

	@Override
	public int deleteById(String deptId) {
		int key = animDeptMapper.deleteByPrimaryKey(deptId);
		return key;
	}

	@Override
	public int deleteAll() {
		AnimDeptExample example = new AnimDeptExample();
		example.createCriteria();
		int key = animDeptMapper.deleteByExample(example);
		return key;
	}

	@Override
	public AnimDept findByIdAndName(String deptId, String deptName) {
		AnimDeptExample example = new AnimDeptExample();
		example.createCriteria().andDeptIdEqualTo(deptId).andDeptNameEqualTo(deptName);
		List<AnimDept> list = animDeptMapper.selectByExample(example);
		if (list.size() < 1) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<AnimDept> findAllDeptByDeleted(boolean isdeleted) {
		AnimDeptExample example = new AnimDeptExample();
		example.createCriteria().andIsdeletedEqualTo(isdeleted);
		List<AnimDept> animDepts = animDeptMapper.selectByExample(example);
		if (animDepts.size() > 0) {
			return animDepts;
		}
		return null;
	}

	@Override
	public List<AnimDept> findChildrenByParentId(String deptId) {
		AnimDeptExample example = new AnimDeptExample();
		example.createCriteria().andParentIdEqualTo(deptId);
		List<AnimDept> animDepts = animDeptMapper.selectByExample(example);
		if (animDepts.size() > 0) {
			return animDepts;
		}
		return null;
	}

	@Override
	public List<AnimDept> findParentDept(String parentId) {
		AnimDeptExample example = new AnimDeptExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<AnimDept> parent = animDeptMapper.selectByExample(example);
		return parent;
	}

	@Override
	public PageInfo<AnimDept> findParentDept(String parentId, int pageNum) {
		PageHelper.startPage(pageNum, ListPageInfo.PAGE_SIZE);
		AnimDeptExample example = new AnimDeptExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<AnimDept> parent = animDeptMapper.selectByExample(example);
		PageInfo<AnimDept> pageInfo = new PageInfo<>(parent);
		return pageInfo;
	}

	@Override
	public PageInfo<AnimDept> findChildrenByParentId(String deptId, int pageNum) {
		PageHelper.startPage(pageNum, ListPageInfo.PAGE_SIZE);
		AnimDeptExample example = new AnimDeptExample();
		example.createCriteria().andParentIdEqualTo(deptId);
		List<AnimDept> animDepts = animDeptMapper.selectByExample(example);
		PageInfo<AnimDept> pageInfo = new PageInfo<>(animDepts);
		return pageInfo;
	}

	@Override
	public int deleteChildren(String parentId) {
		AnimDeptExample example = new AnimDeptExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		int index = animDeptMapper.deleteByExample(example);
		return index;
	}

}
