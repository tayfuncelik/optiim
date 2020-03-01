package com.example.noteapp.service;

import com.example.noteapp.dao.NoteDao;
import com.example.noteapp.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NoteService {

    @Autowired
    private NoteDao noteDao;

    public Note getNote(Note note) {
        return noteDao.findById(note.getId()).get();
    }

    public List<Note> getNoteByUserId(Long userId) {
        return noteDao.getNoteByUserId(userId);
    }

    public void createNote(Note note) {
        noteDao.save(note);
    }

    public void deleteNote(Note note) {
        noteDao.delete(note);
    }

    public void updateNote(Note note) {
        Note myNote = noteDao.findById(note.getId()).get();
        if (myNote != null) {
            noteDao.update(myNote.getNote(), myNote.getId());
        }
    }

}
