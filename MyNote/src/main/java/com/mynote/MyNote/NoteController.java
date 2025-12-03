package com.mynote.MyNote;

import model.Note;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private List<Note> notes = new ArrayList<>();

    public NoteController() {
        notes.add(new Note(1, "Java 學習筆記", "今天學到了物件導向...", "2023-10-24", "2023-10-25"));
        notes.add(new Note(2, "待辦事項", "- [ ] 複習 Spring Boot", "2023-10-23", "2023-10-23"));
    }

    @GetMapping
    public List<Note> getNotes() {
        return notes;
    }
}
