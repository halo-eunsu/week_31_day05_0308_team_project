package com.nhnacademy.shoppingmall.entity.address;

import com.nhnacademy.shoppingmall.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;

    @Override
    public void createAddress(Address address) {
        repository.save(address);
    }

    @Override
    public void deleteAddress(int addressId) {
        repository.deleteById(addressId);
    }

    @Override
    public void modifyAddress(int addressId, String address1, String address2) {
        Address address = repository.findById(addressId).get();
        address.setAddress1(address1);
        address.setAddress2(address2);
        repository.saveAndFlush(address);
    }

    @Override
    public List<Address> getAddresses(User user) {
        return repository.findAllByUser(user);
    }
}
