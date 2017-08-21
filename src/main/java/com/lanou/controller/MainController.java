package com.lanou.controller;

import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lanou.bean.TbShopList;
import com.lanou.service.IOrderService;
import com.lanou.utils.AjaxResult;

@Controller
public class MainController {

	@Resource
	IOrderService service;

	@RequestMapping(value = "/selectShopList")
	@ResponseBody
	public Map<String, Object> selectUser(@RequestParam("userName") String userName) {

		return service.SeleteUserId(userName);
	}

	@RequestMapping(value = "/updateIsSend")
	@ResponseBody
	public Map<String, Object> updateIsSend(TbShopList shopList) {
		return service.updateIsSend(shopList);
	}

	@RequestMapping(value = "/updateIsShow")
	@ResponseBody
	public Map<String, Object> updateIsShow(TbShopList shopList) {

		return service.updateIsShow(shopList);
	}

	@RequestMapping(value = "/updateIsPay")
	@ResponseBody
	public Map<String, Object> updateIsPay(TbShopList shopList) {

		return service.updateIsPay(shopList);
	}

	    // 向购物车添加商品
		@RequestMapping(value = "/editPro")
		@ResponseBody
		public AjaxResult editPro(@RequestParam Map<String, Object> params) {
			return service.editProService(params);
		}

		// 删除购物车的商品
		@RequestMapping(value = "/delectPro")
		@ResponseBody
		public AjaxResult delectPro(@RequestParam Map<String, Object> params) {
			return service.delectProService(params);
		}

		// 查询购物车商品
		@RequestMapping(value = "/selectPro")
		@ResponseBody
		public AjaxResult selectPro(@RequestParam Map<String, Object> params) {
			return service.selectProService(params);
		}
	
}
