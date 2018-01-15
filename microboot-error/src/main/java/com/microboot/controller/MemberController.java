package com.microboot.controller;

import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microboot.bean.Member;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月11日 下午3:34:25 
* 类说明 
*/

@Controller
public class MemberController extends AbstractBaseController{
	
	@RequestMapping(value="/addpre",method = RequestMethod.GET)
	public String addPre(){
		return "member/member_add";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	@ResponseBody
	public Object add(@Valid Member mb,BindingResult result){
		if(result.hasErrors()){
			Iterator<ObjectError> iterator = result.getAllErrors().iterator();
			while (iterator.hasNext()) {
				ObjectError error = iterator.next();
				System.out.println("【error message】code = " + error.getCode() + 
						",message = " + error.getDefaultMessage());
				
			}
			return result.getAllErrors();
		}else{
			return mb;
		}
	}
	
	@RequestMapping(value="testError")
	@ResponseBody
	public String testErrorPage(){
		System.out.println("除法计算："+(10/0));
		return "Hello World!";
	}
	
}
 