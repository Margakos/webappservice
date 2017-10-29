package com.regeneration.springboot.servicewebapp.repositories;

import com.regeneration.springboot.servicewebapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    List<User> findAll();

    User save(User user);

    User findByEmailOrAfm(String email, String afm);

}
