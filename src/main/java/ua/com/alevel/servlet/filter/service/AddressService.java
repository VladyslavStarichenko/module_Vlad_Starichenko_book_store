package ua.com.alevel.servlet.filter.service;

import ua.com.alevel.servlet.dao.AddressDao;
import ua.com.alevel.servlet.models.Address;

import java.util.List;

public class AddressService {
    AddressDao addressDao = new AddressDao();
    public List<Address> retrieveAddresses() {
        return addressDao.getAllAddresses();
    }

    public void addAddress(Address address) {
        addressDao.createAddress(address.getAddressName(),address);
    }

    public void deleteAddress(String addressName) {

        addressDao.deleteAddress(addressName);
    }

    public void updateAddress(Address address){
        addressDao.updateAddress(address);
    }
}
