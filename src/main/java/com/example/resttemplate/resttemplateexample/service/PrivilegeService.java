package com.example.resttemplate.resttemplateexample.service;

import com.example.resttemplate.resttemplateexample.dao.PrivilegeDAO;
import org.springframework.stereotype.Service;

/**
 * @author Ramazan Karagöz
 * @date 9/11/2019
 */
@Service
public class PrivilegeService {

    private final PrivilegeDAO privilegeDAO;

    public PrivilegeService(PrivilegeDAO privilegeDAO) {
        this.privilegeDAO = privilegeDAO;
    }
}
