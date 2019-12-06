package com.xinyi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.xinyi.bean.Person;
import com.xinyi.bean.Role;
import com.xinyi.bean.RoleBean;
import com.xinyi.condition.Condition1;
import com.xinyi.condition.Condition2;
import com.xinyi.condition.MyImportBeanDefinitionRegistrar;
import com.xinyi.condition.MyImportSelector;

@Configuration
@Conditional(Condition1.class)
@Import({Role.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MyConfig1 {
	
	//@Scope("prototype")
	//默认单实例
	@Bean("Lin Sin")
	@Lazy
//	@Conditional(Condition2.class)
	public Person person() {
		//System.out.println("IOC容器中注入person实例");
		return new Person("李青",18);
	}
	
	//@Conditional(Condition2.class)
	@Bean("Yasuo")
	public Person person1() {
		return new Person("亚索",23);
	}
	
	@Bean("Zed")
	public Person person2() {
		return new Person("劫",32);
	}
	
	
	@Bean
	public RoleBean roleBean() {
		return new RoleBean();
	}
}
