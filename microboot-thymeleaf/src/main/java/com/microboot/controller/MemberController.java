package com.microboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="/member/testError")
	@ResponseBody
	public String testErrorPage(){
		System.out.println("除法计算："+(10/0));
		return "Hello World!";
	}
	
	@RequestMapping(value="/member/memberShow",method = RequestMethod.GET)
	public String memberShow(Model model){
		
		Member member = new Member();
		member.setMid(100L);
		member.setName("张蛋");
		member.setAge(15);
		member.setSalary(9999.99);
		member.setBirthday(new Date());	
				
		model.addAttribute("member", member);
		return "member/member_show";
	}
	
	
	@RequestMapping(value="/member/memberList",method = RequestMethod.GET)
	public String memberList(Model model){
		List<Member> memberList = new ArrayList<Member>();
		for(int i = 1 ; i <= 10 ; i++){
			Member member = new Member();
			member.setMid(100L+i);
			member.setName("张"+i+"蛋");
			member.setAge(15);
			member.setSalary(9999.99);
			member.setBirthday(new Date());	
			memberList.add(member);
		}
		model.addAttribute("memberList", memberList);
		return "member/member_showList";
	}
	
	
	@RequestMapping(value="/member/memberMap",method = RequestMethod.GET)
	public String memberMap(Model model){
		Map<String,Member> memberMap = new HashMap<String,Member>();
		for(int i = 1 ; i <= 10 ; i++){
			Member member = new Member();
			member.setMid(100L+i);
			member.setName("张"+i+"蛋");
			member.setAge(15);
			member.setSalary(9999.99);
			member.setBirthday(new Date());	
			memberMap.put("Member--->"+i, member);
		}
		model.addAttribute("memberList", memberMap);
		return "member/member_showMap";
	}
	
	@RequestMapping(value="/member/memberSet",method = RequestMethod.GET)
	public String memberSet(Model model){
		Set<String> names = new HashSet<String>();
		Set<Integer> ids = new HashSet<Integer>();
		for(int i = 1 ; i <= 10 ; i++){
			names.add("springboot--->"+i);
			ids.add(i);
		}
		model.addAttribute("names", names);
		model.addAttribute("ids", ids);
		return "member/member_showSet";
	}
}
 