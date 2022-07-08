package com.easybuy.service;

import com.easybuy.entity.User;

public interface UserService {
    boolean addUser(User user);
    User findByName(String name);
    User getByNameAndPwd(String name,String pwd);
}
