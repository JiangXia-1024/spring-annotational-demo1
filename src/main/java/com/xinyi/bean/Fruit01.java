package com.xinyi.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Fruit01 implements InitializingBean,DisposableBean {

	public void afterPropertiesSet() throws Exception {
		System.out.println("Fruit01初始化");

	}

	public void destroy() throws Exception {
		System.out.println("Fruit01销毁");
		
	}
	
	public Fruit01() {
		System.out.println("Fruit01被创建");
	}

}
