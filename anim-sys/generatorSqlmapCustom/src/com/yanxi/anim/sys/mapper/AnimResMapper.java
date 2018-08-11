package com.yanxi.anim.sys.mapper;

import com.yanxi.anim.sys.pojo.AnimRes;
import com.yanxi.anim.sys.pojo.AnimResExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnimResMapper {
    int countByExample(AnimResExample example);

    int deleteByExample(AnimResExample example);

    int deleteByPrimaryKey(String resId);

    int insert(AnimRes record);

    int insertSelective(AnimRes record);

    List<AnimRes> selectByExample(AnimResExample example);

    AnimRes selectByPrimaryKey(String resId);

    int updateByExampleSelective(@Param("record") AnimRes record, @Param("example") AnimResExample example);

    int updateByExample(@Param("record") AnimRes record, @Param("example") AnimResExample example);

    int updateByPrimaryKeySelective(AnimRes record);

    int updateByPrimaryKey(AnimRes record);
}