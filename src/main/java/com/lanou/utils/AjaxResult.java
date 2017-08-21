package com.lanou.utils;

import org.springframework.stereotype.Component;

@Component
public class AjaxResult {
	private int flag;
	private String info;
	private Object data;

	public static AjaxResult error(String info) {
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setInfo(info);
		ajaxResult.setFlag(0);
		return ajaxResult;
	}

	public AjaxResult(int flag, String info, Object data) {
		super();
		this.flag = flag;
		this.info = info;
		this.data = data;
	}

	public static AjaxResult success(String info, Object data) {
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setInfo(info);
		ajaxResult.setFlag(1);
		ajaxResult.setData(data);
		return ajaxResult;
	}

	public AjaxResult() {
		super();
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AjaxResult [flag=" + flag + ", info=" + info + ", data=" + data + "]";
	}
}
