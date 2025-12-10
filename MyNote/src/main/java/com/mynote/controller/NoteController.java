package com.mynote.controller;

import org.springframework.web.bind.annotation.*;

import com.mynote.model.Note;
import com.mynote.service.NoteService;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*")
public class NoteController {

	// 注入 Service，不直接操作資料庫
	private final NoteService noteService;

	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}

	// 取得使用者userId筆記
	@GetMapping
	public List<Note> getNotes(@RequestParam Integer userId) {
	    return noteService.findByUserId(userId);
	}

	// 新增筆記
	@PostMapping
	public Note createNote(@RequestBody Note note) {
		return noteService.create(note);
	}

	// 更新筆記
	@PutMapping("/{id}")
	public Note updateNote(@PathVariable Integer id, @RequestBody Note updatedNote) {
		updatedNote.id = id; // 設定要更新的主鍵
		return noteService.update(updatedNote);
	}

	// 刪除筆記
	@DeleteMapping("/{id}")
	public void deleteNote(@PathVariable Integer id) {
		noteService.delete(id);
	}
}