package com.example.resttemplate.resttemplateexample.dao;

import com.example.resttemplate.resttemplateexample.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ramazan Karagöz
 * @date 9/4/2019
 */
@Repository
public interface PrivilegeDAO extends JpaRepository<Privilege,Long> {
}
