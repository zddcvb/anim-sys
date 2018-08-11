package com.yanxi.anim.sys.service.base;

import java.util.List;
/**
 * 所有服务的基类
 * @author 邹丹丹
 *
 * @param <T> javabean
 */
public interface BaseService<T> {
	/**
	 * 根据id查找信息
	 * @param id
	 * @return
	 */
	public T findById(String id);
	/**
	 * 根据id和name查找信息
	 * @param id
	 * @param name
	 * @return
	 */
	public T findByIdAndName(String id, String name);
	/**
	 * 查找所有的信息
	 * @return
	 */
	public List<T> findAll();
	/**
	 * 插入数据
	 * @param t
	 * @return
	 */
	public int insert(T t);
	/**
	 * 更新数据
	 * @param t
	 * @return
	 */
	public int update(T t);
	/**
	 * 根据id删除数据
	 * @param id
	 * @return
	 */
	public int deleteById(String id);
	/**
	 * 删除所有数据
	 * @return
	 */
	public int deleteAll();
}
