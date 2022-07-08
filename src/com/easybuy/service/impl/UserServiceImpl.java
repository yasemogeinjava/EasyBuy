package com.easybuy.service.impl;

import com.easybuy.dao.UserDao;
import com.easybuy.dao.impl.UserDaoImpl;
import com.easybuy.entity.User;
import com.easybuy.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User getByNameAndPwd(String name, String pwd) {
        return userDao.getByNameAndPwd(name,pwd);
    }
}
