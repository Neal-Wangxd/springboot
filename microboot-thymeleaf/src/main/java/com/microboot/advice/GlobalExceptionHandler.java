package com.microboot.advice; 


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月12日 下午2:40:15 
* 类说明 : 全局异常类
*/
import org.springframework.web.servlet.ModelAndView;

import com.microboot.bean.ErrorInfo;

@ControllerAdvice //作为控制层的切面处理
public class GlobalExceptionHandler {
	
	public static final String DEFAULT_ERROR_VIEW = "error_show";//错误显示的页面
	
	@ExceptionHandler(Exception.class)
	public ModelAndView defauleErrorView(HttpServletRequest request,Exception e){
		ModelAndView modelAndView = new ModelAndView(DEFAULT_ERROR_VIEW);
		modelAndView.addObject("Exception",e);
		modelAndView.addObject("URL",request.getRequestURI());
		return modelAndView;
	}

}
 