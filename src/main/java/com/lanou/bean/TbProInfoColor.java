package com.lanou.bean;

public class TbProInfoColor {
    private Integer id;

    private String proColor;

    private Integer proId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProColor() {
        return proColor;
    }

    public void setProColor(String proColor) {
        this.proColor = proColor;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

	@Override
	public String toString() {
		return "TbProInfoColor [id=" + id + ", proColor=" + proColor + ", proId=" + proId + "]";
	}
}