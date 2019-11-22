package com.xinyi.condition;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.xinyi.bean.Role;

//判断是否是windows系统
public class Condition1 implements Condition{
	/**
	 * ConditionContext：判断条件能使用的上下文，这里是角色
	 * AnnotatedTypeMetadata：当前标注了Condition注解的注释信息
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 判断角色是否是打野
		//1.能够获取到ioc容器使用的beanfactory
		ConfigurableBeanFactory beanFactory = context.getBeanFactory();
		//2、获取类加载器
		ClassLoader loader = context.getClassLoader();
		//3、获取当前环境信息
		Environment environment=context.getEnvironment();
		//4、获取bean定义的注册类
//		BeanDefinitionRegistry registry = context.getRegistry();
//		Role role = context.getClass(Role.class);
		String property = environment.getProperty("os.name");
		if(property.contains("Windows")) {
			return true;
		}
		return false;
	}

}
