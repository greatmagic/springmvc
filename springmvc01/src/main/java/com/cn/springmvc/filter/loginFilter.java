package com.cn.springmvc.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.cn.springmvc.utils.EhcacheUtils;
@Service
public class loginFilter implements Filter{
	private List<String> urlList=new ArrayList<String>();
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		//System.out.println(request.getRequestURI());
		String url=request.getRequestURI();
		HttpServletResponse response=(HttpServletResponse) arg1;
		//跨域设置
		String url_axios="http:\\localhost";
		response.setHeader("Access-Control-Allow-Origin", url_axios);
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setHeader("Access-Control-Max-Age", "0");
		response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		//设置不拦截的请求，比如登录
		if(!urlList.contains(url)){
			Object object= request.getSession().getAttribute("userMap");
			//session为空拦截
			if(object==null){				
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("result", 4);
				map.put("data", new HashMap());
				JSON json=(JSON) JSON.toJSON(map);
				PrintWriter pw=response.getWriter();
				pw.write(json.toString());
				pw.close();
				return;
			}
		}
		arg2.doFilter(arg0, arg1);
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		urlList.add("/springmvc/jsp/fileUp.jsp");
		urlList.add("/springmvc/springMvc/upload");
		urlList.add("/springmvc/springMvc/list1");
		urlList.add("/springmvc/springMvc/list2");
	}

}
