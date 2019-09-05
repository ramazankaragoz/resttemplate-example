package com.example.resttemplate.resttemplateexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Ramazan Karagöz
 * @date 9/5/2019
 */
@Entity
@Table(name = "message_source")
public class MessageSourceEntity extends BaseEntity {

    @Column(name = "locale")
    private String locale;

    @Column(name = "message_key")
    private String messageKey;

    @Column(name = "message_description")
    private String description;


    public MessageSourceEntity() {
    }

    public MessageSourceEntity(String locale, String messageKey, String description) {
        this.locale = locale;
        this.messageKey = messageKey;
        this.description = description;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
