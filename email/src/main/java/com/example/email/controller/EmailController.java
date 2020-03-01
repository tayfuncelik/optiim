package com.example.email.controller;

import com.example.email.model.EmailEntity;
import com.example.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/email")
@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    private ResponseEntity sendEmail(@RequestBody EmailEntity entity) {
        if (entity == null) {
            return ResponseEntity.badRequest().body("EMPTY OBJECT");
        }
        boolean isSend = emailService.sendEmail(entity);
        return ResponseEntity.status(201).body(isSend == true ? "SUCCESS" : "FAILED");
    }
}

