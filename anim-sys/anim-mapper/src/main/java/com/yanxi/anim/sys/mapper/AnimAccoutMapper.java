package com.yanxi.anim.sys.mapper;

import com.yanxi.anim.sys.pojo.AnimAccout;
import com.yanxi.anim.sys.pojo.AnimAccoutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnimAccoutMapper {
    int countByExample(AnimAccoutExample example);

    int deleteByExample(AnimAccoutExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnimAccout record);

    int insertSelective(AnimAccout record);

    List<AnimAccout> selectByExample(AnimAccoutExample example);

    AnimAccout selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnimAccout record, @Param("example") AnimAccoutExample example);

    int updateByExample(@Param("record") AnimAccout record, @Param("example") AnimAccoutExample example);

    int updateByPrimaryKeySelective(AnimAccout record);

    int updateByPrimaryKey(AnimAccout record);
}