package com.xinyi.bean;

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
