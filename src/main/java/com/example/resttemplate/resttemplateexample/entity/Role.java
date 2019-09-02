package com.example.resttemplate.resttemplateexample.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * @author Ramazan Karagöz
 * @date 9/2/2019
 */

public class Role {

    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Collection<ApplicationUser> applicationUsers;

    @ManyToMany
    @JoinTable(name = "privileges_roles",
            joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id",referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public Role() {
    }

    public Role(String roleName, Collection<ApplicationUser> applicationUsers, Collection<Privilege> privileges) {
        this.roleName = roleName;
        this.applicationUsers = applicationUsers;
        this.privileges = privileges;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<ApplicationUser> getApplicationUsers() {
        return applicationUsers;
    }

    public void setApplicationUsers(Collection<ApplicationUser> applicationUsers) {
        this.applicationUsers = applicationUsers;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }


}
