package com.example.demo.ct.service;

import java.util.List;

import com.example.demo.ct.entity.Customer;
import com.example.demo.ct.request.CustomerRequest;

public interface CustomerService {

	Customer createCustomer(CustomerRequest customerRequest, String token);

	List<Customer> getCustomerList(String token);

	void deleteCustomer(String uuid, String token);

	Customer updateCustomer(String uuid, CustomerRequest customerRequest, String token);

}
