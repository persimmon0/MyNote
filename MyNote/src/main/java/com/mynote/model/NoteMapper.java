package com.mynote.model;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NoteMapper {
    List<Note> findAll();
    Note findById(Integer id);
    int insert(Note note);
    int update(Note note);
    int deleteById(Integer id);
}
