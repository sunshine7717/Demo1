package com.lanou.mapper;

import com.lanou.bean.TbProType1;

public interface TbProType1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbProType1 record);

    int insertSelective(TbProType1 record);

    TbProType1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbProType1 record);

    int updateByPrimaryKey(TbProType1 record);
}