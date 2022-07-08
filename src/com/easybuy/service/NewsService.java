package com.easybuy.service;

import com.easybuy.entity.News;

import java.util.List;

public interface NewsService {
    List<News> findAllNews();
    News findById(int id);
    List<News> findNewsPage(int page,int pageSize);
    int countNumber();
    List<News> findFiveNews();
    int count();
    List<News> PageNews(int page, int pagesize);
}
