package com.regeneration.springboot.servicewebapp.repositories;

import com.regeneration.springboot.servicewebapp.model.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public interface RepairRepository extends CrudRepository<Repair,Long> {


}
