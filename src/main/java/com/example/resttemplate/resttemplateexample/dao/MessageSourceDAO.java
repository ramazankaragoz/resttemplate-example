package com.example.resttemplate.resttemplateexample.dao;

import com.example.resttemplate.resttemplateexample.entity.MessageSourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ramazan Karagöz
 * @date 9/5/2019
 */
@Repository
public interface MessageSourceDAO extends JpaRepository<MessageSourceEntity,Long> {

    MessageSourceEntity findByMessageKeyAndLocale(String messageKey,String locale);
}
