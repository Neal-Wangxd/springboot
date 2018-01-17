package com.microboot.service.impl;

import org.springframework.stereotype.Service;

import com.microboot.bean.Member;
import com.microboot.service.MemberService;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 上午11:52:14 
* 类说明 
*/
@Service
public class MemberServiceImpl implements MemberService{

	@Override
	public Member getMember(String mid) {
		Member member = new Member();
		member.setMid(mid);
		member.setAge(23);
		member.setSalary(15000.00);
		return member;
	}

}
 