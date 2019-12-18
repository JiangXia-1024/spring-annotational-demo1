package com.xinyi.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xinyi.dao.MyDao;

@Service
public class MyService {

//	@Autowired
//	@Resource(name="mydao2") 类似于@Autowired
	@Inject
	@Autowired(required = false)
	@Qualifier("mydao2")
	public MyDao myDao;
	
	//public MyDao mydao2;

	@Override
	public String toString() {
		return "MyService [MyDao=" + myDao + "]";
	}
	
	
	
	
}
