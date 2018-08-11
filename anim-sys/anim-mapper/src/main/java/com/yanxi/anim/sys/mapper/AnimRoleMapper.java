package com.yanxi.anim.sys.mapper;

import com.yanxi.anim.sys.pojo.AnimRole;
import com.yanxi.anim.sys.pojo.AnimRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnimRoleMapper {
    int countByExample(AnimRoleExample example);

    int deleteByExample(AnimRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(AnimRole record);

    int insertSelective(AnimRole record);

    List<AnimRole> selectByExample(AnimRoleExample example);

    AnimRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") AnimRole record, @Param("example") AnimRoleExample example);

    int updateByExample(@Param("record") AnimRole record, @Param("example") AnimRoleExample example);

    int updateByPrimaryKeySelective(AnimRole record);

    int updateByPrimaryKey(AnimRole record);
}