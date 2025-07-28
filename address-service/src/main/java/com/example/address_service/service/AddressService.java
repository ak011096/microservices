package com.example.address_service.service;

import com.example.address_service.dto.AddressResponse;
import com.example.address_service.entity.Address;
import org.springframework.data.jpa.repository.NativeQuery;

public interface AddressService {


    AddressResponse getAddressByEmployeeId(Long id);
}
