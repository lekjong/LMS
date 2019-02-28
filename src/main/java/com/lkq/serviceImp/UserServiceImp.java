package com.lkq.serviceImp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lkq.dao.TreeDao;
import com.lkq.dao.UserDao;
import com.lkq.entity.User;
import com.lkq.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService {

	@Resource
	private UserDao  userDao;       //注入UserDao接口的实现类，采用代理的方式实现；

	public Integer add(User user) {
		// TODO Auto-generated method stub
		return userDao.add(user);
	}

	public Integer update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	public List<User> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.list(map);
	}

	public Integer getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.getTotal(map);
	}

	 
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}

	@Override
	public User findByNum(String num) {
		// TODO Auto-generated method stub
		return userDao.findByNum(num);
	}
	
    
	
	
	
}
