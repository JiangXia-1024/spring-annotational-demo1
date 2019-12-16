package com.xinyi.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinyi.bean.Person;
import com.xinyi.bean.Role;
import com.xinyi.config.MyConfig;
import com.xinyi.config.MyConfig1;
import com.xinyi.config.MyConfig2;

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
	
	@Test
	public void test4() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig1.class);
		String[] names = applicationContext.getBeanDefinitionNames();
		for(String name:names) {
			System.out.println(name);
		}
		
		Object beanObject = applicationContext.getBean("roleBean");
		System.out.println("roleBean的类型是："+beanObject.getClass());
		
		Object beanObject1 = applicationContext.getBean("&roleBean");
		System.out.println("获取roleBean本身："+beanObject1.getClass());
	}
	
	//测试声明周期
	@Test
	public void test5() {
		//创建ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);
		System.out.println("IOC容器创建完成");
		
		//关闭ioc容器
		applicationContext.close();
	}
	
	//测试属性赋值
	@Test
	public void test6() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
	}
}
