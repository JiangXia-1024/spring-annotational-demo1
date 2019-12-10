package com.xinyi.bean;

import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

    //bean初始化方法调用前被调用
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
    	System.out.println("postProcessBeforeInitialization..."+beanName+"=>"+bean);
		return bean;
    }
    //bean初始化方法调用后被调用
    public Object postProcessAfterInitialization(Object bean, String beanName) {
    	System.out.println("postProcessAfterInitialization..."+beanName+"=>"+bean);
		return bean;
    }

}
