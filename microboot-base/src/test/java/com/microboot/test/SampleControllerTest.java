package com.microboot.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.microboot.StartSpringBootMain;

import junit.framework.TestCase;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月4日 下午1:41:21 
* 类说明 : SampleController的测试类
*/
@SpringBootTest(classes=StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SampleControllerTest {
	
	@Resource
	private StartSpringBootMain sampleController;
	
	@Test
	public void TestHome(){
		TestCase.assertEquals(this.sampleController.home(), "Hello World!  Hello SpringBoot");
	}

}
 