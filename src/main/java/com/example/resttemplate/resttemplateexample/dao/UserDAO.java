package com.example.resttemplate.resttemplateexample.dao;

import com.example.resttemplate.resttemplateexample.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ramazan Karagöz
 * @date 8/29/2019
 */

@Repository
public interface UserDAO extends JpaRepository<ApplicationUser,Long> {

    ApplicationUser findByUsername(Long username);

    <T> T getByFirstName(String firstName, Class<T> type);

}
