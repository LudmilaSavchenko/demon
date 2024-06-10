package com.example.demon.service;

import com.example.demon.domain.Managers;
import com.example.demon.repository.ManagersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagersService {
    private final String MOSCOW_TIME_ZONE = "GMT+3";
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

    public Managers findTop1ByTimeZone(String timeZone) {
        return managersRepository.findTop1ByTimeZone(timeZone);
    }

    public Object getManagerByTimeZone(String timeZone){
        Managers manager = findTop1ByTimeZone(timeZone);
        if (manager == null ){
            manager = findTop1ByTimeZone(MOSCOW_TIME_ZONE);
            return (manager != null) ? manager : "Менеджер не найден";
        }
        else{
            return manager;
        }
    }

    public boolean isExistManagerByFirstNameRuAndLastNameRu(String fistName, String lastName){
        List<Managers> managersList;
        managersList = findByFirstNameRuAndLastNameRu(fistName,lastName);
        if (managersList != null) {
            return true;
        }
        else {
            return false;
        }
    }
    public List<Managers> findByFirstNameRuAndLastNameRu(String fistName, String lastName){
        return  managersRepository.findByFirstNameRuAndLastNameRu(fistName,lastName);
    }
}
