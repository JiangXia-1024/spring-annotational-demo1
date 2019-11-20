package com.xinyi.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinyi.config.MyConfig;
import com.xinyi.config.MyConfig1;

public class IOCTest {
	@Test
	public void test1() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		String[] strings = applicationContext.getBeanDefinitionNames();
		for(String string : strings) {
			System.out.println(string);
		}
		
	}
	
	@Test
	public void test2() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig1.class);
//		String[] strings = applicationContext.getBeanDefinitionNames();
//		for(String string : strings) {
//			System.out.println(string);
//		}
		//默认单实例
		Object person1 = applicationContext.getBean("person");
		Object person2 = applicationContext.getBean("person");
		System.out.println(person1 == person2);
	}
}
