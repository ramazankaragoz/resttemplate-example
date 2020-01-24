package com.example.resttemplate.resttemplateexample.service;


import com.example.resttemplate.resttemplateexample.entity.ApplicationUser;

public interface IUserService {
    void proxyProcess();

    String getFirstName(String firstName);
    ApplicationUser getByFirstName(String firstName);
}
