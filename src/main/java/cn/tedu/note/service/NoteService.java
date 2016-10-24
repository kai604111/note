package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.Note;
import cn.tedu.note.exception.NoteNotFoundException;
import cn.tedu.note.exception.UserNotFoundException;

public interface NoteService {
	List<Map<String,Object>> listNote(String bookId) throws UserNotFoundException,NoteNotFoundException;
	
	Note getNote(String noteId) throws NoteNotFoundException;
	
	Note createNote(String notebookId,String userId,String title);
	
	Note updateNote(String noteId,String title,String body);
	
	boolean moveNote(String noteId, String notebookId);
	
	boolean deleteNote(String noteId);
}
