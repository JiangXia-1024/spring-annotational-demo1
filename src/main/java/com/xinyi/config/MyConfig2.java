package com.xinyi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.xinyi.bean.Fruit;
import com.xinyi.bean.Fruit01;
import com.xinyi.bean.Fruit02;
import com.xinyi.bean.MyBeanPostProcessor;
import com.xinyi.bean.Person;

/**
 * 
 * @author： xinyi、
 * @date：2019年12月6日 上午10:21:57
 * @descript：Bean的生命周期
 * 			bean创建----初始化----销毁的过程
 * 	IOC容器管理Bean的声明周期
 * 	可以自定义初始化和销毁方法
 * 	容器在bean进行到当前声明周期的时候调用自定义的初始化和销毁方法
 *  
 *  配置文件中的init-method 和destroy-method
 *  
 *  1)、指定初始化和销毁方法：
 *  	@Bean注解指定init-method 和 destroy-method
 *  
 *  	构造（创建对象）：
 *  	单实例：在容器创建的时候创建对象
 *  	多实例：在每次获取对象的时候才创建对象
 */		

//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class MyConfig2 {
	@Scope("PROTOTYPE")
	@Bean(initMethod = "init",destroyMethod = "destroy")
	public Fruit fruit() {
		return new Fruit();
	}
	
	
	@Bean
	public Fruit01 fruit01() {
		return new Fruit01();
	}
	
	@Bean
	public Fruit02 fruit02() {
		return new Fruit02();
	}
	
	@Bean
	public MyBeanPostProcessor myBeanPostProcessor() {
		return new MyBeanPostProcessor();
	}
	
	@Bean
	public Person person() {
		//return new Person("亚索",23,"孤儿玩家");
		return new Person();
	}
}
