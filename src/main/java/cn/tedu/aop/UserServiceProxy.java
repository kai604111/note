package cn.tedu.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.tedu.note.entity.User;
import cn.tedu.note.exception.NameOrPasswordException;
import cn.tedu.note.service.UserService;

@Component("userServiceProxy")
public class UserServiceProxy implements UserService{

	@Autowired
	DemoAspect demoAspect;
	
	@Autowired
	UserService target;
	
	public User login(String name, String password) throws NameOrPasswordException {
		demoAspect.hello();
		System.out.println("Hello Proxy");
		return target.login(name, password);
	}

	public User sign_in(String name, String password1, String password2, String nick) {
		System.out.println("Hello Proxy");
		return target.sign_in(name, password1, password2, nick);
	}
	
	

}
