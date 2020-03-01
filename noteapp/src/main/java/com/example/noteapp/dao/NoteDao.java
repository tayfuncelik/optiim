package com.example.noteapp.dao;

import com.example.noteapp.model.Note;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface NoteDao extends CrudRepository<Note, Long> {

    @Modifying
    @Query("UPDATE Note n SET n.note = :note WHERE n.id = :id")
    public void update(@Param("note") String note, @Param("id") Long id);

    @Query("select n from Note n where n.userId = :userId")
    List<Note> getNoteByUserId(@Param("userId") Long userId);

}
