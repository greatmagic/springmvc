package com.cn.springmvc.aop;

import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserInfoInject {
	public static final Log log = LogFactory.getLog(UserInfoInject.class);

	@Before(value = "execution(* (com.cn.springmvc.controller.SpringmvcController+).*(..))")
	public void inject(JoinPoint jp) {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
		Object[] args = jp.getArgs();
		for (Object obj : args) {
			if (obj instanceof HashMap) {
				HashMap search = (HashMap) obj;
			}
		}
	}
}
