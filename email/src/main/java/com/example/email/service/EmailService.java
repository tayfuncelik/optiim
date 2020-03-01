package com.example.email.service;

import com.example.email.config.MailSenderService;
import com.example.email.model.EmailEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    private static Logger LOG = LoggerFactory.getLogger(EmailService.class);


    @Autowired
    private MailSenderService mailSenderService;

    public boolean sendEmail(EmailEntity entity) {
        LOG.info("Email is sending...");

        try {
            mailSenderService.sendmail(entity);
            LOG.info("Email is sent");
            return true;
        }catch (Exception e){
            LOG.error("Email is not sent",e);
            return false;
        }
    }
}
