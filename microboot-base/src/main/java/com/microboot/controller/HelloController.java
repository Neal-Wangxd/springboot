package com.microboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月4日 下午2:27:32 
* 类说明  :  测试Controller类
* @Controller 在类上定义表示定义的是一个控制器
* @ResponseBody 将控制器中方法的返回值变为rest内容
* 
* @RestController Controller与ResponseBody 的复合注解
* 
* 参数传递:
* 最简单的做法就是地址重写 "xxx?参数名称=内容"
* 
* 由于SpringBoot支持Rest风格处理，所以对于参数的接收可以采用路径参数形式
* 
* 
*/
@RestController
public class HelloController {

	@RequestMapping("/Hello")
    @ResponseBody
	public String Hello(){
		return "Hello World!";
	}
	
	
	@RequestMapping("/SayHello")
	public String SayHello(String person){
		return "Hello " + person;
	}
	//http://localhost:8080/SayHello?person=abc
	
	@RequestMapping(value="/sayGood/{per}",method=RequestMethod.GET)
	public String sayGood(@PathVariable("per") String person){
		return "Good " + person;
	}
	//http://localhost:8080/sayGood/abc
	
	
	@RequestMapping(value="/mul/{num}",method=RequestMethod.GET)
	public int sum(@PathVariable("num") int num){
		return num * num;
	}
	
	@RequestMapping("/object")
	public String getObjecct(HttpServletRequest request,HttpServletResponse response){
		return "IP : " + request.getRemoteAddr() +" ResponseCode : " + response.getCharacterEncoding() +
				"SessionID :" + request.getSession().getId() +" RealPath :" + request.getServletContext().getRealPath("/upload/");
	}
}