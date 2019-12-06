package com.xinyi.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义导入选择器，返回需要注册的组件
public class MyImportSelector implements ImportSelector {
	
	//返回值就是匹配的要注册的组件（全类名）
	//AnnotationMetadata:当前标注@import注解的类的所有注解信息
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.xinyi.bean.Role1","com.xinyi.bean.Role2"};
	}

}
