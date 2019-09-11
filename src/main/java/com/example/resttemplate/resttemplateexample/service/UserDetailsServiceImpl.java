package com.example.resttemplate.resttemplateexample.service;

import com.example.resttemplate.resttemplateexample.dao.RoleDAO;
import com.example.resttemplate.resttemplateexample.dao.UserDAO;
import com.example.resttemplate.resttemplateexample.entity.ApplicationUser;
import com.example.resttemplate.resttemplateexample.entity.Privilege;
import com.example.resttemplate.resttemplateexample.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;

    @Autowired
    public UserDetailsServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApplicationUser user=userDAO.findByUsername(Long.valueOf(s));

        if (user==null){
            throw new UsernameNotFoundException(s+" berlitilen kullanıcı bulunamadı!!");
        }


        return new org.springframework.security.core.userdetails.User(user.getUsername().toString(),user.getPassword(), user.getEnabled(),
                true,
                true,
                true,
                getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles){
        return getGrantedAuthority(getPrivileges(roles));
    }


    private List<String> getPrivileges(Collection<Role> roles){

        List<String> privileges=new ArrayList<>();
        List<Privilege> privilegeList=new ArrayList<>();

        for (Role role:roles){
            privilegeList.addAll(role.getPrivileges());
        }

        for (Privilege privilege:privilegeList){
            privileges.add(privilege.getPrivilegeName());
        }

        return privileges;

    }


    private List<GrantedAuthority> getGrantedAuthority(List<String> privileges){
        List<GrantedAuthority> authorities=new ArrayList<>();

        for (String privilege:privileges){
            authorities.add(new SimpleGrantedAuthority(privilege));
        }

        return authorities;
    }
}
