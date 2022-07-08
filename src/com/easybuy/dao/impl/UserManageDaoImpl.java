package com.easybuy.dao.impl;

import com.easybuy.dao.UserManageDao;
import com.easybuy.entity.User;
import com.easybuy.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManageDaoImpl implements UserManageDao {

    @Override
    public List<User> findAll() {
        String sql = "select * from easybuy_user";
        ResultSet query = JDBCUtil.query(sql,null);
        List<User> userList = new ArrayList<>();
        try{
            while(query.next()){
                User user = new User();
                user.setId(query.getInt("id"));
                user.setLoginName(query.getString("loginName"));
                user.setUserName(query.getString("userName"));
                user.setPassword(query.getString("password"));
                user.setSex(query.getInt("sex"));
                user.setIdentityCode(query.getString("identityCode"));
                user.setEmail(query.getString("email"));
                user.setMobile(query.getString("mobile"));
                user.setType(query.getInt("type"));
                userList.add(user);
            }
            return userList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(int id) {
        String sql = "select * from easybuy_user where id =?";
        Object[] params = {id};
        ResultSet query = JDBCUtil.query(sql, params);
        try {
            User user = new User();
            while (query.next()){
                System.out.println(query.getInt("id"));
                System.out.println(user.getId());
                if (id>0) {
                    user.setId(query.getInt("id"));
                    user.setLoginName(query.getString("loginName"));
                    user.setUserName(query.getString("userName"));
                    user.setPassword(query.getString("password"));
                    user.setSex(query.getInt("sex"));
                    user.setIdentityCode(query.getString("identityCode"));
                    user.setEmail(query.getString("email"));
                    user.setMobile(query.getString("mobile"));
                    user.setType(query.getInt("type"));
                }
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findUserPage(int page, int pageSize) {
        String sql="select * from easybuy_user limit ?,?";
        Object[] params={pageSize*(page-1),pageSize};
        ResultSet query = JDBCUtil.query(sql, params);
        List<User> userList = new ArrayList<>();
        try{
            while(query.next()){
                User user = new User();
                user.setId(query.getInt("id"));
                user.setLoginName(query.getString("loginName"));
                user.setUserName(query.getString("userName"));
                user.setPassword(query.getString("password"));
                user.setSex(query.getInt("sex"));
                user.setIdentityCode(query.getString("identityCode"));
                user.setEmail(query.getString("email"));
                user.setMobile(query.getString("mobile"));
                user.setType(query.getInt("type"));
                userList.add(user);
            }
            return userList;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int countNumber() {
        String sql = "select count(1) as total  from easybuy_user ";
        ResultSet resultSet = JDBCUtil.query(sql,null);
        try {
            while (resultSet.next()){
                int total= resultSet.getInt("total");
                return total;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "delete from easybuy_user where id =?";
        Object[] params = {id};
        int update = JDBCUtil.update(sql,params);
        if(update>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateById(User user) {
        String sql = "update easybuy_user set loginName=?,userName=?,identityCode=?,email=?,mobile=? ,type=? where id =?";
        Object[] params = {user.getLoginName(),user.getUserName(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getType(),user.getId()};
        int update =  JDBCUtil.update(sql,params);
        if (update>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addUser(User user) {
        String sql ="insert into easybuy_user(loginName,userName,password,identityCode,email,mobile,type) values(?,?,?,?,?,?,?)";
        Object[] params ={user.getLoginName(),user.getUserName(),user.getPassword(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getType()};
        int update = JDBCUtil.update(sql, params);
        if(update>0){
            return true;
        }
        return false;
    }
}
