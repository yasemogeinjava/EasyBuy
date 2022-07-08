package com.easybuy.entity;

import java.util.List;

public class UserPage {
    private List<User> user;
    private int curPage;
    private int totalPage;
    private String url;

    public UserPage(){

    }

    public UserPage(List<User> user, int curPage, int totalPage, String url) {
        this.user = user;
        this.curPage = curPage;
        this.totalPage = totalPage;
        this.url = url;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
