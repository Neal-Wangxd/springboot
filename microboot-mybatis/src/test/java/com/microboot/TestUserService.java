package com.microboot;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.microboot.bean.User;
import com.microboot.service.UserService;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 下午6:06:54 
* 类说明 
*/

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestUserService {

	@Resource
	private UserService userService;
	
	@Test
	public void testList(){
		System.out.println(this.userService.list());
	}
	
	@Test
	public void testAdd(){
		User user = new User();
		user.setUsername("abc");
		user.setAge(33);
		System.out.println(this.userService.addUser(user));
	}
	
}
 