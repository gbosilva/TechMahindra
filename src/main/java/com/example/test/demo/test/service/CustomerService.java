package com.example.test.demo.test.service;

import com.example.test.demo.test.dto.CustomerDTO;

/**
 * Interface with astract methods which will interact with the implementation class
 */
public interface CustomerService {

    public CustomerDTO saveCustomer(CustomerDTO customerDTO);

    public CustomerDTO findByCustomerId(Integer id);
}
