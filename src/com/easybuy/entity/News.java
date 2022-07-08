package com.easybuy.entity;

import javax.xml.crypto.Data;
import java.sql.Date;

/*
资讯类
* */
public class News {
    private int id;
    private String title;
    private String content;
    private Date createTime;

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date creatTime) {
        this.createTime = creatTime;
    }
}
