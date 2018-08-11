package com.yanxi.anim.sys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.pojo.AnimEmployee;
import com.yanxi.anim.sys.service.base.BaseService;

public interface AnimEmployeeService extends BaseService<AnimEmployee>{

	PageInfo<AnimEmployee> findEmployeesByQueryCondition(String employeeNameQuery, String roleId, String deptId,
			int pageNum);

	void insertBatch(List<AnimEmployee> animEmployees);

	AnimEmployee findByCard(String content);
	

}
