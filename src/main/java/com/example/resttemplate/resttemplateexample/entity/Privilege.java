package com.example.resttemplate.resttemplateexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author Ramazan Karagöz
 * @date 9/2/2019
 */
@Entity
@Table(name = "privilege")
public class Privilege extends BaseEntity {

    @Column(name = "privilege_name")
    private String privilegeName;

    @ManyToMany(mappedBy = "privileges")
    Collection<Role> roles;

    public Privilege() {
    }

    public Privilege(String privilegeName, Collection<Role> roles) {
        this.privilegeName = privilegeName;
        this.roles = roles;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
