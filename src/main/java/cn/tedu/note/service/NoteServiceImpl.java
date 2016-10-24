package cn.tedu.note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.note.dao.NoteMapper;
import cn.tedu.note.dao.NotebookMapper;
import cn.tedu.note.dao.UserMapper;
import cn.tedu.note.entity.Note;
import cn.tedu.note.entity.NoteBook;
import cn.tedu.note.entity.User;
import cn.tedu.note.exception.NoteNotFoundException;
import cn.tedu.note.exception.NotebookNotFoundException;
import cn.tedu.note.exception.UserNotFoundException;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NotebookMapper notebookDao;
	
	@Autowired
	private UserMapper userDao;
	
	@Autowired
	private NoteMapper noteDao;

	//笔记
	@Transactional
	public List<Map<String,Object>> listNote(String bookId) throws NoteNotFoundException{
		if(bookId==null||bookId.trim().isEmpty()){
			throw new NoteNotFoundException("笔记ID为空");
		}
		
		NoteBook notebook = notebookDao.findNotebookById(bookId);
		if (notebook==null) {
			throw new NoteNotFoundException("没有笔记");
		}
		
		bookId = bookId.trim();
		List<Map<String, Object>> list = noteDao.findNotesByNotebookId(bookId);
		if(list == null){
			throw new NoteNotFoundException("笔记不存在");
		}
		return list;
	}

//	显示笔记内容
	//只读，速度快
	//isolation=Isolation.READ_COMMITTED并发时安全，读提交后的值
	//propagation=Propagation.REQUIRED
	@Transactional(readOnly=true,isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public Note getNote(String noteId){
		if(noteId==null||noteId.trim().isEmpty()){
			throw new IllegalArgumentException("noteid不存在");
		}
		noteId = noteId.trim();
		Note note = noteDao.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("笔记内容不存在");
		}
		return note;
	}
	
	@Transactional
	public Note createNote(String notebookId, String userId, String title) {
		if (notebookId==null || notebookId.trim().isEmpty()) {
			throw new IllegalArgumentException("参数不合法");
		}
		if (userId==null || userId.trim().isEmpty()) {
			throw new IllegalArgumentException("参数不合法");
		}
		
		NoteBook notebook = notebookDao.findNotebookById(notebookId);
		if (notebook == null) {
			throw new NoteNotFoundException("笔记ID不存在");
		}
		
		User user = userDao.findByUserId(userId);
		if (user==null) {
			throw new UserNotFoundException("用户ID不存在");
		}
		if (title==null || title.trim().isEmpty()) {
			title="新建笔记";
		}
		String s = null;
		s.charAt(0);
		title = title.trim();
		String id = UUID.randomUUID().toString();
		Long time = System.currentTimeMillis();
		Note note = new Note(id,notebookId,userId,"1","1",title,"",time,time);
		noteDao.saveNote(note);
		return note;
	}

	//更改标题和笔记
	@Transactional
	public Note updateNote(String noteId,String title,String body) {
		if (noteId==null||noteId.trim().isEmpty()) {
			throw new IllegalArgumentException("noteId没找到");
		}
		Note note = noteDao.findNoteById(noteId);
		if (note==null) {
			throw new NoteNotFoundException("笔记没找到");
		}
		Map<String, Object> noteInfo = new HashMap<String, Object>();
		if (title!=null && !title.trim().isEmpty()) {
			title.trim();
			if (! note.getTitle().equals(title)) {
				note.setTitle(title);
				noteInfo.put("title", title);
			}
		}
		if (body != null) {
			body = body.trim();
			if (! note.getBody().equals(body)) {
				note.setBody(body);
				noteInfo.put("body", body);
			}
		}
		if (noteInfo.isEmpty()) {
			return note;
		}
		noteInfo.put("noteId", noteId);
		noteInfo.put("modifyTime", System.currentTimeMillis());
		noteDao.updateNote(noteInfo);
		return note;
	}

//	移动笔记到其他笔记本
	@Transactional
	public boolean moveNote(String noteId, String notebookId) {
		if ((noteId==null || noteId.trim().isEmpty())) {
			throw new IllegalArgumentException("noteId不合法");
		}
		Note note = noteDao.findNoteById(noteId);
		if (note==null) {
			throw new NoteNotFoundException("笔记没找到");
		}
		if (notebookId==null || notebookId.trim().isEmpty()) {
			throw new IllegalArgumentException("notebookId不合法");
		}
		NoteBook notebook = notebookDao.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("笔记本没找到");
		}
		if (notebookId.equals(note.getNotebookId())) {
//			没有更改笔记位置，无需更改
			return false;
		}
		Map<String,Object> map = new HashMap<String, Object>(); 
		map.put("noteId", noteId);
		map.put("notebookId", notebookId);
		map.put("modifyTime", System.currentTimeMillis());
		noteDao.updateNote(map);
		return true;
	}

	//更改笔记本状态
	// 正常状态：1
	// 回收站状态 :2 回收站的状态在正常页面不再显示，只在回收站显示
	// 删除状态： 3
	//
	@Transactional
	public boolean deleteNote(String noteId) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
