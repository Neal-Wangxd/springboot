package com.microboot.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 上午11:19:28 
* 类说明 : 拦截器处理类
*/
public class MyInterceptor implements HandlerInterceptor {

	private Logger log = LoggerFactory.getLogger(MyInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		this.log.info("【*****MyInterceptor.preHandle***** 】"+method.getBean().getClass().getSimpleName());
		return true; //如果返回false表示不继续请求，true表示继续请求
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		this.log.info("【*****MyInterceptor.preHandle***** 】"+method.getBean().getClass().getSimpleName());
		this.log.info("【*****MyInterceptor.modelAndView***** 】"+modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		this.log.info("【*****MyInterceptor.modelAndView***** 】拦截处理完毕");
	}

}
 