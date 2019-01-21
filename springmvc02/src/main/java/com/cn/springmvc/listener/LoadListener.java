package com.cn.springmvc.listener;

import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cn.springmvc.common.Const;
import com.cn.springmvc.utils.ReadProperties;




/**
 * web.xml配置监听器,初始化是执行contextInitialized方法
 * */
public class LoadListener implements ServletContextListener{
	public static HashMap<String,String> dataMap = new HashMap<String,String>();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		this.init();
	}
	//初始化方法，可以加载各种数据，放到静态map或cache中
    public void init(){
    	System.out.println("listener监听初始化");
		ReadProperties read = new ReadProperties("springmvc");
		String demo = read.getProperty(Const.DEMO);
		dataMap.put(Const.DEMO, demo);
    }
}
