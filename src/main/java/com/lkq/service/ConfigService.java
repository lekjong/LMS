package com.lkq.service;

import com.lkq.entity.Config;

public interface ConfigService {
	
	public Integer update(Config config);
	
	public Config findById(Integer id);
	
}
