package com.example.demon.repository;

import com.example.demon.domain.Customers;
import com.example.demon.domain.Managers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ManagersRepository extends JpaRepository<Managers, Long> {
    List<Managers> findAll();
    List<Managers> findTop1ByFirstNameRu(String fistName);
}