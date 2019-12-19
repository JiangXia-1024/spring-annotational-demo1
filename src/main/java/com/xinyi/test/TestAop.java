package com.xinyi.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinyi.aop.MathCalculator;
import com.xinyi.config.MyConfigOfAOP;

public class TestAop {
	
	@Test
	public void test1() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigOfAOP.class);
		//1.不要自己创建对象,要用容器中的对象
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 2);
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
		mathCalculator.div(2, 1);
		applicationContext.close();
	}
	
}
