package com.lanou.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lanou.bean.TbShopList;
import com.lanou.bean.TbUser;
import com.lanou.utils.AjaxResult;

public interface IOrderService {

	// 根据用户名查询用户Id
	public Map<String, Object> SeleteUserId(@Param("userName") String userName);

	// 修改发货属性
	public Map<String, Object> updateIsSend(TbShopList shopList);

	// is_show
	public Map<String, Object> updateIsShow(TbShopList shopList);
	
	//is_pay
	public Map<String, Object> updateIsPay(TbShopList shopList);
	
    public AjaxResult editProService(Map<String, Object> params);
	
	public AjaxResult delectProService(Map<String, Object> params);

	public AjaxResult selectProService(Map<String, Object> params);
	
	
}
