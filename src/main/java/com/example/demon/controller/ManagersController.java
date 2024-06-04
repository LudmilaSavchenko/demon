package com.example.demon.controller;

import com.example.demon.domain.Customers;
import com.example.demon.domain.Managers;
import com.example.demon.service.ManagersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(value = "/managers")
public class ManagersController {
    private final ManagersService managersService;

    public ManagersController(ManagersService managersService) {
        this.managersService = managersService;
    }

    @GetMapping("/managers")
    public List<String> getCustomers(){
        return managersService.findAll().stream()
                .map(Managers::getFirstNameRu)
                .toList();
    }
}
