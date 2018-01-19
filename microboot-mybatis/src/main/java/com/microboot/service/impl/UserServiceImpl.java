package com.microboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microboot.bean.User;
import com.microboot.dao.UserDao;
import com.microboot.service.UserService;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 下午6:04:46 
* 类说明 
*/
@Service
public class UserServiceImpl implements UserService {

		
	@Resource
	private UserDao userDao;
	
	@Override
	public List<User> list() {
		return this.userDao.findAll();
	}

	@Override
	public boolean addUser(User user) {
		return this.userDao.addUser(user);
	}

}
 