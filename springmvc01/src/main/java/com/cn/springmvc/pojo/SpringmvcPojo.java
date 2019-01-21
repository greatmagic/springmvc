package com.cn.springmvc.pojo;

/**
 * springmvc 实体bean
 * 
 * @author 赵志龙
 * @date 2018-02-10
 * */
public class SpringmvcPojo {
	// id值
	private String id;
	// 姓名
	private String na;
	// 年龄
	private int age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNa() {
		return na;
	}

	public void setNa(String na) {
		this.na = na;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"id\":" + this.id + "\"na\":" + this.na + "\"age\":"
				+ this.age + "}";
	}
}
