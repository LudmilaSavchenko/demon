package com.example.demon.service;

import com.example.demon.domain.Customers;
import com.example.demon.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {
    private final CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customers> findTop10(String fistName){
        return customersRepository.findTop10ByFirstName(fistName);
    }

    public List<Customers> findAll(){
        return customersRepository.findAll();
    }
}
