package com.companyname.easyDrive.service;

import com.companyname.easyDrive.Dtos.Request.CustomerRequest;
import com.companyname.easyDrive.Dtos.Response.CustomerResponse;
import com.companyname.easyDrive.Enum.Gender;
import com.companyname.easyDrive.converters.CustomerTransformer;
import com.companyname.easyDrive.model.Customer;
import com.companyname.easyDrive.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor// This annotation will create constructor for final variables
public class CustomerService {

   private final CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }
    public CustomerResponse getCustomer(String email) {
        Customer savedCustomer = customerRepository.findByEmailId(email);
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.findAllByGenderAndAgeGreaterThen(gender,age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}


