package com.easybuy.service.impl;

import com.easybuy.dao.AddressDao;
import com.easybuy.dao.impl.AddressDaoImpl;
import com.easybuy.entity.Address;
import com.easybuy.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao = new AddressDaoImpl();
//    @Override
//    public Address findByUserid(int userId) {
//        return addressDao.findByUserid(userId);
//    }

    @Override
    public List<Address> findAddressListById(int userId) {
        return addressDao.findAddressListById(userId);
    }

    @Override
    public Address findById(int id) {
        return addressDao.findById(id);
    }

    @Override
    public boolean addAddress(Address address) {
        return addressDao.addAddress(address);
    }
}
