package com.lanou.bean;

public class TbProInfo {
    private Integer id;

    private Integer proNum;

    private String proIntroduce;

    private String proPlace;

    private String proUse;

    private Integer proStandard;

    private Integer proId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProNum() {
        return proNum;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    public String getProIntroduce() {
        return proIntroduce;
    }

    public void setProIntroduce(String proIntroduce) {
        this.proIntroduce = proIntroduce;
    }

    public String getProPlace() {
        return proPlace;
    }

    public void setProPlace(String proPlace) {
        this.proPlace = proPlace;
    }

    public String getProUse() {
        return proUse;
    }

    public void setProUse(String proUse) {
        this.proUse = proUse;
    }

    public Integer getProStandard() {
        return proStandard;
    }

    public void setProStandard(Integer proStandard) {
        this.proStandard = proStandard;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

	@Override
	public String toString() {
		return "TbProInfo [id=" + id + ", proNum=" + proNum + ", proIntroduce=" + proIntroduce + ", proPlace="
				+ proPlace + ", proUse=" + proUse + ", proStandard=" + proStandard + ", proId=" + proId + "]";
	}
}