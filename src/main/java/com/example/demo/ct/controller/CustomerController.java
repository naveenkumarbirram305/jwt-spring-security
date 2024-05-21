package com.example.demo.ct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ct.entity.Customer;
import com.example.demo.ct.request.CustomerRequest;
import com.example.demo.ct.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerRequest customerRequest,
                                                 @RequestHeader("Authorization") String token) {
        customerService.createCustomer(customerRequest, token);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created");
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Customer>> getCustomerList(@RequestHeader("Authorization") String token) {
        List<Customer> customers = customerService.getCustomerList(token);
        return ResponseEntity.ok(customers);
    }

    @PatchMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam("uuid") String uuid,
                                                @RequestHeader("Authorization") String token) {
        customerService.deleteCustomer(uuid, token);
        return ResponseEntity.ok("Successfully deleted");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestParam("uuid") String uuid,
                                                 @RequestBody CustomerRequest customerRequest,
                                                 @RequestHeader("Authorization") String token) {
        customerService.updateCustomer(uuid, customerRequest, token);
        return ResponseEntity.ok("Successfully Updated");
    }

}
