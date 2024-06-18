package com.example.demon.controller;

import com.example.demon.domain.Customers;
import com.example.demon.service.CustomersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/customers")
public class CustomersController {
    private final CustomersService customersService;
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }
    //private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);

    @GetMapping()
    public List<String> getCustomers(){
        //logger.info("Выполняется метод getCustomers");
        return customersService.findAll().stream()
                .map(Customers::getFirstName)
                .toList();
    }
}