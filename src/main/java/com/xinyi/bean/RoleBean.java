package com.xinyi.bean;

import org.springframework.beans.factory.FactoryBean;

//创建spring定义的FactoryBean类
public class RoleBean implements FactoryBean<Role> {

	//返回一个role对象并添加到容器中
	public Role getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Role();
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Role.class;
	}

}
