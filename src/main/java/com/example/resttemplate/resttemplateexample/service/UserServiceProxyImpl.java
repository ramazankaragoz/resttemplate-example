package com.example.resttemplate.resttemplateexample.service;

import com.example.resttemplate.resttemplateexample.dao.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceProxyImpl implements IUserServiceProxy{

    private final UserDAO userDAO;

    public UserServiceProxyImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void process() {
        System.out.println("proxy service loading..");
        userDAO.findAll().stream().forEach(System.out::println);
    }
}
