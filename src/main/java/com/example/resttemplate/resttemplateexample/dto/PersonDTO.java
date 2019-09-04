package com.example.resttemplate.resttemplateexample.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Ramazan Karagöz
 * @date 9/4/2019
 */

public class PersonDTO extends BaseDTO{

    @NotNull(message = "{person.firstname.notnull}")
    @Size(min = 2,max = 15,message = "{person.firstname.size}")
    private String firstName;
    @NotNull
    @Size(min = 3,max = 18)
    private String lastName;
    private Integer age;

    public PersonDTO() {
    }

    public PersonDTO(String firstName, String lastName, Integer age) {
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
