package com.example.test.demo.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.test.entity.Customer;
import com.example.test.demo.test.service.CustomerService;

/**
 * Class controller to show the endpoint to consume the data
 */
@RestController //convierte la clase en un controlador REST.
@RequestMapping("/customers")   //define el endpoint base.
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    /**
     * Method to save a customer in db
     * @param customer
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){

        try{
            Customer cust = customerService.saveCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(cust);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al guardar el usuario: " + e.getMessage());
        }
    }
    /**
     * Method to get a customer from the db.
     * @PathVariable es una anotacion que se usa para indicar que la url lleva un parametro obligatorio como parte de la url
     * @RequestParam es otra anotacion que sirve para pedir parametros en la url pero estos van despues del signo de
     * interrogacion
     * @QueryParam y @PathParam
     * @param name
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerByName(@PathVariable Integer id){
        
        try{
            Customer cust = customerService.findByCustomerId(id);
            return ResponseEntity.status(HttpStatus.OK).body(cust);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al buscar usuario: "+e.getMessage());
        }
    }
}
