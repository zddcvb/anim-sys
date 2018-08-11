package com.yanxi.anim.sys.mapper;

import com.yanxi.anim.sys.pojo.AnimResCatagorty;
import com.yanxi.anim.sys.pojo.AnimResCatagortyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnimResCatagortyMapper {
    int countByExample(AnimResCatagortyExample example);

    int deleteByExample(AnimResCatagortyExample example);

    int deleteByPrimaryKey(String resCatagortyId);

    int insert(AnimResCatagorty record);

    int insertSelective(AnimResCatagorty record);

    List<AnimResCatagorty> selectByExample(AnimResCatagortyExample example);

    AnimResCatagorty selectByPrimaryKey(String resCatagortyId);

    int updateByExampleSelective(@Param("record") AnimResCatagorty record, @Param("example") AnimResCatagortyExample example);

    int updateByExample(@Param("record") AnimResCatagorty record, @Param("example") AnimResCatagortyExample example);

    int updateByPrimaryKeySelective(AnimResCatagorty record);

    int updateByPrimaryKey(AnimResCatagorty record);
    
    List<AnimResCatagorty> findByResCatagortyName();
}