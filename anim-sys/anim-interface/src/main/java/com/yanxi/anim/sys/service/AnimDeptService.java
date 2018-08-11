package com.yanxi.anim.sys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yanxi.anim.sys.pojo.AnimDept;
import com.yanxi.anim.sys.service.base.BaseService;

public interface AnimDeptService extends BaseService<AnimDept> {
	/**
	 * 根据部门名称查找部门
	 * 
	 * @param deptName
	 * @return
	 */
	public AnimDept findByName(String deptName);

	/**
	 * 查询所有的部门，根据删除属性
	 * 
	 * @param isdeleted
	 * @return
	 */
	public List<AnimDept> findAllDeptByDeleted(boolean isdeleted);

	/**
	 * 通过部门id，查询所有的下级部门
	 * 
	 * @param deptId
	 * @return
	 */
	public List<AnimDept> findChildrenByParentId(String deptId);
	/**
	 * 分页查询
	 * @param deptId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<AnimDept> findChildrenByParentId(String deptId, int pageNum);
	/**
	 * 根据parentid属性，查找所有的上级部门
	 * 
	 * @param parentId
	 * @return
	 */
	public List<AnimDept> findParentDept(String parentId);
	/**
	 * 分页查询
	 * @param parentId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageInfo<AnimDept> findParentDept(String parentId, int pageNum);
	/**
	 * 根据parentId删除对应的下级部门
	 * @param parentId
	 * @return int
	 */

	public int deleteChildren(String parentId);

}
