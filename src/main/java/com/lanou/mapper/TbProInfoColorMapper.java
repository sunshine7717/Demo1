package com.lanou.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lanou.bean.TbProInfoColor;
@Repository
public interface TbProInfoColorMapper {
	//通过pro_id和pro_color查询商品颜色是否存在
	TbProInfoColor selectByProIdAndProColor(@Param("pro_color")String pro_color,@Param("pro_id")int pro_id);
	
	
	
	
	
	
	
	
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(TbProInfoColor record);

    int insertSelective(TbProInfoColor record);

    TbProInfoColor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbProInfoColor record);

    int updateByPrimaryKey(TbProInfoColor record);
}