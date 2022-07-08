package com.easybuy.service.impl;

import com.easybuy.dao.UserManageDao;
import com.easybuy.dao.impl.UserManageDaoImpl;
import com.easybuy.entity.User;
import com.easybuy.service.UserManageService;

import java.util.List;

public class UserManageServiceImpl implements UserManageService {
    private UserManageDao userManageDao = new UserManageDaoImpl();

    @Override
    public List<User> findAll() {
        return userManageDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userManageDao.findById(id);
    }

    @Override
    public List<User> findUserPage(int page, int pageSize) {
        return userManageDao.findUserPage(page,pageSize);
    }

    @Override
    public int countNumber() {
        return userManageDao.countNumber();
    }

    @Override
    public boolean deleteById(int id) {
        return userManageDao.deleteById(id);
    }

    @Override
    public boolean updateById(User user) {
        return userManageDao.updateById(user);
    }

    @Override
    public boolean addUser(User user) {
        return userManageDao.addUser(user);
    }
}
