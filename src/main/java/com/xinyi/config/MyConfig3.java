package com.xinyi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.xinyi.bean.Fruit01;
import com.xinyi.bean.Fruit02;
import com.xinyi.dao.MyDao;

/**
 * 自动装配：
 * 		spring利用DI（依赖注入），完成对IOC容器中的各个组件的依赖关系进行赋值
 * 
 * 1）、@autowired：自动注入
 * 			1、一个组件需要另一个组件 service需要 dao，默认优先按照类型去容器中找对应的组件（类似于applicationContext.getBean(MyDao.class);）
 * 			2、如果找到多个相同类型的组件再讲属性的名称作为组件的id去容器中查找
 * 			3、@Qualifier("mydao"):使用@@Qualifier注解指定需要装配的组件的id，而不是使用属性名
 * 			4、自动装配默认一定要将属性赋好值，没有会报错
 * 			5、@Primary：让spring进行自动装配的时候默认使用首选的bean,后续也可以继续使用@Qualifier注解
 * 
 * 2）、spring还支持使用@resource（jsr250） 和@inject（jsr330）【java规范的注解】
 * 			@resource:可以和@autowired一样实现自动装配功能，默认是按组件名称进行装配，但是没有支持@primary和@Autowired(required = false)的功能
 * 			@inject：需要导入 javax inject依赖 和@autowired功能一样，没有但是也required = false功能
 * 
 * 			@autowired是spring定义的，而@resource和@Inject是java规范
 * 3）autowired：构造器 参数 方法 属性都可以标注，而且都是从容器中获取参数组件的值 
 * 			标注在构造器上，如果组件只有一个有参构造器，这个有参构造器的@autowired可以省略，参数位置的组件还是可以自动从容器中获取
 * 			标注在方法位置:@bean+方法参数：参数从容器中获取；默认不写autowired，效果是一样的都能自动装配
 * 4） 自定义组件想要使用spring容器底层的一些组件：applicationcontext beanfactory  xxx
 * 			只需要自定义组件实现 xxxaware接口：在创建对象的时候，会调用接口规定的方法注入相关组件 aware 接口方法回调的方式吧spring容器底层的一些组件注入到ioc容器中
 * 			xxxaware是通过xxxawareprocessor 后置处理器
 * @author： xinyi、
 * @date：2019年12月16日 下午3:02:10
 * @descript：
 */

@Configuration
@ComponentScan({"com.xinyi.service","com.xinyi.dao","com.xinyi.controller"})
public class MyConfig3 {
	
	@Primary
	//@Bean("mydao2") 还有mydao类 上的注解也注释掉
	public MyDao myDao() {
		MyDao mydao = new MyDao();
		mydao.setFlag("2");
		return mydao;
	}
	
	/**
	 * @bean 标注的方法创建对象的时候，方法参数的值从容器中获取
	 * @param fruit02
	 * @return
	 */
	@Bean
	public Fruit01 Fruit01(@Autowired Fruit02 fruit02) {
		return new Fruit01();
	}
}
