package com.microboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月5日 下午4:35:10 
* 类说明 
*/
@SpringBootApplication
@EnableScheduling //启用间隔调度
public class StartSpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(StartSpringBootMain.class, args);
    }
}
 