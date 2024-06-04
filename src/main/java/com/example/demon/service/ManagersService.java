package com.example.demon.service;

import com.example.demon.domain.Customers;
import com.example.demon.domain.Managers;
import com.example.demon.repository.ManagersRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ManagersService {
    private final ManagersRepository managersRepository;

    public ManagersService(ManagersRepository managersRepository) {
        this.managersRepository = managersRepository;
    }

    public List<Managers>  findAll() {
        return managersRepository.findAll();
    }

    public List<Managers> findTop1ByFirstNameRu(String fistName) {
        return managersRepository.findTop1ByFirstNameRu(fistName);
    }
}
