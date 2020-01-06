package com.xinyi.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinyi.aop.MathCalculator;
import com.xinyi.config.MyConfigOfAOP;
import com.xinyi.ext.ExtConfig;
import com.xinyi.tx.TxConfig;
import com.xinyi.tx.UserService;

public class TestOfExt {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
		
		//发布事件
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
		});
		
		applicationContext.close();
	}
}

