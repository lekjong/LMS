package com.lkq.serviceImp;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import com.lkq.dao.ConfigDao;
import com.lkq.entity.Config;
import com.lkq.service.ConfigService;


@Service("configService")
public class ConfigServiceImp implements ConfigService {
	
	@Resource
	private ConfigDao configDao;
	
	
	public Integer update(Config config) {
		int i =  configDao.update(config);
		config = configDao.findById(1);
		//刷新缓存
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();  
        ServletContext servletContext = webApplicationContext.getServletContext(); 
        servletContext.setAttribute("config", config);
		return i ;
	}
	
	public Config findById(Integer id) {
		// TODO Auto-generated method stub
		return configDao.findById(id);
	}
	
	
}
