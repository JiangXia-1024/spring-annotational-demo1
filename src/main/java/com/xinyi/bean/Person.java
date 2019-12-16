package com.xinyi.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
	
	//@value基本类型赋值
	@Value("亚索")
	private String name;
	
	//@value:SpEL表达式赋值,下面结果为24
	@Value("#{23+1}")
	private Integer age;
	
	//@value:获取properties配置文件中的值
	@Value("${person.sname}")
    private String sname;
	
    public String getName() {
		return name;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sname=" + sname + "]";
	}


	public Person(String name, Integer age, String sname) {
		super();
		this.name = name;
		this.age = age;
		this.sname = sname;
	}

	public Person() {
	
	}
	
	
}
