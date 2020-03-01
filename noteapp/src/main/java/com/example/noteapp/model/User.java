package com.example.noteapp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class User{

    private Long id;
    private String name;
    private String lastName;
    private String email;
}
