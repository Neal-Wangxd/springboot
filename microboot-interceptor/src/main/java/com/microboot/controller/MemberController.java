package com.microboot.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microboot.bean.Member;
import com.microboot.service.MemberService;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 上午10:39:45 
* 类说明 
*/
@Controller
public class MemberController extends AbstractBaseController{

	@Resource
	private MemberService memberService;
	
	
	@RequestMapping(value = "/memberAddPre",method = RequestMethod.GET)
	public String memberAddPre(){
		return "/member/member_add";
	}
	
	@RequestMapping(value = "memberAdd", method = RequestMethod.POST)
	@ResponseBody
	public Member memberAdd(Member member){
		return member;
	}
	
	@RequestMapping(value = "memberGet", method = RequestMethod.GET)
	@ResponseBody
	public Member memberGet(String mid){
		return this.memberService.getMember(mid);
	}
	
}
 