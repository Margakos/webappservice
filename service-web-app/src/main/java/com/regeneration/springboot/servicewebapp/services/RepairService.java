package com.regeneration.springboot.servicewebapp.services;

import com.regeneration.springboot.servicewebapp.model.Repair;
import com.regeneration.springboot.servicewebapp.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface RepairService {


    void register(Repair repair) throws Exception;

    void update(Repair repair) throws Exception;
    void deleteRepair(Long input) throws Exception;
    List<Repair> findAllRepairs() throws Exception;
    List<Repair> findByArriveDateLessThanOrderByArriveDateAsc(LocalDateTime day) throws Exception;
    List<Repair> findByArriveDateBetweenOrderByArriveDateAsc(LocalDateTime day1,LocalDateTime day2) throws Exception;
    List<Repair> findAll();
    List<Repair> findAllByUserId(Long userId);
    List<Repair> findById(Long id);

}
