package com.example.noteapp.model;

import lombok.Data;

import java.io.File;

@Data
public class EmailEntity {

    private Long id;
    private String cc;
    private String to;
    private String from;
    private String messageBody;
    private File attach;
}
