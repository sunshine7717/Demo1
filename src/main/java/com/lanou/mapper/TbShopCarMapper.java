package com.lanou.mapper;

import org.springframework.stereotype.Repository;

import com.lanou.bean.TbShopCar;
import com.lanou.bean.TbUser;
@Repository
public interface TbShopCarMapper {
	// 通过商品ID、用户ID、产品尺码、产品颜色查询购物车是否存在该商品
	 TbShopCar selectBySomeInfo(int pro_id,int user_id,String pro_size,String pro_color);	
	 //根据账号查询购物车商品
	 TbShopCar selectShopCarByUserId(TbUser userId);
	
	
	
	
	
	
	
	
	
	
	/*自动生成*/
    int deleteByPrimaryKey(Integer id);

    int insert(TbShopCar record);

    int insertSelective(TbShopCar record);

    TbShopCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbShopCar record);

    int updateByPrimaryKey(TbShopCar record);
}