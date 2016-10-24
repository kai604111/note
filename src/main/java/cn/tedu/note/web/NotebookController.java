package cn.tedu.note.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.entity.NoteBook;
import cn.tedu.note.exception.UserNotFoundException;
import cn.tedu.note.service.NotebookService;
import cn.tedu.note.util.JsonResult;

@Controller
@RequestMapping("/notebook")
public class NotebookController {

	@Autowired
	private NotebookService notebookService;
	
//	处理页面加加载时展示笔记本
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult<List<Map<String,Object>>> listNotebooks(String userId){
//		try{
			List<Map<String,Object>> list = notebookService.listNotebooks(userId);
			return new JsonResult<List<Map<String,Object>>>(list);
//		}catch(UserNotFoundException e){
//			e.printStackTrace();
//			return new JsonResult<List<Map<String,Object>>>(e.getMessage());
//		}
	}

	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult<NoteBook> addNotebook(String userId,String name){
//		try {
			NoteBook notebook = notebookService.addNotebook(userId, name);
			return new JsonResult<NoteBook>(notebook);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new JsonResult<NoteBook>(e.getMessage());
//		}
	}

}
