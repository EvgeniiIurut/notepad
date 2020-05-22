package com.epam.webnotepad.controller;

import com.epam.webnotepad.domain.Note;
import com.epam.webnotepad.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/new-note")
public class NewNoteController {

    private final NoteService noteService;

    public NewNoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    String createNewNote(@RequestParam("header") String header,
                         @RequestParam("body") String body,

                         Model model){
        final Note createdNote = noteService.createNewNote(header, body);
        model.addAttribute("createdNote", createdNote);
        return "new-note-created";
    }
}
