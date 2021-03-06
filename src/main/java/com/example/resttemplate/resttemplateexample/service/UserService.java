package com.example.resttemplate.resttemplateexample.service;

import com.example.resttemplate.resttemplateexample.dao.UserDAO;
import com.example.resttemplate.resttemplateexample.dao.UserFirstNameView;
import com.example.resttemplate.resttemplateexample.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Ramazan Karagöz
 * @date 8/29/2019
 */

@Service
public class UserService implements IUserService{

    private final UserDAO userDAO;
    private final IUserServiceProxy iUserServiceProxy;

    @Autowired
    public UserService(UserDAO userDAO, IUserServiceProxy iUserServiceProxy) {
        this.userDAO = userDAO;
        this.iUserServiceProxy = iUserServiceProxy;
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


    public List<String> getPreAuthorities(){

        Collection<? extends GrantedAuthority> grantedAuthorities= SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        List<String> authoritiyNames=new ArrayList<>();
        for (GrantedAuthority grantedAuthority:grantedAuthorities){
            authoritiyNames.add(grantedAuthority.getAuthority());
        }

        return authoritiyNames;
    }

    public void proxyProcess(){
        iUserServiceProxy.process();
    }

    @Override
    public String getFirstName(String firstName) {

        UserFirstNameView userFirstNameView=userDAO.getByFirstName(firstName,UserFirstNameView.class);

       return userFirstNameView.getFirstName();
    }

    @Override
    public ApplicationUser getByFirstName(String firstName) {
        return userDAO.getByFirstName(firstName,ApplicationUser.class);
    }
}
