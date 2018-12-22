package com.microboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月4日 下午1:15:44 
* 类说明 : 测试springboot
* 注解:
* @Controller 进行控制器的配置注解，这个注解所在的类就是控制器类
* @EnableAutoConfiguration 开启自动配置处理
* @RequestMapping("/") 表示访问的映射路径，此时的访问路径为：“/”,访问地址:http://localhost:8080/
* @ResponseBody 表示直接将返回的数据以字符串或json的形式获得
* 
* @EnableAutoConfiguration 为整个SpringBoot的启动注解配置,即这个注解应该随着程序的主类一起进行定义
* 而对于控制器程序类，由于在项目中会有许多控制器，最好统一保存在一个包下。
* 如果要进行简单的开发，所有的程序类一定要在启动类所在的包的子包下。
* 
* 传统的做法
* @EnableAutoConfiguration
* @ComponentScan("com.microboot.controller") //定义一个扫描路径
* 
* @ComponentScan 负责连接controller和主类
* 
* 实际开发中
* @SpringBootApplication  //启动SpringBoot程序，而后自带包扫描
* @SpringBootApplication = @EnableAutoConfiguration + @ComponentScan +其他配置
* 
*/
@Controller
@SpringBootApplication
public class StartSpringBootMain {
	
	@RequestMapping("/")
	public String home() {
		return "Hello World!  Hello SpringBoot";
	}
	
    public static void main(String[] args) {
        SpringApplication.run(StartSpringBootMain.class, args);
    }

}
 