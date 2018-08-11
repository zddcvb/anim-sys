package com.yanxi.anim.sys.service.base;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Override
	public T findById(String id) {
		return null;
	}

	@Override
	public T findByIdAndName(String id, String name) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public int insert(T t) {
		return 0;
	}

	@Override
	public int update(T t) {
		return 0;
	}

	@Override
	public int deleteById(String id) {
		return 0;
	}

	@Override
	public int deleteAll() {
		return 0;
	}

}
