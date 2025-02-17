package com.example.test.demo.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.demo.test.entity.Customer;

/**
 * Interface que sirve para interactuar con la base de datos
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    

    @SuppressWarnings("unchecked")
    Customer save(Customer customer);

    Customer findByCustomerId(Integer id);

}
