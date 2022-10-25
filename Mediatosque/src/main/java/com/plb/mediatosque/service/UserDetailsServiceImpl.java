package com.plb.mediatosque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.plb.mediatosque.entity.User;
import com.plb.mediatosque.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
     private UserRepository userRepository;


    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if(user == null)
            throw new UsernameNotFoundException("Aucun utilisateur ne correspond à l'email" + login);
        return new UserDetailsImpl(user);
    }
}
