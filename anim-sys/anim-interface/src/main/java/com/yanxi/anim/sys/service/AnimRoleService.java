package com.yanxi.anim.sys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.pojo.AnimRole;
import com.yanxi.anim.sys.service.base.BaseService;
/**
 * AnimRole的服务接口
 * @author 邹丹丹
 * 
 *
 */
public interface AnimRoleService extends BaseService<AnimRole>{
	/**
	 * 根据部门id查找所有的岗位信息
	 * @param deptId
	 * @return
	 */
	public List<AnimRole> findAllByDeptId(String deptId);
	/**
	 * 分页显示所有的信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<AnimRole> findAll(int pageNum);
	/**
	 * 根据岗位名称、部门名称查询，并分页显示
	 * @param roleNameQuery
	 * @param deptNameQuery
	 * @param pageNum
	 * @return
	 */
	public PageInfo<AnimRole> findRolesByRoleNameAndDeptId(String roleNameQuery, String deptId, int pageNum);
	/**
	 * 根据岗位名称查询岗位信息
	 * @param roleNameQuery
	 * @return
	 */
	public AnimRole findByName(String roleNameQuery);
	/**
	 * 批量插入数据
	 * @param animRoles
	 */
	public void insertBatch(List<AnimRole> animRoles);
	

}
