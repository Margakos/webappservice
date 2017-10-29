package com.regeneration.springboot.servicewebapp.services;

import com.regeneration.springboot.servicewebapp.exceptions.InvalidCredentialsException;
import com.regeneration.springboot.servicewebapp.model.Repair;
import com.regeneration.springboot.servicewebapp.model.User;
import com.regeneration.springboot.servicewebapp.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RepairServiceImpl implements RepairService{



    @Autowired
    RepairRepository repairRepository;


    @Override
    public List<Repair> findById(Long id){
        return repairRepository.findById(id);
    }

    @Override
    public void register(Repair repair) throws Exception {
        repairRepository.save(repair);
    }

    @Override
    public void update(Repair repair) throws Exception {
        repairRepository.save(repair);
    }

    @Override
    public void deleteRepair(Long input) throws Exception {
        repairRepository.delete(input);
    }

    @Override
    public List<Repair> findAllRepairs() throws Exception {
        List<Repair> myRepairs=new ArrayList();

           repairRepository.findAll().forEach(myRepairs::add);

           return myRepairs;
    }

    @Override
    public List<Repair> findByArriveDateLessThanOrderByArriveDateAsc(LocalDateTime day) throws Exception {
        return repairRepository.findByArriveDateLessThanOrderByArriveDateAsc(day);
    }

    @Override
    public List<Repair> findByArriveDateBetweenOrderByArriveDateAsc(LocalDateTime day1, LocalDateTime day2) throws Exception {
        return repairRepository.findByArriveDateBetweenOrderByArriveDateAsc(day1,day2);
    }

    @Override
    public List<Repair> findAll(){
        return repairRepository.findAll();
    }

    @Override
    public List<Repair> findAllByUserId(Long userId) {
        return repairRepository.findAllByUserId(userId);
    }
}
