package com.xinyi.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinyi.bean.Fruit;
import com.xinyi.bean.People;
import com.xinyi.bean.Person;
import com.xinyi.bean.Role;
import com.xinyi.config.MyConfig;
import com.xinyi.config.MyConfig1;
import com.xinyi.config.MyConfig2;
import com.xinyi.config.MyConfig3;
import com.xinyi.controller.MyController;
import com.xinyi.dao.MyDao;
import com.xinyi.service.MyService;

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
	
	
	//测试自动装配
	@Test
	public void test7() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig3.class);
		//MyService myService  = applicationContext.getBean(MyService.class);
	//	System.out.println(myService); 
		
		//输出的是同一个dao对象
	//	MyDao mydao = applicationContext.getBean(MyDao.class); 
	//	System.out.println(mydao);
		
		
		People people = applicationContext.getBean(People.class);
		System.out.println(people);
		Fruit fruit = applicationContext.getBean(Fruit.class);
		System.out.println(fruit);
		
		
		applicationContext.close();
	}
}
