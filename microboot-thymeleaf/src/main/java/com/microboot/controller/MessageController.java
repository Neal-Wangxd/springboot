package com.microboot.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月6日 上午10:45:56 
* 类说明 
*/
//@RestController
@Controller
public class MessageController extends AbstractBaseController{
	
	
	@RequestMapping(value="/echo",method=RequestMethod.GET)
	public String echo(String mid){
		System.out.println("【访问地址】"+super.getMessage("member.add.action"));
		return super.getMessage("welcome.msg", mid);
	}
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String show(String mid,Model model){
		model.addAttribute("url","www.baidu.com");//request 属性传递包装
		model.addAttribute("mid", mid);//
		return "message/message_show";//此处只返回路径，该路径没有设置后缀，后缀默认是*.html
	}
	
	@RequestMapping(value="/showStyle",method=RequestMethod.GET)
	public String showStyle(Model model){
		model.addAttribute("msg","<span style='color:red'>Hello SpringBoot</span>");//request 属性传递包装
		return "message/message_showStyle";
	}
	
	@RequestMapping(value="/message/showInner",method=RequestMethod.GET)
	public String inner(HttpServletRequest request,Model model){
		request.setAttribute("msg", "Hello SpringBoot");
		model.addAttribute("url","www.baidu.com");
		
		request.setAttribute("requestMsg", "Hello SpringBoot");
		request.getSession().setAttribute("sessionMsg", "SpringBoot-session");
		request.getServletContext().setAttribute("applicationMsg", "SpringBoot-application");
		request.setAttribute("urlNew", "<span style='color:red'>www.mldn.cn</span>");
		
		return "message/message_showInner";
	}
}
 