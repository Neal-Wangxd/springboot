package com.microboot.config;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月19日 下午2:00:02 
* 类说明 
*/
@Configuration  //定时调度的配置类一定要实现指定的父接口
public class SchedulerConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {//开启一个线程调度池
		taskRegistrar.setScheduler(Executors.newScheduledThreadPool(100));
	}

}
 