package com.cn.springmvc.utils;

import com.cn.springmvc.common.Const;

/**
 * 初始化设置，把配置值放到ehcache中
 * @author 赵志龙
 * @date 2018-02-10
 * */
public class EhcacheStart {
	//初始化方法
	public void init(){
		ReadProperties read=new ReadProperties("springmvc");
		//读取配置文件并放入到encache中
		String demo=read.getProperty(Const.DEMO);
		EhcacheUtils.put(Const.DEMO, demo);
	}
}
