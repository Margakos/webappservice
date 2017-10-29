package com.regeneration.springboot.servicewebapp.repositories;

import com.regeneration.springboot.servicewebapp.model.Repair;
import com.regeneration.springboot.servicewebapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface RepairRepository extends CrudRepository<Repair,Long> {

  List<Repair> findByArriveDateLessThanOrderByArriveDateAsc(LocalDateTime day) throws Exception;
  List<Repair> findByArriveDateBetweenOrderByArriveDateAsc(LocalDateTime day1,LocalDateTime day2) throws Exception;
  List<Repair> findAll();
  List<Repair> findAllByUserId(Long userId);
  List<Repair> findById(Long id);
}
