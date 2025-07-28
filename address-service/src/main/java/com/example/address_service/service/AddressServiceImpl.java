package com.example.address_service.service;

import com.example.address_service.dto.AddressResponse;
import com.example.address_service.entity.Address;
import com.example.address_service.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepo addressRepo;
    @Override
    public AddressResponse getAddressByEmployeeId(Long id) {
        Address address= addressRepo.findByEmployeeId(id);

        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setLane1(address.getLane1());
        addressResponse.setLane2(address.getLane2());
        addressResponse.setCity(address.getCity());
        addressResponse.setState(address.getState());
        addressResponse.setPincode(address.getPincode());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setEmployeeId(address.getEmployeeId());
        return addressResponse;
    }
}
