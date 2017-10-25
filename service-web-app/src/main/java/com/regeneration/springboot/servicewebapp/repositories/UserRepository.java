package com.regeneration.springboot.servicewebapp.repositories;

import com.regeneration.springboot.servicewebapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    List<User> findByFirstName(String firstName);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    List<User> findByLastName(String lastname);

    List<User> findAll();

    User save(User user);

    User findByEmailOrAfm(String email, String afm);
}
