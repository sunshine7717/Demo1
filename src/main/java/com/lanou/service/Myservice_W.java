package com.lanou.service;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import com.lanou.bean.TbUser;
import com.lanou.bean.TbUserAddress;
import com.lanou.bean.TbUserInfo;
public interface Myservice_W {
	public Map<String, Object> register(TbUser tbUser,TbUserInfo tbUserInfo);

	public Map<String, Object> login(HttpServletRequest request, TbUser tbUser);
	public Map<String, Object> loginn(HttpServletRequest request);
	public Map<String, Object> alter(@Param("username") String username,@Param("userpass")String userpass,@Param("userpassword")String userpassword);
	public Map<String, Object> addAddress(@Param("id") Integer id);
	public Map<String, Object> addAddrs(@Param("id") Integer id,@Param("useradd") String user_add);
	public Map<String, Object> delte( Integer id);
	public Map<String, Object> updelte( TbUserAddress tbUserAddress);
	public Map<String, Object> altero(HttpSession session,TbUserInfo tbUserInfo);
	public Map<String, Object> update(String username);
	public Map<String, Object> userselect( String username);

}
