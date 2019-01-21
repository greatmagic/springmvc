package com.cn.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.springmvc.dao.SpringmvcDao;
import com.cn.springmvc.pojo.SpringmvcPojo;
import com.cn.springmvc.service.SpringmvcService;
/**
 * service层实现类
 * @author 赵志龙
 * @date 2018-02-10
 * */
@Service("springmvcService")
public class SpringmvcServiceImpl implements SpringmvcService{
	@Resource
	private SpringmvcDao springmvcDao;
	public List<SpringmvcPojo> getList(SpringmvcPojo springmvcPojo) {
		// TODO Auto-generated method stub
		return springmvcDao.getList(springmvcPojo);
	}

}
