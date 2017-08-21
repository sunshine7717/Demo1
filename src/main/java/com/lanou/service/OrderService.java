package com.lanou.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanou.bean.TbImg;
import com.lanou.bean.TbProInfoColor;
import com.lanou.bean.TbProInfoSize;
import com.lanou.bean.TbProduct;
import com.lanou.bean.TbShopCar;
import com.lanou.bean.TbShopList;
import com.lanou.bean.TbUser;
import com.lanou.bean.TbUserAddress;
import com.lanou.bean.TbUserInfo;
import com.lanou.mapper.TbImgMapper;
import com.lanou.mapper.TbProInfoColorMapper;
import com.lanou.mapper.TbProInfoSizeMapper;
import com.lanou.mapper.TbProductMapper;
import com.lanou.mapper.TbShopCarMapper;
import com.lanou.mapper.TbShopListMapper;
import com.lanou.mapper.TbUserAddressMapper;
import com.lanou.mapper.TbUserInfoMapper;
import com.lanou.mapper.TbUserMapper;
import com.lanou.utils.AjaxResult;

@Service
public class OrderService implements IOrderService {

	int userId;

	@Resource
	TbUserMapper userMapper;

	@Resource
	TbShopListMapper shopListMapper;

	@Resource
	TbImgMapper imgMapper;

	@Resource
	TbUserInfoMapper userInfoMapper;
	
	@Resource
	public TbShopCarMapper shopCarMapper;// 购物车表

	@Resource
	public TbProductMapper productMapper;// 商品表

	@Resource
	public TbProInfoSizeMapper proInfoSizeMapper;// 产品尺码表
	
	@Resource
	public TbProInfoColorMapper proInfoColorMapper;// 产品颜色表
	
/*------------------------------订单管理-----------------------------------*/
	
	public Map<String, Object> SeleteUserId(String userName) {

		List<Object> list = new ArrayList<Object>();

		Map<String, Object> result = new HashMap<String, Object>();

		TbUser user = userMapper.SeleteUserId(userName);

		userId = user.getId();

		TbShopList shoplist = shopListMapper.seleteshoplist(userId);

		int proId = shoplist.getProId();

		TbImg img = imgMapper.selectImgByProId(proId);

		TbUserInfo userInfo = userInfoMapper.seleteUserInfo(userId);

		if (userName == null || userName.equals("")) {

			result.put("msg", "用户名为空");

		} else {

			list.add(userName);

		}

		if (shoplist.getId() == null || shoplist.getId().equals("")) {

			result.put("msg", "订单Id为空");

		} else {

			list.add(shoplist.getId());

		}

		if (shoplist.getProColor() == null || shoplist.getProColor().equals("")) {

			result.put("msg", "无法查询此商品颜色");

		} else {

			list.add(shoplist.getProColor());

		}

		if (shoplist.getProSize()==null||shoplist.getProSize().equals("")) {
			
			result.put("msg", "无法查询此商品大小");
			
		} else {

			list.add(shoplist.getProSize());
		}
		
		if (shoplist.getShopNum()==null||shoplist.getShopNum().equals("")) {
			
			result.put("msg", "无法查询此商品数量");
			
		} else {

			list.add(shoplist.getShopNum());
			
		}
		
		if (img.getProImgurl().equals("")||img.getProImgurl()==null) {
			
			result.put("msg", "无法加载图片");
			
		} else {

			list.add(img.getProImgurl());
		}
		
		if (userInfo.getUserAddress()==null||userInfo.getUserAddress().equals("")) {
			
			result.put("msg", "无法查询订单地址");
			
		} else {

			list.add(userInfo.getUserAddress());
			
		}
		
		if (userInfo.getUserPhonenum()==null || userInfo.getUserPhonenum().equals("")) {
			
			result.put("msg", "无法查询订单电话号码");
			
		} else {
			userInfo.getUserPhonenum();
		}
		
		list.add(shoplist.getIsPay());

		list.add(shoplist.getIsSend());

		list.add(shoplist.getIsShow());		

		if (list.size() > 0) {

			result.put("result", 1);

			result.put("msg", list);

		} else {

			result.put("result", 0);
		}

		return result;
	}

	public Map<String, Object> updateIsSend(TbShopList shopList) {

		Map<String, Object> result = new HashMap<String, Object>();

		shopList.setIsSend(1);

		int i = shopListMapper.updateIsSend(shopList);

		if (i == 1) {

			result.put("result", 1);

			result.put("msg", "发货成功");

		} else {

			result.put("result", 0);

			result.put("msg", "发货失败");

		}

		return result;

	}

	public Map<String, Object> updateIsShow(TbShopList ShopList) {

		Map<String, Object> result = new HashMap<String, Object>();

		ShopList.setIsShow(1);

		int i = shopListMapper.updateIsShow(ShopList);

		if (i == 1) {

			result.put("result", 1);

		} else {

			result.put("result", 0);

		}

		return result;

	}

	public Map<String, Object> updateIsPay(TbShopList shopList) {

		Map<String, Object> result = new HashMap<String, Object>();

		shopList.setIsPay(1);

		int i = shopListMapper.updateIsPay(shopList);

		if (i == 1) {

			result.put("result", 1);

			result.put("msg", "支付失败");

		} else {

			result.put("result", 0);

			result.put("msg", "支付成功");

		}

		return result;
	}
/*---------------------------购物车管理-------------------------*/
	public AjaxResult editProService(Map<String, Object> params) {
		// 1、获取商品ID并判断商品是否存在
		int pro_id;
		if (params.get("pro_id") == null || params.get("pro_id").equals("")) {
			return AjaxResult.error("商品ID为空");
		} else {
			try {
				pro_id = Integer.parseInt(params.get("pro_id").toString());
				// 查询商品是否存在
				TbProduct product = productMapper.selectByPrimaryKey(pro_id);
				if (product == null) {
					return AjaxResult.error("商品不存在");
				}
			} catch (Exception e) {
				return AjaxResult.error("商品ID不为数字");
			}
		}
		// 2、获取用户名
		String user_name;
		int user_id = -1;// 用户ID
		if (params.get("user_name") == null || params.get("user_name").equals("")) {
			return AjaxResult.error("用户名为空");
		} else {
			user_name = (String) params.get("user_name");
			// 查询账号是否存在
			TbUser user = userMapper.selectByuserName(user_name);
			if (user == null) {
				return AjaxResult.error("用户信息错误");
			}
			user_id = user.getId();
		}
		// 3、获取商品数量
		int num_pro = 1;
		if (params.get("num_pro") == null || params.get("num_pro").equals("")) {
			return AjaxResult.error("商品数量为空");
		} else {
			try {
				num_pro = Integer.parseInt(params.get("num_pro").toString());
			} catch (Exception e) {
				return AjaxResult.error("商品数量不为数字");
			}
		}
		// 4、获取商品尺码
		String pro_size;
		if (params.get("pro_size") == null || params.get("pro_size").equals("")) {
			return AjaxResult.error("商品尺码为空");
		} else {
			pro_size = (String) params.get("pro_size");
			// 查询商品尺码是否存在
			TbProInfoSize proInfoSize = proInfoSizeMapper.selectByProIdAndProSize(pro_id, pro_size);
			if (proInfoSize == null) {
				return AjaxResult.error("此商品无此尺码");
			}
			System.out.println(proInfoSize);
		}
		// 5、获取商品颜色
		String pro_color;
		if (params.get("pro_color") == null || params.get("pro_color").equals("")) {
			return AjaxResult.error("商品颜色为空");
		} else {
			pro_color = (String) params.get("pro_color");
			// 查询商品颜色是否存在
			TbProInfoColor proInfoColor = proInfoColorMapper.selectByProIdAndProColor(pro_color, pro_id);
			if (proInfoColor == null) {
				return AjaxResult.error("此商品无此颜色");
			}
		}
		// 创建一个购物车的对象
		TbShopCar shopCar = new TbShopCar();
		shopCar.setProId(pro_id);// 设置商品ID
		shopCar.setUserId(user_id);// 设置用户ID
		shopCar.setShopNum(num_pro);// 设置购买数量
		shopCar.setProSize(pro_size);// 设置产品尺码
		shopCar.setProColor(pro_color);// 设置产品颜色
		// 通过商品ID、用户ID、产品尺码、产品颜色查询购物车是否存在该商品
		TbShopCar shopCarTest = shopCarMapper.selectBySomeInfo(pro_id, user_id, pro_size, pro_color);
		System.out.println(shopCarTest);
		if (shopCarTest == null) {
			// 将数据添加到数据库
			int flag = shopCarMapper.insert(shopCar);
			if (flag > 0) {
				return AjaxResult.success("添加成功", null);
			} else {
				return AjaxResult.error("服务器异常");
			}
		} else {
			return AjaxResult.error("商品已存在");
		}
	}

	public AjaxResult delectProService(Map<String, Object> params) {
		if (params.get("id") == null || params.get("id").equals("")) {
			return AjaxResult.error("id为空");
		} else {
			// 查询购物车是否含有此商品
			try {
				int id = Integer.parseInt(params.get("id").toString());
				TbShopCar shopCarTest = shopCarMapper.selectByPrimaryKey(id);
				if (shopCarTest == null) {
					return AjaxResult.error("购物车无此条目");
				} else {
					int flag = shopCarMapper.deleteByPrimaryKey(id);
					if (flag > 0) {
						return AjaxResult.success("删除成功", null);
					} else {
						return AjaxResult.error("服务器异常");
					}
				}
			} catch (Exception e) {
				return AjaxResult.error("id为不为数字");
			}
		}
	}

	public AjaxResult selectProService(Map<String, Object> params) {
		if (params.get("user_name") == null || params.get("user_name").equals("")) {
			return AjaxResult.error("用户名为空");
		} else {
			String user_name = (String) params.get("user_name");
			TbUser user = userMapper.selectByuserName(user_name);
			if (user == null) {
				return AjaxResult.error("用户名不存在");
			}else {
				//根据账号查询购物车商品
				TbUser userId=userMapper.SeleteUserId(user_name);
			
				System.out.println(userId);
			}
		}
  
		return null;
	}
}
