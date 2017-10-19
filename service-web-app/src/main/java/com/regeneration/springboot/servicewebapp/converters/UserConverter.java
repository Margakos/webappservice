package com.regeneration.springboot.servicewebapp.converters;

import com.regeneration.springboot.servicewebapp.forms.CreateUser;
import com.regeneration.springboot.servicewebapp.model.User;

public class UserConverter {
    public static User buildUserObject(CreateUser createUser) {
        User user = new User();
        user.setFirstName(createUser.getFirstName());
        user.setPassword(createUser.getPassword());
        user.setEmail(createUser.getEmail());
        user.setAfm(createUser.getAfm());
        user.setLastName(createUser.getLastName());
        user.setAddress(createUser.getAddress());
        user.setPlates(createUser.getPlates());
        user.setRole(createUser.getRole());
        return user;
    }

}
