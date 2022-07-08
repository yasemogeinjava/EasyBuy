package com.easybuy.dao;

import com.easybuy.entity.Address;

import java.util.List;

public interface AddressDao {

    List<Address> findAddressListById(int userId);

    Address findById(int id);

    boolean addAddress(Address address);
}
