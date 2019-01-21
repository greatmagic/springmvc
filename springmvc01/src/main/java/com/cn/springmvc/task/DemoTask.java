package com.cn.springmvc.task;

import org.apache.log4j.Logger;

/**
 * 定时任务类
 * @author 赵志龙
 * @date 2018-02-10
 * */
public class DemoTask {
	private static Logger log=Logger.getLogger(DemoTask.class);
	//定时任务执行方法
	public void demo(){
		log.info("定时任务执行了！！！！！！");
	}
}
