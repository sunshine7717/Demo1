package com.lanou.bean;

import java.util.Date;

public class TbAdmin {
    private Integer id;

    private String adminName;

    private String adminPass;

    private Date adminTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public Date getAdminTime() {
        return adminTime;
    }

    public void setAdminTime(Date adminTime) {
        this.adminTime = adminTime;
    }

	@Override
	public String toString() {
		return "TbAdmin [id=" + id + ", adminName=" + adminName + ", adminPass=" + adminPass + ", adminTime="
				+ adminTime + "]";
	}
}