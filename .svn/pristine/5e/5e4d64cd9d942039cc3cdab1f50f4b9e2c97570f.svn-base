package cn.tedu.note.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.entity.User;
import cn.tedu.note.exception.NameOrPasswordException;
import cn.tedu.note.service.UserService;
import cn.tedu.note.util.JsonResult;

@Controller
@RequestMapping("/sign")
public class SignController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/sign.do")
	@ResponseBody
	public JsonResult<User> sign(String name,String password1,String password2,String nick){
//		try{
			User user = userService.sign_in(name, password1, password2, nick);
			return new JsonResult<User>(user);
//		}catch(NameOrPasswordException e){
//			e.printStackTrace();
//			return new JsonResult<User>(e.getField(),e.getMessage(),null);
//		}catch(Exception e){
//			e.printStackTrace();
//			return new JsonResult<User>(e);
//		}
	}
}
