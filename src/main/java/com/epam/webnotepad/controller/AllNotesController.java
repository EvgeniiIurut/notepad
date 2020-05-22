package com.epam.webnotepad.controller;

import com.epam.webnotepad.domain.Note;
import com.epam.webnotepad.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("all-notes")
public class AllNotesController {

    private final NoteService noteService;

    public AllNotesController(NoteService noteService) {
        this.noteService = noteService;
    } //???????????????????????

    @GetMapping
    public String getAllNotes(Model model) {
        final Collection<Note> allNotes = noteService.getAllNotes();
        model.addAttribute("allNotes", allNotes);
        return "all-notes";
    }
}
