package com.lanou.bean;

import java.util.Date;

public class TbProduct {
    private Integer id;

    private String proName;

    private String proPrice;

    private String proDiscount;

    private Date proCretime;

    private Integer proTypeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public String getProDiscount() {
        return proDiscount;
    }

    public void setProDiscount(String proDiscount) {
        this.proDiscount = proDiscount;
    }

    public Date getProCretime() {
        return proCretime;
    }

    public void setProCretime(Date proCretime) {
        this.proCretime = proCretime;
    }

    public Integer getProTypeid() {
        return proTypeid;
    }

    public void setProTypeid(Integer proTypeid) {
        this.proTypeid = proTypeid;
    }

	@Override
	public String toString() {
		return "TbProduct [id=" + id + ", proName=" + proName + ", proPrice=" + proPrice + ", proDiscount="
				+ proDiscount + ", proCretime=" + proCretime + ", proTypeid=" + proTypeid + "]";
	}
}