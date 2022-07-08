package com.easybuy.dao.impl;

import com.easybuy.dao.AddressDao;
import com.easybuy.entity.Address;
import com.easybuy.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {

@Override
public List<Address> findAddressListById(int userId) {
    String sql = " select * from easybuy_user_address where userId=?";
    Object[] params = {userId};
    ResultSet query = JDBCUtil.query(sql, params);
    try {
        List<Address> addressList = new ArrayList<>();
        while (query.next()) {
            Address address = new Address();
            address.setAddress(query.getString("address"));
            address.setUserId(query.getInt("userId"));
            address.setCreatTime(query.getDate("createTime"));
            address.setRemark(query.getString("remark"));
            address.setId(query.getInt("id"));
            addressList.add(address);
        }return  addressList;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    @Override
    public Address findById(int id) {
        String sql = "select * from easybuy_user_address where id = ?";
        Object[] params = {id};
        ResultSet query = JDBCUtil.query(sql, params);
        try {
            while (query.next()) {
                Address address = new Address();
                address.setAddress(query.getString("address"));
                address.setUserId(query.getInt("userId"));
                address.setCreatTime(query.getDate("createTime"));
                address.setRemark(query.getString("remark"));
                address.setId(query.getInt("id"));
                return address;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addAddress(Address address) {
        String sql = "insert into easybuy_user_address(userId,address,remark) value (?,?,?)";
        Object[] params = {address.getUserId(),address.getAddress(),address.getRemark()};
        int update = JDBCUtil.update(sql, params);
        if (update > 0) {
            return true;
        }
        return false;
    }
}
