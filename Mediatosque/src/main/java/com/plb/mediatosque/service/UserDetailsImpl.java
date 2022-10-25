package com.plb.mediatosque.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.plb.mediatosque.entity.User;

public class UserDetailsImpl implements UserDetails {
    
    private static final long serialVersionUID = 1L;
    
    private User user;
    
    public UserDetailsImpl(User user) {
        this.user = user;
    }
    
    @Override
    public String getUsername() {
        return user.getLogin();
    }
    
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<>();
//        for (final Privilege privilege : user.getPrivileges()) {
//            authorities.add(new SimpleGrantedAuthority(privilege.getName()));
//        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public User getUser() {
        return user;
    }
}
