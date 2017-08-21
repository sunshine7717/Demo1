package com.lanou.service;

import java.util.List;

import com.lanou.bean.TbProduct;

public interface IProInterfacesHy {

	public String addGoods(TbProduct tbProduct);

	public String deleteGoods(TbProduct tbProduct);

	public String updateGoods(TbProduct tbProduct);

	public List<TbProduct> selectGoods(TbProduct tbProduct);

	public TbProduct selectFirstGoods(TbProduct tbProduct);

}
