package com.cn.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.cn.springmvc.pojo.SpringmvcPojo;
import com.cn.springmvc.service.SpringmvcService;
/**
 * demo控制类
 * @author 赵志龙
 * @date 2018-02-10
 * */
@Controller
@RequestMapping(value="/springMvc")
public class SpringmvcController {
	//log4j日志
	private static Logger log=Logger.getLogger(SpringmvcController.class);
	@Resource
	private SpringmvcService springmvcService;
	/**
	 * 第一个案例
	 * 获取列表，直接返回数据
	 * */
	@RequestMapping("/list1")
	@ResponseBody
	public String getList(HttpServletRequest request, HttpServletResponse response, Model model){
		SpringmvcPojo spring=new SpringmvcPojo();
		List<SpringmvcPojo> resultList=springmvcService.getList(spring);
		return resultList.toString();
	}
	/**
	 * 第一个案例
	 * 获取列表，到jsp渲染
	 * */
	@RequestMapping("/list2")
	public String getJsp(HttpServletRequest request, HttpServletResponse response, Model model){
		SpringmvcPojo spring=new SpringmvcPojo();
		List<SpringmvcPojo> resultList=springmvcService.getList(spring);
		model.addAttribute("list", resultList);
		return "demo";
	}
	/**
	 * 上传文件
	 * */
	@RequestMapping(value="upload",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String upLoad(@RequestParam("file") MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
        String path = request.getSession().getServletContext().getRealPath("file");
        String fileName = file.getOriginalFilename();    
        //获取项目根路径
        String path1 = request.getSession().getServletContext().getContextPath()+"/file/"+fileName;
        File dir = new File(path,fileName);          
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        //MultipartFile自带的解析方法  
        file.transferTo(dir);
        response.setCharacterEncoding("utf8");
        return "上传成功！";
	}
}
