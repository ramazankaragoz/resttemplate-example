package com.example.resttemplate.resttemplateexample.service;

import com.example.resttemplate.resttemplateexample.dao.PersonDAO;
import com.example.resttemplate.resttemplateexample.dto.PersonDTO;
import com.example.resttemplate.resttemplateexample.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author Ramazan Karagöz
 * @date 9/4/2019
 */


@Service
public class PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Transactional
    public PersonDTO save(PersonDTO personDTO){

        return toDTO(personDAO.save(toEntity(personDTO)));

    }


    public Person toEntity(PersonDTO personDTO){


        if (personDTO==null){
           return new Person();
        }

        Person person=new Person();

        person.setId(personDTO.getId());
        person.setAge(personDTO.getAge());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setCreateDate(personDTO.getCreateDate());
        person.setUpdateDate(personDTO.getUpdateDate());
        person.setDurum(personDTO.getDurum());
        person.setCreatedBy(personDTO.getCreatedBy());
        person.setLastModifiedBy(personDTO.getLastModifiedBy());

        return person;

    }

    public PersonDTO toDTO(Person person){

        if (person==null){
            return new PersonDTO();
        }

        PersonDTO personDTO=new PersonDTO();

        personDTO.setId(person.getId());
        personDTO.setAge(person.getAge());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setCreateDate(person.getCreateDate());
        personDTO.setUpdateDate(person.getUpdateDate());
        personDTO.setDurum(person.getDurum());
        personDTO.setCreatedBy(person.getCreatedBy());
        personDTO.setLastModifiedBy(person.getLastModifiedBy());

        return personDTO;

    }
}
