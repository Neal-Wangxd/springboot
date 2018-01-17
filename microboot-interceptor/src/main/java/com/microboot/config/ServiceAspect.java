package com.microboot.config;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 下午1:36:27 
* 类说明 
*/
@Aspect
@Component
public class ServiceAspect {
	private Logger log = LoggerFactory.getLogger(ServiceAspect.class);
	@Around("execution(* com.microboot..service..*.*(..))")
	public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable{
			this.log.info("【*****Service-Before***** 】执行参数："+Arrays.toString(point.getArgs()));	
			Object obj = point.proceed(point.getArgs());//进行具体业务调用
			this.log.info("【*****Service-After***** 】返回结果 ："+obj);
			return obj;
	}
	
}
 