package com.example.test.demo.test.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.demo.test.dto.CustomerDTO;
import com.example.test.demo.test.entity.Customer;
import com.example.test.demo.test.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class to controll the business implementation to call method from the repository layer.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Metodo que recibe un DTO y lo convierte a entity para ser enviado al repository
     * y cuando el repository regresa el entity se convierte a dto para ser mostrado en la respuesta
     */
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {

        logger.info("*** Iniciando metodo saveCustomer en CustomerServiceImpl.class");
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        UUID uuid = UUID.randomUUID();

        customerDTO.setCreatedAt(currentDateTime);
        customerDTO.setCreatedBy( String.valueOf(uuid) );

        ModelMapper modelMapper = new ModelMapper();
        Customer cust = modelMapper.map(customerDTO, Customer.class);

        cust = customerRepository.save(cust);

        customerDTO = modelMapper.map(cust, CustomerDTO.class);

        logger.info("***Terminanado metodo saveCustomer en CustomerServiceImpl.class");
        return customerDTO;
    }

    /**
     * Metodo que sirve para buscar un Customer por su id, devuelve un dto
     */
    @Override
    public CustomerDTO findByCustomerId(Integer id) {

        ModelMapper modelMapper = new ModelMapper();
        Customer cust = customerRepository.findByCustomerId(id);
        CustomerDTO  customerDTO = modelMapper.map(cust, CustomerDTO.class);

        return customerDTO;
    }
}
