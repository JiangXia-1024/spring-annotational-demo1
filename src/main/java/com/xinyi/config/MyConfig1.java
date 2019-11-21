package com.xinyi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.xinyi.bean.Person;

@Configuration
public class MyConfig1 {
	
	//@Scope("prototype")
	//默认单实例
	@Bean("person")
	@Lazy
	public Person person() {
		System.out.println("IOC容器中注入person实例");
		return new Person("李青",18);
	}
}
