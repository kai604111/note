package dao_test;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.note.dao.NotebookMapper;
import cn.tedu.note.dao.UserMapper;
import cn.tedu.note.entity.NoteBook;
import cn.tedu.note.service.NotebookService;
import sun.print.resources.serviceui;

public class NotebookTestCase {

	@Resource(name="userMapper")
	private UserMapper userDao;
	private NotebookMapper dao;
	private NotebookService service;
	private ApplicationContext ctx;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml","spring-service.xml");
		dao = ctx.getBean("notebookMapper",NotebookMapper.class);
		service = ctx.getBean("notebookService",NotebookService.class);
	}

	@Test
	public void testfindNotebookByUserId(){
		List<Map<String, Object>> m = dao.findNotebookByUserId("52f9b276-38ee-447f-a3aa-0d54e7a736e4");
		for (Map<String, Object> map : m) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testfindNotebookById(){
		System.out.println(dao.findNotebookById("0037215c-09fe-4eaa-aeb5-25a340c6b39b"));
	}
	
	@Test
	public void testListNotebooks(){
		NotebookService service = ctx.getBean("notebookService",NotebookService.class);
		String userId = "03590914-a934-4da9-ba4d-b41799f917d1";
		List<Map<String, Object>> list = service.listNotebooks(userId);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testSaveNotebookDao(){
		NoteBook b = new NoteBook();
		b.setId("1");
		b.setCreatetime(new Timestamp(System.currentTimeMillis()));
		b.setName("新本本");
		b.setUserId("2");
		b.setTypeid("66");
		dao.savaNotebook(b);
		System.out.println(b);
	}
	
	@Test
	public void testSaveNotebookService(){
		String userId = "1";
		String name = "2";
		System.out.println(service.addNotebook(userId, name));
	}
	
}
