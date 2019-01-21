package com.cn.springmvc.dao;

import java.util.List;

import com.cn.springmvc.pojo.SpringmvcPojo;

/**
 * dao实现类
 * @author 赵志龙
 * @date 2018-02-10
 * */
public interface SpringmvcDao {
	//获取springmvc列表
	public List<SpringmvcPojo> getList(SpringmvcPojo springmvcPojo);
}
