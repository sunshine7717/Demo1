package com.lanou.mapper;

import com.lanou.bean.TbUserInfo;

public interface TbUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserInfo record);

    int insertSelective(TbUserInfo record);

    TbUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserInfo record);

    int updateByPrimaryKey(TbUserInfo record);
    
    TbUserInfo seleteUserInfo(Integer userId);
    
    int updateuserid(TbUserInfo TbUserInfo);
    
  
}