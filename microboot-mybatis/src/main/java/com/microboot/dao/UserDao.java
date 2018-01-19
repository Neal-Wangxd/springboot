package com.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microboot.bean.User;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 下午5:54:22 
* 类说明 ： 用户Dao层  ，类前面一定要加@Mapper注解
*/
@Mapper
public interface UserDao {
	
	public List<User> findAll();
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addUser(User user);

}
 