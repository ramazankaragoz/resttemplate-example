package com.example.resttemplate.resttemplateexample.service;

import com.example.resttemplate.resttemplateexample.dao.UserDAO;
import com.example.resttemplate.resttemplateexample.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public UserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApplicationUser user=userDAO.findByUsername(Long.valueOf(s));

        if (user==null){
            throw new UsernameNotFoundException(s+" berlitilen kullanı bulunamadı!!");
        }


        return new org.springframework.security.core.userdetails.User(user.getUsername().toString(),user.getPassword(), Collections.emptyList());
    }
}
