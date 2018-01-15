package com.microboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microboot.service.impl.MessageServiceImpl;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月7日 上午10:46:37 
* 类说明 
*/
@Configuration
public class ServiceConfig {
	
	@Bean    //此处返回的是一个spring的配置Bean，与.xml的<bean>等价
	public MessageServiceImpl getMessageService(){
		return new MessageServiceImpl();
	}

}
 