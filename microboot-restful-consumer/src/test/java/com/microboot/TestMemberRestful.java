package com.microboot;

import static org.mockito.Matchers.matches;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.microboot.bean.Member;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月23日 下午2:31:36 
* 类说明 
*/

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMemberRestful {

	@Resource
	private RestTemplate restTemplate;
	
	@Test
	public void testAdd(){
		Boolean  flag = this.restTemplate.postForObject(
				"http://localhost:8088/restful-provider/member/add?mid=123&name=NEAL&age=23",
				Member.class,boolean.class);
		System.out.println(flag);
	}
	
	@Test
	public void testGet(){
		Member member = this.restTemplate.getForObject(
				"http://localhost:8088/restful-provider/member/get/123",
				Member.class);
		System.out.println(member);
	}
}
 