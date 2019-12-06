package com.xinyi.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.xinyi.bean.Role3;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{
	/**
	 * AnnotationMetadata：当前类的注解信息
	 * BeanDefinitionRegistry：bean定义的注册类信息
	 * 需要注册到容器中的bean调用BeanDefinitionRegistry.registryBeanDefinition
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//设置注入条件：containsBeanDefinition的参数时全类名
		boolean flag = registry.containsBeanDefinition("com.xinyi.bean.Role");
		
		if(flag) {
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Role3.class);
			registry.registerBeanDefinition("自定注入的Bean名称", beanDefinition);
		}
		
	}

}
