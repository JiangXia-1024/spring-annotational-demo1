package com.xinyi.bean;

import org.springframework.stereotype.Repository;

@Repository
public class Fruit {

	public Fruit() {
		System.out.println("Fruit被创建");
	}
	

	public void init() {
		System.out.println("Fruit被初始化");
	}
	
	public void destroy() {
		System.out.println("Fruit被销毁");
	}
}
