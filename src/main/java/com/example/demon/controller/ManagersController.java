package com.example.demon.controller;

import com.example.demon.domain.Managers;
import com.example.demon.service.ManagersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

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
    public List<String> getManagerByName(@RequestParam String firstName,
                                         @RequestParam String lastName){
        return managersService.getManagerName(firstName, lastName);
    }

}
