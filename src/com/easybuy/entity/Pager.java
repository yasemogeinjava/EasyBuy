package com.easybuy.entity;

public class Pager {
    private int pageCount;
    private String url;
    private int currentPage;

    public Pager() {
    }

    public Pager(int pageCount, String url, int currentPage) {
        this.pageCount = pageCount;
        this.url = url;
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
