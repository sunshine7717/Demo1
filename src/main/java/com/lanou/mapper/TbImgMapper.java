package com.lanou.mapper;

import com.lanou.bean.TbImg;

public interface TbImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbImg record);

    int insertSelective(TbImg record);

    TbImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbImg record);

    int updateByPrimaryKey(TbImg record);
    
    TbImg selectImgByProId(Integer proId);
}