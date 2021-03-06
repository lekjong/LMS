package com.lkq.service;


import java.util.List;
import java.util.Map;
import com.lkq.entity.UserSub;


public interface UserSubService {
	
	
	public Integer add(UserSub userSub);
	
	public Integer update(UserSub userSub);
	
	public List<UserSub> list(Map<String,Object> map);
	
	public Integer getTotal(Map<String,Object> map);
	
	public UserSub findById(Integer id);
	
	public Integer delete(Integer id);
	
	
}
