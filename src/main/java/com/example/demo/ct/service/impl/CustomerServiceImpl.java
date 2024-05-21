package com.example.demo.ct.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ct.entity.Customer;
import com.example.demo.ct.repository.CustomerRepository;
import com.example.demo.ct.request.CustomerRequest;
import com.example.demo.ct.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(CustomerRequest customerRequest, String token) {
	 Customer customer = new Customer();
     customer.setFirstName(customerRequest.getFirstName());
     customer.setLastName(customerRequest.getLastName());
     customer.setStreet(customerRequest.getStreet());
     customer.setAddress(customerRequest.getAddress());
     customer.setCity(customerRequest.getCity());
     customer.setState(customerRequest.getState());
     customer.setEmail(customerRequest.getEmail());
     customer.setPhone(customerRequest.getPhone());

     return customerRepository.save(customer);
 }

	public List<Customer> getCustomerList(String token) {
		/**
		 * Get customer list logic (retrieve from the database) Assuming the token is
		 * used for authentication, you might extract user details from the token if
		 * needed
		 * 
		 */
		return customerRepository.findAll();
	}

 public void deleteCustomer(String uuid, String token) {
     // Delete customer logic (validate request, delete from the database)
     // Assuming the token is used for authentication, you might extract user details from the token if needed

     Optional<Customer> optionalCustomer = customerRepository.findById(Long.parseLong(uuid));
     if (optionalCustomer.isPresent()) {
         Customer customer = optionalCustomer.get();
         customerRepository.delete(customer);
     } else {
         // Handle case where customer with given UUID is not found
         throw new RuntimeException("Customer with UUID " + uuid + " not found");
     }
 }

 public Customer updateCustomer(String uuid, CustomerRequest customerRequest, String token) {
     // Update customer logic (validate request, update in the database)
     // Assuming the token is used for authentication, you might extract user details from the token if needed

     Optional<Customer> optionalCustomer = customerRepository.findById(Long.parseLong(uuid));
     if (optionalCustomer.isPresent()) {
         Customer customer = optionalCustomer.get();
         customer.setFirstName(customerRequest.getFirstName());
         customer.setLastName(customerRequest.getLastName());
         customer.setStreet(customerRequest.getStreet());
         customer.setAddress(customerRequest.getAddress());
         customer.setCity(customerRequest.getCity());
         customer.setState(customerRequest.getState());
         customer.setEmail(customerRequest.getEmail());
         customer.setPhone(customerRequest.getPhone());

        return customerRepository.save(customer);
     } else {
         // Handle case where customer with given UUID is not found
         throw new RuntimeException("Customer with UUID " + uuid + " not found");
     }
 }

}
