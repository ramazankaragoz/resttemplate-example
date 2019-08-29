package com.example.resttemplate.resttemplateexample.service;

import com.example.resttemplate.resttemplateexample.dao.UserDAO;
import com.example.resttemplate.resttemplateexample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ramazan Karagöz
 * @date 8/29/2019
 */

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public User save(User user){
        return userDAO.save(user);
    }

    @Transactional
    public User update(User user){
        return userDAO.save(user);
    }
}
