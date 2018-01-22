package com.microboot;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.microboot.bean.User;


/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 下午5:03:55 
* 类说明 
*/
@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRedis {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void testConnection(){
		this.redisTemplate.opsForValue().set("springboot-redis", "hello-redis");
		System.out.println(this.redisTemplate.opsForValue().get("springboot-redis")+"*********************");
	}
	
	@Test
	public void testUser(){
		User user = new User();
		user.setUsername("张三");
		user.setAge(23);
		user.setBirthday(new Date());
		user.setHight(175);
		this.redisTemplate.opsForValue().set("User", user);
		System.out.println(this.redisTemplate.opsForValue().get("User")+"*********************");
	}
}
 