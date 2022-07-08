package com.easybuy.service.impl;

import com.easybuy.dao.NewsDao;
import com.easybuy.dao.impl.NewsDaoImpl;
import com.easybuy.entity.News;
import com.easybuy.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
   private NewsDao newsDao = new NewsDaoImpl();
    @Override
    public List<News> findAllNews() {
        return newsDao.findAll();
    }

    @Override
    public News findById(int id) {
        return newsDao.findById(id);
    }

    @Override
    public List<News> findNewsPage(int page, int pageSize) {
        return newsDao.findNewsPage(page,pageSize);
    }

    @Override
    public int countNumber() {
        return newsDao.countNumber();
    }

    @Override
    public List<News> findFiveNews() {
        return newsDao.findFiveNews ();
    }

    @Override
    public int count() {
        return newsDao.count ();
    }

    @Override
    public List<News> PageNews(int page, int pagesize) {
        return newsDao.PageNews (page,pagesize);
    }
}
