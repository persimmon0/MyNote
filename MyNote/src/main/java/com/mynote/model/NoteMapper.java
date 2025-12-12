package com.mynote.model;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NoteMapper {
	List<NoteModel> findByUserId(Integer userId);
    NoteModel findById(Integer id);
    int insert(NoteModel note);
    int update(NoteModel note);
    int deleteById(Integer id);
}
