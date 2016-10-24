package cn.tedu.note.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.note.dao.NotebookMapper;
import cn.tedu.note.dao.UserMapper;
import cn.tedu.note.entity.NoteBook;
import cn.tedu.note.entity.User;
import cn.tedu.note.exception.UserNotFoundException;

@Service("notebookService")
public class NotebookServiceImpl implements NotebookService{

	@Autowired
	private UserMapper userDao;
	
	@Autowired
	private NotebookMapper notebookDao;
	
	//展示所有的笔记本
	public List<Map<String, Object>> listNotebooks(String userId) throws UserNotFoundException {
		if(userId==null || userId.trim().isEmpty()){
			throw new UserNotFoundException("ID为空");
		}
		User user = userDao.findByUserId(userId);
		if(user==null){
			throw new UserNotFoundException("用户ID不存在");
		}
		return notebookDao.findNotebookByUserId(userId.trim());
	}

	//添加笔记本
	public NoteBook addNotebook(String userId, String name) {
		if (userId==null || userId.trim().isEmpty()) {
			throw new IllegalArgumentException("userId不存在");
		}
		User user = userDao.findByUserId(userId);
		if (user==null) {
			throw new UserNotFoundException("用户不存在");
		}
		if (name==null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("name不存在");
		}
		NoteBook notebook = new NoteBook();
		notebook.setId(UUID.randomUUID().toString());
		notebook.setUserId(userId);
		notebook.setName(name);
		notebook.setTypeid("5");
		notebook.setCreatetime(new Timestamp(System.currentTimeMillis()));
		notebookDao.savaNotebook(notebook);
		return notebook;
	}
	
	
}
