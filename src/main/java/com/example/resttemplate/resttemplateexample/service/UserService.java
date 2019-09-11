package com.example.resttemplate.resttemplateexample.service;

import com.example.resttemplate.resttemplateexample.dao.UserDAO;
import com.example.resttemplate.resttemplateexample.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public ApplicationUser save(ApplicationUser user){
        return userDAO.save(user);
    }

    @Transactional
    public ApplicationUser update(ApplicationUser user){
        return userDAO.save(user);
    }

    @Transactional
    public void delete(ApplicationUser user){
        userDAO.delete(user);
    }

    @Transactional
    public List<ApplicationUser> findAll(){
        return userDAO.findAll();
    }
}
