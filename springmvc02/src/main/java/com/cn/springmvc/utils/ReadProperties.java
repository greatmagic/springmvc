package com.cn.springmvc.utils;

import java.util.Properties;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

/**
 * 配置文件读取工具类
 * @author 赵志龙   at 2018-02-10
 * */
public class ReadProperties {
	private String file;
	static ResourceBundle rb=null;
	private static Properties sysData=new Properties();
	private static final Logger log=Logger.getLogger(ReadProperties.class);
	public ReadProperties(){
		super();
	}
	public ReadProperties(String file){
		super();
		this.file=file;
		SetBundle();
	}
	public String getProperty(String key){
		String result=null;
		try{
			if(sysData.get(key)==null)
				try{
					result=rb.getString(key);
					sysData.put(key, result);
				}catch(Exception e){
					log.error(e);
				}
			else
				result=sysData.getProperty(key);
		}catch(Exception e){
			log.error(e);
		}
		return result;
	}
	public String[] getPropertyValues(String key){
		String[] result=null;
		try{
			if(sysData.get(key)==null)
				try{
					String str=rb.getString(key);
					result=str.split(",");
					sysData.put(key, result);
				}catch(Exception e){
					log.equals(e);
				}
			else
				result=(String[])sysData.get(key);
		}catch(Exception e){
			log.error(e);
		}
		return result;
	}
	private void SetBundle(){
		try{
			rb=ResourceBundle.getBundle(file);
		}catch(Exception e){
			log.error(e);
		}
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
}
