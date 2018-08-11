package com.yanxi.anim.sys.mapper;

import com.yanxi.anim.sys.pojo.AnimEmployee;
import com.yanxi.anim.sys.pojo.AnimEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnimEmployeeMapper {
    int countByExample(AnimEmployeeExample example);

    int deleteByExample(AnimEmployeeExample example);

    int deleteByPrimaryKey(String employeeId);

    int insert(AnimEmployee record);

    int insertSelective(AnimEmployee record);

    List<AnimEmployee> selectByExample(AnimEmployeeExample example);

    AnimEmployee selectByPrimaryKey(String employeeId);

    int updateByExampleSelective(@Param("record") AnimEmployee record, @Param("example") AnimEmployeeExample example);

    int updateByExample(@Param("record") AnimEmployee record, @Param("example") AnimEmployeeExample example);

    int updateByPrimaryKeySelective(AnimEmployee record);

    int updateByPrimaryKey(AnimEmployee record);
}