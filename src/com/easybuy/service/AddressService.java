package com.easybuy.service;

import com.easybuy.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAddressListById(int userId);

    Address findById(int id);

    boolean addAddress(Address address);
}
