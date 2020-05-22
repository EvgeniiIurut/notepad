package com.epam.webnotepad.controller;

import com.epam.webnotepad.domain.Note;
import com.epam.webnotepad.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping(path = "/delete-note")
public class DeleteNoteController {

    private final NoteService noteService;

    public DeleteNoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    String deleteNote(@RequestParam("id") UUID id,
                      Model model){
        noteService.deleteNote(id);
        return "delete-note";
    }
}
