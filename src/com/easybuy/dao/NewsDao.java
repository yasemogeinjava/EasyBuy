package com.easybuy.dao;

import com.easybuy.entity.News;

import java.util.List;

public interface NewsDao {
    List<News> findAll();
    News findById(int id);
    List<News> findNewsPage(int page,int pageSize);
    int countNumber();

    //select * from easybuy_news order by createTime desc limit 5;
    List<News> findFiveNews();

    int count();

    List<News> PageNews(int page,int pagesize);
}
