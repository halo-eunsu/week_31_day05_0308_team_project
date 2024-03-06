package com.nhnacademy.shoppingmall.entity.address;

import com.nhnacademy.shoppingmall.entity.user.User;

import java.util.List;

public interface AddressService {
    void createAddress(Address address);
    void deleteAddress(int addressId);
    void modifyAddress(int addressId, String address1, String address2);
    List<Address> getAddresses(User user);
}
