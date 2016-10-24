package cn.tedu.note.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.Note;

public interface NoteMapper {
	/**
	 * 根据笔记id查询笔记列表 
	 * @param bookId 笔记本ID
	 * @return 笔记列表数据
	 */
	List<Map<String,Object>> findNotesByNotebookId(String bookId);
	
	Note findNoteById(String noteId);
	
	void saveNote(Note note);
	
	void updateNote(Map<String,Object> note);
}
