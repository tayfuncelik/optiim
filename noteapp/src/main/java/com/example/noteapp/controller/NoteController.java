package com.example.noteapp.controller;

import com.example.noteapp.model.EmailEntity;
import com.example.noteapp.model.Note;
import com.example.noteapp.model.User;
import com.example.noteapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/note")
@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
     * This method will add note with userId
     *
     * @param note
     * @return
     */
    @PostMapping("/addNote")
    private ResponseEntity addNote(@RequestBody Note note) {

        if (note == null) {
            return ResponseEntity.badRequest().body("EMPTY OBJECT");
        }
        noteService.createNote(note);
        return ResponseEntity.status(201).body(sendEmailToUser(note).getBody());
    }

    @PostMapping("/updateNote")
    private ResponseEntity updateNote(@RequestBody Note note) {

        if (note == null) {
            return ResponseEntity.badRequest().body("EMPTY OBJECT");
        }
        noteService.updateNote(note);
        return ResponseEntity.status(201).body(sendEmailToUser(note).getBody());
    }

    @PostMapping("/getNote")
    private ResponseEntity getNoteByUserId(@RequestParam(name = "userId") Long userId) {

        if (userId == null) {
            return ResponseEntity.badRequest().body("EMPTY OBJECT");
        }
        List<Note> list = noteService.getNoteByUserId(userId);
        return ResponseEntity.status(201).body(list);
    }


    private ResponseEntity<String> sendEmailToUser(Note note) {
        //This will send email about created note
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("userId", note.getUserId().toString());

        User entityResp = restTemplate.getForObject("http://localhost:8081/users/getUser/{userId}", User.class, params);
        ResponseEntity<String> sendEmailResp = restTemplate.postForEntity("http://localhost:8082/email/sendEmail", entityResp, String.class);
        return sendEmailResp;
    }
}
