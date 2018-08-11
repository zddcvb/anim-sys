package com.yanxi.anim.sys.service.impl;

import java.util.List;

import javax.sound.sampled.LineListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.yanxi.anim.sys.mapper.AnimEmployeeMapper;
import com.yanxi.anim.sys.pojo.AnimEmployee;
import com.yanxi.anim.sys.pojo.AnimEmployeeExample;
import com.yanxi.anim.sys.pojo.AnimEmployeeExample.Criteria;
import com.yanxi.anim.sys.service.AnimEmployeeService;
import com.yanxi.anim.sys.utils.ListPageInfo;

@Service
public class AnimEmployeeServiceImpl implements AnimEmployeeService {
	@Autowired
	private AnimEmployeeMapper animEmployeeMapper;

	@Override
	public AnimEmployee findById(String animEmployeeId) {
		AnimEmployee animEmployee = animEmployeeMapper.selectByPrimaryKey(animEmployeeId);
		if (animEmployee != null) {
			return animEmployee;
		}
		return null;
	}

	@Override
	public AnimEmployee findByIdAndName(String animEmployeeId, String animEmployeeName) {
		AnimEmployeeExample example = new AnimEmployeeExample();
		example.createCriteria().andEmployeeIdEqualTo(animEmployeeId).andEmployeeNameEqualTo(animEmployeeName);
		List<AnimEmployee> animEmployees = animEmployeeMapper.selectByExample(example);
		if (animEmployees.size() > 0) {
			return animEmployees.get(0);
		}
		return null;
	}

	@Override
	public List<AnimEmployee> findAll() {
		AnimEmployeeExample example = new AnimEmployeeExample();
		example.createCriteria();
		List<AnimEmployee> animEmployees = animEmployeeMapper.selectByExample(example);
		if (animEmployees.size() > 0) {
			return animEmployees;
		}
		return null;
	}

	@Override
	public int insert(AnimEmployee animEmployee) {
		int index = animEmployeeMapper.insert(animEmployee);
		return index;
	}

	@Override
	public int update(AnimEmployee animEmployee) {
		return animEmployeeMapper.updateByPrimaryKey(animEmployee);
	}

	@Override
	public int deleteById(String employeeId) {
		return animEmployeeMapper.deleteByPrimaryKey(employeeId);
	}

	@Override
	public int deleteAll() {
		AnimEmployeeExample example = new AnimEmployeeExample();
		example.createCriteria();
		int index = animEmployeeMapper.deleteByExample(example);
		return index;
	}

	@Override
	public PageInfo<AnimEmployee> findEmployeesByQueryCondition(String employeeNameQuery, String roleId, String deptId,
			int pageNum) {
		PageHelper.startPage(pageNum, ListPageInfo.PAGE_SIZE);
		AnimEmployeeExample example = new AnimEmployeeExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtil.isEmpty(employeeNameQuery)) {
			criteria.andEmployeeNameEqualTo(employeeNameQuery);
		}
		if (!StringUtil.isEmpty(roleId)) {
			criteria.andRoleIdEqualTo(roleId);
		}
		if (!StringUtil.isEmpty(deptId)) {
			criteria.andDeptIdEqualTo(deptId);
		}
		example.setOrderByClause("employee_worked_time asc");
		List<AnimEmployee> list = animEmployeeMapper.selectByExample(example);
		PageInfo<AnimEmployee> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public void insertBatch(List<AnimEmployee> animEmployees) {
		if (animEmployees != null) {
			for (AnimEmployee animEmployee : animEmployees) {
				insert(animEmployee);
			}
		}
	}

	@Override
	public AnimEmployee findByCard(String content) {
		AnimEmployeeExample example = new AnimEmployeeExample();
		example.createCriteria().andEmployeeCardnumEqualTo(content);
		List<AnimEmployee> list = animEmployeeMapper.selectByExample(example);
		if (list != null && list.size() >= 1) {
			return list.get(0);
		}
		return null;
	}

}
