package com.lanou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanou.bean.TbUser;

public interface TbUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(TbUser record);

	int insertSelective(TbUser record);

	TbUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TbUser record);

	int updateByPrimaryKey(TbUser record);

	public TbUser SeleteUserId(@Param("userName") String userName);

	// 通过userName查询账户是否存在
	TbUser selectByuserName(@Param("userName") String userName);

	List<TbUser> select(String username);

	// twwwwwwww
	TbUser selects(String username);

	TbUser userselect(@Param("username") String username);

	TbUser reselct(@Param("username") String username, @Param("userpass") String userpass);

	int alter(@Param("username") String username, @Param("userpassword") String userpassword);
}