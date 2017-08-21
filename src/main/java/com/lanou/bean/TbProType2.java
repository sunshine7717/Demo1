package com.lanou.bean;

public class TbProType2 {
    private Integer id;

    private String proTypename;

    private Integer proType1Id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProTypename() {
        return proTypename;
    }

    public void setProTypename(String proTypename) {
        this.proTypename = proTypename;
    }

    public Integer getProType1Id() {
        return proType1Id;
    }

    public void setProType1Id(Integer proType1Id) {
        this.proType1Id = proType1Id;
    }

	@Override
	public String toString() {
		return "TbProType2 [id=" + id + ", proTypename=" + proTypename + ", proType1Id=" + proType1Id + "]";
	}
}