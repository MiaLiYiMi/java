package com.imooc.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@ImportResource("classpath:config.xml")
public class StoreConfig {
	
	@Value("${url}")
	private String url;
	
	//当前操作系统的用户名      @Value("${username}") 注意在配置文件中的取名
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@Bean
	public MyDriverManager myDriverManager() {
		return new MyDriverManager(url, username, password);
	}
	
	
	@Bean(name = "stringStore1", initMethod="init", destroyMethod="destroy")
	public Store stringStore1() {
		return new StringStore();
	}
	
	
	@Bean(name = "stringStore2" ,initMethod="init", destroyMethod="destroy")
	//范围为prototype，代理方式：TARGET_CLASS
	@Scope(value="prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Store stringStore2() {
		return new StringStore();
	}
	
	@Bean(name = "stringStore3" ,initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype")
	public Store stringStore3() {
		return new StringStore();
	}
	
	@Bean(name = "stringStore4" )
	//范围为prototype，代理方式：TARGET_CLASS
	@Scope(value="prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Store stringStore4() {
		return new StringStore();
	}

	
	@Autowired
	private Store<String> s1;
	
	@Autowired
	private Store<Integer> s2;
	
	@Bean
	public StringStore stringStore() {
		return new StringStore();
	}
	
	@Bean
	public IntegerStore integerStore() {
		return new IntegerStore();
	}
	
	@Bean(name = "stringStoreTest")
	public Store stringStoreTest() {
		System.out.println("s1 : " + s1.getClass().getName());
		System.out.println("s2 : " + s2.getClass().getName());
		return new StringStore();
	}

}
