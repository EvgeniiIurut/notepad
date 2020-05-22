package com.epam.webnotepad.service;

import com.epam.webnotepad.dao.NoteDAO;
import com.epam.webnotepad.domain.Note;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Service
public class NoteService {

    private final NoteDAO noteDAO;

    public NoteService(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    public Note createNewNote(String header, String text) {
        Objects.requireNonNull(header);
        final Note note = new Note();
        note.setId(UUID.randomUUID());
        note.setHeader(header);
        note.setText(text);
        return noteDAO.create(note);
    }

    public void deleteNote(UUID id) {
        noteDAO.delete(id);
    }

    public Collection<Note> getAllNotes() {
        return noteDAO.getAll();
    }

    public Note getById(UUID id) {
        return noteDAO.getNote(id);
    }

}