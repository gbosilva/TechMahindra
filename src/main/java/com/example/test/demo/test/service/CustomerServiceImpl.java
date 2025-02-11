package com.example.test.demo.test.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.demo.test.entity.Customer;
import com.example.test.demo.test.repository.CustomerRepository;

/**
 * Class to controll the business implementation to call method from the repository layer.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {

        LocalDateTime currentDateTime = LocalDateTime.now();
        UUID uuid = UUID.randomUUID();

        customer.setCreatedAt(currentDateTime);
        customer.setCreatedBy( String.valueOf(uuid) );
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByCustomerId(Integer id) {
        return customerRepository.findByCustomerId(id);
    }
}
