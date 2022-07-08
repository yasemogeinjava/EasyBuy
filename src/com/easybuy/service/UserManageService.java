package com.easybuy.service;

import com.easybuy.entity.User;

import java.util.List;

public interface UserManageService {
    List<User> findAll();
    User findById(int id);
    List<User> findUserPage(int page,int pageSize);
    int countNumber();
    boolean deleteById(int id);
    boolean updateById(User user);
    boolean addUser(User user);
}
