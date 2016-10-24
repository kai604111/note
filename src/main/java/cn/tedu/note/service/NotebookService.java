package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.NoteBook;
import cn.tedu.note.exception.UserNotFoundException;

public interface NotebookService {
	
	/**
	 * 查询全部的笔记本列表
	 * @param userId 用户ID
	 * @return 这个用户的笔记本列表信息
	 * @throws UserNotFoundException userId对应的用户不存在
	 */
	List<Map<String,Object>> listNotebooks(String userId) throws UserNotFoundException;
	NoteBook addNotebook(String userId,String name);
}
