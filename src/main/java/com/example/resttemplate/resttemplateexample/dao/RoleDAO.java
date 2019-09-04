package com.example.resttemplate.resttemplateexample.dao;

import com.example.resttemplate.resttemplateexample.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ramazan Karagöz
 * @date 9/4/2019
 */
@Repository
public interface RoleDAO extends JpaRepository<Role,Long> {
}
