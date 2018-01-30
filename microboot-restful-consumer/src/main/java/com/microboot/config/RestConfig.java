package com.microboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月23日 下午2:28:01 
* 类说明 
*/
@Configuration
public class RestConfig {

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
 