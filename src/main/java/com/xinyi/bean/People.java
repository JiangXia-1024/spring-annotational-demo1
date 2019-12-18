package com.xinyi.bean;

import java.awt.CardLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//默认加载在ioc容器中的组件，容器启动会调用午餐构造器创建对象，再
//进行初始化赋值等操作
@Component
public class People {
	
//	@Autowired
	public Fruit fruit;

	@Autowired
	public People(Fruit fruit) {
		this.fruit = fruit;
		System.out.println("有参构造器");
	}
	
	public Fruit getFruit() {
		return fruit;
	}

	@Autowired
	//标注在方法上，spring容器创建当前对象的时候就会调用方法完成赋值
	//方式使用的参数：自定义类型的值从ioc容器中获取
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	@Override
	public String toString() {
		return "People []";
	}
	
	

}
