package com.example.employee_service.controller;

import com.example.employee_service.dto.AddressResponse;
import com.example.employee_service.dto.EmployeeResponse;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class EmployeeController {

    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private WebClient webClient;

    @GetMapping("/Employee")
    public String getEmployeeDetails(){
        String empAddress=restTemplate.getForObject("http://address-service/address",String.class);
        return "Hello Ajith,  "+empAddress;

//        String empAddress= webClient.get().uri("localhost:8080/address").retrieve().bodyToMono(String.class).block();
//        return "Hello Ajith,  "+empAddress;
    }


    @GetMapping("/getEmployees/{id}")
    public ResponseEntity getEmployeeDetails(@PathVariable Long id){
        AddressResponse addressResponse = new AddressResponse();
        EmployeeResponse empDetails = employeeService.getEmployeeDetails(id);
        addressResponse = restTemplate.getForObject("http://address-service/address/{id}", AddressResponse.class,id);
//       ServiceInstance serviceInstance= loadBalancerClient.choose("address-service");
//       String uri=serviceInstance.getUri().toString();
 //       addressResponse =  webClient.get().uri("http://address-service/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();
        empDetails.setAddressResponse(addressResponse);
        return new ResponseEntity(empDetails,HttpStatus.OK);
    }
}
