package com.example.test.demo.test.service;

import com.example.test.demo.test.entity.Customer;

/**
 * Interface with astract methods which will interact with the implementation class
 */
public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer findByCustomerId(Integer id);
}
