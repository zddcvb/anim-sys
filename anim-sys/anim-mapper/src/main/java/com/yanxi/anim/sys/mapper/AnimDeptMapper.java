package com.yanxi.anim.sys.mapper;

import com.yanxi.anim.sys.pojo.AnimDept;
import com.yanxi.anim.sys.pojo.AnimDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnimDeptMapper {
	int countByExample(AnimDeptExample example);

	int deleteByExample(AnimDeptExample example);

	int deleteByPrimaryKey(String deptId);

	int insert(AnimDept record);

	int insertSelective(AnimDept record);

	List<AnimDept> selectByExample(AnimDeptExample example);

	AnimDept selectByPrimaryKey(String deptId);

	int updateByExampleSelective(@Param("record") AnimDept record, @Param("example") AnimDeptExample example);

	int updateByExample(@Param("record") AnimDept record, @Param("example") AnimDeptExample example);

	int updateByPrimaryKeySelective(AnimDept record);

	int updateByPrimaryKey(AnimDept record);
}