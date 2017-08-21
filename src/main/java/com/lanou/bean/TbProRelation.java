package com.lanou.bean;

public class TbProRelation {
    private Integer id;

    private Integer proTypeid;

    private Integer proId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProTypeid() {
        return proTypeid;
    }

    public void setProTypeid(Integer proTypeid) {
        this.proTypeid = proTypeid;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

	@Override
	public String toString() {
		return "TbProRelation [id=" + id + ", proTypeid=" + proTypeid + ", proId=" + proId + "]";
	}
}