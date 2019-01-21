package com.cn.springmvc.service;

import java.util.List;
import com.cn.springmvc.pojo.SpringmvcPojo;
/**
 * springmvc service层
 * @author 赵志龙
 * @date 2018-2-10
 * */
public interface SpringmvcService {
	//获取列表
	public List<SpringmvcPojo> getList(SpringmvcPojo springmvcPojo);
}
