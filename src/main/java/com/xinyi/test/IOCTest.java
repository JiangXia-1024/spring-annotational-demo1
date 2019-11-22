package com.xinyi.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinyi.bean.Person;
import com.xinyi.bean.Role;
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
		System.out.println("IOC容器创建完成");
		Object person1 = applicationContext.getBean("person");
		Object person2 = applicationContext.getBean("person");
		System.out.println(person1 == person2);
	}
	
	@Test
	public void test3() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig1.class);
		String[] names = applicationContext.getBeanNamesForType(Person.class);
		for(String name:names) {
			System.out.println(name);
		}
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println(persons);
	}
}
