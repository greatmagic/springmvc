package com.cn.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc 过滤器配置
 * @author 赵志龙
 * @date 2018-02-18
 * */
public class LogInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		/**
		 * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，
		 * 该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
		 * 用于进行资源清理。
		 * */
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		/**
		 * 该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，
		 * 可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
		 * */
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		/**
		 * 该方法将在请求处理之前进行调用，只有该方法返回true，才会继续执行后续的Interceptor和Controller，
		 * 当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，
		 * 如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法
		 * */
		return true;
	}

}
