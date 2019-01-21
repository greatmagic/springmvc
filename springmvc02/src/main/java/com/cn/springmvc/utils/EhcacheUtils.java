package com.cn.springmvc.utils;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.dao.DataRetrievalFailureException;
import com.cn.springmvc.common.Const;

/**
 * ehcache工具类
 * @author 赵志龙
 * @date 2018-02-10
 * */
public class EhcacheUtils {
    private static Ehcache Cache=CacheManager.getInstance().getCache(Const.OBJECT);
    //将对象存放入缓存中
    public synchronized static void put(String key,Object object){
       Element element=new Element(key, object);
       Cache.put(element);
   }
   //获取角色菜单
   @SuppressWarnings("unchecked")
   public synchronized static Object get(String key){
	   Element element = null;
	   try {
		   element =Cache.get(key);
	   } catch (CacheException cacheException) {
		   throw new DataRetrievalFailureException("Cache failure: " + cacheException.getMessage(), cacheException);
	   }
	   if (element == null) {
		   return null;
	   } else {
		   return  element.getValue();
	   }
   }
   //全部清空
   public synchronized static void removeAll(){
       Cache.removeAll();
       //Cache.clearStatistics();
       Cache.flush();
   }
   //清除
   public synchronized static void remove(String key){
	   Cache.remove(key);	   
   }
}
