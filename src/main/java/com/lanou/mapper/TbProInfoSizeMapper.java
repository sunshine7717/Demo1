package com.lanou.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestAttribute;

import com.lanou.bean.TbProInfoSize;
@Repository
public interface TbProInfoSizeMapper {
	//通过产品ID和商品和尺码查询商品尺码是否存在
	TbProInfoSize selectByProIdAndProSize(@Param("pro_id")int pro_id,@Param("pro_size")String pro_size);
	
	
	
	
	
	
	
	
	/*自动生成*/
    int deleteByPrimaryKey(Integer id);

    int insert(TbProInfoSize record);

    int insertSelective(TbProInfoSize record);

    TbProInfoSize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbProInfoSize record);

    int updateByPrimaryKey(TbProInfoSize record);
}