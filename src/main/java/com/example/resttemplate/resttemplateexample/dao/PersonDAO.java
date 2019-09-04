package com.example.resttemplate.resttemplateexample.dao;

import com.example.resttemplate.resttemplateexample.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ramazan Karagöz
 * @date 9/4/2019
 */

public interface PersonDAO extends JpaRepository<Person,Long> {
}
