package com.epam.webnotepad.controller;

import com.epam.webnotepad.domain.Note;
import com.epam.webnotepad.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.UUID;

@Controller
@RequestMapping(value={"/update-note"})
public class UpdateNoteController {

    private final NoteService noteService;

    public UpdateNoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    String updateNote(@RequestParam("id")UUID id,
                      Model model){
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "update-note";
    }

}
