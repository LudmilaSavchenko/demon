package com.example.demon.controller;

import com.example.demon.domain.Customers;
import com.example.demon.service.CustomersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersController {

    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/customers")
    public List<String> getCustomers(){
        return customersService.findAll().stream()
                .map(Customers::getFirstName)
                .toList();
    }
}
