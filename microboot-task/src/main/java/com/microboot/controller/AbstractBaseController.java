package com.microboot.controller;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

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
	
	/**
	 * 处理日期格式
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(simpleDateFormat, true));
	}

}
 