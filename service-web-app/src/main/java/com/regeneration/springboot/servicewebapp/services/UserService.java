package com.regeneration.springboot.servicewebapp.services;

import com.regeneration.springboot.servicewebapp.model.Repair;
import com.regeneration.springboot.servicewebapp.model.User;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    User login(String email, String password) throws AuthenticationException;

    void logout(String email) throws Exception;

    void register(User user) throws Exception;

    void update(User user) throws Exception;

    List<User> searchAll();

    void deleteUser(Long input) throws Exception;
      User findByEmailOrAfm(String input);
}
