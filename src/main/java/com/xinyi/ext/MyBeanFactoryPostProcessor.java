package com.xinyi.ext;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanFactoryPostProcessor......postProcessBeanFactory.....");
		int count = beanFactory.getBeanDefinitionCount();
		String[] nameStrings = beanFactory.getBeanDefinitionNames();
		System.out.println("当前beanfactory有"+count+"个bean");
		System.out.println(Arrays.asList(nameStrings));
	}

}
