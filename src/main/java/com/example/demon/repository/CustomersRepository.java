package com.example.demon.repository;

import com.example.demon.domain.Customers;
import com.example.demon.domain.Managers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
    List<Customers> findAll();
    List<Customers> findTop10ByFirstName(String fistName);
}