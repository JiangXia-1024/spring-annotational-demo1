package com.xinyi.dao;

import org.springframework.stereotype.Repository;

//默认类名首字母小写的形式
//@Repository
public class MyDao {
	
	private String flag="1";

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "MyDao [flag=" + flag + "]";
	}
	
	
}
