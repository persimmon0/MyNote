package com.mynote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mynote.model.NoteModel;
import com.mynote.model.NoteMapper;

@Service
public class NoteService {

    private final NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    // 依使用者userId取得筆記
    public List<NoteModel> findByUserId(Integer userId) {
        return noteMapper.findByUserId(userId);
    }

    // 依 ID 取得筆記
    public NoteModel findById(Integer id) {
        return noteMapper.findById(id);
    }

    // 新增筆記
    public NoteModel create(NoteModel note) {
        noteMapper.insert(note);
        System.out.println("新增筆記ID:" + note.id);
        return note;
    }

    // 更新筆記
    public NoteModel update(NoteModel note) {
        noteMapper.update(note);
        return note;
    }

    // 刪除筆記
    public void delete(Integer id) {
    	System.out.println("刪除筆記ID:" + id);
        noteMapper.deleteById(id);
    }
}
