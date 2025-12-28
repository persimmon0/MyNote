package com.mynote.controller;

import org.springframework.web.bind.annotation.*;

import com.mynote.model.NoteModel;
import com.mynote.service.NoteService;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

	// Service，不直接操作資料庫
	private final NoteService noteService;

	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}

	// 取得"使用者-userId"筆記
	@GetMapping
	public List<NoteModel> getNotes(HttpSession session) {
		
		// 接userId
		Integer userId = (Integer) session.getAttribute("userId");
	    
		System.out.println("內頁的userID:" + userId);

	    // 查資料庫
	    return noteService.findByUserId(userId);
	}

	// 新增筆記
	@PostMapping
	public NoteModel createNote(@RequestBody NoteModel note, HttpSession session) {

	    Integer userId = (Integer) session.getAttribute("userId");
	    
	    note.userId = userId;
	    
	    return noteService.create(note);
	}

	// 更新筆記
	@PutMapping("/{id}")
	public NoteModel updateNote(@PathVariable Integer id, @RequestBody NoteModel updatedNote) {
		updatedNote.id = id;
		return noteService.update(updatedNote);
	}

	// 刪除筆記
	@DeleteMapping("/{id}")
	public void deleteNote(@PathVariable Integer id) {
		noteService.delete(id);
	}
}