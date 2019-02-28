package com.lkq.dao;

import com.lkq.entity.Config;

public interface ConfigDao {
	
	public Integer update(Config config);
	
	public Config findById(Integer id);
	
	
}
