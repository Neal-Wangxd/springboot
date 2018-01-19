package com.microboot.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月19日 下午1:50:54 
* 类说明 
*/
@Component
public class MyScheduler {
	
	@Scheduled(fixedRate = 2000)//采用间隔调度，每两秒执行一次
	public void runJobA(){
		System.out.println("【*****TaskA*****】" + 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}
	
	@Scheduled(cron = "* * * * * ?")//每秒调用
	public void runJobB() throws Exception{
		Thread.sleep(3000);
		System.out.println("【#####TaskB#####】" + 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}

}
 