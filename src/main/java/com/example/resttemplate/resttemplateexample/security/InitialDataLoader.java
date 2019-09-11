/*
package com.example.resttemplate.resttemplateexample.security;

import com.example.resttemplate.resttemplateexample.dao.PrivilegeDAO;
import com.example.resttemplate.resttemplateexample.dao.RoleDAO;
import com.example.resttemplate.resttemplateexample.dao.UserDAO;
import com.example.resttemplate.resttemplateexample.entity.ApplicationUser;
import com.example.resttemplate.resttemplateexample.entity.Privilege;
import com.example.resttemplate.resttemplateexample.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

*/
/**
 * @author Ramazan Karagöz
 * @date 9/11/2019
 *//*

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    private final UserDAO userDAO;

    private final RoleDAO roleDAO;

    private final PrivilegeDAO privilegeDAO;

    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public InitialDataLoader(UserDAO userDAO, RoleDAO roleDAO, PrivilegeDAO privilegeDAO, BCryptPasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.privilegeDAO = privilegeDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (alreadySetup)
            return;

        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);

        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = roleDAO.findByRoleName("ROLE_ADMIN");

        ApplicationUser applicationUser = new ApplicationUser();

        applicationUser.setFirstName("Ramazan");
        applicationUser.setLastName("Karagöz");
        applicationUser.setUsername(40516901118L);
        applicationUser.setPassword(passwordEncoder.encode("123123"));
        applicationUser.setEnabled(true);
        applicationUser.setRoles(Arrays.asList(adminRole));
        userDAO.save(applicationUser);

        alreadySetup = true;


    }

    @Transactional
    public Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeDAO.findByPrivilegeName(name);

        if (privilege == null) {
            privilege = new Privilege();
            privilege.setPrivilegeName(name);
            privilegeDAO.save(privilege);
        }

        return privilege;
    }

    public Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
        Role role = roleDAO.findByRoleName(name);

        if (role == null) {
            role = new Role();
            role.setRoleName(name);
            role.setPrivileges(privileges);
            roleDAO.save(role);
        }

        return role;
    }
}
*/
