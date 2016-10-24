package cn.tedu.note.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tedu.note.entity.NoteBook;

/**
 * 笔记本的数据访问接口
 */
@Repository
public interface NotebookMapper {
	
	/**
	 * 根据用户id查询笔记本列表信息
	 * @param userid
	 * @return 笔记本列表信息
	 */
	List<Map<String,Object>> findNotebookByUserId(String userId);

	NoteBook findNotebookById(String bookId);
	
	void savaNotebook(NoteBook notebook);

}
