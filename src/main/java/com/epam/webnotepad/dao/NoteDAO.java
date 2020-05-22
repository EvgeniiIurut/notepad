package com.epam.webnotepad.dao;

import com.epam.webnotepad.domain.Note;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

@Repository
public class NoteDAO {

    private final JdbcTemplate jdbcTemplate;

    public NoteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Note create(Note note) {
        note.setCreatedAt(Instant.now());
        note.setUpdatedAt(Instant.now());
        final int updatedRows = jdbcTemplate.update("insert into note (id, header, text, created_at, updated_at) VALUES ( ?,?,?,?,? )",
                note.getId(),
                note.getHeader(),
                note.getText(),
                note.getCreatedAt(),
                note.getUpdatedAt()
        );
        return note;
    }

    public boolean delete(UUID id) {
        final int updatedRows = jdbcTemplate.update("delete note where id = ?;", id);
        return updatedRows == 0;
    }


    public Collection<Note> getAll() {
        return jdbcTemplate.query("SELECT * FROM note", (resultSet, rowNum) -> {
            final Note note = new Note();
            note.setId(UUID.fromString(resultSet.getString("id")));
            note.setHeader(resultSet.getString("header"));
            note.setText(resultSet.getString("text"));
            note.setCreatedAt(resultSet.getTimestamp("created_at").toInstant());
            note.setUpdatedAt(resultSet.getTimestamp("updated_at").toInstant());
            return note;
        });
    }

    public Note getNote(UUID id) {
        return jdbcTemplate.query("SELECT * FROM note where id = ?;", new Object[]{id}, (resultSet) -> {
            final Note note = new Note();
            note.setId(UUID.fromString(resultSet.getString("id")));
            note.setHeader(resultSet.getString("header"));
            note.setText(resultSet.getString("text"));
            note.setCreatedAt(resultSet.getTimestamp("created_at").toInstant());
            note.setUpdatedAt(resultSet.getTimestamp("updated_at").toInstant());
            return note;
        });
    }
}
