package com.lanou.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.TbProduct;
import com.lanou.service.ProServiceHy;

@Controller
public class ProControllerHy {

	@Resource
	private ProServiceHy proservice;

	Map<String, Object> map = new HashMap<String, Object>();

	@RequestMapping(value = "/addgoods")
	@ResponseBody
	public Map<String, Object> addGoods(TbProduct tbProduct) {

		System.out.println(tbProduct.getProName() + "------");

		String str = proservice.addGoods(tbProduct);

		System.out.println(str);

		map.put("info", str);

		return map;

	}

	@RequestMapping(value = "/deletegoods")
	@ResponseBody
	public Map<String, Object> deleteGoods(TbProduct tbProduct) {

		String str = proservice.deleteGoods(tbProduct);

		System.out.println(str + "======");

		map.put("info", str);

		return map;

	}

	@RequestMapping(value = "/updategoods")
	@ResponseBody
	public Map<String, Object> updateGoods(TbProduct tbProduct) {

		map.put("info", proservice.updateGoods(tbProduct));

		System.out.println(map + "++++++");

		return map;
	}

	@RequestMapping(value = "/selectgoods")
	@ResponseBody
	public Map<String, Object> selectGoods(TbProduct tbProduct) {

		map.put("info", proservice.selectGoods(tbProduct));

		System.out.println(map + "******");

		return map;
	}

	@RequestMapping(value = "/selectfirstgoods")
	@ResponseBody
	public Map<String, Object> selectFirstGoods(TbProduct tbProduct) {

		System.out.println(tbProduct);

		TbProduct pro = proservice.selectFirstGoods(tbProduct);

		map.put("info", pro);

		return map;
	}

}
