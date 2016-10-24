package cn.tedu.note.service;

import cn.tedu.note.entity.User;
import cn.tedu.note.exception.NameOrPasswordException;

public interface UserService {
	/**
	 * 封装登录逻辑
	 * 如果登录成功就返回登录的成功的用户信息
	 * 否则登录失效就抛出异常
	 * @param name 用户名
	 * @param password 密码
	 * @return 登录成功的用户信息
	 * @throws NameOrPasswordException 登录失败
	 */
	User login(String name,String password) throws NameOrPasswordException;
	User sign_in(String name,String password1,String password2,String nick);
}
