package com.lanou.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lanou.bean.User;

@Repository
public interface UserMapper {
	   User userselect(@Param("username")String username);
	    
}
