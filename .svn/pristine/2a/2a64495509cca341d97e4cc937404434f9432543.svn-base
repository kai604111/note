package dao_test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.note.dao.NoteMapper;
import cn.tedu.note.entity.Note;
import cn.tedu.note.service.NoteService;

public class NoteTest {


	@Resource(name="noteMapper")
	private NoteMapper dao;
	private ApplicationContext ctx;
	private NoteService service ;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml","spring-service.xml");
		dao = ctx.getBean("noteMapper",NoteMapper.class);
		service = ctx.getBean("noteService",NoteService.class);
	}

	@Test
	public void testfindNotesByNotebookId(){
		System.out.println(dao.findNotesByNotebookId("20b4cbec-bd55-4c21-9c41-3a11ada2b803"));
	}
	
	@Test
	public void testListNotebooks(){
//		NoteService service = ctx.getBean("noteService",NoteService.class);
		List<Map<String, Object>> list = service.listNote("d0b0727f-a233-4a1f-8600-f49fc1f25bc9");
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testShowNote(){
		System.out.println(dao.findNoteById("02e12cfc-07c3-4256-9057-789d33a02aa5"));
	}
	
	@Test
	public void testShowNoteService(){
		NoteService service = ctx.getBean("noteService",NoteService.class);
		
		System.out.println(service.getNote("53d1b3ed-59a1-4715-a7b2-9027b0d551e0"));
	}
	
	@Test
	public void testsaveNote(){
		String id = UUID.randomUUID().toString();
		Note n = new Note(id,"1","2","1","1","hello","World!",1L,1L);
		dao.saveNote(n);
		System.out.println(n.toString());
	}
	
	@Test
	public void testCreateNote(){
		String notebookId = "0037215c-09fe-4eaa-aeb5-25a340c6b39b";
		String userId = "52f9b276-38ee-447f-a3aa-0d54e7a736e4";
		String title = "世界是我们的!!!!O(∩_∩)O哈哈~";
		Note n = new Note();
		Note n2 = service.createNote(notebookId, userId, title);
		System.out.println(n2);
	}
	
	@Test
	public void testUpdateNote(){
		String noteId = "02e12cfc-07c3-4256-9057-789d33a02aa5";
		String title = "今天天气不错";
		String body = "是滴";
		Long modifyTime = System.currentTimeMillis();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("noteId", noteId);
		map.put("title", title);
		map.put("modifyTime", modifyTime);
		map.put("body", body);
		dao.updateNote(map);
	}
	
	@Test
	public void testUpdateNoteService(){
		String noteId = "02e12cfc-07c3-4256-9057-789d33a02aa5";
		String title = "今天天气不错";
		String body = "是滴";
		System.out.println(service.updateNote(noteId, title, body));
		System.out.println(dao.findNoteById("02e12cfc-07c3-4256-9057-789d33a02aa5"));
	}
	
	@Test
	public void testTime(){
		System.out.println(new Timestamp(System.currentTimeMillis()));
	}
	
	@Test
	public void testMoveNote(){
		String noteId = "003ec2a1-f975-4322-8e4d-dfd206d6ac0c";
		String notebookId = "0037215c-09fe-4eaa-aeb5-25a340c6b39b";
		boolean tf = service.moveNote(noteId, notebookId);
		System.out.println(tf);
	}
}
