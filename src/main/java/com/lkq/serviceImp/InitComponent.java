package com.lkq.serviceImp;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import com.lkq.entity.Config;
import com.lkq.service.ConfigService;


@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware{
	
	private static ApplicationContext applicationContext;
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application=sce.getServletContext();
		ConfigService configService=(ConfigService) applicationContext.getBean("configService");
		
		//把config  初始到全局缓存中
		Config config = configService.findById(1);
		//将页面的全局设置对象保存到 缓存中
		application.setAttribute("config", config);
		
	}
	
	
	
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

}
