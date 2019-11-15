package com.xinyi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinyi.bean.Person;
import com.xinyi.config.MyConfig;


public class MainTest {

	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person personbean = (Person) applicationContext.getBean("Person");
//		System.out.println(personbean);

		//以前时返回配置文件得位置，这里时返回配置类得位置
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		Person person = applicationContext.getBean(Person.class);
		System.out.println(person);
		//返回类型
		String[] persontype = applicationContext.getBeanNamesForType(Person.class);
		for(String nameString :persontype) {
			System.out.println(nameString);
		}
		
	}

}
