package com.xinyi.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Fruit02 {
	
	public Fruit02() {
		System.out.println("Fruit02创建");
	}
	
	//对象创建并赋值之后调用
	@PostConstruct
	public void init() {
		System.out.println("Fruit02初始化");
	}
	
	//对象被从ioc容器中移除之前调用
	@PreDestroy
	public void destroy() {
		System.out.println("Fruit02被销毁");
	}
}
