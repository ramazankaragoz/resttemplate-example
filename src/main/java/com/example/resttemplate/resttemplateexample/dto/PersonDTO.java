package com.example.resttemplate.resttemplateexample.dto;

import com.example.resttemplate.resttemplateexample.config.util.*;

import javax.validation.constraints.Size;

/**
 * @author Ramazan Karagöz
 * @date 9/4/2019
 */

public class PersonDTO extends BaseDTO{

    @NotNull(message = "{person.firstname.notnull}",label = "ADI")
    @Size(min = 2,max = 15,message = "{person.firstname.size}")
    private String firstName;
    @NotNull
    @Size(min = 3,max = 18)
    private String lastName;
    private Integer age;

    @TcNo(message = "{person.tcno.valid}",label = "Kullanıcı Adı")
    private Long tcNo;

    @IpAddress(message = "{person.ipaddress}",label = "Ip Adresi")
    private String ipAddress;

    @EmailAddress(message = "{person.email.valid}",label = "Eposta Adresi")
    private String emailAddress;

    @PhoneNumber(message = "{person.phone.valid}",label = "Telefon Numarası")
    private String phoneNumber;

    public PersonDTO() {
    }

    public PersonDTO(String firstName, String lastName, Integer age,String ipAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ipAddress=ipAddress;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Long getTcNo() {
        return tcNo;
    }

    public void setTcNo(Long tcNo) {
        this.tcNo = tcNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
