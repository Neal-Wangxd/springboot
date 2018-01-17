package com.microboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.microboot.util.MyInterceptor;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 上午11:29:35 
* 类说明 
*/
@Configuration
public class MyWebApplicationConfig extends WebMvcConfigurerAdapter{//MVC配置

	@Override
	public void addInterceptors(InterceptorRegistry registry){//拦截器注册处理
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");//匹配路径
		super.addInterceptors(registry);
	}

}
 