package com.regeneration.springboot.servicewebapp.services;

import com.regeneration.springboot.servicewebapp.model.User;
import org.springframework.security.core.AuthenticationException;

public interface AccountService {

    User login(String email, String password) throws AuthenticationException;

    void logout(String email) throws Exception;

    void register(User user) throws Exception;

}
