package com.lanou.bean;

public class TbProInfoSize {
    private Integer id;

    private String proSize;

    private Integer proId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProSize() {
        return proSize;
    }

    public void setProSize(String proSize) {
        this.proSize = proSize;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

	@Override
	public String toString() {
		return "TbProInfoSize [id=" + id + ", proSize=" + proSize + ", proId=" + proId + "]";
	}
}