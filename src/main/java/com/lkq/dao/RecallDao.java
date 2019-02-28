package com.lkq.dao;

import java.util.List;
import java.util.Map;
import com.lkq.entity.Recall;


public interface RecallDao {
	
	public Integer add(Recall recall);
	
	public Integer update(Recall recall);
	
	public List<Recall> list(Map<String,Object> map);
	
	public  Integer getTotal(Map<String,Object> map);
	
	public Recall findById(Integer id);
	
	public Integer delete(Integer id);
	
	public Recall findBySubId(Integer subId);
	
	public Integer deleteBySubId(Integer subId);
	
	
}
