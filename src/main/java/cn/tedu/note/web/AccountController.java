package cn.tedu.note.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.entity.User;
import cn.tedu.note.exception.NameOrPasswordException;
import cn.tedu.note.service.UserService;
import cn.tedu.note.util.JsonResult;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult<User> login(String name,String password,HttpServletResponse response){
//		try{
			User user = userService.login(name, password);
			Cookie cookie = new Cookie("loginUserId", user.getUserId());
			cookie.setPath("/");
			response.addCookie(cookie);
			return new JsonResult<User>(user);
//		}catch(NameOrPasswordException e){
//			e.printStackTrace();
//			return new JsonResult<User>(e.getField(), e.getMessage(), null);
//		}catch(Exception e){
//			e.printStackTrace();
//			return new JsonResult<User>(e);
//		}
	}
	
	
	
	
}
