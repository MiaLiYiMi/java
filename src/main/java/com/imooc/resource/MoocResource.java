package com.imooc.resource;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;


public class MoocResource implements ApplicationContextAware  {
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void resource() throws IOException {
		Resource resource = applicationContext.getResource("classpath:config.txt");
		Resource resource1 = applicationContext.getResource("config.txt");
		Resource resource2 = applicationContext.getResource("url:http://www.imooc.com/video/3758");
		
		System.out.println(resource.getFilename());
		System.out.println(resource1.contentLength());
		System.out.println(resource2.toString());
	}

}
