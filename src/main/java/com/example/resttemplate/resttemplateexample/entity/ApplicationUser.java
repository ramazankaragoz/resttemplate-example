package com.example.resttemplate.resttemplateexample.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Ramazan Karagöz
 * @date 8/29/2019
 */

@Entity
@Table(name = "usr_user")
public class ApplicationUser extends BaseEntity {

    @Column(name = "username",nullable = false)
    private Long username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "token_expired")
    private Boolean tokenExpired;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Collection<Role> roles;

    public ApplicationUser() {
    }

    public ApplicationUser(Long username, String password, String firstName, String lastName, Boolean enabled, Boolean tokenExpired, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.tokenExpired = tokenExpired;
        this.roles = roles;
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(Boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }


}
