package com.microboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月5日 下午4:35:10 
* 类说明 
*/
@SpringBootApplication
@ComponentScan("com.microboot")
public class StartSpringBootMain extends SpringBootServletInitializer{ //必须继承指定的父类
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(StartSpringBootMain.class);
	}
	
	
    public static void main(String[] args) {
        SpringApplication.run(StartSpringBootMain.class, args);
    }
}
 