package com.xinyi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.xinyi.bean.Person;

//配置类等同于以前的配置文件
//@Configuration等同于告诉spring这是一个配置类
@Configuration
@ComponentScan(value="com.xinyi")
public class MyConfig {
	//@Bean给容器中注入一个bean，类型为返回值得类型，id默认方法名作为id
	//注入person得值
	@Bean("person222")
	public Person person111() {
		return new Person("xinyi、",19);
	}
}
