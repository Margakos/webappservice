package com.regeneration.springboot.servicewebapp.services;

import com.regeneration.springboot.servicewebapp.exceptions.InvalidCredentialsException;
import com.regeneration.springboot.servicewebapp.model.User;
import com.regeneration.springboot.servicewebapp.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {



    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);
    private Set<String> loggedInUsers = new HashSet<>();


    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) throws AuthenticationException {

        User retrievedUser = userRepository.findByEmailAndPassword(email, password);
        if (retrievedUser == null) {
            throw new InvalidCredentialsException("User not found!");
        }

        loggedInUsers.add(email);
        return retrievedUser;
    }

    @Override
    public void logout(String email) {
        loggedInUsers.remove(email);
    }

    @Override
    public void register(User user) throws Exception {
        userRepository.save(user);
        LOG.debug("User has been registered!");
    }

}
