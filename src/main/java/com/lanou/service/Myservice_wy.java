package com.lanou.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import com.lanou.bean.TbUser;
import com.lanou.bean.TbUserAddress;
import com.lanou.bean.TbUserInfo;
import com.lanou.bean.User;
import com.lanou.mapper.TbUserAddressMapper;
import com.lanou.mapper.TbUserInfoMapper;
import com.lanou.mapper.TbUserMapper;
import com.lanou.mapper.UserMapper;

@Service
public class Myservice_wy implements Myservice_W {
	@Resource
	TbUserMapper tbUserMapper;
	@Resource
	TbUserInfoMapper tbUserInfoMapper;
	@Resource
	TbUserAddressMapper tbUserAddressMapper;
	@Resource
	UserMapper userMapper;
	public Map<String, Object> register(TbUser tbUser, TbUserInfo tbUserInfo) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (tbUser.getUserName() == null || tbUser.getUserName().equals("") || tbUser.getUserPass() == null
				|| tbUser.getUserPass().equals("")) {
			map.put("1", "账号或密码为空");
		} else {

			System.out.println(tbUser.getUserName() + "," + tbUser.getUserPass());
			// 通过用户名拿到tb_user里面的全部对象
			List<TbUser> list = tbUserMapper.select(tbUser.getUserName());
			if (list.isEmpty()) {
				System.out.println("11111111111111111");
				tbUser.setUserTime(new Timestamp((new Date()).getTime()));
				tbUserMapper.insert(tbUser);
				TbUser listi = tbUserMapper.selects(tbUser.getUserName());
				// int userid = listi.get(0).getId();
				tbUserInfo.setUserId(listi.getId());
				tbUserInfo.setId(null);
				tbUserInfoMapper.insert(tbUserInfo);

				map.put("0", "注册成功");
			} else {
				map.put("1", "已注册请勿重复注册");
			}
		}
		return map;
	}
	// 登陆

	public Map<String, Object> login(HttpServletRequest request, TbUser tbUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(tbUser.getUserName() + tbUser.getUserPass());
		TbUser liste = tbUserMapper.reselct(tbUser.getUserName(), tbUser.getUserPass());
		HttpSession session = request.getSession();
		if (liste == null) {
			map.put("1", "登陆失败");

		} else {
			map.put("0", "登陆成功");
			System.out.println("登陆成功");
			session.setAttribute("user", liste);
		}
		return map;
	}

	// 退出登录
	public Map<String, Object> loginn(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		request.getSession().removeAttribute("user");
		map.put("flag", 1);
		return map;
	}

	// 修改密码
	public Map<String, Object> alter(String username, String userpass, String userpassword) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(username + "," + userpass + "," + userpassword);
		TbUser user = tbUserMapper.reselct(username, userpass);
		if (user == null) {
			map.put("state", 0);
		} else {
			int aaa = tbUserMapper.alter(username, userpassword);
			System.out.println(aaa);
			map.put("state", "修改成功");
		}
		return map;
	}

	// 查询地址
	public Map<String, Object> addAddress(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		TbUserAddress tbs = tbUserAddressMapper.addselect(id);
		System.out.println(id);
		if (tbs == null) {
			System.out.println(tbs);
			map.put("state", 0);
		} else {
			map.put("state", tbs.getUserAdd());
		}
		return map;
	}

	// 添加地址
	public Map<String, Object> addAddrs(Integer id, String useradd) {
		System.out.println(id + "," + useradd);
		Map<String, Object> map = new HashMap<String, Object>();
		TbUserAddress tbUserAddress = new TbUserAddress();
		tbUserAddress.setUserAdd(useradd);
		tbUserAddress.setUserId(id);
		System.out.println(tbUserAddress.getUserAdd());
		int tj = tbUserAddressMapper.insert1(tbUserAddress);
		System.out.println("tj:" + tj);
		if (tj != 1) {
			map.put("state", 0);

		} else {
			map.put("state", "添加成功");
		}
		return map;
	}

	// 删除地址
	public Map<String, Object> delte(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int dl = tbUserAddressMapper.deleteByPrimaryKey(id);
		if (dl != 1) {
			map.put("state", 0);

		} else {
			map.put("state", "删除成功");
		}
		return map;
	}

	// 更新地址
	public Map<String, Object> updelte(TbUserAddress tbUserAddress) {
		Map<String, Object> map = new HashMap<String, Object>();
		int up = tbUserAddressMapper.updateByPrimaryKey(tbUserAddress);
		if (up != 1) {
			map.put("state", 0);

		} else {
			map.put("state", "更新成功");
		}
		return map;
                 
		
	}

	
	// 修改信息
	public Map<String, Object> altero(HttpSession session, TbUserInfo tbUserInfo) {
		Map<String, Object> map = new HashMap<String, Object>();
		TbUser tb = (TbUser) session.getAttribute("user");
		tbUserInfo.setUserId(tb.getId());
		System.out.println(tbUserInfo.getUserPhonenum()+tbUserInfo.getUserEmail()+tbUserInfo.getUserId());
		try {
			tbUserInfoMapper.updateuserid(tbUserInfo);
			map.put("state", "修改成功");
		} catch (Exception e) {
			map.put("state", 0);
		}

		return map;
	}
//管理员重置密码
	public Map<String, Object> update(String username) {
		Map<String, Object> map = new HashMap<String, Object>();
	TbUser tbUser=tbUserMapper.selects(username);
	if (tbUser == null) {
		map.put("state", 0);
	} else {
		int aaa = tbUserMapper.alter(username, "123456");
		System.out.println(aaa);
		map.put("state", "修改成功");
	}
	return map;

	}
	//管理员用户信息查询
	public Map<String, Object> userselect(String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		User tbb=userMapper.userselect(username);
		System.out.println("1111"+tbb);
		if(tbb==null){
			map.put("state", 0);	
		}else {
			map.put("state", "查询成功");
		}
		
		return map;
	}

	
}
