package com.example.demon.repository;

import com.example.demon.domain.Managers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ManagersRepository extends JpaRepository<Managers, Long> {
    List<Managers> findTop1ByTimeZone(String timeZone);
}