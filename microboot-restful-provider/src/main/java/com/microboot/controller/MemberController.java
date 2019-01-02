package com.microboot.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microboot.bean.Member;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月23日 下午1:32:29 
* 类说明 
*/
@RestController
public class MemberController {
	
	@RequestMapping(value="/member/add",method={RequestMethod.POST,RequestMethod.GET} )
	public Object add(@RequestBody Member member){//表示当前的配置可以直接将参数变为实体对象
		System.out.println("【*****接收对象*****MemberController.add()】"+member);
		return true;
	}
	
	@RequestMapping(value="/member/get/{mid}",method=RequestMethod.GET)
	public Member get(@PathVariable("mid") long mid){
		Member member = new Member();
		member.setMid(mid);
		member.setName("springboot-restful-" + mid);
		member.setSalary(15899.00);
		member.setAge(25);
		member.setBirthday(new Date());
		System.out.println("【^^^^^获取对象^^^^^^MemberController.get()】"+member);
		return member;
	}

}
 