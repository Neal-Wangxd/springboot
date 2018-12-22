package com.microboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.microboot.bean.Member;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月23日 下午3:25:54 
* 类说明 
*/
@Controller
public class MemberConsumerController extends AbstractBaseController {

	@Resource
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public String getMember(long mid,Model model){
		Member member = this.restTemplate.getForObject(
				"http://localhost:8088/restful-provider/member/get/"+ mid, Member.class);
		List<Member> members = new ArrayList<>();
		members.add(member);
		model.addAttribute("memberList",members);
		
		return "member/member_show";
	}
	
	@RequestMapping(value = "/add")
	public String addMember(Model model){ 
		return "member/member_add";
	}
	
	@RequestMapping(value="/addDo",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object addMemberDo(Member member){
		Boolean flag = this.restTemplate.postForObject(
				"http://localhost:8088/restful-provider/member/add" , member, boolean.class);
		return flag ;
	}
}
 