package com.easybuy.dao;

import com.easybuy.entity.User;

public interface UserDao {
    //insert into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile,type) value(?,?,?,?,?,?,?,?);
    boolean addUser(User user);

    //"select * from easybuy_user where loginName = ?";
    User findByName(String name);

    //select * from news_users where loginName = ? and password=?
    User getByNameAndPwd(String name,String pwd);
}