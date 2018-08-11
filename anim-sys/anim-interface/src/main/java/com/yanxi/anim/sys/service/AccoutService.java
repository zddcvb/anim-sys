package com.yanxi.anim.sys.service;

import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.pojo.AnimAccout;
import com.yanxi.anim.sys.service.base.BaseService;

public interface AccoutService extends BaseService<AnimAccout> {

	PageInfo<AnimAccout> findAllByPage(int pageNum,String username);

	AnimAccout findByUsernameAndPassword(AnimAccout accout);

}
