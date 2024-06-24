package com.example.demon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demon.domain.Managers;
import com.example.demon.repository.ManagersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagersService {
    private static final Logger logger = LoggerFactory.getLogger(ManagersService.class);

    private static final String MOSCOW_TIME_ZONE = "GMT+3";
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

    public List<String> getManagerName(String firstName, String lastName) {
        logger.info("function getManagerName, firstName = {} ,  lastName = {}", firstName, lastName);
        List<String> result;
        List<Managers> managersList = managersRepository.findByFirstNameRuAndLastNameRu(firstName, lastName);

        if (managersList.isEmpty()) {

            result = List.of("Нет менеджера по вашим критериям");
            logger.info("function getManagerName, result = {}", String.join(" ", result));
            return result;
        }

        result = managersList.stream()
                .map(Managers::getFirstNameRu)
                .toList();
        logger.info("function getManagerName, result = {}", String.join(" ", result));
        return result;
    }
}
