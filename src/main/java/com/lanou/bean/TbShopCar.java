package com.lanou.bean;

public class TbShopCar {
    private Integer id;

    private Integer proId;

    private Integer userId;

    private Integer shopNum;

    private String proSize;

    private String proColor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopNum() {
        return shopNum;
    }

    public void setShopNum(Integer shopNum) {
        this.shopNum = shopNum;
    }

    public String getProSize() {
        return proSize;
    }

    public void setProSize(String proSize) {
        this.proSize = proSize;
    }

    public String getProColor() {
        return proColor;
    }

    public void setProColor(String proColor) {
        this.proColor = proColor;
    }

	@Override
	public String toString() {
		return "TbShopCar [id=" + id + ", proId=" + proId + ", userId=" + userId + ", shopNum=" + shopNum + ", proSize="
				+ proSize + ", proColor=" + proColor + "]";
	}
}