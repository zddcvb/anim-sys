package com.yanxi.anim.sys.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.yanxi.anim.sys.mapper.AnimRoleMapper;
import com.yanxi.anim.sys.pojo.AnimRole;
import com.yanxi.anim.sys.pojo.AnimRoleExample;
import com.yanxi.anim.sys.pojo.AnimRoleExample.Criteria;
import com.yanxi.anim.sys.service.AnimRoleService;
import com.yanxi.anim.sys.utils.ListPageInfo;

/**
 * animRoleService的服务实现接口
 * 
 * @author 邹丹丹
 *
 */
@Service
public class AnimRoleServiceImpl implements AnimRoleService {
	/**
	 * 自动注入roleMapper
	 */
	@Autowired
	private AnimRoleMapper roleMapper;

	/**
	 * 根据roleid查询animrole
	 */
	@Override
	public AnimRole findById(String roleId) {
		AnimRole animRole = roleMapper.selectByPrimaryKey(roleId);
		if (animRole == null) {
			return null;
		}
		return animRole;
	}

	/**
	 * 根据roleid和rolename查询animrole
	 */
	@Override
	public AnimRole findByIdAndName(String roleId, String roleName) {
		AnimRoleExample example = new AnimRoleExample();
		example.createCriteria().andRoleIdEqualTo(roleId).andRoleNameEqualTo(roleName);
		List<AnimRole> animRoles = roleMapper.selectByExample(example);
		if (animRoles.size() > 1) {
			return animRoles.get(0);
		}
		return null;
	}

	/**
	 * 查询所有的animrole
	 */
	@Override
	public List<AnimRole> findAll() {
		AnimRoleExample example = new AnimRoleExample();
		example.createCriteria();
		List<AnimRole> animRoles = roleMapper.selectByExample(example);
		if (!animRoles.isEmpty() && animRoles.size() > 1) {
			return animRoles;
		}
		return null;
	}

	/**
	 * 插入新的animrole
	 */
	@Override
	public int insert(AnimRole animRole) {
		int index = roleMapper.insert(animRole);
		if (index != 0) {
			return index;
		}
		return 0;
	}

	/**
	 * 更新animrole
	 */
	@Override
	public int update(AnimRole animRole) {
		int index = roleMapper.updateByPrimaryKey(animRole);
		return index;
	}

	/**
	 * 根据roleid删除animrole
	 */
	@Override
	public int deleteById(String roleId) {
		int index = roleMapper.deleteByPrimaryKey(roleId);
		if (index != 0) {
			return index;
		}
		return 0;
	}

	/**
	 * 删除所有的animrole
	 */
	@Override
	public int deleteAll() {
		AnimRoleExample example = new AnimRoleExample();
		example.createCriteria();
		int index = roleMapper.deleteByExample(example);
		return index;
	}

	/**
	 * 根据部门id查询岗位信息
	 */
	@Override
	public List<AnimRole> findAllByDeptId(String deptId) {
		AnimRoleExample example = new AnimRoleExample();
		example.createCriteria().andDeptIdEqualTo(deptId);
		List<AnimRole> animRoles = roleMapper.selectByExample(example);
		if (animRoles.size() > 0) {
			return animRoles;
		}
		return null;
	}

	@Override
	public PageInfo<AnimRole> findAll(int pageNum) {

		PageHelper.startPage(pageNum, ListPageInfo.PAGE_SIZE);
		AnimRoleExample example = new AnimRoleExample();
		example.createCriteria();
		example.setOrderByClause("role_createTime asc,dept_id asc");
		List<AnimRole> animRoles = roleMapper.selectByExample(example);
		if (animRoles == null) {
			return null;
		}
		PageInfo<AnimRole> pageInfo = new PageInfo<>(animRoles);
		return pageInfo;
	}

	@Override
	public PageInfo<AnimRole> findRolesByRoleNameAndDeptId(String roleNameQuery, String deptId, int pageNum) {
		PageHelper.startPage(pageNum, ListPageInfo.PAGE_SIZE);
		AnimRoleExample example = new AnimRoleExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtil.isEmpty(roleNameQuery)) {
			criteria.andRoleNameEqualTo(roleNameQuery);
		}
		if (deptId != null) {
			criteria.andDeptIdEqualTo(deptId);
		}
		example.setOrderByClause("role_createTime asc,dept_id asc");
		List<AnimRole> list = roleMapper.selectByExample(example);
		if (list == null) {
			return null;
		}
		PageInfo<AnimRole> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public AnimRole findByName(String roleNameQuery) {
		AnimRoleExample example = new AnimRoleExample();
		example.createCriteria().andRoleNameEqualTo(roleNameQuery);
		List<AnimRole> list = roleMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void insertBatch(List<AnimRole> animRoles) {
		if (animRoles != null) {
			for (AnimRole animRole : animRoles) {
				roleMapper.insert(animRole);
			}
		}
	}

}
