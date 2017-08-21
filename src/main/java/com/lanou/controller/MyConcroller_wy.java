package com.lanou.controller;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lanou.bean.TbUser;
import com.lanou.bean.TbUserAddress;
import com.lanou.bean.TbUserInfo;
import com.lanou.service.Myservice_wy;

@Controller
public class MyConcroller_wy {
	@Resource
	Myservice_wy myservice;
	

	@RequestMapping(value = "/register")
	@ResponseBody
	public Map<String, Object> register(TbUser tbUser,TbUserInfo tbUserInfo) {
		System.out.println(tbUser.getUserName()+","+tbUser.getUserPass());
		return myservice.register(tbUser,tbUserInfo);

	}
//	��½
	@RequestMapping(value="/login")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request, TbUser tbUser){
		
		return myservice.login(request,tbUser);
		
	}
	//�û��˳�
	@RequestMapping(value="/loginn")
	@ResponseBody
	public Map<String, Object> loginn(HttpServletRequest request){
		return myservice.loginn(request);
		
	}
//�޸�����
	@RequestMapping(value="/alter")
	@ResponseBody
	public Map<String, Object> alter(@Param("username") String username,@Param("userpass")String userpass,@Param("userpassword")String userpassword){
	
		
		return myservice.alter(username, userpass, userpassword);
		
	}
	//��ӵ�ַ,��ѯ��ַ
	@RequestMapping(value="/address")
	@ResponseBody
	public Map<String, Object> addAddress(@Param("id") Integer id){
		System.out.println(id+"�鷳������");
		return myservice.addAddress(id);	
	}
	//��ӵ�ַ
	@RequestMapping(value="/addresss")
	@ResponseBody
	public Map<String, Object> addAddres(@RequestParam("id") Integer id,@RequestParam("useradd") String user_add){
		System.out.println(id+"."+user_add);
		return myservice.addAddrs(id, user_add);
		
	}
	//ɾ����ַ
	@RequestMapping(value="/delte")
	@ResponseBody
	Map<String, Object> delte(@RequestParam("id") Integer id){
		return myservice.delte(id);
		
	}
	//���µ�ַ
	@RequestMapping(value="/updelte")
	@ResponseBody
	Map<String, Object> updelte(TbUserAddress tbUserAddrss){
		tbUserAddrss.setId(19);
		tbUserAddrss.setUserId(0);
		tbUserAddrss.setUserAdd("�Ϳ������jfk���˷�");
		return myservice.updelte(tbUserAddrss);
		
	}
	
	//�޸��û���Ϣ
	@RequestMapping(value="/altero")
	@ResponseBody
	public Map<String, Object> altero(HttpSession session,TbUserInfo tbUserInfo){
		return myservice.altero(session, tbUserInfo);
		
	}
	//����Ա��������
	@RequestMapping(value="/update")
	@ResponseBody
	public Map<String, Object> update(@RequestParam("username") String username){
		return myservice.update(username);
		
	}
			
	//����Ա�û���Ϣ��ѯ
	@RequestMapping(value="/userselect")
	@ResponseBody
	public Map<String, Object> userselect(@RequestParam("username") String username){
		return myservice.userselect(username);
		
	}
	
}
