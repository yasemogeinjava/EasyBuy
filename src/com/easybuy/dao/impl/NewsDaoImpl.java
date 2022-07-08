package com.easybuy.dao.impl;

import com.easybuy.dao.NewsDao;
import com.easybuy.entity.News;
import com.easybuy.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {
    @Override
    public List<News> findAll() {
        String sql = "select * from easybuy_news";
        ResultSet query = JDBCUtil.query (sql, null);
        List<News> newsList = new ArrayList<> ();

        try {
            while (query.next ()) {
                News news = new News ();
                news.setId (query.getInt ("id"));
                news.setTitle (query.getString ("title"));
                news.setContent (query.getString ("content"));
                news.setCreateTime (query.getDate ("createTime"));
                newsList.add (news);
            }
            return newsList;
        } catch (Exception e) {
            e.printStackTrace ();
        }

        return null;
    }

    @Override
    public List<News> findFiveNews() {
        String sql = "select * from easybuy_news order by createTime desc limit 5";
        ResultSet query = JDBCUtil.query (sql, null);
        List<News> newsList = new ArrayList<> ();
        try {
            while (query.next ()) {
                News news = new News ();
                news.setId (query.getInt ("id"));
                news.setTitle (query.getString ("title"));
                news.setContent (query.getString ("content"));
                news.setCreateTime (query.getDate ("createTime"));
                newsList.add (news);
            }
            return newsList;
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public News findById(int id) {
        String sql = "select * from easybuy_news where id =?";
        Object[] params = {id};
        ResultSet query = JDBCUtil.query (sql, params);
        try {
            News news = new News ();
            while (query.next ()) {
                System.out.println (query.getInt ("id"));
                System.out.println (news.getId ());
                if (id > 0) {
                    news.setId (query.getInt ("id"));
                    news.setTitle (query.getString ("title"));
                    news.setContent (query.getString ("content"));
                    news.setCreateTime (query.getDate ("createTime"));
                }
            }
            return news;
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public List<News> findNewsPage(int page, int pageSize) {
        String sql = "select * from easybuy_news limit ?,?";
        Object[] params = {pageSize * (page - 1), pageSize};
        ResultSet query = JDBCUtil.query (sql, params);
        List<News> newsList = new ArrayList<> ();
        try {
            while (query.next ()) {
                News news = new News ();
                news.setId (query.getInt ("id"));
                news.setTitle (query.getString ("title"));
                news.setContent (query.getString ("content"));
                news.setCreateTime (query.getDate ("createTime"));
                newsList.add (news);
            }
            return newsList;
        } catch (Exception e) {
            e.printStackTrace ();
        }

        return null;
    }

    @Override
    public int countNumber() {
        String sql = "select count(1) as total  from easybuy_news ";
        ResultSet resultSet = JDBCUtil.query (sql, null);
        try {
            while (resultSet.next ()) {
                int total = resultSet.getInt ("total");
                return total;
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return 0;
    }


    @Override
    public int count() {
        String sql = "select count(1) as total from easybuy_news";
        ResultSet query = JDBCUtil.query (sql, null);
        try {
            if (query.next ()) {
                int i = query.getInt ("total");
                return i;
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return 0;
    }

    @Override
    public List<News> PageNews(int page, int pagesize) {
        String sql = "select * from easybuy_news limit ?,?";
        Object[] params = {pagesize * (page - 1), pagesize};
        ResultSet query = JDBCUtil.query (sql, params);
        List<News> newsList = new ArrayList<> ();
        try {
            while (query.next ()) {
                News New = new News ();
                New.setContent (query.getString ("content"));
                New.setCreateTime (query.getDate ("createTime"));
                New.setId (query.getInt ("id"));
                New.setTitle (query.getString ("title"));
                newsList.add (New);
            }
            return newsList;
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }
}
