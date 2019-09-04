package com.example.resttemplate.resttemplateexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Ramazan Karagöz
 * @date 9/4/2019
 */
@Entity
@Table(name = "person")
public class Person extends BaseEntity {

    @Column(name = "first_name",length = 15,nullable = false)
    private String firstName;
    @Column(name = "last_name",length = 15,nullable = false)
    private String lastName;
    @Column(name = "age",length = 2,nullable = false)
    private Integer age;

    public Person() {
    }

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
