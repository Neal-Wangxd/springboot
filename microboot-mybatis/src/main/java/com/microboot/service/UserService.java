package com.microboot.service;

import java.util.List;

import com.microboot.bean.User;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 下午6:02:45 
* 类说明 
*/
public interface UserService {
	
	public List<User> list();
	
	public boolean addUser(User user);
	
}
 