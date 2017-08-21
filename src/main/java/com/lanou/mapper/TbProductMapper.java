package com.lanou.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.bean.TbProduct;
@Repository
public interface TbProductMapper {
	

	
	List<TbProduct> selectAllGoods();

	
	
	
	
	
	
	
	
	/*———————————————————— 自动生成 ————————————————————*/
	
    int deleteByPrimaryKey(Integer id);

    int insert(TbProduct record);

    int insertSelective(TbProduct record);

    TbProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbProduct record);

    int updateByPrimaryKey(TbProduct record);
}