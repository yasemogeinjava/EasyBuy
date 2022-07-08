package com.easybuy.dao.impl;

import com.easybuy.dao.UserDao;
import com.easybuy.entity.User;
import com.easybuy.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean addUser(User user) {
        String sql = "insert into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile) value(?,?,?,?,?,?,?)";
        Object[] params = {user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile()};
        int update = JDBCUtil.update(sql, params);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public User findByName(String name) {
        String sql = "select * from easybuy_user where loginName = ?";
        Object[] params = {name};
        ResultSet query = JDBCUtil.query(sql, params);
        User user = new User();
        try {
            while (query.next()){
               return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByNameAndPwd(String name, String pwd) {
        String sql = "select * from easybuy_user where loginName = ? and password=?";
        Object[] params = {name,pwd};
        ResultSet query = JDBCUtil.query(sql, params);
        User user = new User();
        try {
            while (query.next()) {
                user.setId(query.getInt("id"));
                user.setLoginName(query.getString("loginName"));
                user.setUserName(query.getString("userName"));
                user.setPassword(query.getString("password"));
                user.setSex(query.getInt("sex"));
                user.setIdentityCode(query.getString("identityCode"));
                user.setEmail(query.getString("email"));
                user.setMobile(query.getString("mobile"));
                user.setType(query.getInt("type"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
