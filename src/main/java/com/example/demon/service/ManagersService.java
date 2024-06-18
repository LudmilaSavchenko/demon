package com.example.demon.service;

import com.example.demon.domain.Managers;
import com.example.demon.repository.ManagersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagersService {
    private final static String MOSCOW_TIME_ZONE = "1";
    private final ManagersRepository managersRepository;

    public ManagersService(ManagersRepository managersRepository) {
        this.managersRepository = managersRepository;
    }

    public List<Managers>  findAll() {
        return managersRepository.findAll();
    }

    public List<String> getManagerByTimeZone(String timeZone){
        List<Managers> managersList = managersRepository.findTop1ByTimeZone(timeZone);
        if (managersList.isEmpty()){
            managersList = managersRepository.findTop1ByTimeZone(MOSCOW_TIME_ZONE);
        }

        if (managersList.isEmpty()){
            return List.of("Нет менеджера по вашим критериям");
        }

        return managersList.stream()
                .map(Managers::getFirstNameRu)
                .toList();
    }
}
