package com.yanxi.anim.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.mapper.AnimAccoutMapper;
import com.yanxi.anim.sys.pojo.AnimAccout;
import com.yanxi.anim.sys.pojo.AnimAccoutExample;
import com.yanxi.anim.sys.service.AccoutService;
import com.yanxi.anim.sys.service.base.BaseServiceImpl;
import com.yanxi.anim.sys.utils.ListPageInfo;

@Service
public class AccoutServiceImpl extends BaseServiceImpl<AnimAccout> implements AccoutService {
	@Autowired
	private AnimAccoutMapper accoutMapper;

	@Override
	public PageInfo<AnimAccout> findAllByPage(int pageNum, String username) {
		PageHelper.startPage(pageNum, ListPageInfo.ACCOUT_PAGE_SIZE);
		AnimAccoutExample example = new AnimAccoutExample();
		if (username != null) {
			example.createCriteria().andUsernameEqualTo(username);
		}
		example.setOrderByClause("username asc");
		List<AnimAccout> accouts = accoutMapper.selectByExample(example);
		if (accouts != null) {
			PageInfo<AnimAccout> pageInfo = new PageInfo<>(accouts);
			return pageInfo;
		}
		return null;
	}

	@Override
	public int insert(AnimAccout t) {
		return accoutMapper.insert(t);
	}

	@Override
	public int update(AnimAccout t) {
		return accoutMapper.updateByPrimaryKey(t);
	}

	@Override
	public AnimAccout findById(String id) {
		return accoutMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(String id) {
		return accoutMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteAll() {
		AnimAccoutExample example = new AnimAccoutExample();
		int deleteByExample = accoutMapper.deleteByExample(example);
		return deleteByExample;
	}

	@Override
	public AnimAccout findByUsernameAndPassword(AnimAccout accout) {
		AnimAccoutExample example = new AnimAccoutExample();
		example.createCriteria().andUsernameEqualTo(accout.getUsername()).andPasswordEqualTo(accout.getPassword());
		List<AnimAccout> list = accoutMapper.selectByExample(example);
		if (list != null) {
			return list.get(0);
		}
		return null;
	}

}
