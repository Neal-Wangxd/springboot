package com.microboot.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月12日 上午11:20:44 
* 类说明  : 错误信息配置类
*/
@Configuration
public class ErrorPageConfig {
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		
		
		return new EmbeddedServletContainerCustomizer(){
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage errorPage_400 = new ErrorPage(HttpStatus.BAD_REQUEST,"/error_400.html");
				ErrorPage errorPage_404 = new ErrorPage(HttpStatus.NOT_FOUND,"/error_404.html");
				ErrorPage errorPage_500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error_500.html");
				container.addErrorPages(errorPage_400,errorPage_404,errorPage_500);
			}
		};
	}

}
 