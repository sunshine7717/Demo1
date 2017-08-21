package com.lanou.mapper;

import com.lanou.bean.TbShopList;

public interface TbShopListMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(TbShopList record);

	int insertSelective(TbShopList record);

	TbShopList selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TbShopList record);

	int updateByPrimaryKey(TbShopList record);

	public TbShopList seleteshoplist(Integer userId);

	int updateIsSend(TbShopList shoplist);

	int updateIsShow(TbShopList shoplist);
	
	int updateIsPay(TbShopList shoplist);
}