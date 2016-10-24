package dao_test;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.note.dao.UserMapper;
import cn.tedu.note.entity.User;
import cn.tedu.note.service.UserService;

public class UserTestCase1 {
	
	private UserMapper dao;
	private UserService service;
	private ApplicationContext ctx;
	@Before
	public void init(){
		 ctx = new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml","spring-service.xml");
		dao = ctx.getBean("userMapper", UserMapper.class);
		service = ctx.getBean("userService",UserService.class);
		
	}
	
	@Test
	public void test1() throws SQLException {
		System.out.println(dao.findAll());
	}
	
	@Test
	public void userMapprTest() throws SQLException {
		User c = dao.findByUserName("haha");
		System.out.println(c);
	}
	
	@Test
	public void test5(){
		System.out.println(dao.findByUserNick("jreeykiller"));
	}
	
	@Test
	public void test6(){
		System.out.println(dao.findByUserId("03590914-a934-4da9-ba4d-b41799f917d1"));
	}
	
	@Test
	public void testMapperScanner(){
		Object obj = ctx.getBean("dataSource");
		System.out.println(obj);
	}
	
	@Test
	public void test3(){
		User u = new User();
		u.setUserId("2");
		u.setUserName("Tom");
		u.setUserPwd("123");
		u.setUserNick("jreeykiller");
		dao.saveUser(u);
	}
	
	@Test
	public void test4(){
		UserService service = ctx.getBean("userService",UserService.class);
		User u = service.login("haha", "123");
		System.out.println(u);
	}
	
	@Test
	public void testSignService(){
		String name = "";
		String pwd1 = "123";
		String pwd2 = "1232";
		String nick = "大王";
		User u = service.sign_in(name, pwd1, pwd2, nick);
		System.out.println(u.toString());
	}
}
