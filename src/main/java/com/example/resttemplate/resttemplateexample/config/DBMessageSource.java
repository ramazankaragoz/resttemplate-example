package com.example.resttemplate.resttemplateexample.config;

import com.example.resttemplate.resttemplateexample.dao.MessageSourceDAO;
import com.example.resttemplate.resttemplateexample.entity.MessageSourceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author Ramazan Karagöz
 * @date 9/5/2019
 */
@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {

    private final MessageSourceDAO messageSourceDAO;
    private final String DEFAULT_LOCALE="tr";

    @Autowired
    public DBMessageSource(MessageSourceDAO messageSourceDAO) {
        this.messageSourceDAO = messageSourceDAO;
    }


    @Override
    protected MessageFormat resolveCode(String messageKey, Locale locale) {

        MessageSourceEntity message=messageSourceDAO.findByMessageKeyAndLocale(messageKey,locale.getLanguage());

        if (message==null){
            message=messageSourceDAO.findByMessageKeyAndLocale(messageKey,DEFAULT_LOCALE);
        }

        return new MessageFormat(message.getDescription(),new Locale(message.getLocale()));
    }

}
