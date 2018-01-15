package com.microboot.service.impl;

import org.springframework.stereotype.Service;

import com.microboot.service.IMessageService;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月7日 上午10:39:34 
* 类说明 
*/
//@Service
public class MessageServiceImpl implements IMessageService{

	@Override
	public String info() {
		return "Hello SpringBoot , Hello World";
	}

}
 