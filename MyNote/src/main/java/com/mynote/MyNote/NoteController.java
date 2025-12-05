package com.mynote.MyNote;

import model.Note;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private List<Note> notes = new ArrayList<>();
    private final ObjectMapper mapper = new ObjectMapper();
    private final String FILE_PATH = "notes.json"; // 存檔路徑


    public NoteController() {
        // 啟動時先讀檔
        loadNotesFromFile();

        // 如果檔案是空的，就先放一些預設資料
        if (notes.isEmpty()) {
            notes.add(new Note(1, "Java 學習筆記", "今天學到了物件導向...", "2023-10-24", "2023-10-25"));
            notes.add(new Note(2, "待辦事項", "- [ ] 複習 Spring Boot", "2023-10-23", "2023-10-23"));
            saveNotesToFile(); // 存到檔案
        }

    }

    //@GetMapping+List<Note> → 回傳JSON資料
    @GetMapping
    public List<Note> getNotes() {
        return notes;
    }
 // 新增筆記
    @PostMapping
    public Note createNote(@RequestBody Note note) {
        notes.add(note);
        saveNotesToFile(); // 存到檔案
        return note;
    }

    // 更新筆記
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable int id, @RequestBody Note updatedNote) {
        for (Note n : notes) {
            if (n.getId() == id) {
                n.setTitle(updatedNote.getTitle());
                n.setContent(updatedNote.getContent());
                n.setUpdatedAt(updatedNote.getUpdatedAt());
                saveNotesToFile();
                return n;
            }
        }
        return null;
    }

    // 刪除筆記
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable int id) {
        notes.removeIf(n -> n.getId() == id);
        saveNotesToFile();
    }

    // --- 檔案存取 ---
    private void saveNotesToFile() {
        try {
            mapper.writeValue(new File(FILE_PATH), notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNotesFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                notes = mapper.readValue(file, new TypeReference<List<Note>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
