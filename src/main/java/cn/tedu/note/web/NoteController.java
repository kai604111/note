package cn.tedu.note.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.entity.Note;
import cn.tedu.note.exception.NoteNotFoundException;
import cn.tedu.note.exception.UserNotFoundException;
import cn.tedu.note.service.NoteService;
import cn.tedu.note.util.JsonResult;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
//	处理展示笔记请求
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult<List<Map<String,Object>>> listNote(String notebookId){
//		try {
			List<Map<String, Object>> list = noteService.listNote(notebookId);
			return new JsonResult<List<Map<String,Object>>>(list);
//		} catch(UserNotFoundException e){
//			e.printStackTrace();
//			return new JsonResult<List<Map<String,Object>>>(e.getMessage());
//		}catch(NoteNotFoundException e){
//			e.printStackTrace();
//			return new JsonResult<List<Map<String,Object>>>(e.getMessage());
//		}
	}
	
	@RequestMapping("/load.do")
	@ResponseBody
	public JsonResult<Note> getNote(String noteId){
//		try {
			Note note = noteService.getNote(noteId);
			return new JsonResult<Note>(note);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new JsonResult<Note>(e);
//		}
	}
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult<Note> addNote(String notebookId,String userId,String title){
//		try {
			Note note = noteService.createNote(notebookId, userId, title);
			return new JsonResult<Note>(note);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new JsonResult<Note>(e.getMessage());
//		}
		
	}
	
	@RequestMapping("/modify.do")
	@ResponseBody
	public JsonResult<Note> add(String noteId,String title,String body){
//		try {
			Note note = noteService.updateNote(noteId, title, body);
			return new JsonResult<Note>(note);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new JsonResult<Note>(e.getMessage());
//		}
	}
	
	@RequestMapping("/move.do")
	@ResponseBody
	public JsonResult<Boolean> move(String noteId,String notebookId){
//		try {
			Boolean tf = noteService.moveNote(noteId, notebookId);
			return new JsonResult<Boolean>(tf);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new JsonResult<Boolean>(e.getMessage());
//		}
		
	}
}
