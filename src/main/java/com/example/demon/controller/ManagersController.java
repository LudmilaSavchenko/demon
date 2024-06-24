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

    @GetMapping()
    public List<String> getManagers(){
        return managersService.findAll().stream()
                .map(Managers::getFirstNameRu)
                .toList();
    }

    @GetMapping("/findManagersByName")
    public List<String> getCustomersByName(String fistName, String lastName){
        return managersService.getManagerName(fistName, lastName);
    }
}
