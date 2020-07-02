package com.example.booking_system.controllers;

import com.example.booking_system.models.Customer;
import com.example.booking_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomersByCourseName(
            @RequestParam(name = "courseName", required = false) String courseName,
            @RequestParam(name = "town", required = false) String town
    )
    {
        if (town != null && courseName != null) {
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseName(town, courseName), HttpStatus.OK);
        }
        if (courseName != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}
