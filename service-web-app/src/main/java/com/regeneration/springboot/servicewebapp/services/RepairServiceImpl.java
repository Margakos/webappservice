package com.regeneration.springboot.servicewebapp.services;

import com.regeneration.springboot.servicewebapp.exceptions.InvalidCredentialsException;
import com.regeneration.springboot.servicewebapp.model.Repair;
import com.regeneration.springboot.servicewebapp.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RepairServiceImpl implements RepairService{



    @Autowired
    RepairRepository repairRepository;


    @Override
    public void register(Repair repair) throws Exception {
        repairRepository.save(repair);
    }
}
