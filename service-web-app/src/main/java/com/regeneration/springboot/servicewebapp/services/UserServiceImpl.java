package com.regeneration.springboot.servicewebapp.services;

import com.regeneration.springboot.servicewebapp.exceptions.InvalidCredentialsException;
import com.regeneration.springboot.servicewebapp.model.User;
import com.regeneration.springboot.servicewebapp.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {



    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
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

    @Override
    public void update(User user) throws Exception {
        userRepository.save(user);
    }

    @Override
    public User findByEmailOrAfm(String input) {
        return userRepository.findByEmailOrAfm(input, input);
    }

    @Override
    public List<User> searchAll() {

        List<User> users=new ArrayList();

         userRepository.findAll().forEach(users::add);
         return users;
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }


}
