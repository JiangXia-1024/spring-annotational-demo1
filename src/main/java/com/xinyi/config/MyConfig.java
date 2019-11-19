package com.xinyi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.xinyi.bean.Person;
import com.xinyi.dao.MyDao;

//配置类等同于以前的配置文件
//@Configuration等同于告诉spring这是一个配置类
@Configuration
//@ComponentScans(value = { @ComponentScan(value="com.xinyi",includeFilters = {@Filter(type=FilterType.ANNOTATION,classes = {Service.class,Repository.class})},useDefaultFilters = false),... })
//@ComponentScan(value="com.xinyi",excludeFilters = {@Filter(type=FilterType.ANNOTATION,classes = {Service.class,Repository.class})})
//@ComponentScan(value="com.xinyi",includeFilters = {@Filter(type=FilterType.ANNOTATION,classes = {Service.class,Repository.class})},useDefaultFilters = false)
//@ComponentScan(value="com.xinyi",includeFilters = {@Filter(type=FilterType.ASSIGNABLE_TYPE,classes = {MyDao.class})},useDefaultFilters = false)
@ComponentScan(value="com.xinyi",includeFilters = {@Filter(type=FilterType.CUSTOM,classes = {MyTypeFilter.class})},useDefaultFilters = false)
public class MyConfig {
	//@Bean给容器中注入一个bean，类型为返回值得类型，id默认方法名作为id
	//注入person得值
	@Bean("person222")
	public Person person111() {
		return new Person("xinyi、",19);
	}
}
