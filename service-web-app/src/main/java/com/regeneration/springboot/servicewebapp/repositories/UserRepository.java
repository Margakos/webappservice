package com.regeneration.springboot.servicewebapp.repositories;

import com.regeneration.springboot.servicewebapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {


    List<User> findByFirstName(String firstName);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    List<User> findByLastName(String lastname);

    List<User> findAll();

    User save(User user);

}
