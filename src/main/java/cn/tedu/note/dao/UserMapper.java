package cn.tedu.note.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.note.entity.User;

/**
 * 封装用户User对象的CRUD方法
 * MapperScanner 会扫描这个接口,自动为接口创建实现类,并实例化接口的子类Bean对象
 * @author Administrator
 *
 */
@Repository
public interface UserMapper {
	List<User> findAll();
	User findByUserName(String name);
	void saveUser(User user);
	User findByUserNick(String nick);
	User findByUserId(String userId);
	
}
