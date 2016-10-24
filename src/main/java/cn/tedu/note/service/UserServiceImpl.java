package cn.tedu.note.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.note.dao.UserMapper;
import cn.tedu.note.entity.User;
import cn.tedu.note.exception.NameOrPasswordException;
import cn.tedu.note.util.Utils;

/**
 * 
 * @Service 与组件扫描配合,扫描到cn.tedu.note.service
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userMapper")
	private UserMapper userDao;
	
	public User login(String name, String password) throws NameOrPasswordException {
		System.out.println("Login()");
//		String s=null;
//		s.charAt(0);
//		检查入口参数!!!
		if(name==null||name.trim().isEmpty()){
			throw new NameOrPasswordException(1, "用户名为空");
		}
		if(password==null||password.trim().isEmpty()){
			throw new NameOrPasswordException(2, "密码为空");
		}
		name = name.trim();
		password = password.trim();
		User user = userDao.findByUserName(name);
		if(user==null){
			throw new NameOrPasswordException(3, "用户名不存在");
		}
//		计算加盐
		String pwd = Utils.md5salt(password);
		if(pwd.equals(user.getUserPwd())){
//			登录成功
			return user;
		}
		throw new NameOrPasswordException(4, "错误密码");
	}

	public User sign_in(String name, String password1 ,String password2,String nick) {
//		检查入口参数!!!
		if(name==null||name.trim().isEmpty()){
			throw new NameOrPasswordException(1, "用户名为空");
		}
		if(password1==null||password1.trim().isEmpty()){
			throw new NameOrPasswordException(3, "密码为空");
		}
		if(password2==null||password2.trim().isEmpty()){
			throw new NameOrPasswordException(4, "密码为空");
		}
		if(nick==null||nick.trim().isEmpty()){
			throw new NameOrPasswordException(2, "昵称为空");
		}
		if(!password1.equals(password2)){
			throw new NameOrPasswordException(4,"两次密码不同");
		}
		name = name.trim();
		password1 = password1.trim();
		password2 = password2.trim();
		nick = nick.trim();
		User u = userDao.findByUserName(name);
		if(u!=null){
			throw new NameOrPasswordException(1,"用户名重复");
		}
		u = userDao.findByUserNick(nick);
		if(u!=null){
			throw new NameOrPasswordException(2,"昵称重复");
		}
		password1 = Utils.md5salt(password1);
		password2 = Utils.md5salt(password2);
		if (!password1.equals(password2)) {
			throw new NameOrPasswordException(4,"加盐错误");
		}
		String userId = UUID.randomUUID().toString();
		User user = new User();
		user.setUserId(userId);
		user.setUserName(name);
		user.setUserPwd(password2);
		user.setUserToken(nick);
		userDao.saveUser(user);
		return user;
	}
	
	

}
