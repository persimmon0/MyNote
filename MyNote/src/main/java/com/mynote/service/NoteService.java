package com.mynote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mynote.model.Note;
import com.mynote.model.NoteMapper;

@Service
public class NoteService {

    private final NoteMapper noteMapper;

    // 建構子注入 NoteMapper
    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    // 取得所有筆記
    public List<Note> findAll() {
        return noteMapper.findAll();
    }

    // 依 ID 取得筆記
    public Note findById(Integer id) {
        return noteMapper.findById(id);
    }

    // 新增筆記
    public Note create(Note note) {
        noteMapper.insert(note);
        return note;
    }

    // 更新筆記
    public Note update(Note note) {
        noteMapper.update(note);
        return note;
    }

    // 刪除筆記
    public void delete(Integer id) {
        noteMapper.deleteById(id);
    }
}
