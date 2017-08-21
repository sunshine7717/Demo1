package com.lanou.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanou.bean.TbProduct;
import com.lanou.mapper.TbProductMapper;
import com.lanou.service.IProInterfacesHy;

@Service
public class ProServiceHy implements IProInterfacesHy {

	@Resource
	private TbProductMapper tbproductMapper;

	public String addGoods(TbProduct tbProduct) {

		if (tbProduct.getId() == null || tbProduct.getId().equals("")) {
			return "商品名称为空";
		} else if (tbProduct.getProName() == null || tbProduct.getProName().equals("")) {
			return "商品名字为空";
		} else if (tbProduct.getProPrice() == null || tbProduct.getProPrice().equals("")) {
			return "商品价格为空";
		} else if (tbProduct.getProDiscount() == null || tbProduct.getProDiscount().equals("")) {
			return "商品折扣价为空";
		} else if (tbProduct.getProCretime() == null || tbProduct.getProCretime().equals("")) {
			return "商品上架时间为空";
		} else {
			if (tbproductMapper.insert(tbProduct) > 0) {
				return "success";
			} else {
				return "error";
			}

		}

	}

	public String deleteGoods(TbProduct tbProduct) {
		if (tbProduct.getId() == null || tbProduct.getId().equals("")) {
			return "商品ID为空";
		} else {

			TbProduct pro = tbproductMapper.selectByPrimaryKey(tbProduct.getId());

			if (pro == null) {
				return "无此商品";
			} else {
				if (tbproductMapper.deleteByPrimaryKey(tbProduct.getId()) > 0) {
					return "success";
				} else {
					return "error";
				}
			}

		}

	}

	public String updateGoods(TbProduct tbProduct) {
		if (tbProduct.getId() == null || tbProduct.getId().equals("")) {
			return "商品ID为空";
		} else {

			TbProduct pro = tbproductMapper.selectByPrimaryKey(tbProduct.getId());

			if (pro == null) {
				return "无此商品";
			} else {
				if (tbproductMapper.updateByPrimaryKeySelective(tbProduct) > 0) {
					return "success";
				} else {
					return "error";
				}
			}

		}

	}

	public List<TbProduct> selectGoods(TbProduct tbProduct) {

		List<TbProduct> tbPro = tbproductMapper.selectAllGoods();

		System.out.println(tbPro);

		return tbPro;
	}

	public TbProduct selectFirstGoods(TbProduct tbProduct) {

		TbProduct pro = tbproductMapper.selectByPrimaryKey(tbProduct.getId());

		return pro;
	}

}
