package com.xinyi.config;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

//实现TypeFilter接口
public class MyTypeFilter implements TypeFilter {

	//metadataReader:读取到当前正在扫描的类
	//metadataReaderFactory:读取到其他任何类的信息
	//match方法返回boolean类型的值，true表示匹配，符合过滤规则，false则不匹配
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// TODO Auto-generated method stub
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取正在扫描的类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取当前类资源信息(路径信息)
		Resource resource = metadataReader.getResource();
		
		String classnameString = classMetadata.getClassName();
		System.out.println("正在扫描的类："+classnameString);
		if(classnameString.contains("er")) {
			return true;
		}
		return false;
	}

}
