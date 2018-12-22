package com.microboot.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microboot.service.IMessageService;

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
	
	@Resource(name="messageService")
	private IMessageService messageService;
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info(){
		return this.messageService.info();
	}
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String show(String mid,Model model){
		model.addAttribute("url","www.baidu.com");//request 属性传递包装
		model.addAttribute("mid", mid);//
		return "message/message_show";//此处只返回路径，该路径没有设置后缀，后缀默认是*.html
	}
	//http://localhost/springboot/show?mid=%E6%92%92%E5%9C%B0%E6%96%B9

}
 