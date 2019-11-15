package com.xinyi.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinyi.config.MyConfig;

public class IOCTest {
	@Test
	public void test1() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		String[] strings = applicationContext.getBeanDefinitionNames();
		for(String string : strings) {
			System.out.println(string);
		}
	}
}
