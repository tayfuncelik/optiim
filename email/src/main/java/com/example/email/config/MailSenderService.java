package com.example.email.config;

import com.example.email.model.EmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Component
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendmail(EmailEntity entity) throws AddressException, MessagingException, IOException {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(entity.getTo());
        mail.setSubject("Testing Mail API");
        mail.setText("Hurray ! You have done that dude...");

        /*
         * This send() contains an Object of SimpleMailMessage as an Parameter
         */
        javaMailSender.send(mail);
    }
}
