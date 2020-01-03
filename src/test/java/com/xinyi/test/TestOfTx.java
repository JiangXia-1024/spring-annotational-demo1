package com.xinyi.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinyi.aop.MathCalculator;
import com.xinyi.config.MyConfigOfAOP;
import com.xinyi.tx.TxConfig;
import com.xinyi.tx.UserService;

public class TestOfTx {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
		
		UserService userService  =  applicationContext.getBean(UserService.class);
		
		userService.insertUser();
		
		applicationContext.close();
	}
}

