package com.lanou.mapper;

import com.lanou.bean.TbUserAddress;

public interface TbUserAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserAddress record);

    int insertSelective(TbUserAddress record);

    TbUserAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserAddress record);

    int updateByPrimaryKey(TbUserAddress record);
    
    TbUserAddress selectAddByUserId(Integer userId);
    
    TbUserAddress addselect(Integer id);
    
    int insert1(TbUserAddress tbUserAddress);
}