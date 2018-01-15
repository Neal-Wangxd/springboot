package com.microboot.controller;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月6日 上午10:39:11 
* 类说明 
*/
public abstract class AbstractBaseController {
	
	@Resource
	private MessageSource messageSource; //自动注入资源对象
	public String getMessage(String key,String... args){
		return this.messageSource.getMessage(key, args,Locale.getDefault());
	}
	

}
 