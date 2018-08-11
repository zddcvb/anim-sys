package com.yanxi.anim.sys.mapper;

import com.yanxi.anim.sys.pojo.AnimPerm;
import com.yanxi.anim.sys.pojo.AnimPermExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnimPermMapper {
    int countByExample(AnimPermExample example);

    int deleteByExample(AnimPermExample example);

    int deleteByPrimaryKey(String permId);

    int insert(AnimPerm record);

    int insertSelective(AnimPerm record);

    List<AnimPerm> selectByExample(AnimPermExample example);

    AnimPerm selectByPrimaryKey(String permId);

    int updateByExampleSelective(@Param("record") AnimPerm record, @Param("example") AnimPermExample example);

    int updateByExample(@Param("record") AnimPerm record, @Param("example") AnimPermExample example);

    int updateByPrimaryKeySelective(AnimPerm record);

    int updateByPrimaryKey(AnimPerm record);
}