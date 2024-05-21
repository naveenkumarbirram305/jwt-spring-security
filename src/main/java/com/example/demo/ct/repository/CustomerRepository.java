package com.example.demo.ct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ct.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
