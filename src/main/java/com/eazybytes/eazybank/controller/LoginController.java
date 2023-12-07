package com.eazybytes.eazybank.controller;

import com.eazybytes.eazybank.model.Customer;
import com.eazybytes.eazybank.repositry.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer SavedCustomer;
        ResponseEntity response;

        SavedCustomer = customerRepository.save(customer);
        if(SavedCustomer.getId() > 0){
            response = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Given User details are saved successfully");
        } else {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred");
        }

        return response;
    }
}
