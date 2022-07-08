package com.easybuy.entity;

import java.util.List;

public class Page {
    private List<News> news;
    private int curPage;
    private int totalPage;
    private String url;

    public Page(){

    }

    public Page(List<News> news, int curPage, int totalPage,String url) {
        this.news = news;
        this.curPage = curPage;
        this.totalPage = totalPage;
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
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
}
