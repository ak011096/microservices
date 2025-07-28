package com.example.address_service.controller;

import com.example.address_service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;
    @GetMapping("/address")
    public String sayHello(){

        return "Valasaravakkam, chennai-84";
    }

    @GetMapping("/address/{empId}")
    public ResponseEntity getAddressByEmployeeId(@PathVariable Long empId){
       return ResponseEntity.status(200).body(addressService.getAddressByEmployeeId(empId));
    }
}
