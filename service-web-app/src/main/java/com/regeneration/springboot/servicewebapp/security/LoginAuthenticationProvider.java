package com.regeneration.springboot.servicewebapp.security;

import com.regeneration.springboot.servicewebapp.model.User;
import com.regeneration.springboot.servicewebapp.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(LoginAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = (String) authentication.getCredentials();

        User retrievedUser = userService.login(email, password);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(retrievedUser.getRole());
        List rolesList = new ArrayList();
        rolesList.add(grantedAuthority);
        LOG.info("Loogged in user role " + retrievedUser.getRole());
        return new UsernamePasswordAuthenticationToken(email, password, rolesList);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
