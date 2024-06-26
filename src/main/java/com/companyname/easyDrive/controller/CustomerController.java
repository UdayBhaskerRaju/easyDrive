package com.companyname.easyDrive.controller;

import com.companyname.easyDrive.Dtos.Request.CustomerRequest;
import com.companyname.easyDrive.Dtos.Response.CustomerResponse;
import com.companyname.easyDrive.Enum.Gender;
import com.companyname.easyDrive.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor //This annotation will create constructor for final variables
public class CustomerController {

    //Injecting Bean like this is a good practice instead of using @autowired
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customer = customerService.addCustomer(customerRequest);
        return new ResponseEntity(customer, HttpStatus.OK);
    }
    @GetMapping("/email/{email}")
    public CustomerResponse getCustomer(@PathVariable("email") String email){
        return customerService.getCustomer(email);
    }
    @GetMapping("/gender/{gender}/age/{age}")
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThen(@PathVariable("gender") Gender gender,
                                                                  @PathVariable("age") int age){
        return customerService.getAllByGenderAndAgeGreaterThan(gender,age);
    }
}
