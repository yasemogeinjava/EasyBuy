package com.easybuy.entity;

import java.util.Date;

public class Address {
    private Integer id;
    private Integer userId;
    private String address;
    private Date creatTime;
    private String remark;

    public Address() {
    }

    public Address(Integer id, Integer userId, String address, Date creatTime, String remark) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.creatTime = creatTime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
