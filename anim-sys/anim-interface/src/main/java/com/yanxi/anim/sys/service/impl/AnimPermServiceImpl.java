package com.yanxi.anim.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanxi.anim.sys.mapper.AnimPermMapper;
import com.yanxi.anim.sys.pojo.AnimPerm;
import com.yanxi.anim.sys.pojo.AnimPermExample;
import com.yanxi.anim.sys.service.AnimPermService;

@Service
public class AnimPermServiceImpl implements AnimPermService {
	@Autowired
	private AnimPermMapper animPermMapper;

	@Override
	public List<AnimPerm> findAll() {
		AnimPermExample example = new AnimPermExample();
		example.createCriteria();
		List<AnimPerm> animPerms = animPermMapper.selectByExample(example);
		if (animPerms.size()>0) {
			return animPerms;
		}
		return null;
	}

	@Override
	public int insert(AnimPerm animPerm) {
		return animPermMapper.insert(animPerm);
	}

	@Override
	public int update(AnimPerm animPerm) {
		return animPermMapper.updateByPrimaryKey(animPerm);
	}

	@Override
	public int deleteById(String id) {
		return animPermMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteAll() {
		return 0;
	}

	@Override
	public AnimPerm findById(String id) {
		return animPermMapper.selectByPrimaryKey(id);
	}

	@Override
	public AnimPerm findByIdAndName(String id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
