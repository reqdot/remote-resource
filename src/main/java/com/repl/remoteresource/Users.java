package com.repl.remoteresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Users implements UserDetailsService {

    @Autowired
    private ResourceOwnerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResourceOwner resourceOwner = repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException());
        return new User(resourceOwner.getUsername(),
                resourceOwner.getPassword(), new ArrayList<>());
    }
}
